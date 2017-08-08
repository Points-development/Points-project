/**
 * DataRepository
 * 刷新从网络获取;非刷新从本地获取,
 * 若本地数据过期,先返回本地数据,然后返回从网络获取的数据
 * @flow
 */
'use strict';

import React, { Component } from 'react';

import {
    AsyncStorage,
} from 'react-native';

class NetUtil extends React.Component {
	
	static get(url,callback){
        //fetch请求
        fetch(url,{
            method: 'Get',
            headers:{
            	'Accept': 'application/json',
            	'Content-type': 'application/json'
            }
        })
        .then((response) => {
        	if(response.status==200){
        		response.json().then(function(data){
        			callback({status:200,data:data});
        		}).catch((error) => {
        			//for this case, the return data is not a json
                	callback({status:200})
                })
        	}else{
        		callback(response);
        	}
        })
        .catch((error) => {
        	callback({status:405})
        }).done();
    }
	
	static post(url,params,callback){
        //fetch请求
        fetch(url,{
            method: 'POST',
            headers:{
            	'Accept': 'application/json',
            	'Content-type': 'application/json'
            },
            body:JSON.stringify(params)
        })
        .then((response) => {
        	if(response.status==200){
        		response.json().then(function(data){
        			callback({status:200,data:data});
        		}).catch((error) => {
        			//for this case, the return data is not a json
                	callback({status:200})
                })
        	}else{
        		callback(response);
        	}
        })
        .catch((error) => {
        	callback({status:405})
        }).done();
    }   
}

module.exports = NetUtil;