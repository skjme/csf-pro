FROM java:8-jdk-alpine

COPY ./target/nacos-feign-svc-1.0.0.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch nacos-feign-svc-1.0.0.jar'

ENTRYPOINT ["java", "-jar", "nacos-feign-svc-1.0.0.jar"]