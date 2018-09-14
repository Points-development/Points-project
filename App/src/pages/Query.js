import React, {Component} from 'react';
import { createMaterialTopTabNavigator } from 'react-navigation';
import {
    StyleSheet,
    View,
    Text,
    Image,
    Button,
    TouchableOpacity
} from 'react-native'
import QuerySelf from './QuerySelf'
import QueryOther from './QueryOther'

let TabBar = createMaterialTopTabNavigator({
    self: {screen: QuerySelf},
    other: {screen: QueryOther},
},
{
    tabBarPosition: 'top',
    initialRouteName:'self',
    tabBarOptions: {
        activeTintColor: gColors.theme,
        inactiveTintColor: 'gray',
		showIcon:false,
		labelStyle: {
            fontSize: 16,
        },
        indicatorStyle:{
        	backgroundColor:gColors.buttonColor
        },
        style: {
        	borderBottomWidth: StyleSheet.hairlineWidth,
        	borderBottomColor: 'rgba(0, 0, 0, .3)',
			backgroundColor: '#ffffff',

		},
    },
    animationEnabled:true,
    swipeEnabled: true //是否允许tabBar手势切换
});

export default class Query extends Component {
	
	constructor(props) { 
		super(props);
	}
	
	render() {
        return (
        	<View style={{flex: 1}}>
                <TabBar />
            </View> 
        )
    }
	
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor:gColors.background
    },
    rightIcon: {
        paddingRight: 15,
        paddingLeft:15,
        justifyContent: 'center',
        alignItems: 'center'
    },
})
