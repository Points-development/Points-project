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

#Step4
1. cd /Users/xzgan/Library/Android/sdk/tools
2. find device: ./emulator -list-avds
3. nohup emulator -avd device28 -dns-server 8.8.8.8 &
4. npm start in project dir


#Android packaging offline

./gradlew assembleRelease

使用安卓studio 生成离线包

#uninstall npm module from react native:
#if this is non-js based module,execute belows:
react-native unlink react-native-video

#then remove npm module
npm uninstall --save react-native-video






#android key add below to build.gradle

signingConfigs {
        release {
            storeFile file("/Users/xzgan/git/Points-project/App/android/keystores/my-release-key.keystore")
            storePassword "Letmein123"
            keyAlias "point"
            keyPassword "Letmein123"
        }
}

buildTypes {
        release {
            minifyEnabled enableProguardInReleaseBuilds
            proguardFiles getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro"
            signingConfig signingConfigs.release
        }
}

#generate key 
keytool -genkey -v -keystore my-release-key.keystore  -alias point -keyalg RSA -keysize 2048 -validity 20000
