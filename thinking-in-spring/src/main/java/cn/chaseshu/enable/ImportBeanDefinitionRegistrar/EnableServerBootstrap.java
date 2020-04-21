package cn.chaseshu.enable.ImportBeanDefinitionRegistrar;

import cn.chaseshu.enable.Server;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableServer(type = Server.ServerType.FTP)
public class EnableServerBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EnableServerBootstrap.class);
        context.refresh();

        Server ser = context.getBean(Server.class);
        ser.start();

        context.close();
    }
}
