(function () {
    'use strict';

    angular.module('portal.system')
        .factory('systemService', systemService);

    systemService.$inject = ['$http','$q'];

    function systemService($http,$q) {
        var factory = {};
        
        factory.getUsers = function(){
            var deferred = $q.defer();
            $http.get('/pointservice/user').then(
                    function (resp) {
                        deferred.resolve(resp.data);
                    },
                    function (resp) {
                        deferred.reject(resp.data);
                    }
            );
            return deferred.promise;
        };
        factory.getUsersProperty = function(){
            var deferred = $q.defer();
            $http.get('/pointservice/user/property').then(
                    function (resp) {
                        deferred.resolve(resp.data);
                    },
                    function (resp) {
                        deferred.reject(resp.data);
                    }
            );
            return deferred.promise;
        };
        factory.createUser = function(user){
            var deferred = $q.defer();
            $http.post('/pointservice/user',user).then(
                    function (resp) {
                        deferred.resolve(resp.data);
                    },
                    function (resp) {
                        deferred.reject(resp.data);
                    }
             );
            return deferred.promise;
        };
        factory.deleteUser = function(desId,routeId){
            var deferred = $q.defer();
            $http.delete('/pointservice/').then(
                    function (resp) {
                        deferred.resolve(resp.data);
                    },
                    function (resp) {
                        deferred.reject(resp.data);
                    }
             );
            return deferred.promise;
        };
        factory.updateUser = function(user){
            var deferred = $q.defer();
            $http.put('/pointservice/user',user).then(
                    function (resp) {
                        deferred.resolve(resp.data);
                    },
                    function (resp) {
                        deferred.reject(resp.data);
                    }
             );
            return deferred.promise;
        };
        return factory;
    }
})();