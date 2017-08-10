/// <reference path='../../../typings/tsd.d.ts' />

(function () {
    'use strict';

    angular.module('system.user')
        .controller('UserManageController', UserManageController);

    UserManageController.$inject = ['storage','messageCenterService','systemService','$uibModal'];

    function UserManageController(storage,messageCenterService,systemService,$uibModal) {
        var vm = this;
        
        vm.hasSelected=false;
		vm.checkAll = false;
        vm.init = function(){
        	vm.userlist = [];
        	systemService.getUsers().then(function(response){
        		for(var i=0;i<response.length;i++){
        			vm.userlist.push.apply(vm.userlist, response[i].users)
        		}
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
    		obj.checked = !obj.checked;
	      	if(obj.checked){
	      	}else{
	      		
	      	}
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
      	    	  	$scope.userPropertys = vm.userPropertys;
      	      		$scope.submit_user = function(){
	      	      		if(!$scope.name || !$scope.branch || !$scope.user.property || !$scope.admin){
		  	    			  $scope.error = '所有选项必填';
		  	    			  return false;
		  	    		}
	      	      		
	      	      		var user= {
	      	      				name:$scope.name,
	      	      				branch:$scope.branch,
	      	      				property:$scope.user.property,
	      	      				admin:$scope.admin=='true'?true:false
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
	    
	    vm.selectAll = function(){
	      	vm.checkAll = !vm.checkAll;
	      	for(var i=0;i<vm.userlist.length;i++){
	      		vm.userlist[i].checked=vm.checkAll;
	      	}
	    };
	    
	    vm.deleteUsers = function(){
	    	for(var i=0;i<vm.userlist.length;i++){
	      		if(vm.userlist[i].checked){
	      			
	      		}
	      	}
	    }
        vm.scrollTableStyle={
        				"width":"100%",
        				"height":(window.innerHeight-270),
        				"overflow-y":"scroll",
        				"margin-top":"-40px"
        };
        
    }
})();