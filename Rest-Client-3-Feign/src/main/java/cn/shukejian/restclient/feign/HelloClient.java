package cn.shukejian.restclient.feign;

import feign.RequestLine;

public interface HelloClient {

    @RequestLine("GET /hello/sayHello")
    String sayHello();

}
