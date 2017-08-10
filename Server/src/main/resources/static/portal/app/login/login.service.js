/// <reference path="../../../typings/tsd.d.ts" />

(function () {
    'use strict';

    angular
        .module('portal.login')
        .factory('loginService', loginServiceFactory);

    loginServiceFactory.$inject = ['$log', '$filter', '$q', '$http', 'security'];

    function loginServiceFactory($log, $filter, $q, $http, security) {
        var factory = {};
        factory.addUser = function(user){
        	var deferred = $q.defer();
	        $http.post('/unrestricted/register' ,user, {
	        	skipAuthorization: true,
	            headers: {
	                'Content-Type': 'application/json'
	            }}
	        ).then(
	            function (resp) {
	                deferred.resolve(resp.data);
	            },
	            function (resp) {
	                deferred.reject(angular.fromJson(resp.data));
	            }
	        );
	        return deferred.promise;
        }
        return factory;

    }
})();