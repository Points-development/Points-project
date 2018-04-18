/// <reference path='../../../typings/tsd.d.ts' />

(function () {
    'use strict';

    angular.module('portal.layout')
        .controller('LayoutController', LayoutController);

    LayoutController.$inject = ['$log','$rootScope', '$state', 'allPermissions', 'security','$uibModal','storage','systemService','messageCenterService'];

    function LayoutController($log, $scope,$state,allPermissions, security,$uibModal,storage,systemService,messageCenterService) {
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
        if(storage.get('branches')){
        	vm.branchlist = storage.get('branches');
        }
        if($state.current.name == 'home.organization.queryuser'){
        	vm.activeSubNode = 'home.organization.'+storage.get('branch');
        }else if($state.current.name == 'home.examine.query'){
        	vm.activeSubNode = 'home.examine.'+storage.get('branch');
        }else{
        	vm.activeSubNode = $state.current.name;
        }
        
        vm.currentUser = security.getCurrentUser();
        // if refresh keep the highlight node
        vm.organizationNode = vm.queryNode =vm.examineNode =  false;
        if(vm.activeNode == 'home.organization'){
        	vm.organizationNode = true;
        }else if(vm.activeNode == 'home.system'){
        	vm.systemManage = true;
        }else if(vm.activeNode == 'home.query'){
        	vm.queryNode = true;
        }else if(vm.activeNode == 'home.examine'){
        	vm.examineNode = true;
        }
        vm.viewMode = 'nav-md';
        
        vm.switchViewMode = function(){
        	if(vm.viewMode == 'nav-md'){
        		vm.viewMode = 'nav-sm';
        	}else{
        		vm.viewMode = 'nav-md';
        	}
        };
        
        var getBranchList = function(){
        	systemService.getBranches(vm.currentUser.organization).then(function(response){
        		vm.branchlist = response;
        		storage.set('branches',vm.branchlist);
        	},function(response){
        		messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        	});
        }
        
        $scope.$on('layout.update.tree', function(event,data) {
        	getBranchList();
        });
        
        vm.activeTreeNode = function(v){
        	vm.activeNode = v;
        	if(v == 'home.system'){
        		vm.systemManage = !vm.systemManage;
        	}else if(v == 'home.query'){
        		vm.queryNode = !vm.queryNode;
        	}else if(v == 'home.organization'){
        		vm.organizationNode = !vm.organizationNode;
        		getBranchList();
        		return;
        	}else if(v == 'home.examine'){
        		vm.examineNode = !vm.examineNode;
        		getBranchList();
        		return;
        	}
        	$state.go(v,{},{reload:true});
        };
        
        vm.activeSubTreeNode = function(v,$event,branch){
        	$event.stopPropagation();
        	if(branch){
        		storage.set('branch',branch);
        		$state.go(v,{branchName:branch},{reload:true});
        	}else{
        		vm.activeSubNode = v;
        		$state.go(v,{},{reload:true});
        	}
        	
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