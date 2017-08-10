/// <reference path="../../typings/tsd.d.ts" />

(function () {
    'use strict';
    
    angular.module('portal').config(config);
        
    config.$inject = ['$translateProvider', '$urlRouterProvider', '$stateProvider', '$httpProvider', 'allPermissions'];
    
    function config($translateProvider, $urlRouterProvider, $stateProvider, $httpProvider, allPermissions) {

    		$translateProvider
        .determinePreferredLanguage()
        .fallbackLanguage('en_US');
        
        $stateProvider
            .state('home', {
                url: '/home',
                templateUrl: 'app/layout/layout.html',
                controller: 'LayoutController',
                controllerAs: 'lac'
            })
            .state('login', {
                url: '/login',
                templateUrl: 'app/login/login.html',
                controller: 'LoginController',
                controllerAs: 'loginCtrl'
            })
            .state('resetpwd', {
                url: '/resetpwd',
                templateUrl: 'app/login/resetpwd.html',
                controller: 'LoginController',
                controllerAs: 'loginCtrl'
            })
            .state('register', {
                url: '/register',
                templateUrl: 'app/login/register.html',
                controller: 'LoginController',
                controllerAs: 'loginCtrl'
            });
        //router
        $urlRouterProvider.otherwise('/login');
    }
})();