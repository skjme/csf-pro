package cn.shukejian.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

// SVC name : account-service
// Visit url : http://localhost:9092/v1/account/helloNacos?name=feign
// Swagger-ui : http://localhost:9092/swagger-ui.html

// docker builder :
// docker build -t nacos-feign-svc .
// docker run :
// docker run -p 9092:9092 nacos-feign-svc

// 依赖nacos，所以需要先安装启动nacos
// https://nacos.io/zh-cn/docs/quick-start-docker.html
// git clone https://github.com/nacos-group/nacos-docker.git
// cd nacos-docker
// docker-compose -f example/standalone-derby.yaml up

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class NacosFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosFeignApplication.class, args);
    }
}