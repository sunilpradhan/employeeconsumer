package com.javainuse;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.javainuse.controllers.ConsumerControllerClient;

@SpringBootApplication
@EnableFeignClients
public class SpringBootConsumerdApplication {

	public static void main(String[] args) throws RestClientException, IOException, InterruptedException {
		ApplicationContext ctx = SpringApplication.run(
				SpringBootConsumerdApplication.class, args);
		
		ConsumerControllerClient consumerControllerClient=ctx.getBean(ConsumerControllerClient.class);
		System.out.println("consumerControllerClient:" + consumerControllerClient);
		for(int i=0; i < 100; i++) {
			consumerControllerClient.getEmployee();
			// Thread.sleep(1000);
		}
		
	}
	
	@Bean
	public  ConsumerControllerClient  consumerControllerClient()
	{
		return  new ConsumerControllerClient();
	}
}