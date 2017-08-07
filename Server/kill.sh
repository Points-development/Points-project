#!/bin/sh
kill -9 `ps -ef|grep points-app | grep -v grep |awk '{print $2}'`