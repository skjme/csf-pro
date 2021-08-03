package com.example.demo.clientapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

@SpringBootTest
class ClientTests {

	@Test
	void resourceAccess() {
		
		String url = "http://localhost:8888/restful/hello";
		Client client = ClientBuilder.newClient();
		Response response = client.target(url)
				.queryParam("name", "chaseshu")
				.request("text/plain")
				.get();
		System.out.println(response);
	}
	

}
