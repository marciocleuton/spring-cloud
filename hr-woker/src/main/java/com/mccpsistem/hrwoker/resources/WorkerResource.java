package com.mccpsistem.hrwoker.resources;

import java.io.Console;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mccpsistem.hrwoker.entities.Worker;
import com.mccpsistem.hrwoker.repositories.WorkerRepository;
import org.slf4j.Logger;

@RestController
@RefreshScope
@RequestMapping(value ="/worker")

public class WorkerResource {
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(WorkerResource.class);
	
	@Value("${test.config}")
	private String testConfig;
	
	@Autowired
	private Environment env;
	
	 private final WorkerRepository workerRepository;      

	 public WorkerRepository getWorkerRepository() {
		return workerRepository;
	}

	public WorkerResource(WorkerRepository workerRepository) {        
	  this.workerRepository = workerRepository;   
	   }
	
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs() {
		logger.info("CONFIG = " + testConfig);
		return ResponseEntity.noContent().build();
	}		

	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		
		List<Worker> list = workerRepository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<Worker> findByid(@PathVariable Long id){
		
		try {
			Thread.sleep(3000L);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		logger.info("Port ="+ env.getProperty("local.server.port"));
		Worker obj = workerRepository.findById(id).get();
		return ResponseEntity.ok(obj);
	}

}
