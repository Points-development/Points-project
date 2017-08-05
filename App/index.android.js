

import React, { Component } from 'react';
import {
  AppRegistry,
} from 'react-native';

import Assessment from './src/Assessment'

if (!__DEV__) {
  global.console = {
    info: () => {},
    log: () => {},
    warn: () => {},
    error: () => {}
  };
}

export default class assessment extends Component {
  render() {
    return (
      <Assessment />
    );
  }
}

AppRegistry.registerComponent('assessment', () => assessment);
