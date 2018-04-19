package com.javainuse.services;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javainuse.model.Employee;



@FeignClient("employee-zuul-service")
public interface RemoteCallService {

	@RequestMapping(method=RequestMethod.GET, value="producer/employee")
	public Employee getData();
}
