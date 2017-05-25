FROM tomcat:latest
ADD target/blogg*.war /usr/local/tomcat/webapps/instablog.war
ADD setenv.sh /usr/local/tomcat/bin/setenv.sh