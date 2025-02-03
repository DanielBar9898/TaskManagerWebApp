# Use Apache Tomcat 10.0.11 as the base image
FROM tomcat:10.0.11

# Copy the WAR file into Tomcat's webapps directory
COPY out/artifacts/TaskManagerWeb_War.war /usr/local/tomcat/webapps/TaskManagerWeb_Web.war

# Expose port 8080
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
