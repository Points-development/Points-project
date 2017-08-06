/**
 * Created by ljunb on 16/8/21.
 */
import React, { Component } from 'react';
import {
	StyleSheet,
	View,
	TouchableOpacity,
    ScrollView,
	Text
} from 'react-native';

import Button from '../components/Button'
import UserDefaults from '../common/UserDefaults'


export default class System extends React.Component {

    componentWillUnmount() {
    }
    
    constructor (props) {
    	super (props)
    	this.state={
    		currentUser:''
    	}
    	UserDefaults.getObject('user').then(user=>{
    		this.setState({currentUser:user.name})
    	})
    	
    }
    
    _logout = ()=>{
		this.props.navigation.navigate('Login');
	}

    render() {
        return (
        	<View style={styles.container}>
        		<View style={styles.userInfo}>
        			<Text>当前用户:{gUser.name}</Text>
        			<Text>版本信息:1.0.0.0</Text>
        		</View>
        		<View style={styles.rowGroup}>
        			<View style={{ height: 1, backgroundColor: '#CCCCCC',opacity:0.5 }} />
            		<TouchableOpacity activeOpacity={0.75}>
		              	<View style={styles.row}>
		              		<Text>声明</Text>
		              	</View>
		            </TouchableOpacity>
		            <View style={{ height: 1, backgroundColor: '#CCCCCC',opacity:0.5 }} />
		            <TouchableOpacity activeOpacity={0.75}>
		              	<View style={styles.row}>
		              		<Text>关于</Text>
		              	</View>
	              	</TouchableOpacity>
	              	<View style={{ height: 1, backgroundColor: '#CCCCCC',opacity:0.5 }} />
	            </View>
	            <Button label="退出" textStyle={styles.textStyle} style={styles.button} pressAction={this._logout}></Button>
            </View>
        );
    }
}


const styles = StyleSheet.create({
	container: {
	    flex: 1,
	    alignItems: 'center',
	    backgroundColor:gColors.background
	},
	userInfo:{
    	height:50,
    	padding:10,
    	flexDirection:'column',
    	alignItems: 'center'
    },
	rowGroup:{
    	marginTop:10,
    	width:gScreen.width,
    },
    row:{
    	flexDirection:'row',
    	height:40,
    	padding:10,
    	backgroundColor:'#fff',
    	alignItems: 'center'
    },
    button:{
    	marginTop:30,
		backgroundColor:'#ff5c49',
		width:gScreen.width/2,
	},
	textStyle:{
		fontSize:20,
	}
})