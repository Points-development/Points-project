(function () {
    'use strict';

    angular.module('portal.examine')
        .factory('examineService', examineService);

    examineService.$inject = ['$http','$q'];

    function examineService($http,$q) {
        var factory = {};
        
        factory.getPublicScore = function(branch,organization){
            var deferred = $q.defer();
            var branch = encodeURIComponent(branch);
            var organization = encodeURIComponent(organization);
            $http.get('/pointservice/pingyi/qunzhongpingyi?branch='+branch+'&organization='+organization).then(
                function (resp) {
                    deferred.resolve(resp.data);
                },
                function (resp) {
                    deferred.reject(resp.data);
                }
            );
            return deferred.promise;
        };
        factory.updatePublicScore = function(branch,organization,list){
            var deferred = $q.defer();
            var branch = encodeURIComponent(branch);
            var organization = encodeURIComponent(organization);
            $http.post('/pointservice/pingyi/qunzhongpingyi?branch='+branch+'&organization='+organization,list).then(
                function (resp) {
                    deferred.resolve(resp.data);
                },
                function (resp) {
                    deferred.reject(resp.data);
                }
            );
            return deferred.promise;
        };
        
        factory.getSelfScore = function(branch,organization){
            var deferred = $q.defer();
            var branch = encodeURIComponent(branch);
            var organization = encodeURIComponent(organization);
            $http.get('/pointservice/pingyi/ziping?branch='+branch+'&organization='+organization).then(
                function (resp) {
                    deferred.resolve(resp.data);
                },
                function (resp) {
                    deferred.reject(resp.data);
                }
            );
            return deferred.promise;
        };
        factory.updateSelfScore = function(branch,organization,list){
            var deferred = $q.defer();
            var branch = encodeURIComponent(branch);
            var organization = encodeURIComponent(organization);
            $http.post('/pointservice/pingyi/ziping?branch='+branch+'&organization='+organization,list).then(
                function (resp) {
                    deferred.resolve(resp.data);
                },
                function (resp) {
                    deferred.reject(resp.data);
                }
            );
            return deferred.promise;
        };
        
        factory.getEachScore = function(branch,organization){
            var deferred = $q.defer();
            var branch = encodeURIComponent(branch);
            var organization = encodeURIComponent(organization);
            $http.get('/pointservice/pingyi/huping?branch='+branch+'&organization='+organization).then(
                function (resp) {
                    deferred.resolve(resp.data);
                },
                function (resp) {
                    deferred.reject(resp.data);
                }
            );
            return deferred.promise;
        };
        factory.updateEachScore = function(branch,organization,list){
            var deferred = $q.defer();
            var branch = encodeURIComponent(branch);
            var organization = encodeURIComponent(organization);
            $http.post('/pointservice/pingyi/huping?branch='+branch+'&organization='+organization,list).then(
                function (resp) {
                    deferred.resolve(resp.data);
                },
                function (resp) {
                    deferred.reject(resp.data);
                }
            );
            return deferred.promise;
        };
        
        factory.getOrganizationScore = function(branch,organization){
            var deferred = $q.defer();
            var branch = encodeURIComponent(branch);
            var organization = encodeURIComponent(organization);
            $http.get('/pointservice/pingyi/zuzhipingjia?branch='+branch+'&organization='+organization).then(
                function (resp) {
                    deferred.resolve(resp.data);
                },
                function (resp) {
                    deferred.reject(resp.data);
                }
            );
            return deferred.promise;
        };
        factory.updateOrganizationScore = function(branch,organization,list){
            var deferred = $q.defer();
            var branch = encodeURIComponent(branch);
            var organization = encodeURIComponent(organization);
            $http.post('/pointservice/pingyi/zuzhipingjia?branch='+branch+'&organization='+organization,list).then(
                function (resp) {
                    deferred.resolve(resp.data);
                },
                function (resp) {
                    deferred.reject(resp.data);
                }
            );
            return deferred.promise;
        };
        
        factory.getSummaryScore = function(branch,organization){
            var deferred = $q.defer();
            var branch = encodeURIComponent(branch);
            var organization = encodeURIComponent(organization);
            $http.get('/pointservice/pingyi/defenhuizong?branch='+branch+'&organization='+organization).then(
                function (resp) {
                    deferred.resolve(resp.data);
                },
                function (resp) {
                    deferred.reject(resp.data);
                }
            );
            return deferred.promise;
        };
        factory.updateSummaryScore = function(branch,organization,list){
            var deferred = $q.defer();
            var branch = encodeURIComponent(branch);
            var organization = encodeURIComponent(organization);
            $http.post('/pointservice/pingyi/defenhuizong?branch='+branch+'&organization='+organization,list).then(
                function (resp) {
                    deferred.resolve(resp.data);
                },
                function (resp) {
                    deferred.reject(resp.data);
                }
            );
            return deferred.promise;
        };
        factory.getResultScore = function(username){
            var deferred = $q.defer();
            var branch = encodeURIComponent(branch);
            var organization = encodeURIComponent(organization);
            $http.get('/pointservice/pingyi/baogaodan?username='+username).then(
                function (resp) {
                    deferred.resolve(resp.data);
                },
                function (resp) {
                    deferred.reject(resp.data);
                }
            );
            return deferred.promise;
        };
        factory.updateResultScore = function(username,result){
            var deferred = $q.defer();
            var branch = encodeURIComponent(branch);
            var organization = encodeURIComponent(organization);
            $http.post('/pointservice/pingyi/baogaodan?username='+username,result).then(
                function (resp) {
                    deferred.resolve(resp.data);
                },
                function (resp) {
                    deferred.reject(resp.data);
                }
            );
            return deferred.promise;
        };
        factory.resetScore = function(branch){
            var deferred = $q.defer();
            var branch = encodeURIComponent(branch);
            $http.delete('/pointservice/score/points?branch='+branch).then(
                function (resp) {
                    deferred.resolve(resp.data);
                },
                function (resp) {
                    deferred.reject(resp.data);
                }
            );
            return deferred.promise;
        };
		factory.getPartyScore = function(branch,organization){
            var deferred = $q.defer();
            var branch = encodeURIComponent(branch);
            var organization = encodeURIComponent(organization);
            $http.get('/pointservice/pingyi/partyhistory?branch='+branch+'&organization='+organization).then(
                function (resp) {
                    deferred.resolve(resp.data);
                },
                function (resp) {
                    deferred.reject(resp.data);
                }
            );
            return deferred.promise;
        };
        factory.updatePartyScore = function(branch,organization,parties){
            var deferred = $q.defer();
            var branch = encodeURIComponent(branch);
            var organization = encodeURIComponent(organization);
            $http.post('/pointservice/pingyi/partyhistory?branch='+branch+'&organization='+organization,parties).then(
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