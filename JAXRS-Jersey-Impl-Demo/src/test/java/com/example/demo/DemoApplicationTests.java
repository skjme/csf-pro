package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		
		String url = "http://localhost:8888/restful/hello";
		Client client = ClientBuilder.newClient();
		Response response = client.target(url).request("text/plain").get();
		System.out.println(response);
	}

}
