package cn.shukejian.account.controller;

import cn.shukejian.account.model.Person;
import cn.shukejian.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        return person;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createPerson(@RequestBody Person person) {
        System.out.println(person.getName() + "-" + person.getAge());
        return "Success, Person Id: " + person.getId();
    }

}
