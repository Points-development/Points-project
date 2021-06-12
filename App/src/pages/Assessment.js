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
	ScrollView,
	TextInput,
} from 'react-native';	
import CheckBox from '../components/Checkbox'
import RadioForm, {RadioButton, RadioButtonInput, RadioButtonLabel} from 'react-native-simple-radio-button';
import Button from '../components/Button'
import NetUtil from '../service/NetUtil'


export default class Assessment extends React.Component {

    componentWillUnmount() {
    }
    
    componentDidMount() {
    	const {who} = this.props.navigation.state.params
    	if(who == 'others'){
    		//let url1 = gServer.host+'/branch/users?username='+gUser.name;
    		let url1 = gServer.host+'/score/pointsbyuser?branch='+gUser.branch+'&scorer='+gUser.name;
        	NetUtil.get(url1,function (response) {
        		if(response.status == 200){
        			this.setState({branchUsers: response.data});
        		}else{
        			ToastAndroid.show('网络异常，请稍后重试!', ToastAndroid.SHORT); 
        		}
            }.bind(this));
    	}else{
    		let url2 = gServer.host+'/paper/1?username='+gUser.name;
        	NetUtil.get(url2,function (response) {
        		if(response.status == 200){
        			let questions = [];
        			let category=null;
        			response.data.questions.map(function (question) {
        				if(category != question.category){
        					category = question.category;
        					questions.push({'category':category,'isTitle':true});
        				}
        				if(question.type==1){
							question.options.map(function (item) {
								item['label'] = item.description;
								item['description'] = item.description;
        					});
        				}
        				questions.push(question);
        			});
        			this.setState({dataSource:{
        				id:response.data.id,
        				name:response.data.name,
        				questions:questions
        			}});
        		}else{
        			this.setState({errorMsg: '请检查网络或联系管理员'});
        		}
            }.bind(this));
        	let url3 = gServer.host+'/score/'+gUser.name+"?scorer="+gUser.name;
        	NetUtil.get(url3,function (response) {
        		if(response.status == 200){
        			if(response.data.length>0){
        				this.setState({isSubmitted:true});
        				ToastAndroid.show('系统检测到您已完成本次自评，如有疑问请联系系统管理员', ToastAndroid.SHORT);
        			}
        		}else{
        			this.setState({errorMsg: '请检查网络或联系管理员'});
        		}
            }.bind(this))
    	}
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
    		checkBoxChecked:[],
    		branchUsers:[],
    		selfScore:{common:{},self:{}}
    	}
    }
    
    _checkSubmit = ()=>{
    	let score = {
        	paperId:1,
        	scorer:gUser.name,
        	scoree:this.state.evaluator=='自己'?gUser.name:this.state.evaluator,
        	common:0,
        	self:0
    	}
    	for(let i=0;i<this.state.dataSource.questions.length;i++){
    		let item = this.state.dataSource.questions[i];

    		if(item.hasOwnProperty('selected')){
    			if(item.property =='共性'){
    				score.common +=item.options[item.selected].optionPoint;
    			}else{
    				score.self += item.options[item.selected].optionPoint
    			}
    		}else{
    			if(item.isTitle || item.type==2){
    				continue;
    			}
    			ToastAndroid.show('还有题目未作答!', ToastAndroid.SHORT);
    			return false;
    		}
    	}
    	
    	score.commonTotalScore = score.common;
    	score.selfTotalScore = score.self;
    	this.setState({resultVisible: true,selfScore:score});
    }
    
    _submit = ()=>{
    	let score = {
    		paperId:this.state.evaluator=='自己'?1:1,
    		scorer:gUser.name,
    		scoree:this.state.evaluator=='自己'?gUser.name:this.state.evaluator,
    		scores:[],
    		point:this.state.selfScore.commonTotalScore+this.state.selfScore.selfTotalScore
    	}
    	this.state.dataSource.questions.map(function(item){
    		if(item.hasOwnProperty('selected')){
    			let question={questionId:item.id,optionsId:item.options[item.selected].id,answer:null};
    			score.scores.push(question);
    		}
    		if(item.type == 2){
    			let question={questionId:item.id,answer:item.answer,optionsId:0};
    			score.scores.push(question);
    		}
    	});
    	let url = gServer.host+'/score/'+score.scoree;
    	NetUtil.post(url,score,function (response) {
    		if(response.status == 200){
    			ToastAndroid.show('评测提交成功!', ToastAndroid.SHORT);
    			this.setState({isSubmitted:true,resultVisible: false});
    		}else{
    			ToastAndroid.show(JSON.stringify(response), ToastAndroid.SHORT); 
    		}
        }.bind(this));
    }
    
    changeCheck=(item,index)=>{
        item.selected = index;
    }
    
    _renderItem = (item,index1) => {
    	
    	if(item.item.isTitle){
    		return (
				<View style={styles.category}>
					<Text style={{color:'#000',fontSize:21,fontWeight:'bold'}}>{item.item.category}</Text>
				</View>	
    		)
    	}
    	let label = item.item.questionId+". "+ item.item.description;
    	
        return (
        		<View >
        		{
					item.item.type ==1 &&
        			<View style={styles.question1}>
	        			<View style={{padding:20,paddingTop:30}}>
	        				<Text style={{color:gColors.defaultFontColor,fontSize:gFont.contentSize}}>{label}</Text>
	        			</View>
	        			<View style={{padding:10,paddingLeft:20}}>
			        		<RadioForm
				                radio_props={item.item.options}
			        			buttonColor={gColors.buttonColor}
			        			initial={-1}
			        			radioStyle={{paddingRight:15}}
			        			labelStyle={{fontSize:18}}
			        			formHorizontal={false}
			        		  	labelHorizontal={true}
				                onPress={(value,index) =>this.changeCheck(item.item,index)}
				              />
			            </View>
        			</View>
        		}
        			{
        				item.item.type !=1 &&
        					<View style={{height:200}}>
	        				<View style={{padding:20}}>
		        				<Text style={{color:gColors.defaultFontColor,fontSize:gFont.contentSize}}>{item.item.questionId}. {item.item.description}</Text>
		        			</View>
				        	<View style={{padding:10,paddingLeft:20}}>
				        		<TextInput
					                style={{height: 80,textAlignVertical:'top',borderColor:'#50C900',borderWidth: 1}}
					                onChangeText={(text) => item.item.answer=text}
				        			underlineColorAndroid='transparent'
				        			multiline = {true}
					             />
				        	</View>
				            </View>
        			
        			}
        			
		        	
        		</View>
        	)
    }

    _separator = () => {
        return <View style={{ height: 1, backgroundColor: '#CCCCCC',opacity:0.5 }} />
    }
    
    _keyExtractor = (item, index) => index.toString();
    
    _onPress = item => {
    	this.setState({modalVisible: false,evaluator:item.username});
    	let url2 = gServer.host+'/paper/1?username='+item.username;
    	NetUtil.get(url2,function (response) {
    		if(response.status == 200){
    			let questions = [];
    			let category=null;
    			response.data.questions.map(function (question) {
    				if(category != question.category){
    					category = question.category;
    					questions.push({'category':category,'isTitle':true});
    				}
    				if(question.type==1){
						question.options.map(function (item) {
							item['label'] = item.description;
							item['description'] = item.description;
    					});
    				}
    				questions.push(question);
    			});
    			this.setState({dataSource:{
    				id:response.data.id,
    				name:response.data.name,
    				questions:questions
    			}});
    		}else{
    			this.setState({errorMsg: '请检查网络或联系管理员'});
    		}
        }.bind(this))
    }
    
    _back = ()=>{
    	this.props.navigation.goBack();
    }
    
    _closeResult = ()=>{
    	this.setState({resultVisible: false});
    }
    
    _renderUserItem = (item, key) => {
        let itemName = item.username
        return (
        	<View key={`${item.username}-${key}`}>
	        {itemName != gUser.name && item.otherPoint==0 && 
	        	<TouchableOpacity
	                activeOpacity={0.75}
	                style={styles.item}
	                onPress={()=>this._onPress(item)}
	            >
	                <Text style={{color: '#000', fontSize:gFont.headerSize}}>{item.realname}</Text>
	            </TouchableOpacity>
            }
	        {(itemName==gUser.name || item.otherPoint>0) && 
	        	<View
	        		style={styles.item}>
                	<Text style={{color: '#ddd', fontSize:gFont.headerSize}}>{item.realname}(已评价)</Text>
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
        				<Text style={{fontSize:gFont.headerSize,color:gColors.defaultFontColor}}>
        					{this.state.dataSource.name}
        				</Text>
        				<Text style={{fontSize:gFont.headerSize2,color:'#535a5a',textAlign:'right'}}>
	    					评测对象: {this.state.evaluator}
	    				</Text>	
        			</View>
        			<View style={styles.list}>
	        			<FlatList
		                    ref={(flatList)=>this._flatList = flatList}
		                    ItemSeparatorComponent={this._separator}
		                    renderItem={(item, index) => this._renderItem(item,index)}
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
			              			<Text style={{fontWeight:'bold'}}>评测分数:</Text>
			              		</View>
			              		<View style={{paddingLeft:(gScreen.width * (5 / 20)-gScreen.width * (7 / 80)-30)}}>
			              			<View style={styles.circle}>
						                <Text style={{fontWeight:'bold',fontSize:24,color:gColors.buttonColor}}>
						                	{this.state.selfScore.commonTotalScore+this.state.selfScore.selfTotalScore}分
						                </Text>
					                </View>
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
	circle:{
		marginHorizontal:5,
		marginVertical:5,
		width:gScreen.width * (7 / 40),
		height:gScreen.width * (7 / 40),
		borderRadius:gScreen.width * (7 / 80),
		borderColor:'#8c9696',
		borderWidth:3,
		alignItems:'center',
		justifyContent: 'center',
	},
	list:{
		flex:1,
		paddingHorizontal:10,
		paddingBottom:20
	},
	question:{
		height:150
	},
	category:{
		alignItems: 'center',
		justifyContent: 'center',
		height:70
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