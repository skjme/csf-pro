package cn.shukejian.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

// SVC Name: app-service
// Visit Url: http://localhost:9091/app?name=feign
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"cn.shukejian.account"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class NacosApp {
    public static void main(String[] args) {
        SpringApplication.run(NacosApp.class, args);
    }
}
