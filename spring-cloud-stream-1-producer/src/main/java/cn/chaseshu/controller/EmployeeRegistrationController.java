package cn.chaseshu.controller;

import cn.chaseshu.model.Employee;
import cn.chaseshu.source.EmployeeRegistrationSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
@RestController
@EnableBinding(EmployeeRegistrationSource.class)
public class EmployeeRegistrationController {

    @Autowired
    EmployeeRegistrationSource employeeRegistrationSource;

    @RequestMapping("/register")
    @ResponseBody
    public String orderFood(@RequestBody Employee employee) {
        IntStream.range(0, 10).forEach(
                v -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    employee.setEmpID("emp-"+v);
                    employeeRegistrationSource.employeeRegistration().send(MessageBuilder.withPayload(employee).build());
                }
        );
        log.error(employee.toString());
        return "Employee Registered";
    }
}