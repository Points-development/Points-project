/// <reference path='../../../typings/tsd.d.ts' />

(function () {
    'use strict';

    angular.module('system.user')
        .controller('UserManageController', UserManageController);

    UserManageController.$inject = ['storage','messageCenterService','systemService','$uibModal','security','$stateParams','$state'];

    function UserManageController(storage,messageCenterService,systemService,$uibModal,security,$stateParams,$state) {
        var vm = this;
		vm.selectUser = null;
		vm.currentUser = security.getCurrentUser();
		vm.branch = $stateParams.branchName;
        vm.init = function(){
        	vm.selectUser = null;
        	systemService.getUsers(vm.branch,vm.currentUser.organization).then(function(response){
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
        	systemService.getUsers(vm.branch,vm.currentUser.organization).then(function(response){
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
      	      controller:['$scope','$uibModalInstance','storage', function($scope,$uibModalInstance,storage) {
      	    	  	$scope.error = '';
      	    	  	$scope.user={
      	    	  		property:'',
      	    	  		organization:vm.currentUser.organization
      	    	  	}
      	    	  	$scope.branch = vm.branch;
      	    	  	$scope.admin = false;
					$scope.sex = true;
      	    	  	$scope.userPropertys = vm.userPropertys;
      	      		$scope.submit_user = function(){
	      	      		if(!$scope.name || !$scope.realName || !$scope.branch || !$scope.user.property){
		  	    			  $scope.error = '所有选项必填';
		  	    			  return false;
		  	    		}
	      	      		
	      	      		var user= {
	      	      				name:$scope.name,
	      	      				realName:$scope.realName,
								sex:$scope.sex,
	      	      				organization:$scope.user.organization,
	      	      				branch:$scope.branch,
	      	      				property:$scope.user.property,
	      	      				admin:$scope.admin,
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
	    
	    vm.deleteUser = function(){
			$uibModal.open({
      	    	animation: true,
      	    	size:"csm",
      	    	ariaLabelledBy: 'modal-title-top',
      	    	ariaDescribedBy: 'modal-body-top',
				templateUrl: 'templates/confirmDeleteTemp.html',
      	        controller:['$scope','$uibModalInstance', function($scope,$uibModalInstance) {
      	        	$scope.deleteItem = '所选用户';
      	      		$scope.delete_ok = function(){
	      	      		systemService.deleteUser(vm.selectUser.name).then(function(response){
	  	      				messageCenterService.add('success', '删除成功!', {timeout:3000});
							vm.init();
							$uibModalInstance.close($scope);
							vm.selectUser = null;
						},	function(response){
							messageCenterService.add('danger', response, {timeout:3000});
						});	
					}
									  
      	      		$scope.delete_cancel = function(){
      	    	  		$uibModalInstance.dismiss('cancel');
      	      		}
      	      	}]		
			})
		}
	    
	    vm.deleteBranch = function(){
	    	$uibModal.open({
                animation: true,
                ariaLabelledBy: 'modal-title-top',
                ariaDescribedBy: 'modal-body-top',
                size:"csm",
                templateUrl: 'templates/confirmDeleteTemp.html',
                controller:['$scope','$uibModalInstance', function($scope,$uibModalInstance) {
                    $scope.deleteItem = '本支部及所有用户';
                    $scope.delete_cancel=function(){
                        $uibModalInstance.dismiss('cancel');
                    }
                    $scope.delete_ok = function(){
                    	systemService.deleteBranch(vm.branch,vm.currentUser.organization).then(function(response){
		      	      		messageCenterService.add('success', '删除成功!', {timeout:1000});
		      	      		$uibModalInstance.dismiss('cancel');
		      	      		$scope.$emit('layout.update.tree', 'child');
		      	      		$state.go('home.organization.create',{},{reload:true});
		            	},function(response){
		            		messageCenterService.add('danger', response, {timeout:3000});
		            	});
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
	      	      controller:['$scope','$uibModalInstance','storage', function($scope,$uibModalInstance,storage) {
	      	    	  	$scope.error = '';
	      	    	  	$scope.user=vm.selectUser;
	      	    	  	$scope.resetPwd = false;
	      	    	  	$scope.userPropertys = vm.userPropertys;
	      	    	  	$scope.branch = vm.branch;
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
	      	      			vm.init();
	      	    	  		$uibModalInstance.dismiss('cancel');
	      	      		}
	      	      }]
	        	});
		}
	    
        vm.scrollTableStyle={
			"width":"100%",
			"height":(window.innerHeight-200),
			"overflow-y":"scroll",
			"margin-top":"-40px"
        };
        
    }
})();