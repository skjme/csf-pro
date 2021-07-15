package cn.chaseshu.spring.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServer {

    // visit url: http://localhost:10086/config/test/master
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServer.class, args);
    }

    @Bean
    public EnvironmentRepository environmentRepository(){
        return (String application, String profile, String label) -> {
            Environment environment = new Environment("default", profile);

            List<PropertySource> propertySources = environment.getPropertySources();

            Map<String, Object> source = new HashMap<>();

            source.put("name", "李四");

            PropertySource propertySource = new PropertySource("map", source);

            propertySources.add(propertySource);

            return environment;

        };

    }
}
