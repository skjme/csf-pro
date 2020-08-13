package cn.chaseshu.sentinel.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.SentinelWebInterceptor;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.SentinelWebTotalInterceptor;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.config.SentinelWebMvcConfig;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.config.SentinelWebMvcTotalConfig;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class SpringMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Add Sentinel interceptor
//        addSentinelWebTotalInterceptor(registry);
        addSentinelWebInterceptor(registry);
    }

    private void addSentinelWebInterceptor(InterceptorRegistry registry) {
        // <1.1> 创建 SentinelWebMvcConfig 对象
        SentinelWebMvcConfig config = new SentinelWebMvcConfig();
        config.setHttpMethodSpecify(true); // <1.2> 是否包含请求方法。即基于 URL 创建的资源，是否包含 Method。
        // config.setBlockExceptionHandler(new DefaultBlockExceptionHandler()); // <1.3> 设置 BlockException 处理器。

        // SpringMvcConfiguration#addSentinelWebInterceptor(...)

        config.setOriginParser(new RequestOriginParser() { // 设置请求来源解析器。用于黑白名单控制功能。

            @Override
            public String parseOrigin(HttpServletRequest request) {
                // <X> 从 Header 中，获得请求来源
                String origin = request.getHeader("s-user");
                // <Y> 如果为空，给一个默认的
                if (StringUtils.isEmpty(origin)) {
                    origin = "default";
                }
                return origin;
            }

        });
        // <2> 添加 SentinelWebInterceptor 拦截器
        registry.addInterceptor(new SentinelWebInterceptor(config)).addPathPatterns("/**");
    }

    private void addSentinelWebTotalInterceptor(InterceptorRegistry registry) {
        // <1> 创建 SentinelWebMvcTotalConfig 对象
        SentinelWebMvcTotalConfig config = new SentinelWebMvcTotalConfig();

        // <2> 添加 SentinelWebTotalInterceptor 拦截器
        registry.addInterceptor(new SentinelWebTotalInterceptor(config)).addPathPatterns("/**");
    }

}