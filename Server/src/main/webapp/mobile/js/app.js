//var APIServer = "http://123.56.4.5:4090/pointservice";
var APIServer = "/pointservice";
Vue.component(VeBar.name, VeBar)
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
		gUser:{},
		showRoleList:false,
		roleList:[],
		errorList: [],
		newRole:'',
	}
},
mounted:function(){
	this.init();
},
methods: {
	showMsg(msg){
		this.errorList.push(msg)
		let _this=this
		setTimeout(function()  {
			_this.errorList = [];
		},3000);
	},
	pickRole(role){
		this.newRole = role;
	},
	switchRole(){
		let url = APIServer+'/user/property';
    	fetch(url,{
  	      method:"get",
  	      headers: {
  	    	  'Content-Type': 'application/json'
      	  }
  	    }).then(response=>{
  	    	if(response.status != 400 && response.status != 200){
  	    		this.showMsg('请检查网络或联系管理员');
  		    }
  	    	if (response.status==200){
  	    		return response.json();
  	    	}else{
  	    		return {'error':response.text(),'status':response.status}
  	    	}
  	    }).then(data=>{
  	    	if(data.error){
  	    		data.error.then(e=>this.showMsg(e));
      		}else{
      			this.roleList = data;
				this.showRoleList = true
      		}
  		})
	},
	cancel(){
		this.showRoleList = false;	
	},
	submit(){
		this.showRoleList = false;
		let user = this.gUser;
		user.property = this.newRole;
		fetch(APIServer+"/user/"+this.gUser.name,{
	      method:"put",
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
    			setUser(user);
    		}
		})	
	},
	init(){
		let gUser = JSON.parse(localStorage.getItem('gUser'));
		if(!gUser){
			return;
		}
		this.gUser = gUser;
		this.newRole = gUser.property;
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
		displayUsers:[],
		target:'',
		paperId:1
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
	handleSelect(q,option){
		q.optionId = option.id;
		q.optionPoint = option.optionPoint;
	},
	cancel(){
		this.finished=false;
	},
	checkSubmit(){
		let total = 0;
		for(index in this.questions){
			q = this.questions[index];
			if(this.options.length==2){
				if(!q.isTitle && !q.checked){
					total += this.options[0].optionPoint
				}
			}else{
				//四个选项
				if(!q.isTitle){
					total += q.optionPoint;
				}
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
    		paperId:this.paperId,
    		scorer:this.gUser.name,
    		scoree:this.evaluator,
    		scores:[],
    		point:this.total
    	}
		let options = this.options;
    	this.questions.map(function(item){
			if(!item.isTitle){
				if(options.length==2){
					let question={questionId:item.id,optionsId:item.checked?2:1};
    				score.scores.push(question);
				}else{
					let question={questionId:item.id,optionsId:item.optionId};
    				score.scores.push(question);
				}
				
			}
    		
//    		if(item.type == 2){
//    			let question={questionId:item.id,answer:item.answer,optionsId:null};
//    			score.scores.push(question);
//    		}
    	});
    	let url = APIServer+'/score/'+score.scoree;
		if (this.target == 'organization'){
			url = APIServer+'/pingyi/zuzhipingjia/'+score.scoree;
		}
		if (this.target == 'public'){
			url = APIServer+'/pingyi/qunzhongpingyi/'+score.scoree;
		}
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
		let paperId = 1;
		if(this.gUser.name == 'guest'){
			paperId = 2;
			this.paperId = 2;
		}
		fetch(APIServer+'/paper/'+paperId+'?username='+this.evaluator,{
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
				let qId=0;
				data.questions.map(function (question) {
					if(category != question.category){
						category = question.category;
						questions.push({'category':category,'isTitle':true});
					}else{
						question.isTitle = false;
					}
					if (!question.isTitle){
						qId+=1;
						question.qId=qId;
					}
					if(question.type==1 && paperId==1){
						question.checked=false;
					}
					if(question.type==1 && paperId==2){
						question.optionId=0;
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
		let gUser = JSON.parse(localStorage.getItem('gUser'));
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
var Report=Vue.extend({template:"#report",
data:function(){
	this.chartExtend = {
		series(item) {
			item[0].data = item[0].data.map((v, index) => {
				let color = '#57d785';
				if(v>80){
					color='#57d785'
				}else if(v>60){
					color='#fed500'
				}else{
					color='#fe6100'
				}
				return {
					value: v,
					itemStyle: { color: color }
				}
			})
			return item
		}
	}
	return {
		gUser:null,
		errorList: [],
		tabs:['自评报告','他评报告'],
	    activeIndex:0,
		chartData: {
            columns: ['description','point'],
            rows: []
		}
	}
},
mounted:function(){
	this.init();
},
methods: {
	showMsg(msg){
		this.errorList.push(msg)
		let _this=this
		setTimeout(function()  {
			_this.errorList = [];
		},3000);
	},
	init(){
		let gUser = JSON.parse(localStorage.getItem('gUser'));
		if(!gUser){
			return;
		}
		this.gUser = gUser;
		this.getReports('self');
	},
	switchTab(index){
		this.activeIndex = index;
		if (index == 0){
			this.getReports('self');
		}else{
			this.getReports('other');
		}
	},
	getReports(type){
		let url = APIServer+'/pingyi/baogaodan/self?username='+this.gUser.name
		if(type=='other'){
			url = APIServer+'/pingyi/baogaodan/other?username='+this.gUser.name
		}
		fetch(url,{
		     method:"get",
		     headers: {
		      'Content-Type': 'application/json'
		     }
		}).then(response=>{
			return response.json();
		}).then(data=>{
			if(type=='self'){
				this.chartData['rows'] = data.ziPingPoints;	
			}else{
				this.chartData['rows'] = data.huPingPoints;
			}
			
		});
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
	path:"/report",
	component:Report
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