package com.javainuse.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;

import com.javainuse.model.Employee;
import com.javainuse.services.RemoteCallService;

@Controller
public class ConsumerControllerClient {
	
	@Autowired
	private RemoteCallService loadBalancer;

	public void getEmployee() throws RestClientException, IOException {

		try {
			Employee emp = loadBalancer.getData();
			System.out.println(emp.getEmpId());
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	/*
	public void getEmployee() throws RestClientException, IOException {

		ServiceInstance instance = loadBalancer.choose("employeeproducer");
		//ServiceInstance  producerInstance = instances.get(0);
		String baseUrl = instance.getUri().toString() + "/employee";

		System.out.println(instance.getUri());
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl,
				HttpMethod.GET, getHeaders(),String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		
		
	}*/

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}