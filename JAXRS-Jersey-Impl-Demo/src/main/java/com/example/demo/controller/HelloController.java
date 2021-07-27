package com.example.demo.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;


@Path("/hello")
public class HelloController {
 
    @GET
    public String hello(@QueryParam("name") String name){
        System.out.println(name);
        return "hello" + "name";
    }
}
