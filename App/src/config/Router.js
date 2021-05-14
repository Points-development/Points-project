import React, {Component} from 'react';
import { TabNavigator, StackNavigator } from 'react-navigation';
import {
	StyleSheet,
	View,
	StatusBar,
	Image,
	Button,
	TouchableOpacity
} from 'react-native';

import Login from '../pages/Login'
import Home from '../pages/Home'
import Assessment from '../pages/Assessment'
import Query from '../pages/Query'
import System from '../pages/System'
import PartyHistory from '../pages/PartyHistory'



const App = StackNavigator({
	Login: { 
		screen: Login,
		navigationOptions:{header:null}
	},
	Home: {
		screen: Home,
		navigationOptions:{header:null}
	},
	Assessment: {
		screen: Assessment,
		navigationOptions:{title:'评测'}
	},
	PartyHistory: {
		screen: PartyHistory,
		navigationOptions:{title:'党史'}
	},
    Query: {
    	screen: Query,
    	navigationOptions:{title:'查询'}
    },
    System: {
    	screen: System,
    	navigationOptions:{title:'系统'}
    }
});


export default class Router extends Component {
    render() {
        return (
        	<View style={{flex: 1}}>
                <App />
            </View> 
        )
    }
}