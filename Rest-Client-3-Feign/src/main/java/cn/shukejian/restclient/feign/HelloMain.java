package cn.shukejian.restclient.feign;

import feign.Feign;

public class HelloMain {

    public static void main(String[] args) {

        HelloClient client = Feign.builder().target(HelloClient.class, "http://localhost:9092");
        System.out.println(client.sayHello());

    }
}
