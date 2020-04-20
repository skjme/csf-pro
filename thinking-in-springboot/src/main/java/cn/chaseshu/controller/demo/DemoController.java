package cn.chaseshu.controller.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/demo")
@RestController
public class DemoController {

    @GetMapping("/echo")
    public String echo() {
        return "echo";
    }

}
