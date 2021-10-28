package cn.shukejian.tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.Host;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

/**
 * 嵌入式 Tomcat  服务器
 */
public class EmbeddedTomcatSever {
    
    public static void main(String[] args) throws LifecycleException, ServletException {
        
        String classPath = System.getProperty("user.dir") + File.separator + "target" + File.separator + "classes";
        System.out.println(classPath);
    
        // create Tomcat Instance
        Tomcat tomcat = new Tomcat();
        
        tomcat.setPort(9000);
        
        Host host = tomcat.getHost();
        host.setName("localhost");
        host.setAppBase("webapps");
    
        // 设置 Context
        String webapp = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator+"webapp";
        String contextPath = "/";
        
        // 设置 webapp 绝对路径 到Context，作为DocBase
        Context context = tomcat.addWebapp(contextPath, webapp);
        if(context instanceof StandardContext){
            StandardContext standardContext = (StandardContext) context;
            // 设置默认的web.xml 到 Context
            standardContext.setDefaultContextXml(classPath + File.separator + "conf/web.xml");
            
            // 设置 classpath 到 Context
            // 添加 DemoServlet 到 Tomcat 容器
            Wrapper wrapper = tomcat.addServlet(contextPath, "DemoServlet", new DemoServlet());
            wrapper.addMapping("/demo");
        }
        
        // 设置中文不乱吗
        tomcat.getConnector().setURIEncoding("UTF-8");
    
        // 启动服务
        tomcat.start();
        
        // 强制 Tomcat Server等待，避免main线程执行结束关系
        tomcat.getServer().await();
    }
}
