/// <reference path='../../../typings/tsd.d.ts' />

(function () {
    'use strict';

    angular.module('portal.examine').controller('ExamineController', ExamineController);

    ExamineController.$inject = ['storage','messageCenterService','examineService','systemService','security','$stateParams','$uibModal','transferUser','$uibModalStack','$scope'];

    function ExamineController(storage,messageCenterService,examineService,systemService,security,$stateParams,$uibModal,transferUser,$uibModalStack,$scope) {
        var vm = this;
        var currentUser = security.getCurrentUser();
        if(transferUser){
        	currentUser = transferUser;
        	vm.currentUser = currentUser;
		}
		var organization = storage.get('organization');
		if (!organization){
			organization = currentUser.organization
		}
        vm.userName = currentUser.name;
        vm.branch = $stateParams.branchName;
        vm.now = new Date();
        vm.selectTab ='public';
		vm.topIssues = {};
		vm.min =0;
        
        vm.initData = function(){
        	vm.datalist = null;
        	if(vm.selectTab == 'public'){
        		examineService.getPublicScore(vm.branch,organization).then(function(response){
        			vm.datalist = response;
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}else if(vm.selectTab == 'self'){
        		examineService.getSelfScore(vm.branch,organization).then(function(response){
        			vm.datalist = response;
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}else if(vm.selectTab == 'each'){
        		examineService.getEachScore(vm.branch,organization).then(function(response){
        			vm.datalist = response;
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}else if(vm.selectTab == 'organization'){
        		examineService.getOrganizationScore(vm.branch,organization).then(function(response){
        			vm.datalist = response;
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}else if(vm.selectTab == 'summary'){
        		examineService.getSummaryScore(vm.branch,organization).then(function(response){
        			vm.datalist = response;
      	    	  	for(var i=0;i<vm.datalist.length;i++){
      	    	  		if(vm.datalist[i].jianKang == null){
      	    	  		vm.datalist[i].jianKang = '健康';
      	    	  		}
      	    	  	}
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}else if(vm.selectTab == 'result_list'){
        		systemService.getUsers(vm.branch,organization).then(function(response){
            		vm.userlist = response;
            	},function(response){
            		messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
            	});
        	}
        }
        
        vm.update = function(id){
        	if(id == 'public'){
        		examineService.updatePublicScore(vm.branch,organization,vm.datalist)
        		.then(function(response){
        			messageCenterService.add('success', '数据保存成功!', {timeout:1000});
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}else if(id == 'self'){
        		examineService.updateSelfScore(vm.branch,organization,vm.datalist)
        		.then(function(response){
        			messageCenterService.add('success', '数据保存成功!', {timeout:1000});
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}else if(id == 'each'){
        		examineService.updateEachScore(vm.branch,organization,vm.datalist)
        		.then(function(response){
        			messageCenterService.add('success', '数据保存成功!', {timeout:1000});
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}else if(id == 'organization'){
        		examineService.updateOrganizationScore(vm.branch,organization,vm.datalist)
        		.then(function(response){
        			messageCenterService.add('success', '数据保存成功!', {timeout:1000});
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}else if(id == 'summary'){
        		examineService.updateSummaryScore(vm.branch,organization,vm.datalist)
        		.then(function(response){
        			messageCenterService.add('success', '数据保存成功!', {timeout:1000});
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}else if(id == 'result'){
				vm.result.portion = vm.min;
        		examineService.updateResultScore(currentUser.name,vm.result)
        		.then(function(response){
        			messageCenterService.add('success', '数据保存成功!', {timeout:1000});
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}
        }
        
        $scope.$on('chart-create', function(evt, chart){
        	  vm.mychart=chart;
        });
        
        vm.initResult=function(){
        	vm.chart_labels = ['政治方向', '政治领导', '政治根基', '政治生态', '政治风险',
        		'政治本色', '政治能力','先锋模范'];
        	vm.datasetOverride = [
        		{
	    	        borderWidth: 1,
	    	        backgroundColor:[],
	    	        type: 'bar'
        		},
    	    ];

	    	vm.chart_data = [[]];
	    	vm.chart_options={scales: {
	            yAxes: [{
	                ticks: {
	                    beginAtZero:true,
	                    stacked: true
	                }
	            }],
	            xAxes: [{
	            	ticks: {
	                    offsetGridLines: true,
	                    stacked: true,
	                    autoSkip: false
	                }
	            }]
	        }};
        	examineService.getResultScore(currentUser.name).then(function(response){
  	  			vm.result = response;
  	  			if(!vm.result.lastModifiedTime){
  	  				vm.result.lastModifiedTime = vm.now;
					}
				if(!vm.result.portion){
  	  				vm.result.portion = 0;
				}
				vm.min = vm.result.portion;
				vm.max = 100-vm.result.zongHeDeFenPoints[8].point;
  	  			for(var i=0;i<vm.result.zongHeDeFenPoints.length-1;i++){
  	  				vm.chart_data[0].push(vm.result.zongHeDeFenPoints[i].point);
					vm.datasetOverride[0].backgroundColor.push(vm.getJianKangColor(i));
				}
  	  			vm.topIssues = vm.result.categoryTopIssues;
  	  		},function(response){
  	  			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
  	  		})
        }
        
        vm.generateResult = function(user){
        	$uibModal.open({
	      	      animation: true,
	      	      size:"cm-user",
	      	      ariaLabelledBy: 'modal-title-top',
	      	      ariaDescribedBy: 'modal-body-top',
	      	      templateUrl: 'app/examine/examine_result.html',
		      	  controller:'ExamineController',
	  	          controllerAs: 'ecCtrl',
		  	      resolve: {
		  	    	  transferUser:function(){
		  	        	   return user;
		  	           }
		  	       }
	        });
        }
        
        vm.close = function(){
        	$uibModalStack.dismissAll();
        }
        
        vm.checkHongxian = function(hongxian){
        	if(null == hongxian){
        		return false;
        	}
        	hongxian = hongxian.replace(/ /g,'').replace(/<br>/g,'');
        	if(hongxian != ''){
        		return true;
        	}else{
        		return false;
        	}
        }
        vm.removeHtml = function(hongxian){
        	if(null == hongxian){
        		return hongxian;
        	}
        	hongxian = hongxian.replace(/<br>/g,' ');
        	return hongxian;
        }
        
        vm.calc = function(a,b,c,d,e){
        	if(!a){
        		a=0;
        	}
        	if(!b){
        		b=0;
        	}
        	if(!c){
        		c=0;
        	}
        	if(!d){
        		d=0;
        	}
        	if(!e){
        		e=0;
        	}
        	return parseInt(a)+parseInt(b)+parseInt(c)+parseInt(d)+parseInt(e);
        }
        
        vm.calcTotal = function(obj){
        	var a=obj.zhengZhiFangXiang,b=obj.zhengZhiLingDao,c=obj.zhengZhiGenJi,d=obj.zhengZhiShengTai,e=obj.zhengZhiFengXian;
        	var f=obj.zhengZhiBenSe,g=obj.zhengZhiNengLi,h=obj.xianFengMoFan;
        	if(!a){
        		a=0;
        	}
        	if(!b){
        		b=0;
        	}
        	if(!c){
        		c=0;
        	}
        	if(!d){
        		d=0;
        	}
        	if(!e){
        		e=0;
        	}
        	if(!f){
        		f=0;
        	}
        	if(!g){
        		g=0;
			}
			if(!h){
        		h=0;
        	}
        	
        	var total=parseInt(a)+parseInt(b)+parseInt(c)+parseInt(d)+parseInt(e)+parseInt(f)+parseInt(g)+parseInt(h);
        	if(total==0){
        		return null;
        	}
        	obj.total=Math.ceil(total/8);
        	return Math.ceil(total/8);
        }
        
        vm.getJianKangColor=function(index){
        	if(!vm.result ||  !vm.result.jianKangZhuangTaiPoints){
        		return '#ffffff';
        	}
        	var point = vm.result.jianKangZhuangTaiPoints[index].point;
        	if(point==0){
        		return '#e62325';
        	}else if(point==50){
        		return '#fed500';
        	}else if(point==100){
        		return '#34bc6e';
        	}else{
        		return 'blue';
        	}
        }
        vm.getJianKangStatus=function(point){
        	if(point==0){
        		return "X"
        	}else if(point==50){
        		return "乄"
        	}else if(point==100){
        		return "√"
        	}else{
        		return "未知";
        	}
        }
        
        vm.clickTab = function(name){
        	vm.selectTab = name;
        	vm.initData();
        }
        vm.printdiv = function(divName){
        	var printContents = document.getElementById(divName).innerHTML;
        	if(divName == 'result'){
        		var canvas = document.getElementById("mybar");
            	printContents = printContents.replace('##chartImage##',canvas.toDataURL());
            	printContents = printContents.replace('display: none;','').replace('display: block;','display:none;').replace('display: block;','display:none;');
        	}
            var popupWin = window.open('', '_blank', 'width=800,height=900');
            popupWin.document.open();
            popupWin.document.write('<html><head><link rel="stylesheet" type="text/css" href="content/css/custom.css" /></head>');
            popupWin.document.write('<html><head><link rel="stylesheet" type="text/css" href="content/css/layout.css" /></head>');
            popupWin.document.write('<body onload="window.print()">' + printContents + '</body></html>');
            popupWin.document.close();
        }
        
//        vm.pdfMake = function(id){
//        	html2canvas(document.getElementById(id), {
//                onrendered: function (canvas) {
//                    var data = canvas.toDataURL();
//                    var docDefinition = {
//                        content: [{
//                            image: data,
//                            width: 500,
//                        }]
//                    };
//                    pdfMake.createPdf(docDefinition).download("Score_Details.pdf");
//                }
//            });
//        }
        
        //load data
        vm.initData();
        
        vm.scrollTableStyle={
			"width":"100%",
			"height":(window.innerHeight-200),
			"overflow-y":"scroll",
			"margin-top":"-40px"
        };
        
        vm.getImg = function(check){
        	if(check){
        		return "content/img/checked.png";
        	}else{
        		return "content/img/uncheck.png";
        	}
        }
        
        vm.resetScore = function(){
        	$uibModal.open({
      	    	animation: true,
      	    	size:"csm",
      	    	ariaLabelledBy: 'modal-title-top',
      	    	ariaDescribedBy: 'modal-body-top',
				templateUrl: 'templates/confirmResetTemp.html',
      	        controller:['$scope','$uibModalInstance', function($scope,$uibModalInstance) {
      	        	$scope.deleteItem = '本操作一般用于每次组织评测之前，重置本支部成员上次成绩。确定重置?';
      	      		$scope.delete_ok = function(){
      	      			examineService.resetScore(vm.branch).then(function(response){
	  	      				messageCenterService.add('success', '重置成功!', {timeout:3000});
	  	      				$uibModalInstance.dismiss('cancel');
						},	function(response){
							messageCenterService.add('danger', response, {timeout:3000});
							$uibModalInstance.dismiss('cancel');
						});
					}
									  
      	      		$scope.delete_cancel = function(){
      	    	  		$uibModalInstance.dismiss('cancel');
      	      		}
      	      	}]		
			});
        }
        
    }
})();