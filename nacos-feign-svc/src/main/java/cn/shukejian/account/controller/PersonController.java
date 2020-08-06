package cn.shukejian.account.controller;

import cn.shukejian.account.model.Person;
import cn.shukejian.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@Validated
public class PersonController {

    @GetMapping("/{personId}")
    Person findById(@PathVariable Integer personId) {
        Person person = new Person();
        person.setId(personId);
        person.setName("chaseshu");
        person.setAge(37);
        person.setMessage("this is a test !");
        return person ;

    }

}
