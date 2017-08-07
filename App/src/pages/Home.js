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
	Platform,
	Image
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
    	const shadowOpt = {
			color:"#000",
			border:2,
			radius:3,
			opacity:0.2,
			x:0,
			y:3,
			style:{marginVertical:5}
    	}
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
			            	onPress={()=>this._goQuery}>
			                <View style={{flexDirection:'row'}}>
			                	<Text style={styles.textStyle}>查询</Text>
			                	<Image 
					    			source={require('../assets/image/query.png')}
					            	style={styles.buttonImage}
					            />
			                </View>
			            </TouchableOpacity>
		        		<TouchableOpacity
			            	activeOpacity={0.55}
			            	style={[styles.buttonContainer,styles.button]}
			            	onPress={()=>this._goSystem}>
			                <View style={{flexDirection:'row'}}>
			                	<Text style={styles.textStyle}>系统</Text>
			                	<Image 
					    			source={require('../assets/image/system.png')}
					            	style={styles.buttonImage}
					            />
			                </View>
			            </TouchableOpacity>
        			</View>
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
	buttonImage:{
		width:40,
		height:40
	},
	textStyle:{
		color:'#fff',
		fontSize:30,
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
	    zIndex:3,
	    position: 'relative',
	    flex: 0,
	    backgroundColor: 'transparent',
	},
})