FROM maven:3.6.0-jdk-11-slim AS build
COPY . ChallengeFromFileDocker/
WORKDIR /ChallengeFromFileDocker/
RUN mvn -f /ChallengeFromFileDocker/pom.xml clean package
RUN java -jar /ChallengeFromFileDocker/ChallengeFromFileDocker-1.0-SNAPSHOT.jar Authorization