# Start with a base image containing Java runtime
FROM java:8

# Add Maintainer Info
LABEL maintainer="SKP"

# Add a volume pointing to /tmp
VOLUME /tmp


# Add the application's jar to the container
ADD employeeconsumerservice-0.0.1-SNAPSHOT.jar employeeconsumerservice.jar

#RUN bash -c 'touch /employeeconsumerservice.jar'
# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/employeeconsumerservice.jar"]

EXPOSE 8091
