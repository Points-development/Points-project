/// <reference path="../../typings/tsd.d.ts" />

(function () {
    'use strict';
    
    angular.module('portal')
        .run(startup);
    
    startup.$inject = ['listener'];
        
    function startup(listener) {
        listener.listen();
    }
    
})();