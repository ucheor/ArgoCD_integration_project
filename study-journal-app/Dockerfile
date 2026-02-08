FROM tomcat:9.0.73-jdk11-temurin

# Remove default Tomcat applications
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy HTML file directly to ROOT
COPY webapp/index.html /usr/local/tomcat/webapps/ROOT/index.html

# Set proper permissions
RUN chmod -R 755 /usr/local/tomcat/webapps/ROOT && \
    chmod 644 /usr/local/tomcat/webapps/ROOT/index.html

EXPOSE 8080

CMD ["catalina.sh", "run"]