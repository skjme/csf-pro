package cn.shukejian.app.controller;

import cn.shukejian.account.client.AccountClient;
import cn.shukejian.common.api.BaseResponse;
import cn.shukejian.common.error.ServiceException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class AppController {

    @Autowired
    private AccountClient accountClient;

    @GetMapping("app")
    public BaseResponse test(@RequestParam(value = "name", required = false) String name) {

//        if (StringUtils.isBlank(name)) {
//            throw new ServiceException("参数 Name Is Empty！");
//        }

        return accountClient.helloNacos(name + ", from nacos-feign greeting! ");
    }
}
