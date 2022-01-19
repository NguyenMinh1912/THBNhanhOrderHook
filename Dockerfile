FROM maven:3.8.2-jdk-8 as build

WORKDIR /app

#COPY . .
#
#RUN mvn clean package -DskipTests

ENV SERVE_PORT=8081

ADD target/thbrabbitmqserver-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT exec java -jar app.jar

