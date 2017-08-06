/**
 * Created by ljunb on 16/8/21.
 */
import React, { Component } from 'react';
import {
	StyleSheet,
	View,
	TouchableOpacity,
	Text,
	FlatList,
	Modal,
	Image
} from 'react-native';

import RadioForm, {RadioButton, RadioButtonInput, RadioButtonLabel} from 'react-native-simple-radio-button';
import Button from '../components/Button'


export default class Assessment extends React.Component {

    componentWillUnmount() {
    }
    
    componentDidMount() {
        
    }
    
    constructor (props) {
    	super (props)
    	const {who} = props.navigation.state.params
    	this.state = {
    		modalVisible: who=='others',
    		evaluator:who=='self'?'自己':'其他',
    		dataSource:{
    		    "id": 1,
    		    "name": "党性体检参考指标",
    		    "questions": [
    		    ],
    		    "options": [
    		    ]
    		}
    	}
    }
    _submit = ()=>{
    	
    }
    _renderItem = (item) => {
    	const radio_props = [{'label': '优秀', 'value': '优秀' },
    	                       {'label': '良好', 'value': '良好' },
    	                       {'label': '一般', 'value': '一般' },
    	                       {'label': '较差', 'value': '较差' }];
        return (
        		<View style={styles.question}>
        			<View style={{padding:20,paddingTop:30}}>
        				<Text style={{color:gColors.defaultFontColor}}>{item.item.description}</Text>
        			</View>
        			<View style={{padding:20}}>
		        		<RadioForm
			                radio_props={radio_props}
		        			buttonColor={gColors.buttonColor}
		        			initial={10}
		        			radioStyle={{paddingRight:15}}
		        			formHorizontal={true}
		        		  	labelHorizontal={true}
			                onPress={(value,index) => {
			                	item.item.selected=value
			                }}
			              />
		            </View>
		        	
        		</View>
        	)
    }

    _separator = () => {
        return <View style={{ height: 1, backgroundColor: '#CCCCCC',opacity:0.5 }} />
    }
    
    _keyExtractor = (item, index) => item.id;
    
    _onPress = item => {
    	this.setState({modalVisible: false});
    }
    
    _back = ()=>{
    	this.props.navigation.goBack();
    }
    
    _renderUserItem = (item, key) => {
        const isLastItem = key==1
        return (
            <TouchableOpacity
                key={`${item.name}-${key}`}
                activeOpacity={0.75}
                style={[styles.item, isLastItem && {borderBottomWidth: 0}]}
                onPress={()=>this._onPress(item)}
            >
                <Text style={{color: '#000', fontSize: 16}}>{item.name}</Text>
            </TouchableOpacity>
        )
    }

    render() {
    	const {isConnected,who} = this.props.navigation.state.params
    	const items = [{id: 1,title:'用户1', name: '用户1'},{id: 2,title:'用户1',name: '用户1'}]
    	
        return (
        		<View style={styles.container}>
        			<View style={{paddingTop:20,alignItems: 'center'}}>
        				<Text style={{fontSize:20,color:gColors.defaultFontColor}}>
        					{this.state.dataSource.name}
        				</Text>
        				<Text style={{fontSize:15,color:'#d8d8d8',textAlign:'right'}}>
	    					评测对象: {this.state.evaluator}
	    				</Text>	
        			</View>
        			<View style={styles.list}>
	        			<FlatList
		                    ref={(flatList)=>this._flatList = flatList}
		                    ItemSeparatorComponent={this._separator}
		                    renderItem={this._renderItem}
	        				keyExtractor={this._keyExtractor}
		                    data={this.state.dataSource.questions}>
		                </FlatList>
	                </View>
	                <View style={{ height: 1, backgroundColor: '#CCCCCC',opacity:0.8 }} />
	                <View style={{alignItems: 'center'}}>
		        		<Button label="提交" textStyle={styles.textStyle} style={styles.button} pressAction={this._submit}></Button>
	    			</View>
	    			{who=='others' && 
	    				<Modal 
			              	animationType={"fade"}
			              	transparent={true}
			              	visible={this.state.modalVisible}
			              	onRequestClose={() => {}} 
			              >
			              	<View style={styles.spinner}>
			              		<View style={styles.spinnerContent}>
			              			<View style={{flexDirection: 'row',}}>
					              		<TouchableOpacity
					              			style={{width:50,height:30}}
						                    activeOpacity={0.65}
						                    onPress={this._back}>
						                    <Image style={{width: 20, height: 20}}
						                           source={require('../assets/image/ic_back_dark.png')}
						                           resizeMode={"contain"}
						                    />
						                </TouchableOpacity>
						                <Text style={{paddingLeft:150}}>选择评测对象</Text>
					                </View>
			              			{items.map(this._renderUserItem)}
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
	    backgroundColor:gColors.background
	},
	list:{
		width:gScreen.wdith,
		flex:1,
		paddingHorizontal:10,
		paddingBottom:20
	},
	question:{
		width:gScreen.wdith-100,
		height:190
	},
	button:{
		backgroundColor:gColors.buttonColor,
		width:gScreen.width/2,
	},
	textStyle:{
		fontSize:20,
	},
    spinner: {
    	flex: 1,
        flexDirection: 'column',
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: 'rgba(0, 0, 0, 0.65)'
    },
    spinnerContent: {
    	justifyContent: 'center',
        width: gScreen.width * (7 / 10),
        backgroundColor: '#fcfcfc',
        padding: 20,
        borderRadius: 5
    },
    item: {
        height: 34,
        justifyContent: 'center',
        alignItems: 'center',
        borderBottomColor: '#ddd',
        borderBottomWidth: StyleSheet.hairlineWidth,
        padding: 15,
    }
})