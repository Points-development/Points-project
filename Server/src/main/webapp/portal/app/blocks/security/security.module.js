/// <reference path="../../../../typings/tsd.d.ts" />

(function () {
    'use strict';
    
    angular
        .module('blocks.security', [])
        .constant('allPermissions', {
            operations: {
                view: 'VIEW',
                ctrl: 'CONTROL',
                all:'ALL'
            },
            resources: {
                allLines:"ALL_TRAVEL_LINES",
                manageSystem:"SYSTEM_MANAGE",
                manageDestinationCity:"DESTINATION_CITY_MANAGE"
            }
        });
})();