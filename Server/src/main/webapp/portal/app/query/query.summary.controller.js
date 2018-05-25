

(function () {
    'use strict';

    angular.module('query.user')
        .controller('QuerySummaryController', QuerySummaryController);

    QuerySummaryController.$inject = ['messageCenterService', 'systemService'];

    function QuerySummaryController(messageCenterService, systemService) {
    	var vm = this;
        vm.summary = [];
        vm.startQuery = function(){
        	vm.summary = [];
        	systemService.getQuestionSummary().then(function(response){
        		vm.summary = response;
        	},function(response){
        		if(response.error){
        			messageCenterService.add('danger', response.error, {timeout:3000});
        		}else{
        			messageCenterService.add('danger', '数据请求失败!', {timeout:3000});
        		}
        		
        	});
        }
        
        vm.scrollTableStyle={
        				"width":"100%",
        				"height":(window.innerHeight-270),
        				"overflow-y":"scroll",
        				"margin-top":"-40px"
        };
        

        /**
         * 打印局部div
         * @param printpage 局部div的ID
         */

        vm.printdiv = function (divName) {
        	var printContents = document.getElementById(divName).innerHTML;
            var popupWin = window.open('', '_blank', 'width=800,height=900');
            popupWin.document.open();
            popupWin.document.write('<html><head><link rel="stylesheet" type="text/css" href="content/css/layout.css" /></head>');
            popupWin.document.write('<body onload="window.print()">' + printContents + '</body></html>');
            popupWin.document.close();
        }
        
    }
})();