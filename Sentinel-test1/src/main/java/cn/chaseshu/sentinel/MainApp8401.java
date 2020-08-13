package cn.chaseshu.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MainApp8401 {

    public static void main(String[] args) {

        // <X> 设置系统属性 project.name，提供给 Sentinel 读取
        System.setProperty("project.name", "cloudalibaba-sentinel-service");

        SpringApplication.run(MainApp8401.class, args);
    }
}
