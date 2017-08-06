/**
 * Created by ljunb on 16/8/21.
 */
import React, { Component } from 'react';
import {
	StyleSheet,
	View,
	TouchableOpacity,
	BackHandler,
	ToastAndroid,
	Text,
	Platform
} from 'react-native';

import Button from '../components/Button'

export default class Home extends React.Component {
	
	onBackAndroid = () => {
		const {state} = this.props.navigation; 
	    if (this.lastBackPressed && this.lastBackPressed + 2000 >= Date.now()) {
	    	//最近2秒内按过back键，可以退出应用。
	    	BackHandler.exitApp();
	    	return false;
	    }
	    this.lastBackPressed = Date.now();
	    ToastAndroid.show('再按返回退出应用', ToastAndroid.SHORT); 
	    return true;
	};

	componentDidMount(){ 
        // 添加返回键监听 
		BackHandler.addEventListener('hardwareBackPress', this.onBackAndroid);
    } 
	
    componentWillUnmount() {
    	// 移除返回键监听 
    	if (Platform.OS === 'android') {  
    		BackHandler.removeEventListener('hardwareBackPress',()=>{});  
    	} 
    }
    
    constructor (props) {
    	super (props)
    	let iconHeight = (gScreen.width-100)/2;
    	if((gScreen.width-100)/2 >(gScreen.height-100)/2){
    		iconHeight = (gScreen.height-100)/2;
    	}
    }
    
    _goAssessment = (para)=>{
    	this.props.navigation.navigate('Assessment',{'who':para});
    }
    
    _goQuery = ()=>{
    	this.props.navigation.navigate('Query');
    }
    
    _goSystem = ()=>{
    	this.props.navigation.navigate('System');
    }

    render() {
    	
        return (
        		<View style={styles.container}>
        			<View style={styles.btgroup}>
	        			<Button label="自评" textStyle={styles.textStyle} style={styles.button} pressAction={()=>this._goAssessment('self')}>
	        			</Button>
	        			<Button label="互评" textStyle={styles.textStyle} style={styles.button} pressAction={()=>this._goAssessment('others')}>
	        			</Button>
        			</View>
        			<View style={styles.btgroup}>
	        			<Button label="查询" textStyle={styles.textStyle} style={styles.button} pressAction={this._goQuery}>
	        			</Button>
	        			<Button label="系统" textStyle={styles.textStyle} style={styles.button} pressAction={this._goSystem}>
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
		backgroundColor:'rgba(255,92,73,0.5)',
		shadowColor:'#000',
		shadowOffset:{width:1,height:8},
		elevation:2,
		shadowOpacity:0.3,
		shadowRadius:2,
		width:(gScreen.width-100)/2,
		height:(gScreen.width-100)/2 >(gScreen.height-100)/2?(gScreen.height-100)/2:(gScreen.width-100)/2,
	},
	textStyle:{
		color:'#000',
		fontSize:30,
	}
})