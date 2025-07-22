FROM openjdk:21
COPY target/myapp.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]