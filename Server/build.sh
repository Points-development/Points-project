#!/bin/bash
cd src/main/webapp
echo "Starting to build static web files"
#!!!!!!!!!!!before compress code, please put all required js file in gulpfile.js!!!!!!!!!!!
npm run compress-code
EXIT_CODE=$?
if [ $EXIT_CODE -ne 0 ]; then
    exit $EXIT_CODE
fi
rm -rf ../resources/static
mkdir ../resources/static
cp ./*.html ../resources/static
cp -r ./portal ../resources/static
cp -r ./bower_components ../resources/static
cp ./build/concat-libs.min.js ../resources/static/portal
cp ./build/main.min.js ../resources/static/portal
cp ./build/css/main.min.css ../resources/static/portal/content/css
cp -r ./build/img/* ../resources/static/portal/content/img/
mv ../resources/static/portal/index.html ../resources/static/portal/index.all.html
mv ../resources/static/index.build.html ../resources/static/portal/index.html
echo "Finished to build static web files"
cd ../../..
mvn clean
#!!!!!!when we package and upload to server, please modify WebConfig.java and WebSecurityConfig!!!!!!!!!!!!!
#!!!!!!uncomment the method addResourceHandlers!!!!!!!!!!!!!!!
mvn package -Dmaven.test.skip=true
#rm -rf src/main/resources/static
