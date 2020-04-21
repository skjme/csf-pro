package cn.chaseshu.enable.ImportBeanDefinitionRegistrar;

import cn.chaseshu.enable.Server;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Import(ServerImportBeanDefinitionRegistrar.class)
public @interface EnableServer {

    Server.ServerType type() default Server.ServerType.HTTP;
}
