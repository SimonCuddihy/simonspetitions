FROM tomcat:latest

# Remove default webapps to avoid conflicts
RUN mv /usr/local/tomcat/webapps /usr/local/tomcat/webapps2
RUN mv /usr/local/tomcat/webapps.dist /usr/local/tomcat/webapps

# Deploy the WAR file as ROOT.war for root context
ADD target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 9090 for external access
EXPOSE 9090

# Start Tomcat
CMD ["catalina.sh", "run"]
