#this is a react native project for assessment app
#Step 1 keep .babelrc in project root dir, otherwise can not transform es6 to js
{
  "presets": [
    "react-native"
  ],
  "plugins": [
    "transform-decorators-legacy"
  ]
}


# Step 2
npm install && react-native link


#Step 3
react-native run-ios

#Upgrade,execute below command:
react-native-git-upgrade




#Android packaging offline

./gradlew assembleRelease

#uninstall npm module from react native:
#if this is non-js based module,execute belows:
react-native unlink react-native-video

#then remove npm module
npm uninstall --save react-native-video
