/**
 * Created by ljunb on 16/8/21.
 */
import React, { Component } from 'react';
import {
	StyleSheet,
	View,
	TouchableOpacity,
	FlatList,
	Text
} from 'react-native';

import NetUtil from '../service/NetUtil'


export default class QuerySelf extends React.Component {
	
	static navigationOptions = {
	    tabBarLabel: '自评记录',
	};

    componentWillUnmount() {
    }
    
    componentDidMount() {
    	
    	let url2 = gServer.host+'/score/'+gUser.name;
    	NetUtil.get(url2,function (response) {
    		if(response.status == 200){
    			let scoreHistory = [];
    			response.data.map(function(item,index){
    				item.key = index;
    				if(item.scorer == item.scoree){
    					scoreHistory.push(item);
    				}
    			});
    			this.setState({scoreHistory:scoreHistory});
    		}else{
    			this.setState({errorMsg: '请检查网络或联系管理员'});
    		}
        }.bind(this))
    }
    
    constructor (props) {
    	super (props)
    	this.state = {
    		scoreHistory:[],
    		selfNum:0,
    		otherNum:0
    	}
    }
    
    _separator = () => {
        return <View style={{ height: 1, backgroundColor: '#CCCCCC',opacity:0.5 }} />
    }
    
    _keyExtractor = (item, index) => item.key;
    
    _renderItem = (item) => {
    	let date = new Date();  
        date.setTime(item.item.lastModifiedTime);  
        let time = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
    	let score = {
        	scores1:0,
        	scores2:0,
        	scores3:0,
        	scores4:0,
        }
    	item.item.scores.map(function(item1){
			if(item1.optionsId == 1){
				score.scores1 +=1;
			}
			if(item1.optionsId == 2){
				score.scores2 +=1;
			}
			if(item1.optionsId == 3){
				score.scores3 +=1;
			}
			if(item1.optionsId == 4){
				score.scores4 +=1;
			}
    	});
    	score.total = score.scores1+score.scores2+score.scores3+score.scores4;
    	score.totalScore = score.scores1*5+score.scores2*4+score.scores3*2+score.scores4;
        return (
        		<View style={styles.question}>
        			<View style={{padding:10,paddingTop:30}}>
        				<Text style={{color:gColors.defaultFontColor,fontSize:gFont.contentSize}}>
        				评测时间:{time}
        				</Text>
        				<Text style={{color:gColors.defaultFontColor,fontSize:gFont.contentSize}}>
        				评测结果:共{score.total}个问题,
		                其中优秀{score.scores1}项,
		                良好{score.scores2}项,
		                一般{score.scores3}项,
		                较差{score.scores4}项,
		                分数为
		                	<Text style={{color:'#ff5c49',fontSize:gFont.contentSize}}>{score.totalScore}分</Text>
        				</Text>
        			</View>
		        	
        		</View>
        	)
    	
    }

    render() {
        return (
        		<View style={styles.container}>
	        		{
	                	this.state.scoreHistory.length==0&&
	                	<View style={styles.noRecord}><Text style={{textAlign:'center',padding:50}}>暂无</Text></View>
	                }
	        		<View style={styles.list}>
		    			<FlatList
		                    ref={(flatList)=>this._flatList = flatList}
		                    ItemSeparatorComponent={this._separator}
		                    renderItem={this._renderItem}
		    				keyExtractor={this._keyExtractor}
		                    data={this.state.scoreHistory}>
		                </FlatList>
		            </View>
		            
	        	</View>
        );
    }
}


const styles = StyleSheet.create({
	container: {
	    flex: 1,
	    backgroundColor:gColors.background
	},
	question:{
		height:190,
		justifyContent: 'center',
	},
	noRecord:{
		width:gScreen.width,
		height:100
	},
	list:{
		flex:1,
		paddingHorizontal:10,
	},
})