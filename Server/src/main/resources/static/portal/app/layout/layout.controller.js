/// <reference path='../../../typings/tsd.d.ts' />

(function () {
    'use strict';

    angular.module('portal.layout')
        .controller('LayoutController', LayoutController);

    LayoutController.$inject = ['$log', '$state', 'allPermissions', 'security','$uibModal','storage'];

    function LayoutController($log, $state, allPermissions, security,$uibModal,storage) {
        var vm = this;
        vm.refresh = function () {
            $state.go($state.current, {}, {reload: true});
        };
        vm.logout = function () {
        	storage.cleanSession();
            vm.currentUser = null;
            $state.go('login');
        };
        var states = $state.current.name.split(/\./);
        vm.activeNode =states[0]+'.'+states[1];
        vm.currentUser = security.getCurrentUser();
        // if refresh keep the highlight node
        vm.systemManage = true;
        vm.queryNode = false;
        if(vm.activeNode == 'home.system'){
        	vm.systemManage = true;
        }else if(vm.activeNode == 'home.query'){
        	vm.queryNode = true;
        }
        vm.viewMode = 'nav-md';
        
        vm.switchViewMode = function(){
        	if(vm.viewMode == 'nav-md'){
        		vm.viewMode = 'nav-sm';
        	}else{
        		vm.viewMode = 'nav-md';
        	}
        };
        
        vm.activeTreeNode = function(v){
        	vm.activeNode = v;
        	if(v == 'home.system'){
        		vm.systemManage = !vm.systemManage;
        	}else if(v == 'home.query'){
        		vm.queryNode = !vm.queryNode;
        	}
        	$state.go(v,{},{reload:true});
        };
        
        vm.changePwd = function(){
        	$uibModal.open({
        	      animation: true,
        	      ariaLabelledBy: 'modal-title-top',
        	      ariaDescribedBy: 'modal-body-top',
        	      templateUrl: 'pwdModel.html',
        	      controller:['$scope','$uibModalInstance','security',function($scope,$uibModalInstance,security) {
        	    	  $scope.change_error='';
        	    	  $scope.change_success='';
        	    	  $scope.changepwd_ok=function(){
        	    		  if($scope.change_success != ''){
        	    			  $uibModalInstance.close();
        	    		  }
        	    		  if($scope.newpwd != $scope.newpwd2){
        	    			  $scope.change_error = '新密码两次输入不一致';
        	    			  return false;
        	    		  }
        	    		  vm.currentUser.password = $scope.newpwd;
        	    		  security.changePwd(vm.currentUser,function(data){
        	    			  $scope.change_error ='';
        	    			  $scope.change_success='密码更新成功';
        	    			  
        	    		  },function(response){
        	    			  $scope.change_error = '修改失败';      	    			  
        	    		  });
        	    	  };
        	    	  $scope.changepwd_cancel=function(){
        	    		  $uibModalInstance.dismiss('cancel');
        	    	  };
        	      }]
        	});
        };
    }
})();