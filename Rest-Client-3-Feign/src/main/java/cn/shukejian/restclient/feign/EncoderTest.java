package cn.shukejian.restclient.feign;

import feign.Feign;
import feign.gson.GsonEncoder;

public class EncoderTest {

    public static void main(String[] args) {

        PersonClient client = Feign.builder()
                .encoder(new GsonEncoder())
                .target(PersonClient.class, "http://localhost:9092");

        PersonClient.Person person = new PersonClient.Person();
        person.id = 1;
        person.name = "lisi";
        person.age = 30;
        person.message = "";

        String response = client.createPerson(person);
        System.out.println(response);

    }
}
