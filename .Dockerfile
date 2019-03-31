FROM java:8-jdk-alpine
COPY ./target/requester-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch requester-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","requester-0.0.1-SNAPSHOT.jar"]