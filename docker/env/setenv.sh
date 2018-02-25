#!/bin/sh

export CLASSPATH="${CATALINA_HOME}/env"
export JAVA_OPTS="-Dspring.profiles.active=server"
