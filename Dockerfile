FROM openjdk:17
FROM mysql:8.0.34-oracle

COPY target/amazon.jar  /usr/app/

WORKDIR /usr/app/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "demo-app.jar"]