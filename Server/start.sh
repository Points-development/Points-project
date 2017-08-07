#!/bin/sh

rm -f tpid

nohup java -server -Xms2g -Xmx2g -Djava.security.egd=file:/dev/./urandom -jar ./points-app-0.0.1-SNAPSHOT.jar > /dev/null 2>&1 &

echo $! > tpid