/**
 * Created by ljunb on 16/8/21.
 */
import React, { Component } from 'react';
import {
	StyleSheet,
	View,
	TouchableOpacity,
    ScrollView,
	Text,
	TextInput,
	Keyboard,
	Modal,
	ToastAndroid,
} from 'react-native';

import Button from '../components/Button'
import UserDefaults from '../common/UserDefaults'
import NetUtil from '../service/NetUtil'
const dismissKeyboard = require('dismissKeyboard')


export default class System extends React.Component {

    componentWillUnmount() {
    }
    
    constructor (props) {
    	super (props)
    	this.state={
    		currentUser:'',
    		pwdmodelVisible:false,
    		password1:'',
    		password2:'',
    		errorMsg:''
    	}
    	UserDefaults.getObject('user').then(user=>{
    		this.setState({currentUser:user.name})
    	})
    	
    }
    
    _logout = ()=>{
		this.props.navigation.navigate('Login');
	}
    
    _submit = ()=>{
    	
    	if(this.state.password1 == ''){
    		this.setState({errorMsg:'密码不能为空'})
    		return;
    	}
    	
    	if(this.state.password1 != this.state.password2){
    		this.setState({errorMsg:'两次密码必须一致'})
    		return;
    	}
 
    	let url = gServer.host+'/user/'+gUser.name;
    	gUser.password = this.state.password1;
    	NetUtil.put(url,gUser,function (response) {
    		if(response.status == 200){
    			this.setState({pwdmodelVisible: false});
    			ToastAndroid.show('密码修改成功!', ToastAndroid.SHORT);
    		}else{
    			ToastAndroid.show('网络异常，请稍后重试!', ToastAndroid.SHORT); 
    		}
        }.bind(this));
    }
    
    _changepwd = ()=>{
    	this.setState({pwdmodelVisible: true});
    }
    
    _close = ()=>{
    	this.setState({pwdmodelVisible: false});
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
	              	<TouchableOpacity activeOpacity={0.75} onPress={this._changepwd}>
		              	<View style={styles.row}>
		              		<Text>修改密码</Text>
		              	</View>
	              	</TouchableOpacity>
	              	<View style={{ height: 1, backgroundColor: '#CCCCCC',opacity:0.5 }} />
	            </View>
	            <Button label="退出" textStyle={styles.textStyle} style={styles.button} pressAction={this._logout}></Button>
	            <Modal 
	              	animationType={"fade"}
	              	transparent={true}
	              	visible={this.state.pwdmodelVisible}
	              	onRequestClose={() => {}} 
	              >
	              	<View style={styles.spinner}>
	              		<View style={styles.spinnerContent2}>
		              		<View style={styles.title}>
		        	    		<Text style={{color:'#000',fontSize:16}}>修改密码</Text>
		        	    	</View>
		        	    	{
			        	    	this.state.errorMsg !='' && 
			        	    	<View style={styles.title}>
			        	    		<Text style={{color:'#ff5c49'}}>{this.state.errorMsg}</Text>
			        	    	</View>
			        	    }
	              			<View style={{padding:10}}>
		              			<TextInput
			        	    		style={styles.textInput}
			        	    		multiline={false}
			        	    		placeholder='新密码'
			        	    		placeholderTextColor='#ddd'
			        	    		onSubmitEditing={Keyboard.dismiss} 
			        	    		password={true} 
			        	    		onChangeText={(text) => {
			        	    			this.setState({
			        	    				password1: text
			        	    			})
			        	    		}}
			        	    		value={this.state.password1}
		        	    		/>
		              			<TextInput
			        	    		style={styles.textInput}
			        	    		multiline={false}
			        	    		placeholder='确认密码'
			        	    		placeholderTextColor='#ddd'
			        	    		onSubmitEditing={Keyboard.dismiss} 
			        	    		password={true} 
			        	    		onChangeText={(text) => {
			        	    			this.setState({
			        	    				password2: text
			        	    			})
			        	    		}}
			        	    		value={this.state.password2}
		        	    		/>
			                </View>
			                <View style={{flexDirection: 'row',flex:1,justifyContent: 'center',alignItems: 'center',}}>
			                <Button label="确定" textStyle={styles.textStyle} style={styles.button2} pressAction={this._submit}></Button>
			                <Button label="取消" textStyle={styles.textStyle} style={styles.button3} pressAction={this._close}></Button>
			                </View>
			                
	              		</View>
	              	</View>
	             </Modal>
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
		color:'#000',
		marginLeft:10,
	},
	spinner: {
    	flex: 1,
        flexDirection: 'column',
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: 'rgba(0, 0, 0, 0.65)'
    },
    spinnerContent2: {
    	justifyContent: 'center',
        width: gScreen.width * (5 / 10),
        height: gScreen.height * (5 / 10),
        backgroundColor: '#fcfcfc',
        padding: 20,
        borderRadius: 5
    },
	button2:{
		backgroundColor:gColors.buttonColor,
		width:gScreen.width/6,
		height:30
	},
	button3:{
		backgroundColor:gColors.buttonCancelColor,
		width:gScreen.width/6,
		height:30
	},
	title:{
		height: 20,
		flex: 1,
		justifyContent: 'center',
	    alignItems: 'center',
	},
})