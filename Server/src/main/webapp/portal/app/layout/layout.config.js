/// <reference path='../../../typings/tsd.d.ts' />

(function () {
    'use strict';

    angular.module('portal.layout')
        .config(config);

    config.$inject = ['$stateProvider', 'allPermissions'];

    function config($stateProvider, allPermissions) {
        $stateProvider
	        .state('home.organization', {
	            url: '/organization',
	            abstract: true,
	            template: '<ui-view/>'
	        })
	        .state('home.organization.create', {
	            url: '/organization_create',
	            templateUrl: 'app/organization/create.html',
	            controller:'OrganizeController',
	      	    controllerAs: 'ocCtrl'
	        })
	        .state('home.organization.queryuser', {
	            url: '/organization_queryuser/:branchName',
	            templateUrl: 'app/system/user/user.html',
	            controller:'UserManageController',
	      	    controllerAs: 'umCtrl'
	        })
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
	      	    controllerAs: 'qcCtrl',
	      	    resolve: {
		      		transferUser:function(){
		      			return null;
		  	        }
		  	    }
	        }).state('home.examine', {
	            url: '/examine',
	            abstract: true,
	            template: '<ui-view/>'
	        }).state('home.examine.public', {
	            url: '/examine_public',
	            templateUrl: 'app/examine/examine_public.html',
	            controller:'ExamineController',
	      	    controllerAs: 'ecCtrl',
		      	resolve: {
		      		transferUser:function(){
		      			return null;
		  	        }
		  	    }
	        }).state('home.examine.self', {
	            url: '/examine_self',
	            templateUrl: 'app/examine/examine_self.html',
	            controller:'ExamineController',
	      	    controllerAs: 'ecCtrl',
		      	resolve: {
		      		transferUser:function(){
		      			return null;
		  	        }
		  	    }
	        }).state('home.examine.each', {
	            url: '/examine_each',
	            templateUrl: 'app/examine/examine_each.html',
	            controller:'ExamineController',
	      	    controllerAs: 'ecCtrl',
		      	resolve: {
		      		transferUser:function(){
		      			return null;
		  	        }
		  	    }
	        }).state('home.examine.organization', {
	            url: '/examine_organization',
	            templateUrl: 'app/examine/examine_organization.html',
	            controller:'ExamineController',
	      	    controllerAs: 'ecCtrl',
		      	resolve: {
		      		transferUser:function(){
		      			return null;
		  	        }
		  	    }
	        }).state('home.examine.summary', {
	            url: '/examine_summary',
	            templateUrl: 'app/examine/examine_summary.html',
	            controller:'ExamineController',
	      	    controllerAs: 'ecCtrl',
		      	resolve: {
		      		transferUser:function(){
		      			return null;
		  	        }
		  	    }
	        }).state('home.examine.query', {
	            url: '/examine_query/:branchName',
	            templateUrl: 'app/examine/examine.html',
	            controller:'ExamineController',
	      	    controllerAs: 'ecCtrl',
		      	resolve: {
		      		transferUser:function(){
		      			return null;
		  	        }
		  	    }
	        });
    }
    
})();