package cn.chaseshu.enable.ImportBeanDefinitionRegistrar;

import cn.chaseshu.enable.FtpServer;
import cn.chaseshu.enable.HttpServer;
import cn.chaseshu.enable.Server;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class ServerImportSelector2 implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String importClassName = "";
        Map<String, Object> attribute = importingClassMetadata.getAnnotationAttributes(EnableServer.class.getName());
        Server.ServerType type = (Server.ServerType) attribute.get("type");
        switch (type) {
            case FTP:
                importClassName = FtpServer.class.getName();
                break;
            case HTTP:
                importClassName = HttpServer.class.getName();
                break;
            default:
                break;
        }
        return new String[]{importClassName};

    }
}
