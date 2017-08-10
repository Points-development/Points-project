/// <reference path="../../../../typings/tsd.d.ts" />

(function () {
    'use strict';
    
    angular
        .module('blocks.listener')
        .factory('listener', listenerFactory);

    listenerFactory.$inject = ['$log', '$rootScope', '$translatePartialLoader', '$translate', '$state', 'allPermissions', 'security'];
    
    function listenerFactory($log, $rootScope, $translatePartialLoader, $translate, $state, allPermissions, security) {
        var service = {
            listen: listen
        };
        
        return service;
        
        function listen() {
            
        	
        	$rootScope.$on('$stateChangeStart', function (event, toState) {
                var restrictedState = (toState.name !== 'login');
                if (restrictedState && !security.isAuthenticated()) {
                    $state.go('login', {}, { reload: true });
                    event.preventDefault();
                }
            });
            
            $rootScope.$on('$stateChangeSuccess', function(event, toState) {
                //For group i18n messages, we get second part at most
                var translateParts = toState.name.split('.'),
                    translatePart = translateParts.length > 1 ? translateParts[1] : translateParts[0];
                $translatePartialLoader.addPart(translatePart);
                //Always load home i18n part as a global i18n configuration
                if (translatePart !== 'home') {
                    $translatePartialLoader.addPart('home');
                }
                if (toState.name === 'home') {
//                    var viewAllJobs = security.hasPermission({
//                            op: allPermissions.operations.view,
//                            res: allPermissions.resources.allJobs
//                        }),
//                        viewAllHosts = security.hasPermission({
//                            op: allPermissions.operations.view,
//                            res: allPermissions.resources.allHosts
//                        }),
//                        viewAllUsers = security.hasPermission({
//                            op: allPermissions.operations.view,
//                            res: allPermissions.resources.allUsers
//                        });
//                    var currentStateName;
//                    if (viewAllJobs && viewAllHosts) {
//                        currentStateName = 'home.dashboard';
//                    } else if (viewAllHosts) {
//                        currentStateName = 'home.hosts.list';
//                    } else if (viewAllUsers) {
//                        currentStateName= 'home.users.list';
//                    } else {
//                        currentStateName = 'home.jobs.list';
//                    }
                    //$state.go(currentStateName, {}, { reload: true });
                }
            });
            
//            $rootScope.$on('$translatePartialLoaderStructureChanged', function () {
//                $translate.refresh();
//            });
        }
    }
})();