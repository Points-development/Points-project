/// <reference path="../../typings/tsd.d.ts" />

(function () {
    'use strict';

    angular.module('portal', [
        /* Shared modules */
        'portal.core',

        /* Feature modules */
        'portal.login',
        'portal.layout',
        'portal.system',
        'portal.query'
    ]);
})();