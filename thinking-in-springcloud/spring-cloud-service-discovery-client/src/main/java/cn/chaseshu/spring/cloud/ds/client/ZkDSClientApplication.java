package cn.chaseshu.spring.cloud.ds.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ZkDSClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZkDSClientApplication.class, args);
    }
}
