/// <reference path='../../../typings/tsd.d.ts' />

(function () {
    'use strict';

    angular.module('system.user')
        .controller('UserManageController', UserManageController);

    UserManageController.$inject = ['storage','messageCenterService','systemService','$uibModal','security'];

    function UserManageController(storage,messageCenterService,systemService,$uibModal,security) {
        var vm = this;
		vm.selectUser = null;
		vm.currentUser = security.getCurrentUser();
        vm.init = function(){
			vm.hasSelected=0;
        	systemService.getUsers(vm.currentUser.branch).then(function(response){
        		vm.userlist = response;
        	},function(response){
        		messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        	});
        	systemService.getUsersProperty().then(function(response){
        		vm.userPropertys = response;
        	},function(response){
        		messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        	});
        }
        
        vm.queryUser = function(){
        	systemService.getUsers(vm.queryBranch).then(function(response){
        		vm.userlist = response;
        	},function(response){
        		messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        	});
        	systemService.getUsersProperty().then(function(response){
        		vm.userPropertys = response;
        	},function(response){
        		messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        	});
        }
        
        vm.selectCheck = function(obj){
        	vm.selectUser = obj;
	    };
	    
	    vm.addUser = function(){
	    	$uibModal.open({
      	      animation: true,
      	      size:"cm-user",
      	      ariaLabelledBy: 'modal-title-top',
      	      ariaDescribedBy: 'modal-body-top',
      	      templateUrl: 'templates/userModel.html',
      	      controller:['$scope','$uibModalInstance', function($scope,$uibModalInstance) {
      	    	  	$scope.error = '';
      	    	  	$scope.user={
      	    	  		property:''
      	    	  	}
      	    	  	$scope.admin = false;
      	    	  	$scope.userPropertys = vm.userPropertys;
      	      		$scope.submit_user = function(){
	      	      		if(!$scope.name || !$scope.branch || !$scope.user.property){
		  	    			  $scope.error = '所有选项必填';
		  	    			  return false;
		  	    		}
	      	      		
	      	      		var user= {
	      	      				name:$scope.name,
	      	      				branch:$scope.branch,
	      	      				property:$scope.user.property,
	      	      				admin:$scope.admin
	      	      		}
	      	      		
		      	      	systemService.createUser(user).then(function(response){
		      	      		messageCenterService.add('success', '创建成功!', {timeout:3000});
		      	      		vm.init();
		      	      		$uibModalInstance.dismiss('cancel');
		            	},function(response){
		            		messageCenterService.add('danger', response, {timeout:3000});
		            	});
      	      		}
      	      		$scope.cancel = function(){
      	    	  		$uibModalInstance.dismiss('cancel');
      	      		}
      	      }]
        	});
		}
			
	    vm.updateUser = function(){
	    	$uibModal.open({
	      	      animation: true,
	      	      size:"cm-user",
	      	      ariaLabelledBy: 'modal-title-top',
	      	      ariaDescribedBy: 'modal-body-top',
	      	      templateUrl: 'templates/userUpdateModel.html',
	      	      controller:['$scope','$uibModalInstance', function($scope,$uibModalInstance) {
	      	    	  	$scope.error = '';
	      	    	  	$scope.user=vm.selectUser;
	      	    	  	$scope.userPropertys = vm.userPropertys;
	      	    	  	$scope.resetPwd = false;
	      	      		$scope.submit_user = function(){
		      	      		if(!$scope.user.branch){
			  	    			  $scope.error = '支部选项必填';
			  	    			  return false;
		      	      		}
		      	      		if($scope.resetPwd){
		      	      			$scope.user.password = '123456';
		      	      		}else{
		      	      			delete $scope.user.password;
		      	      		}
			      	      	systemService.updateUser($scope.user).then(function(response){
			      	      		messageCenterService.add('success', '更新成功!', {timeout:3000});
			      	      		vm.init();
			      	      		$uibModalInstance.dismiss('cancel');
			            	},function(response){
			            		messageCenterService.add('danger', response, {timeout:3000});
			            	});
	      	      		}
	      	      		$scope.cancel = function(){
	      	    	  		$uibModalInstance.dismiss('cancel');
	      	      		}
	      	      }]
	        	});
		}
	    
        vm.scrollTableStyle={
        				"width":"100%",
        				"height":(window.innerHeight-270),
        				"overflow-y":"scroll",
        				"margin-top":"-40px"
        };
        
    }
})();