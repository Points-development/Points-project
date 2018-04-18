/// <reference path='../../../typings/tsd.d.ts' />

(function () {
    'use strict';

    angular.module('portal.examine').controller('ExamineController', ExamineController);

    ExamineController.$inject = ['storage','messageCenterService','examineService','systemService','security','$stateParams','$uibModal','transferUser'];

    function ExamineController(storage,messageCenterService,examineService,systemService,security,$stateParams,$uibModal,transferUser) {
        var vm = this;
        var currentUser = security.getCurrentUser();
        if(transferUser){
        	currentUser = transferUser;
        	vm.currentUser = currentUser;
        }
        vm.userName = currentUser.name;
        vm.branch = $stateParams.branchName;
        vm.now = new Date();
        vm.selectTab ='public';
        
        vm.initData = function(){
        	vm.datalist = null;
        	if(vm.selectTab == 'public'){
        		examineService.getPublicScore(vm.branch,currentUser.organization).then(function(response){
        			vm.datalist = response;
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}else if(vm.selectTab == 'self'){
        		examineService.getSelfScore(vm.branch,currentUser.organization).then(function(response){
        			vm.datalist = response;
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}else if(vm.selectTab == 'each'){
        		examineService.getEachScore(vm.branch,currentUser.organization).then(function(response){
        			vm.datalist = response;
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}else if(vm.selectTab == 'organization'){
        		examineService.getOrganizationScore(vm.branch,currentUser.organization).then(function(response){
        			vm.datalist = response;
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}else if(vm.selectTab == 'summary'){
        		examineService.getSummaryScore(vm.branch,currentUser.organization).then(function(response){
        			vm.datalist = response;
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}else if(vm.selectTab == 'result_list'){
        		systemService.getUsers(vm.branch,currentUser.organization).then(function(response){
            		vm.userlist = response;
            	},function(response){
            		messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
            	});
        	}
        }
        
        vm.update = function(id){
        	if(id == 'public'){
        		examineService.updatePublicScore(vm.branch,currentUser.organization,vm.datalist)
        		.then(function(response){
        			messageCenterService.add('success', '数据保存成功!', {timeout:1000});
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}else if(id == 'self'){
        		examineService.updateSelfScore(vm.branch,currentUser.organization,vm.datalist)
        		.then(function(response){
        			messageCenterService.add('success', '数据保存成功!', {timeout:1000});
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}else if(id == 'each'){
        		examineService.updateEachScore(vm.branch,currentUser.organization,vm.datalist)
        		.then(function(response){
        			messageCenterService.add('success', '数据保存成功!', {timeout:1000});
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}else if(id == 'organization'){
        		examineService.updateOrganizationScore(vm.branch,currentUser.organization,vm.datalist)
        		.then(function(response){
        			messageCenterService.add('success', '数据保存成功!', {timeout:1000});
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}else if(id == 'summary'){
        		examineService.updateSummaryScore(vm.branch,currentUser.organization,vm.datalist)
        		.then(function(response){
        			messageCenterService.add('success', '数据保存成功!', {timeout:1000});
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}else if(id == 'result'){
        		examineService.updateResultScore(currentUser.name,vm.result)
        		.then(function(response){
        			messageCenterService.add('success', '数据保存成功!', {timeout:1000});
        		},function(response){
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		});
        	}
        }
        
        vm.initResult=function(){
        	examineService.getResultScore(currentUser.name).then(function(response){
  	  			vm.result = response;
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
        
        vm.clickTab = function(name){
        	vm.selectTab = name;
        	vm.initData();
        }
        vm.printdiv = function(divName){
        	var printContents = document.getElementById(divName).innerHTML;
            var popupWin = window.open('', '_blank', 'width=800,height=900');
            popupWin.document.open();
            popupWin.document.write('<html><head><link rel="stylesheet" type="text/css" href="content/css/custom.css" /></head>');
            popupWin.document.write('<html><head><link rel="stylesheet" type="text/css" href="content/css/layout.css" /></head>');
            popupWin.document.write('<body onload="window.print()">' + printContents + '</body></html>');
            popupWin.document.close();
        }
        
        //load data
        vm.initData();
        
        vm.scrollTableStyle={
			"width":"100%",
			"height":(window.innerHeight-200),
			"overflow-y":"scroll",
			"margin-top":"-40px"
        };
        
    }
})();