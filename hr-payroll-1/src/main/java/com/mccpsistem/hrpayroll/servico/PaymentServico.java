package com.mccpsistem.hrpayroll.servico;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mccpsistem.hrpayroll.entities.Payment;
import com.mccpsistem.hrpayroll.entities.Worker;
import com.mccpsistem.hrpayroll.feignclients.WorkerFeignClient;

//@Component //Registar a clase como um componete do spring
@Service  //Registrar o Serviço
public class PaymentServico {
	

	private String host;
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
		
	public Payment getPayment(long whokerId, int days) {
		
	 Worker worker = workerFeignClient.findByid(whokerId).getBody();
	 return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
