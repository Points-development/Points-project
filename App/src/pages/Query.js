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


export default class Query extends React.Component {

    componentWillUnmount() {
    }
    
    componentDidMount() {
    	
    	let url2 = gServer.host+'/score/'+gUser.name;
    	NetUtil.get(url2,function (response) {
    		if(response.status == 200){
    			this.setState({scoreHistory: response.data});
    		}else{
    			this.setState({errorMsg: '请检查网络或联系管理员'});
    		}
        }.bind(this))
    }
    
    constructor (props) {
    	super (props)
    	this.state = {
    		scoreHistory:[]
    	}
    }
    
    _separator = () => {
        return <View style={{ height: 1, backgroundColor: '#CCCCCC',opacity:0.5 }} />
    }
    
    _keyExtractor = (item, index) => item.id;
    
    _renderItem = (item) => {
    	
    	let type='自评';
    	let date = new Date();  
        date.setTime(item.item.lastModifiedTime);  
        let time = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
    	if(item.item.scorer != gUser.name){
    		type = '他评'
    	}
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
    	score.totalScore = score.scores1*5+score.scores2*3+score.scores3*1;
        return (
        		<View style={styles.question}>
        			<View style={{padding:10,paddingTop:30}}>
        				<Text style={{color:gColors.defaultFontColor}}>
        				评测类型:{type}          评测时间:{time}
        				</Text>
        				<Text style={{color:gColors.defaultFontColor}}>
        				评测结果:共{score.total}个问题,
		                其中优秀{score.scores1}项,
		                良好{score.scores2}项,
		                一般{score.scores3}项,
		                较差{score.scores4}项,
		                分数为
		                	<Text style={{color:'#ff5c49'}}>{score.totalScore}分</Text>
        				</Text>
        			</View>
		        	
        		</View>
        	)
    }

    render() {
        return (
        		<View style={styles.container}>
	        		<View style={{paddingTop:20,alignItems: 'center'}}>
						<Text style={{fontSize:20,color:gColors.defaultFontColor}}>
							评测历史记录
						</Text>
					</View>
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
	    justifyContent: 'center',
	    alignItems: 'center',
	    backgroundColor:gColors.background
	},
	question:{
		width:gScreen.width-50,
		height:190
	},
	list:{
		width:gScreen.width,
		flex:1,
		paddingHorizontal:10,
	},
})