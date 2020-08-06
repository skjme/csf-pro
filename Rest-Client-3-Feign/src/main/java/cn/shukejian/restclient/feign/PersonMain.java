package cn.shukejian.restclient.feign;

import feign.Feign;
import feign.gson.GsonDecoder;

public class PersonMain {

    public static void main(String[] args) {

        PersonClient client = Feign.builder()
                .decoder(new GsonDecoder())
                .target(PersonClient.class, "http://localhost:9092");
        System.out.println(client.findById(1));

    }
}
