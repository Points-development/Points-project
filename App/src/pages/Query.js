/**
 * Created by ljunb on 16/8/21.
 */
import React, { Component } from 'react';
import {
	StyleSheet,
	View,
	TouchableOpacity,
	Text
} from 'react-native';


export default class Query extends React.Component {

    componentWillUnmount() {
    }
    
    constructor (props) {
    	super (props)
    }

    render() {
        return (
        		<View style={styles.container}>
        			<Text>query</Text>
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
	}
})