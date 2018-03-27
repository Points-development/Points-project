/// <reference path='../../../typings/tsd.d.ts' />

(function () {
    'use strict';

    angular.module('query.user')
        .controller('QueryController', QueryController);

    QueryController.$inject = ['storage','messageCenterService','systemService','security'];

    function QueryController(storage,messageCenterService,systemService,security) {
        var vm = this;
        var currentUser = security.getCurrentUser();
        vm.userName = currentUser.name;
        vm.branch = currentUser.branch;
        vm.queryObject = null;
        vm.resultlist = [];
        vm.startQuery = function(branch){
        	vm.resultlist = [];
        	systemService.getUsersScore(branch).then(function(response){
        		vm.resultlist = response;
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
        
        vm.getScore = function(obj){
        	
        	return obj.selfPoint+obj.otherPoint;
        }

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