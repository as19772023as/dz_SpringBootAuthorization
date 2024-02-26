FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY target/dz_SpringBootAuthorization-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "ap.jar"]
