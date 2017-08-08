/// <reference path="../../../../typings/tsd.d.ts" />

(function () {
    'use strict';
    
    angular
        .module('blocks.security')
        .factory('security', securityFactory);

    securityFactory.$inject = ['$log', '$http', 'jwtHelper', 'storage'];
    
    function securityFactory($log, $http, jwtHelper, storage) {
        var service = {
            authenticate: authenticate,
            isAuthenticated: isAuthenticated,
            getCurrentUser: getCurrentUser,
            hasPermission: hasPermission,
            changePwd:changePwd,
            clean: clean
        };
        return service;
        
        function authenticate(authVModel, successCallback, failCallback) {
            $http.post('/pointservice/login', 
                {
                    name: authVModel.username,
                    password: authVModel.password
                }, {
                    skipAuthorization: true,
                    headers: {
                        'Content-Type': 'application/json',
                        'Accept': 'application/json'
                    }
                }).then(
                    function (response) {
                        storage.set('currentUser', response.data);
                        if(!response.data.admin){
                        	failCallback({message:'user is not approved'});
                        }else{
                        	successCallback();
                        }
                        
                    },
                    function (response) {
                        failCallback(response.data);
                    }
                );
        }
        
        function isAuthenticated() {
            var currentUser = storage.get('currentUser') || storage.getFromLocal('currentUser');
            if (currentUser) {
                return true;
            }
            return false;
        }
        
        function  getCurrentUser() {
            return storage.get('currentUser') || storage.getFromLocal('currentUser');
        }

        function hasPermission(needPermission) {
            if (!needPermission) {
                return false;
            }
            var currentUser = storage.get('currentUser') || storage.getFromLocal('currentUser');
            if (!currentUser || jwtHelper.isTokenExpired(currentUser.token)) {
                return false;
            }
            var hasPerm = false;
            for (var j = 0; j < currentUser.authorities.length; j++) {
                if ((needPermission.op + '_' + needPermission.res) == currentUser.authorities[j].authority) {
                    hasPerm = true;
                    break; 
                }
            }
            return hasPerm;
        }
        
        function clean() {
            storage.cleanAll();
        }
        
        function changePwd(pwdModel,successCallback, failCallback){
        	$http.put('/pointservice/user/'+pwdModel.name, 
        			pwdModel
        			, {
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    }).then(
                        function (response) {
                            successCallback(response.data);
                        },
                        function (response) {
                            failCallback(response);
                        }
                    );
        }
    }
})();