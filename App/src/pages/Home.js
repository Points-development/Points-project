/**
 * Created by ljunb on 16/8/21.
 */
import React, { Component } from 'react';
import {
	StyleSheet,
	View,
	TouchableOpacity,
	Text
} from 'react-native';

import Button from '../components/Button'

export default class Login extends React.Component {

    componentWillUnmount() {
        clearTimeout(this.timer);
    }
    
    constructor (props) {
    	super (props)
    }
    
    _submit = ()=>{
    	this.props.navigation.navigate('Login');
    }

    render() {
        return (
        		<View style={styles.container}>
        			<View style={styles.btgroup}>
	        			<Button label="自评" textStyle={styles.textStyle} style={styles.button} pressAction={this._submit}>
	        			</Button>
	        			<Button label="互评" textStyle={styles.textStyle} style={styles.button} pressAction={this._submit}>
	        			</Button>
        			</View>
        			<View style={styles.btgroup}>
	        			<Button label="查询" textStyle={styles.textStyle} style={styles.button} pressAction={this._submit}>
	        			</Button>
	        			<Button label="系统" textStyle={styles.textStyle} style={styles.button} pressAction={this._submit}>
	        			</Button>
        			</View>
	        	</View>
        );
    }
}


const styles = StyleSheet.create({
	container: {
	    flex: 1,
	    justifyContent: 'center',
	    alignItems: 'center',
	    backgroundColor:gColors.background
	},
	btgroup:{
		flexDirection:'row'
	},
	button:{
		backgroundColor:'rgba(255,255,255,1)',
		marginTop:30,
		shadowColor:'#000',
		shadowOffset:{width:1,height:8},
		elevation:2,
		shadowOpacity:0.3,
		shadowRadius:2,
		width:(gScreen.width-200)/2,
		height:(gScreen.width-200)/2,
	},
	textStyle:{
		color:'#000',
		fontSize:20,
		
	}
})