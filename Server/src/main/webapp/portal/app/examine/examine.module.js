(function () {
    'use strict';

    angular.module('portal.examine', [
         'portal.core',
		 'chart.js',
		 'rzSlider'
    ]).directive('contenteditable', ['$sce', function($sce) {
    	  return {
    		    restrict: 'A', // only activate on element attribute
    		    require: '?ngModel', // get a hold of NgModelController
    		    link: function(scope, element, attrs, ngModel) {
    		      if (!ngModel) return; // do nothing if no ng-model

    		      function read() {
    		          ngModel.$setViewValue(element.html());
    		        }

    		        ngModel.$render = function() {
    		          element.html(ngModel.$viewValue || "&nbsp;");
    		        };

    		        element.bind("blur keyup change", function() {
    		          scope.$apply(read);
    		        });
    		    }
    		  };
    }]);
})();