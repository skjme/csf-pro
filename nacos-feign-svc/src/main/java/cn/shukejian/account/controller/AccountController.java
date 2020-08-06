package cn.shukejian.account.controller;

import cn.shukejian.account.service.AccountService;
import cn.shukejian.common.api.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
@Validated
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/helloNacos")
    BaseResponse helloNacos(@RequestParam String name) {

        return accountService.hello(name);

    }

}
