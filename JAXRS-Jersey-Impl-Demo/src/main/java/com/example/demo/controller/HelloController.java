package com.example.demo.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


@Path("/hello")
public class HelloController {
 
    @GET
    public String hello(@QueryParam("name") String name){
        System.out.println(name);
        return "hello，" + name;
    }
    
    @GET
    @Path("/query")
    @Produces(MediaType.TEXT_PLAIN)
    public String listQueryParamNames(@Context UriInfo uriInfo){
        StringBuilder buf = new StringBuilder();
        for(String param: uriInfo.getQueryParameters().keySet()){
            buf.append(param);
            buf.append("\n");
        }
        return buf.toString();
    }
}
