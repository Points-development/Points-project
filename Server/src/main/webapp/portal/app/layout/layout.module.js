/// <reference path="../../../typings/tsd.d.ts" />

(function () {
    'use strict';

    angular.module('portal.layout', [
        'portal.core'
    ]).directive('autoheight',['$window',function ($window) {
        return {
            restrict : 'A',
            scope : {},
            link : function($scope, element, attrs) {
                var winowHeight = $window.innerHeight-55;
                element.css('height',winowHeight + 'px');
                element.css('overflow-y','auto');
            }
        };
    }]);
})();
