FROM maven:3.8.2-jdk-8 as build

COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#ADD target/thbrabbitmqserver-0.0.1-SNAPSHOT.jar app.jar
#
#ENTRYPOINT exec java -jar app.jar
FROM maven:3.8.2-jdk-8
COPY --from=build /home/app/target/thbrabbitmqserver-0.0.1-SNAPSHOT.jar /usr/local/lib/app.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]

