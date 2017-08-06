import React,{Component} from 'react';
import {
    StyleSheet,
    View,
    Text,
    TouchableOpacity
} from 'react-native';

export default class Button extends Component {
	
	render() {
		const {style,textStyle,label,pressAction} = this.props
		_pressButton = ()=>{
			pressAction && pressAction();
		}
		return (
	            <TouchableOpacity
	            	activeOpacity={0.55}
	            	style={[styles.container,style]}
	            	onPress={_pressButton}>
	                <View>
	                	<Text style={textStyle}>{label}</Text>
	                </View>
	            </TouchableOpacity>
	    )
	}
}

const styles = StyleSheet.create({	
	container:{
		marginHorizontal:20,
		height:40,
		backgroundColor:gColors.submitColor,
		marginVertical:10,
		borderRadius:20,
		borderColor:'#D5D5D5',
		borderWidth:0.5,
		alignItems:'center',
		justifyContent: 'center'
	}	
})