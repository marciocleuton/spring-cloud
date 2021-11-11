package com.mccpsistem.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mccpsistem.hrpayroll.entities.Worker;


@Component
@FeignClient(name ="hr-worker",  path ="/worker")
public interface WorkerFeignClient {
	
	@GetMapping(value= "/{id}")
	ResponseEntity<Worker> findByid(@PathVariable Long id);
		
	

}
