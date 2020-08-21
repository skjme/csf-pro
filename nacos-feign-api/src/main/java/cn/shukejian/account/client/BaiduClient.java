package cn.shukejian.account.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="baidu", url="http://www.baidu.com")
public interface BaiduClient {

    @GetMapping
    public String baiduIndex();

}
