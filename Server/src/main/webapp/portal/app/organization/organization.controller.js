/// <reference path='../../../typings/tsd.d.ts' />

(function () {
    'use strict';

    angular.module('portal.organization')
        .controller('OrganizeController', OrganizeController);

    OrganizeController.$inject = ['storage','messageCenterService','systemService','security','$scope'];

    function OrganizeController(storage,messageCenterService,systemService,security,$scope) {
        var vm = this;
        var currentUser = security.getCurrentUser();
        vm.userName = currentUser.name;
        
        vm.createNewBranch = function(){
        	systemService.addBranch(vm.newBranch,currentUser.organization).then(function(response){
        		messageCenterService.add('success', '支部创建成功!', {timeout:1000});
        		$scope.$emit('layout.update.tree', 'child');
        	},function(response){
        		messageCenterService.add('danger', '支部创建失败!', {timeout:3000});
        	});
        }
        
    }
})();