package cn.shukejian.account.client;

import cn.shukejian.common.api.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class AccountHystrix implements AccountClient {

    @Override
    public BaseResponse helloNacos(String param) {
        return BaseResponse.builder().message("请求超时了").build();
    }
}