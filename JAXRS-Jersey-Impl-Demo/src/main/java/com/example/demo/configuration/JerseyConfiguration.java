package com.example.demo.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Jersey服务器配置
 * <p>
 * 使用Jersey来提供对JAX-RS（JSR 370：Java API for Restful Web Services）的支持
 * 这里设置了所有服务的前缀路径“restful”和restful服务资源的包路径
 **/
@Configuration
@ApplicationPath("/restful")
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {
        scanPackages("com.example.demo.controller");
    }

    /**
     * Jersey的packages()方法在Jar形式运行下有问题，这里修理一下
     */
    private void scanPackages(String scanPackage) {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Path.class));
        scanner.addIncludeFilter(new AnnotationTypeFilter(Provider.class));
        this.registerClasses(scanner.findCandidateComponents(scanPackage).stream()
                .map(beanDefinition -> ClassUtils.resolveClassName(Objects.requireNonNull(beanDefinition.getBeanClassName()), this.getClassLoader()))
                .collect(Collectors.toSet()));
    }


}
