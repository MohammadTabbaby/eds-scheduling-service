# Build Stage
FROM maven:3.6-openjdk-17 as builder
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -q -D maven.test.skip=true -f /home/app/pom.xml clean package

# Package Stage
FROM openjdk:17
COPY --from=builder /home/app/target/schedulingservice-0.0.1-SNAPSHOT.jar /usr/local/lib/schedulingservice.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "/usr/local/lib/schedulingservice.jar"]
