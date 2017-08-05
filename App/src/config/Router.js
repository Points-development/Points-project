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

import Home from '../pages/Home'
import Login from '../pages/Login'

const App = StackNavigator({
	Login: { screen: Login },
    Home: {screen: Home}
}, {
    headerMode: 'none',
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