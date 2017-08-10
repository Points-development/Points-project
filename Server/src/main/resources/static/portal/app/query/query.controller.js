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
        vm.queryObject = null;
        vm.resultlist = [];
        vm.startQuery = function(){
        	vm.resultlist = [];
        	systemService.getUsersScore(vm.queryObject).then(function(response){
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
        	var score = 0;
        	for(var i=0;i<obj.scores.length;i++){
        		if(obj.scores[i].optionsId == 1){
        			score +=5
        		}
        		if(obj.scores[i].optionsId == 2){
        			score +=3
        		}
        		if(obj.scores[i].optionsId == 3){
        			score +=1
        		}
        	}
        	return score;
        }
        
    }
})();