(function () {
    'use strict';

    angular.module('portal.system')
        .factory('systemService', systemService);

    systemService.$inject = ['$http','$q'];

    function systemService($http,$q) {
        var factory = {};
        
        factory.getUsers = function(branch){
            var deferred = $q.defer();
            $http.get('/pointservice/branch?branch='+encodeURIComponent(branch)).then(
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
        factory.updateUser = function(user){
            var deferred = $q.defer();
            $http.put('/pointservice/user/'+user.name,user).then(
                    function (resp) {
                        deferred.resolve(resp.data);
                    },
                    function (resp) {
                        deferred.reject(resp.data);
                    }
             );
            return deferred.promise;
        };
        factory.deleteUser = function(username){
            var deferred = $q.defer();
            $http.delete('/pointservice/user/'+username).then(
                    function (resp) {
                        deferred.resolve(resp.data);
                    },
                    function (resp) {
                        deferred.reject(resp.data);
                    }
             );
            return deferred.promise;
        };
        factory.getUsersScore = function(branch){
            var deferred = $q.defer();
            $http.get('/pointservice/score/points?branch='+branch).then(
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