/**
 * global settings
 */
import { Dimensions, Platform, PixelRatio } from 'react-native'

global.gScreen = {
    width: Dimensions.get('window').width,
    height: Dimensions.get('window').height,
    navBarHeight: Platform.OS === 'ios' ? 64 : 50,
    navBarPaddingTop: Platform.OS === 'ios' ? 20 : 0,
    onePix: 1 / PixelRatio.get(),
    isIOS: Platform.OS === 'ios'
}

global.gColors = {
    theme: '#584f60',
    themeFontColor:'#fff',
    submitColor:'#8ee9d4',
    buttonColor:'#50C900',
    buttonDisableColor:'rgba(80,201,79,0.2)',
    buttonCancelColor:'rgba(184, 193, 193,0.8)',
    background: '#fbfcfc',
    defaultFontColor:'#000',
    border: '#d5d5d5',
    healthGreen: 'rgb(142, 213, 7)',
    healthYellow: 'rgb(254, 210, 10)',
    healthRed: 'rgb(251, 25, 8)'
}

global.gFont = {
	headerSize:22,
	headerSize2:20,
	contentSize:16
}

global.gServer = {
	host:'http://123.56.4.5:7080/pointservice'
}