//var APIServer = "http://123.56.4.5:4090/pointservice";
var APIServer = "/pointservice";
var Login=Vue.extend({template:"#login",
data:function(){
    return {
        username:'',
        password:'',
        errorList: []
    };
},
methods:{
	showMsg(msg){
		this.errorList.push(msg)
		let _this=this
		setTimeout(function()  {
			_this.errorList = [];
		},3000);
	},
	login(){
		this.errorList = [];
		if (this.username.trim().length==0){
			this.showMsg("用户名不能为空");
			return;
		}
		if (this.password.trim().length==0){
			this.showMsg("密码不能为空");
			return;
		}
		var user = {
	    	name:this.username,
	    	password:this.password
	    }
		fetch(APIServer+"/login",{
	      method:"post",
	      headers: {
	    	  'Content-Type': 'application/json'
    	  },
	      body: JSON.stringify(user)
	    }).then(response=>{
	    	if(response.status != 403 && response.status != 200){
	    		this.showMsg('请检查网络或联系管理员');
		    }
	       return response.json();
	    }).then(data=>{
	    	if(data.error){
    			this.showMsg(data.error);
    		}else{
    			setUser(data);
    			goPage('/home');
    		}
		})
	}
}
});
var Home=Vue.extend({template:"#home",
data:function(){
	return {
		gUser:null
	}
},
mounted:function(){
	this.init();
},
methods: {
	switchRole(){
		
	},
	init(){
		gUser = JSON.parse(localStorage.getItem('gUser'));
		this.gUser = gUser;	
	}
}
});
var Test=Vue.extend({template:"#test",
data:function() {
	return {
		questions: [],
		options:[],
		errorList: [],
		successList:[],
		id:'',
		name:'',
		evaluator:'',
		gUser:{},
		isSubmitted:false,
		finished:false,
		total:0,
		searchName:'',
		displayUsers:[]
	}
},
mounted:function(){
	this.init();
},
watch: {
	searchName (curVal, oldVal) {
		clearTimeout(this.timeout)
	    this.timeout = setTimeout(() => {
	      this.handleChangeName(curVal)
	    }, 200)
	  }
},
methods: {
	handleChangeName (value) {
		if (value === '') {
			this.displayUsers = this.userList;
			return false;
		}
		if(this.target != 'self'){
			this.displayUsers = this.userList.filter(function (element, index, self) {
			    if(element.realName.indexOf(value)>=0){
			    	return true;
			    }else{
			    	return false;
			    }
			});
		}
		
	},
	clearSearch(){
		this.searchName = '';
		this.displayUsers = this.userList;
	},
	showMsg(msg){
		this.errorList.push(msg)
		let _this=this
		setTimeout(function()  {
			_this.errorList = [];
		},3000);
	},
	showSuccessMsg(msg){
		this.successList.push(msg)
		let _this=this
		setTimeout(function()  {
			_this.successList = [];
			goPage('/home');
		},2000);
	},
	handleClick(q){
		q.checked = !q.checked;
	},
	cancel(){
		this.finished=false;
	},
	checkSubmit(){
		let total = 0;
		for(index in this.questions){
			q = this.questions[index];
			if(!q.isTitle && !q.checked){
				total += this.options[0].optionPoint
			}
		}
		total = Math.round(total);
		if(total>=100){
			total = 100;
		}
		this.total = total;
		this.finished=true;
	},
	submit(){
		let score = {
    		paperId:1,
    		scorer:this.gUser.name,
    		scoree:this.evaluator,
    		scores:[],
    		point:this.total
    	}
    	this.questions.map(function(item){
    		if(item.checked){
    			let question={questionId:item.id,optionsId:item.checked?2:1,answer:null};
    			score.scores.push(question);
    		}
//    		if(item.type == 2){
//    			let question={questionId:item.id,answer:item.answer,optionsId:null};
//    			score.scores.push(question);
//    		}
    	});
    	let url = APIServer+'/score/'+score.scoree;
    	fetch(url,{
  	      method:"post",
  	      headers: {
  	    	  'Content-Type': 'application/json'
      	  },
  	      body: JSON.stringify(score)
  	    }).then(response=>{
  	    	if(response.status != 400 && response.status != 200){
  	    		this.showMsg('请检查网络或联系管理员');
  		    }
  	    	if (response.status==200){
  	    		return {'status':200}
  	    	}else{
  	    		return {'error':response.text(),'status':response.status}
  	    	}
  	    }).then(data=>{
  	    	if(data.error){
  	    		data.error.then(e=>this.showMsg(e));
      		}else{
      			this.finished=false;
      			this.showSuccessMsg('提交成功');
      		}
  		})
	},
	initQuestion(){
		fetch(APIServer+'/paper/1?username='+this.evaluator,{
			method:"get",
		    headers: {
		    	'Content-Type': 'application/json'
		    }
		}).then(response=>{
			if(response.status != 403 && response.status != 200){
				this.showMsg('请检查网络或联系管理员');
		    }
		   return response.json();
		 }).then(data=>{
			if(data.error){
				this.showMsg(data.error);
			}else{
				let questions = [];
				let category=null;
				data.questions.map(function (question) {
					if(category != question.category){
						category = question.category;
						questions.push({'category':category,'isTitle':true});
					}else{
						question.isTitle = false;
					}
					if(question.type==1){
						question.checked=false;
					}
					questions.push(question);
				});
				this.id = data.id;
				this.name = data.name;
				this.questions = questions;
				let options = [];
				data.options.map(function (item) {
					options.push({'label':item.description,'value':item.description,'id':item.id,'optionPoint':item.optionPoint,'optionId':item.optionId});
				});
				this.options = options;
			}
		 })
	},
	getAllUsers(){
		let url1 = APIServer+'/alluser?organization='+this.gUser.organization+'&realname=';
		fetch(url1,{
		     method:"get",
		     headers: {
		      'Content-Type': 'application/json'
		     }
		}).then(response=>{
			return response.json();
		}).then(data=>{
			this.userList = data;
			this.displayUsers = data;
		});
	},
	getBranchUsers(){
		let url1 = APIServer+'/score/pointsbyuser?branch='+this.gUser.branch+'&scorer='+this.gUser.name;
		fetch(url1,{
		     method:"get",
		     headers: {
		      'Content-Type': 'application/json'
		     }
		}).then(response=>{
			return response.json();
		}).then(data=>{
			this.userList = data;
			this.displayUsers = data;
		});
	},
	init() {
		this.target = this.$route.query.target;
		gUser = JSON.parse(localStorage.getItem('gUser'));
		this.gUser = gUser;
		if (this.target == 'self'){
			this.evaluator = this.gUser.name;
			fetch(APIServer+'/score/'+gUser.name+"?scorer="+gUser.name,{
			     method:"get",
			     headers: {
			      'Content-Type': 'application/json'
			     }
			}).then(response=>{
				return response.json();
			}).then(data=>{
				if(data.length>0){
					this.isSubmitted = true;
				}
			});
			this.initQuestion();
		}else if(this.target != 'self'){
			if(this.gUser.name == 'guest'){
				this.getAllUsers();
			}else{
				this.getBranchUsers();
			}
			
		}
	 },
	 pickUser(user){
		 this.evaluator = user.name;
		 this.initQuestion();
	 }
}
});
var routes=[
{
	path:"/login",
	component:Login
},
{
	path:"/home",
	component:Home
},
{
	path:"/test",
	component:Test
}
,
{
	path:"/",
	component:Login
}
];
var router=new VueRouter({
	routes:routes
});
var vm=new Vue({
	el:"#app",
	router:router
});
goPage = function(url){
	router.push({path:url})
}

setUser = function(user){
	localStorage.setItem('gUser',JSON.stringify(user));
}

getQuestions=function(user){
	fetch(APIServer+"/paper/1?username="+user,{
      method:"get"
    }).then(result=>{
      console.log(result);
       return result.json();
    }).then(data=>{
       console.log(data);
       vm.questions = data;
	})
}