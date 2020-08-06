package cn.shukejian.account.client;

import cn.shukejian.account.AccountConstant;
import cn.shukejian.common.api.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 1 定义远程接口
@FeignClient(
        name = AccountConstant.SERVICE_NAME,
        path = "/v1/account",
//        url = "${shukejian.account-service-endpoint}",
        fallback = AccountHystrix.class)
public interface AccountClient {

    @GetMapping("/helloNacos")
    BaseResponse helloNacos(@RequestParam String name);

}
