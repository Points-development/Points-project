import React, {Component} from 'react';
import { TabNavigator, StackNavigator,TabBarTop } from 'react-navigation';
import {
    StyleSheet,
    View,
    Text,
    Image,
    Button,
    TouchableOpacity
} from 'react-native'
import {NavigationActions} from 'react-navigation'
import QuerySelf from './QuerySelf'
import QueryOther from './QueryOther'

let QuerySelfNav = StackNavigator({
	QuerySelf:{
        screen:QuerySelf,
        navigationOptions:{
        	tabBarLabel:'自评记录',
        	header:null,
        	gesturesEnabled:true
        }
    }
});

let QueryOtherNav = StackNavigator({
	QueryOther:{
        screen:QueryOther,
        navigationOptions:{
        	tabBarLabel:'他评记录',
        	header:null,
        	gesturesEnabled:true
        }
		
    }
});

let TabBar = TabNavigator({
    self: {screen: QuerySelfNav},
    other: {screen: QueryOtherNav},
},
{
    tabBarPosition: 'top',
    initialRouteName:'self',
    tabBarComponent:TabBarTop,
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
