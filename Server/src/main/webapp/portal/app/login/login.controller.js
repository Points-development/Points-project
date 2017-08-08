/// <reference path="../../../typings/tsd.d.ts" />

(function () {
    'use strict';

    angular.module('portal.login')
        .controller('LoginController', LoginCtrl);
    
    LoginCtrl.$inject = ['$state','$uibModal', 'security','loginService','storage'];
    
    function LoginCtrl($state,$uibModal, security,loginService,storage) {
        var vm = this;
        
        vm.login = login;
        
        //vm.getImage = "/unrestricted/verifycode?width=400&height=40";
        
        var successCallback = function () {
        		$state.go("home.system.user",{},{reload:true});
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