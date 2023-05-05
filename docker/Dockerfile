FROM maven:3-openjdk-17-slim As Build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:17-jdk-alpine AS run
EXPOSE 8080
COPY --from=build /home/app/target/*.jar /usr/local/lib/service.jar
WORKDIR /usr/local/lib
ENTRYPOINT java -jar service.jar

