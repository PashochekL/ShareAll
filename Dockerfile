FROM openjdk:21
COPY build/libs/ShareAll-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]