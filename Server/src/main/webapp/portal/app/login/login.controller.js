/// <reference path="../../../typings/tsd.d.ts" />

(function () {
    'use strict';

    angular.module('portal.login')
        .controller('LoginController', LoginCtrl);
    
    LoginCtrl.$inject = ['$state','$uibModal', 'security','loginService','storage','systemService'];
    
    function LoginCtrl($state,$uibModal, security,loginService,storage,systemService) {
        var vm = this;
        
        vm.login = login;
        
        //vm.getImage = "/unrestricted/verifycode?width=400&height=40";
        
        var successCallback = function () {
        	vm.currentUser = security.getCurrentUser();
        	systemService.getOrganizations().then(function(response){
        		vm.organizations = response;
        		storage.set('organizations',vm.organizations);
        		if(vm.organizations && vm.organizations.length>0){
					storage.set('organization',vm.organizations[0]);
					systemService.getBranches(vm.organizations[0]).then(function(response){
						vm.branchlist = response;
						storage.set('branches',vm.branchlist);
						if(vm.branchlist && vm.branchlist.length>0){
							storage.set('branch',vm.branchlist[0]);
							$state.go("home.organization.queryuser",{branchName:vm.branchlist[0]},{reload:true});
						}else{
							$state.go("home.organization.create",{},{reload:true});
						}
					},function(response){
						messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
						$state.go("home.organization.create",{},{reload:true});
					});
        			
        		}else{
        			$state.go("home.organization.create",{},{reload:true});
        		}
        	},function(response){
        		messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		$state.go("home.organization.create",{},{reload:true});
        	});
        		
        };
        
        var failCallback = function (data) {
        	if(data.message){
            	if(data.message.indexOf("verify code")>0){
            		vm.failedByVerify=true;
            	}else if(data.message.indexOf("not approved")>0){
            		vm.failedByRefuse=true;
            	}else{
            		vm.failedByUser = true;
            	}          	
            }else{
            	vm.failedByUser = true;
            }
        };
        
        function login() {
            if (vm.username && vm.password) {
                security.authenticate(vm, successCallback, failCallback);   
            } else {
                vm.failedByUser = true;
            }
        }
        
        vm.removeWran=function(v){
        	if(v=='code'){
        		vm.failedByVerify = false;
        	}else{
        		vm.failedByUser = false;
        	}
        	
        }
    }
})();