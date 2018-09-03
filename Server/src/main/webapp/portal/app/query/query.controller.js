/// <reference path='../../../typings/tsd.d.ts' />

(function () {
    'use strict';

    angular.module('query.user')
        .controller('QueryController', QueryController);

    QueryController.$inject = ['storage','messageCenterService','systemService','security','$uibModal','transferUser'];

    function QueryController(storage,messageCenterService,systemService,security,$uibModal,transferUser) {
        var vm = this;
        var currentUser = security.getCurrentUser();
        vm.userName = currentUser.name;
        vm.branch = currentUser.branch;
        vm.organization = currentUser.organization;
        vm.queryObject = null;
        vm.resultlist = [];
        vm.selectTab ='self';
        vm.startQuery = function(branch){
        	vm.resultlist = [];
        	systemService.getUsersScore(branch).then(function(response){
        		vm.resultlist = response;
        	},function(response){
        		if(response.error){
        			messageCenterService.add('danger', response.error, {timeout:3000});
        		}else{
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		}
        		
        	});
        }
        
        vm.scrollTableStyle={
        				"width":"100%",
        				"height":(window.innerHeight-270),
        				"overflow-y":"scroll",
        				"margin-top":"-40px"
        };
        
        vm.getScore = function(obj){
        	
        	return obj.selfPoint+obj.otherPoint;
        }
        
        vm.getAnswer = function(other){
        	let scoree = transferUser.self;
        	let scorer = transferUser.self;
        	if(other){
        		scorer = other;
        	}
        	
        	systemService.getQuestion(scoree).then(function(response){
        		vm.questionResult = response;
        		systemService.getAnswer(scoree,scorer).then(function(response2){
            		vm.scoreResult = response2[0];
            	},function(response2){
            		vm.scoreResult = null;
            		if(response2.error){
            			messageCenterService.add('danger', response2.error, {timeout:3000});
            		}else{
            			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
            		}
            	});
        	},function(response){
        		if(response.error){
        			messageCenterService.add('danger', response.error, {timeout:3000});
        		}else{
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		}        		
        	});
        }
        
        vm.checkAnswer = function(question,option){
        	for(var i=0;i<vm.scoreResult.scores.length;i++){
        		if(vm.scoreResult.scores[i].questionId == question.id 
        				&& vm.scoreResult.scores[i].optionsId == option.id){
        			return true;
        		}
        	}
        	return false;
        }
        
        vm.getQuestionAnser = function(question){
        	for(var i=0;i<vm.scoreResult.scores.length;i++){
        		if(vm.scoreResult.scores[i].questionId == question.id){
        			return vm.scoreResult.scores[i].answer;
        		}
        	}
        	return null;
        }
        
        vm.clickTab = function(name){
        	vm.scoreResult = null;
        	vm.selectTab = name;
        	if(name == 'self'){
        		vm.getAnswer();
        	}else{
        		systemService.getSameBranchUsers(transferUser.self).then(function(response){
            		vm.userlist = response;
            		vm.userlist = vm.userlist.filter(function(u){
            			return u.name != transferUser.self;
            		});
            		if(vm.userlist.length>0){
            			vm.getAnswer(vm.userlist[0].name);
            		}
            		
            	},function(response){
            		messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
            	});
        	}
        	
        }
        
        vm.seeDetail = function(obj){
        	$uibModal.open({
	      	      animation: true,
	      	      size:"cm-user",
	      	      ariaLabelledBy: 'modal-title-top',
	      	      ariaDescribedBy: 'modal-body-top',
	      	      templateUrl: 'app/query/paper_details.html',
		      	  controller:'QueryController',
	  	          controllerAs: 'qcCtrl',
		  	      resolve: {
		  	    	  transferUser:function(){
		  	        	   return {self:obj.username};
		  	           }
		  	       }
	        });
        }
        

        /**
         * 打印局部div
         * @param printpage 局部div的ID
         */

        vm.printdiv = function (divName) {
        	var printContents = document.getElementById(divName).innerHTML;
            var popupWin = window.open('', '_blank', 'width=800,height=900');
            popupWin.document.open();
            popupWin.document.write('<html><head><link rel="stylesheet" type="text/css" href="content/css/layout.css" /></head>');
            popupWin.document.write('<body onload="window.print()">' + printContents + '</body></html>');
            popupWin.document.close();
        }
        
    }
})();