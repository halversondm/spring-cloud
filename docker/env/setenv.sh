#!/bin/sh

export CLASSPATH="${catalina.home}/env"
export JAVA_OPTS="-Dspring.profiles.active=registry,customer,account"
