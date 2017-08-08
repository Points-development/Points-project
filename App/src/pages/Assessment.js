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
	Image,
	ToastAndroid,
	ScrollView
} from 'react-native';

import RadioForm, {RadioButton, RadioButtonInput, RadioButtonLabel} from 'react-native-simple-radio-button';
import Button from '../components/Button'
import NetUtil from '../service/NetUtil'


export default class Assessment extends React.Component {

    componentWillUnmount() {
    }
    
    componentDidMount() {
    	const {who} = this.props.navigation.state.params
    	if(who == 'others'){
    		let url1 = gServer.host+'/branch/users?username='+gUser.name;
        	NetUtil.get(url1,function (response) {
        		if(response.status == 200){
        			this.setState({branchUsers: response.data});
        		}else{
        			ToastAndroid.show('网络异常，请稍后重试!', ToastAndroid.SHORT); 
        		}
            }.bind(this));
    	}
    	
    	let url2 = gServer.host+'/paper/1';
    	NetUtil.get(url2,function (response) {
    		if(response.status == 200){
    			this.setState({dataSource: response.data});
    			let options = [];
    			response.data.options.map(function (item) {
    				options.push({'label':item.description,'value':item.description,'id':item.id});
    			});
    			this.setState({options:options});
    		}else{
    			this.setState({errorMsg: '请检查网络或联系管理员'});
    		}
        }.bind(this))
    }
    
    constructor (props) {
    	super (props)
    	const {who} = props.navigation.state.params
    	this.state = {
    		modalVisible: who=='others',
    		resultVisible:false,
    		isSubmitted:false,
    		evaluator:who=='self'?'自己':'其他',
    		dataSource:{
    		    "id": 1,
    		    "name": "党性体检参考指标",
    		    "questions": [
    		    ]
    		},
    		options: [],
    		branchUsers:[],
    		selfScore:{}
    	}
    }
    
    _checkSubmit = ()=>{
    	let score = {
        	paperId:1,
        	scorer:gUser.name,
        	scoree:this.state.evaluator=='自己'?gUser.name:this.state.evaluator,
        	scores1:0,
        	scores2:0,
        	scores3:0,
        	scores4:0,
    	}
    	this.state.dataSource.questions.map(function(item){
    		if(item.selected){
    			if(item.selected == 1){
    				score.scores1 +=1;
    			}
    			if(item.selected == 2){
    				score.scores2 +=1;
    			}
    			if(item.selected == 3){
    				score.scores3 +=1;
    			}
    			if(item.selected == 4){
    				score.scores4 +=1;
    			}
    		}
    	});
    	score.total = score.scores1+score.scores2+score.scores3+score.scores4;
    	score.totalScore = score.scores1*5+score.scores2*3+score.scores3*1;
    	this.setState({resultVisible: true,selfScore:score});
    }
    
