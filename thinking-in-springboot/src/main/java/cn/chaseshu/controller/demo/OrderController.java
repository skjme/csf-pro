package cn.chaseshu.controller.demo;

import cn.chaseshu.domain.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

// curl http://localhost:8080/prod/order
// curl http://localhost:8080/${profile}/order
@RequestMapping("/order")
@RestController
public class OrderController {

    @GetMapping
    public Order query() {

        Order order = new Order();
        order.setPayTime(LocalDateTime.now());
        order.setPayDate(LocalDate.now());

        return order;
    }

}
