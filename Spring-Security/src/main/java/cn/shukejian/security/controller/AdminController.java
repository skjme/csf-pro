package cn.shukejian.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chaseshu
 * @date 2022/4/3 18:44
 * @apiNote
 */
@RestController
@RequestMapping("admin")
public class AdminController {
    
    @GetMapping("index")
    public String index(){
        return "admin index";
    }
}
