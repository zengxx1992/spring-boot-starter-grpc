From jre-8-simple-alpine-glibc:latest
COPY target/samples-server-1.0-SNAPSHOT.jar /grpc-server.jar
EXPOSE 8080
EXPOSE 6565
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar", "/grpc-server.jar"]