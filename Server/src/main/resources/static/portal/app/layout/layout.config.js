/// <reference path='../../../typings/tsd.d.ts' />

(function () {
    'use strict';

    angular.module('portal.layout')
        .config(config);

    config.$inject = ['$stateProvider', 'allPermissions'];

    function config($stateProvider, allPermissions) {
        $stateProvider
        	.state('home.system', {
	            url: '/system_user',
	            templateUrl: 'app/system/user/user.html',
	            controller:'UserManageController',
	      	    controllerAs: 'umCtrl'
	        })
	        .state('home.query', {
	            url: '/query_user',
	            templateUrl: 'app/query/query.html',
	            controller:'QueryController',
	      	    controllerAs: 'qcCtrl'
	        });
    }
    
})();