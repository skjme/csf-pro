package cn.chaseshu.thinking.in.spring.resource;


import cn.chaseshu.thinking.in.spring.resource.util.ResourceUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.util.stream.Stream;

public class InjectingResourceDemo {

    @Value("classpath:application.properties")
    private Resource defaultProopertiesResourse;

    @Value("classpath*:*.properties")
    private Resource [] propertiesResources;

    @Value("${user.dir}")
    private String currentProjectRootPath;

    @PostConstruct
    public void init(){
        System.out.println(ResourceUtils.getContent(defaultProopertiesResourse));
        System.out.println("-------------");
        Stream.of(propertiesResources).map(ResourceUtils::getContent).forEach(System.out::println);
        System.out.println("-------------");
        System.out.println(currentProjectRootPath);
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册当前类作为 配置类
        context.register(InjectingResourceDemo.class);
        // 启动上下文
        context.refresh();
        // 关闭上下文
        context.close();
    }
}
