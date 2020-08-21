package cn.chaseshu.sentinel.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("discovery")
    public Object discovery(@RequestParam(value = "serviceId",defaultValue = "ruyiyun-api") String serviceId){
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        String s = instances.stream().map(v -> v.getUri().toString() + "/app/index/home/1").findAny().orElseThrow(() -> new IllegalArgumentException("没实例"));
        System.out.println(s);
        ResponseEntity<Map> entity = restTemplate.getForEntity(s, Map.class);
        System.out.println(entity);

        return instances;
    }

    @GetMapping("/echo")
    public String echo() {
        return "echo";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    // 当 GET:/demo/sleep 资源在 5 秒的时间窗口中，如果平均响应时间超过 1 ms，则进行熔断降级。
    @GetMapping("/sleep")
    public String sleep() throws InterruptedException {
        Thread.sleep(100L);
        return "sleep";
    }

    // 热点参数限流
    @GetMapping("/product_info")
    @SentinelResource("demo_product_info_hot")
    public String productInfo(Integer id) {
        return "商品编号：" + id;
    }


    // Sentinel 客户端 API
    @GetMapping("/entry_demo")
    public String entryDemo() {
        Entry entry = null;
        try {
            // <1> 访问资源
            entry = SphU.entry("entry_demo");

            // <2> ... 执行业务逻辑

            return "执行成功";
        } catch (BlockException ex) { // <3>
            return "被拒绝";
        } finally {
            // <4> 释放资源
            if (entry != null) {
                entry.exit();
            }
        }
    }

    @GetMapping("/annotations_demo")
    @SentinelResource(value = "annotations_demo_resource",
            blockHandler = "blockHandler",
            fallback = "fallback")
    public String annotationsDemo(@RequestParam(required = false) Integer id) throws InterruptedException {
        if (id == null) {
            throw new IllegalArgumentException("id 参数不允许为空");
        }
        return "success...";
    }

    // BlockHandler 处理函数，参数最后多一个 BlockException，其余与原函数一致.
    public String blockHandler(Integer id, BlockException ex) {
        return "block：" + ex.getClass().getSimpleName();
    }

    // Fallback 处理函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
    public String fallback(Integer id, Throwable throwable) {
        return "fallback：" + throwable.getMessage();
    }

}