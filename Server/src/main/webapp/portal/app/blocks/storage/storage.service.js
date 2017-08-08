(function () {
    'use strict';
    
    angular
        .module('blocks.storage')
        .factory('storage', storageFactory);

    storageFactory.$inject = ['$log', '$sessionStorage', '$localStorage'];
    
    function storageFactory($log, $sessionStorage, $localStorage) {
        var service = {
            set: set,
            setToLocal: setToLocal,
            get: get,
            getFromLocal: getFromLocal,
            cleanAll: cleanAll,
            cleanSession:cleanSession,
            cleanLocal:cleanLocal          
        };
        return service;
        
        function set(key, value) {
            $sessionStorage[key] = value;
        }
        
        function setToLocal(key, value) {
            $localStorage[key] = value;
        }
        
        function get(key) {
            return $sessionStorage[key];
        }
        
        function getFromLocal(key) {
            return $localStorage[key];
        }
        
        function cleanAll() {
            $sessionStorage.$reset();
            $localStorage.$reset();
        }
        
        function cleanSession() {
            $sessionStorage.$reset();
        }
        
        function cleanLocal() {
            $localStorage.$reset();
        }
    }
})();