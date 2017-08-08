/// <reference path='../../../typings/tsd.d.ts' />

(function () {
    'use strict';

    angular.module('portal.layout')
        .config(config);

    config.$inject = ['$stateProvider', 'allPermissions'];

    function config($stateProvider, allPermissions) {
        $stateProvider
        	.state('home.system', {
            abstract: true,
            url: '/manage',
            template: '<ui-view/>',
              permissions: [{
                  op: allPermissions.operations.all,
                  res: allPermissions.resources.manageSystem
              }]
	        }).state('home.system.user', {
	            url: '/system_user',
	            templateUrl: 'app/system/user/user.html',
	            controller:'UserManageController',
	      	    controllerAs: 'umCtrl'
	        });
    }
    
})();