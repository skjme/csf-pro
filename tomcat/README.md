### JAR 启动
`java -jar ` 读取.jar`META-INF/MANIFEST.MF`，其中属性Main-Class就是指定的引导类
> 参考JDK API: `java.util.jar.Mainfest`

### Tomcat Maven 插件

#### Tomcat 7 插件
```xml
 <plugin>
    <groupId>org.apache.tomcat.maven</groupId>
    <artifactId>tomcat7-maven-plugin</artifactId>
    <version>2.2</version>
</plugin>
```

```properties
Manifest-Version: 1.0
Main-Class: org.apache.tomcat.maven.runner.Tomcat7RunnerCli
```

> Tomcat7RunnerCli.main -> Tomcat7Runner.run

得出Tomcat7 可执行的jar引导类是`org.apache.tomcat.maven.runner.Tomcat7RunnerCli`

#### Tomcat 8 插件

tomcat8-maven-plugin


### Tomcat API

static
`http://localhost:9000/abc.html`
`http://localhost:9000/index.jsp`

servlet
`http://localhost:9000/demo`

