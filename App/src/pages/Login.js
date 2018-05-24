/**
 * Created by xzgan
 */
import React, { Component } from 'react';
import {
	StyleSheet,
	View,
	TouchableOpacity,
	Text,
	TextInput,
	Keyboard,
	Image,
	InteractionManager
} from 'react-native';
import Constant from '../common/constants';
import Button from '../components/Button'
import NetUtil from '../service/NetUtil'
import UserDefaults from '../common/UserDefaults'
const dismissKeyboard = require('dismissKeyboard')

export default class Login extends React.Component {
	
	
	
	componentDidMount() {

    }

    componentWillUnmount() {
    }
    
    constructor (props) {
    	super (props)
    	this.state = {
    		userName:'',
    		password:'',
    		errorMsg:''
    	}
    }
    
    _submit = ()=>{
    	dismissKeyboard();
    	let url = gServer.host+'/login';
    	let user = {
    		name:this.state.userName,
    		password:this.state.password
    	}
    	let navigation = this.props.navigation;
    	NetUtil.post(url,user,function (response) {
    		if(response.status == 200){
    			gUser = response.data;
    			gUser.password = user.password;
    			UserDefaults.setObject('user',response.data);
    			navigation.navigate('Home');
    		} else if(response.status == 403){
    			this.setState({errorMsg: '用户名或者密码错误'});
    		}else{
    			this.setState({errorMsg: '请检查网络或联系管理员'});
    		}
        }.bind(this))
    }

    render() {
        return (
        		<View style={styles.container}>
		        	<Image 
		    			source={require('../assets/image/bj.jpg')}
		            	style={styles.backgroundImage}
		            />
		    		<View style={styles.loginBackground}> 
		    	    </View>
	        	    <View style={styles.loginContainer}>
	        	    	<View style={styles.title}><Text style={{fontSize:20,fontWeight:'bold',color:'#fff'}}>西安经新小学师风师德评测系统</Text></View>
		        	    {
		        	    	this.state.errorMsg !='' && 
		        	    	<View style={styles.title}>
		        	    		<Text style={{color:'#ff5c49'}}>{this.state.errorMsg}</Text>
		        	    	</View>
		        	    }
	        	    	<View style={styles.loginInput}>
		        	    	<TextInput
		        	    		underlineColorAndroid = {'transparent'}
		        	    		style={styles.textInput}
		        	    		multiline={false}
		        	    		placeholder='用户名'
		        	    		placeholderTextColor='#fff'
		        	    		password={false} 
		        	    		onChangeText={(text) => {
		        	    			this.setState({
		        	    				userName: text
		        	    			})
		        	    		}}
		        	    		value={this.state.userName}
		        	    		onSubmitEditing={Keyboard.dismiss} 
		        	    		/>
		        	    </View>
		        	    <View style={styles.loginInput}>
		        	    	<TextInput
		        	    		underlineColorAndroid = {'transparent'}
		        	    		style={styles.textInput}
		        	    		multiline={false}
		        	    		placeholder='密码'
		        	    		placeholderTextColor='#fff'
		        	    		onSubmitEditing={Keyboard.dismiss} 
		        	    		password={true} 
		        	    		onChangeText={(text) => {
		        	    			this.setState({
		        	    				password: text
		        	    			})
		        	    		}}
		        	    		value={this.state.password}
		        	    		/>
		        	    </View>
		        	    <Button label="登录" textStyle={styles.textStyle} style={styles.button} pressAction={this._submit}></Button>
	        	    </View>
	        	</View>
        );
    }
}


const styles = StyleSheet.create({
	backgroundImage: {
	    position: 'absolute',
	    top: 0,
	    left: 0,
	    bottom: 0,
	    right: 0,
	    zIndex:1,
	    width:null,
	    height:null,
	    
	},
	container: {
	    flex: 1,
	    justifyContent: 'center',
	    alignItems: 'center',
	},
	loginBackground: {
		position: 'absolute',
	    top: 0,
	    left: 0,
	    bottom: 0,
	    right: 0,
	    zIndex:2,
	    backgroundColor: 'rgba(0,43,54,0.5)',
	},
	loginContainer: {
	    zIndex:3,
	    position: 'relative',
	    flex: 0,
	    backgroundColor: 'transparent',
	    height:250,
	},
	title:{
		height: 20,
		flex: 1,
		justifyContent: 'center',
	    alignItems: 'center',
	},
	loginInput:{
		height: 50,
		flex: 1,
		borderBottomColor:'#D5D5D5',
		borderBottomWidth:0.5,
		marginHorizontal:40,
		marginVertical:10,
	},
	textInput:{
		height: 50,
		width:gScreen.width-150,
		color:'#fff',
		marginLeft:10,
	},
	button:{
		backgroundColor:'rgba(255,255,255,1)',
		marginTop:30,
		shadowColor:'#000',
		shadowOffset:{width:1,height:8},
		elevation:2,
		shadowOpacity:0.3,
		shadowRadius:2,
		marginHorizontal:40,
	},
	textStyle:{
		color:'#000',
		fontSize:20,
	}
})