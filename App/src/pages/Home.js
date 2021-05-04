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
	TextInput,
	Keyboard,
	Modal,
	Platform,
	Image,
	Dimensions
} from 'react-native';

import Button from '../components/Button'
import UserDefaults from '../common/UserDefaults'
import NetUtil from '../service/NetUtil'

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
	
	handle = (dims) =>{
		console.log(dims);
	}

	componentDidMount(){ 
		this.setState({pwdmodelVisible:gUser.password=='123456'})
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
    	this.state={
    		password1:'',
    		password2:'',
    		errorMsg:''
    	}
    }
    
    _goAssessment = (para)=>{
    	this.props.navigation.navigate('Assessment',{'who':para});
    }
   
    _goParty = ()=>{
    	this.props.navigation.navigate('PartyHistory',{'who':'self'});
    }
    
    _goQuery = ()=>{
    	this.props.navigation.navigate('Query');
    }
    
    _goSystem = ()=>{
    	this.props.navigation.navigate('System');
    }
    
    _submit = ()=>{
    	
    	if(this.state.password1 == ''){
    		this.setState({errorMsg:'密码不能为空'})
    		return;
    	}
    	
    	if(this.state.password1 =='123456'){
    		this.setState({errorMsg:'密码不能设置为初始密码'})
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

    render() {
    	const shadowOpt = {
			color:"#000",
			border:2,
			radius:3,
			opacity:0.2,
			x:0,
			y:3,
			style:{marginVertical:5}
    	}
    	let {height, width} = Dimensions.get('window')
    	gScreen.height = height;
    	gScreen.width = width;
        return (
        		<View style={styles.container}>
	        		<Image 
		    			source={require('../assets/image/home_bg.jpg')}
		            	style={styles.backgroundImage}
		            />
	        		<View style={styles.homeBackground}> 
		    	    </View>
		    	    <View style={styles.homeContainer}>
        			<View style={styles.btgroup}>
	        			<TouchableOpacity
			            	activeOpacity={0.55}
			            	style={[styles.buttonContainer,styles.button]}
			            	onPress={()=>this._goAssessment('self')}>
			                <View style={{flexDirection:'row'}}>
			                	<Text style={styles.textStyle}>自评</Text>
			                	<Image 
					    			source={require('../assets/image/pingjia.png')}
					            	style={styles.buttonImage}
					            />
			                </View>
			            </TouchableOpacity>
		        		<TouchableOpacity
			            	activeOpacity={0.55}
			            	style={[styles.buttonContainer,styles.button]}
			            	onPress={()=>this._goAssessment('others')}>
			                <View style={{flexDirection:'row'}}>
			                	<Text style={styles.textStyle}>互评</Text>
			                	<Image 
					    			source={require('../assets/image/huping.png')}
					            	style={styles.buttonImage}
					            />
			                </View>
			            </TouchableOpacity>
        			</View>
        			<View style={styles.btgroup}>
						<TouchableOpacity
			            	activeOpacity={0.55}
			            	style={[styles.buttonContainer,styles.button]}
			            	onPress={()=>this._goParty()}>
			                <View style={{flexDirection:'row'}}>
			                	<Text style={styles.textStyle}>党史</Text>
			                	<Image 
					    			source={require('../assets/image/party.png')}
					            	style={styles.buttonImage}
					            />
			                </View>
			            </TouchableOpacity>
						<TouchableOpacity
			            	activeOpacity={0.55}
			            	style={[styles.buttonContainer,styles.button]}
			            	onPress={()=>this._goQuery()}>
			                <View style={{flexDirection:'row'}}>
			                	<Text style={styles.textStyle}>查询</Text>
			                	<Image 
					    			source={require('../assets/image/query.png')}
					            	style={styles.buttonImage}
					            />
			                </View>
			            </TouchableOpacity>
        			</View>
        			</View>
                    <View style={styles.settings}>
						<TouchableOpacity
			            	activeOpacity={0.55}
			            	style={styles.button_settings}
			            	onPress={()=>this._goSystem()}>
			                	<Image 
					    			source={require('../assets/image/system.png')}
					            	style={styles.buttonImage}
					            />
			            </TouchableOpacity>
					</View>
        			{this.state.pwdmodelVisible && <Modal 
		              	animationType={"fade"}
		              	transparent={true}
		              	visible={this.state.pwdmodelVisible}
		              	onRequestClose={() => {}} 
		              >
		              	<View style={styles.spinner}>
		              		<View style={styles.spinnerContent2}>
			              		<View style={styles.title}>
			        	    		<Text style={{color:'#000',fontSize:16}}>请立即修改初始密码</Text>
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
				                </View>
				                
		              		</View>
		              	</View>
		             </Modal>
        			}
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
	buttonContainer:{
		marginHorizontal:20,
		height:40,
		backgroundColor:gColors.submitColor,
		marginVertical:10,
		borderRadius:20,
		borderColor:'#D5D5D5',
		borderWidth:0.5,
		alignItems:'center',
		justifyContent: 'center'
	},
	button:{
		backgroundColor:'rgba(2216, 216, 216,0.3)',
		shadowColor:'#000',
		shadowOffset:{width:1,height:8},
		shadowOpacity:0.3,
		shadowRadius:2,
		width:(gScreen.width-100)/3,
		height:(gScreen.width-100)/3 >(gScreen.height-100)/3?(gScreen.height-100)/3:(gScreen.width-100)/3,
	},
	button_settings:{
		width:(gScreen.width-100)/6,
		height:(gScreen.width-100)/6,
	},
	buttonImage:{
		width:40,
		height:40
	},
	textStyle:{
		color:'#fff',
		fontSize:30,
	},
	settings:{
		position: 'absolute',
		right:20,
		top:20,
		zIndex:100,
	},
	homeBackground: {
		position: 'absolute',
	    top: 0,
	    left: 0,
	    bottom: 0,
	    right: 0,
	    zIndex:2,
	    backgroundColor: 'rgba(0,43,54,0.2)',
	},
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
	homeContainer: {
	    zIndex:100,
	    position: 'relative',
	    flex: 0,
	    backgroundColor: 'transparent',
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
        backgroundColor: 'rgba(0, 0, 0, 0.65)',
        zIndex:2
    },
    spinnerContent2: {
    	justifyContent: 'center',
        width: gScreen.width * (6 / 10),
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
	}
})