package com.mccpsistem.hrwoker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mccpsistem.hrwoker.entities.Worker;

public interface WorkerRepository  extends JpaRepository<Worker, Long >{

	 
}
