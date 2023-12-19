FROM openjdk:17
LABEL maintainer="viman.rukshan@mail.com"

EXPOSE 8080

WORKDIR /app

COPY ./build/libs/demoDevops-0.0.1-SNAPSHOT.jar /app/demoDevops-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/app/demoDevops-0.0.1-SNAPSHOT.jar"]