    _submit = ()=>{
    	let score = {
    		paperId:1,
    		scorer:gUser.name,
    		scoree:this.state.evaluator=='自己'?gUser.name:this.state.evaluator,
    		scores:[]
    	}
    	this.state.dataSource.questions.map(function(item){
    		if(item.selected){
    			let question={questionId:item.id,optionsId:item.selected}
    			score.scores.push(question);
    		}
    	});
    	let url = gServer.host+'/score/'+score.scoree;
    	NetUtil.post(url,score,function (response) {
    		if(response.status == 200){
    			ToastAndroid.show('评价提交成功!', ToastAndroid.SHORT);
    			this.setState({isSubmitted:true,resultVisible: false});
    		}else{
    			ToastAndroid.show('网络异常，请稍后重试!', ToastAndroid.SHORT); 
    		}
        }.bind(this));
    	
    }
    _renderItem = (item) => {
    	
    	let defaultSelect = 100;
    	if(item.item.selected){
    		defaultSelect = item.item.selected-1;
    	}	
        return (
        		<View style={styles.question}>
        			<View style={{padding:20,paddingTop:30}}>
        				<Text style={{color:gColors.defaultFontColor}}>{item.item.id}. {item.item.description}</Text>
        			</View>
        			<View style={{padding:20}}>
		        		<RadioForm
			                radio_props={this.state.options}
		        			buttonColor={gColors.buttonColor}
		        			initial={defaultSelect}
		        			radioStyle={{paddingRight:15}}
		        			formHorizontal={true}
		        		  	labelHorizontal={true}
			                onPress={(value,index) => {
			                	item.item.selected=this.state.options[index].id
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
    	this.setState({modalVisible: false,evaluator:item.name});
    }
    
    _back = ()=>{
    	this.props.navigation.goBack();
    }
    
    _closeResult = ()=>{
    	this.setState({resultVisible: false});
    }
    
    _renderUserItem = (item, key) => {
        let itemName = item.name
        return (
        	<View key={`${item.name}-${key}`}>
	        {itemName != gUser.name && 
	        	<TouchableOpacity
	                activeOpacity={0.75}
	                style={styles.item}
	                onPress={()=>this._onPress(item)}
	            >
	                <Text style={{color: '#000', fontSize: 16}}>{item.name}</Text>
	            </TouchableOpacity>
            }
	        {itemName==gUser.name && 
	        	<View
	        		style={styles.item}>
                	<Text style={{color: '#ddd', fontSize: 16}}>{item.name}(不能评测自己)</Text>
                </View>
	        }
	        </View>
        )
    }

    render() {
    	const {isConnected,who} = this.props.navigation.state.params
    	
        return (
        		<View style={styles.container}>
        			<View style={{paddingTop:20,alignItems: 'center'}}>
        				<Text style={{fontSize:20,color:gColors.defaultFontColor}}>
        					{this.state.dataSource.name}
        				</Text>
        				<Text style={{fontSize:15,color:'#535a5a',textAlign:'right'}}>
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
		        		<Button label="提交" textStyle={styles.textStyle} disable={this.state.isSubmitted} style={[styles.button, this.state.isSubmitted && {backgroundColor:gColors.buttonDisableColor}]} pressAction={this._checkSubmit}></Button>
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
						                <Text style={{paddingLeft:50}}>选择评测对象</Text>
					                </View>
					                <ScrollView>
			              				{this.state.branchUsers.map(this._renderUserItem)}
			              			</ScrollView>
			              		</View>
			              	</View>
			             </Modal>
	    			}
    				<Modal 
		              	animationType={"fade"}
		              	transparent={true}
		              	visible={this.state.resultVisible}
		              	onRequestClose={() => {}} 
		              >
		              	<View style={styles.spinner}>
		              		<View style={styles.spinnerContent2}>
		              			<View style={{padding:10}}>
					                <Text>评测分数:</Text>
					                <Text>本次体检问题共{this.state.selfScore.total}个,
					                其中优秀{this.state.selfScore.scores1}项,
					                良好{this.state.selfScore.scores2}项,
					                一般{this.state.selfScore.scores3}项,
					                较差{this.state.selfScore.scores4}项,
					                分数为{this.state.selfScore.totalScore}分</Text>
				                </View>
				                <View style={{flexDirection: 'row',flex:1,justifyContent: 'center',alignItems: 'center',}}>
				                <Button label="确定" textStyle={styles.textStyle} style={styles.button2} pressAction={this._submit}></Button>
				                <Button label="取消" textStyle={styles.textStyle} style={styles.button3} pressAction={this._closeResult}></Button>
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
	    backgroundColor:gColors.background
	},
	list:{
		width:gScreen.width,
		flex:1,
		paddingHorizontal:10,
		paddingBottom:20
	},
	question:{
		width:gScreen.width-50,
		height:190
	},
	button:{
		backgroundColor:gColors.buttonColor,
		width:gScreen.width/2,
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
        height: gScreen.height * (6 / 10),
        backgroundColor: '#fcfcfc',
        padding: 20,
        borderRadius: 5
    },
    spinnerContent2: {
    	justifyContent: 'center',
        width: gScreen.width * (5 / 10),
        height: gScreen.height * (4 / 10),
        backgroundColor: '#fcfcfc',
        padding: 20,
        borderRadius: 5
    },
    item: {
        height: 54,
        justifyContent: 'center',
        alignItems: 'center',
        borderBottomColor: '#ddd',
        borderBottomWidth: StyleSheet.hairlineWidth,
        padding: 15,
    }
})