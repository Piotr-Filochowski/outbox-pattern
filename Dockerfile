FROM openjdk:21
COPY build/libs/outbox-1.0.jar /tmp/app.jar
WORKDIR /tmp
ENTRYPOINT ["java","-jar","app.jar"]