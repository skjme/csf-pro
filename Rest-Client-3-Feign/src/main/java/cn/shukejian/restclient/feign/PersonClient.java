package cn.shukejian.restclient.feign;

import feign.Param;
import feign.RequestLine;
import lombok.Data;

public interface PersonClient {

    @RequestLine("GET /person/{personId}")
    Person findById(@Param("personId") Integer personId);

    @Data
    class Person{
        Integer id;
        String name;
        Integer age;
        String message;
    }
}
