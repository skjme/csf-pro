package com.chaseshu.controller;

import com.chaseshu.sender.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 */
@RestController
public class TestController {

    @Autowired
    private Sender sender;

    @GetMapping("hello")
    public String helloTest() {
        sender.send();
        return "success";
    }
}
