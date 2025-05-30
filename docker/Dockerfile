FROM tomcat:9.0-jre17-alpine

WORKDIR $CATALINA_HOME/webapps

RUN \
rm -rf docs && \
rm -rf host-manager && \
rm -rf manager && \
rm -rf examples && \
rm -rf ROOT

ADD ./target/account-1.0.0.war account-service.war
ADD ./target/customer-1.0.0.war customer-service.war
ADD ./target/registry-1.0.0.war registry.war

WORKDIR $CATALINA_HOME

RUN mkdir env

WORKDIR $CATALINA_HOME/env

ADD ./env/application-server.yml application-server.yml

WORKDIR $CATALINA_HOME/bin

ADD ./env/setenv.sh setenv.sh

EXPOSE 8080

CMD ["catalina.sh", "run"]