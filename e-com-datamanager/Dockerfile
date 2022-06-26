FROM openjdk:8-jdk-alpine
RUN addgroup -S ecom && adduser -S ecom -G ecom
USER ecom:ecom
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]