FROM java:8
ADD demo-1.0.jar app.jar
#ENTRYPOINT [ "java", "-jar", "/app.jar" ]
#EXPOSE 8080
#RUN echo 8.8.8.8 foo > /etc/hosts; ping -c 4 foo
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]