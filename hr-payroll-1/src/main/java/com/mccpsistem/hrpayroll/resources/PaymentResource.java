package com.mccpsistem.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mccpsistem.hrpayroll.entities.Payment;
import com.mccpsistem.hrpayroll.servico.PaymentServico;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
	@Autowired
	private PaymentServico sevico;
	
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{WorkerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long WorkerId, @PathVariable Integer days){
		Payment payment = sevico.getPayment(WorkerId, days);
		
		return ResponseEntity.ok(payment);
				
		
	}
	
	public ResponseEntity<Payment> getPaymentAlternative(Long WorkerId, @PathVariable Integer days){
		
		Payment payment = new  Payment("Marcio", 400.0, days);
		
		return ResponseEntity.ok(payment);
			
	}
	
	

}
