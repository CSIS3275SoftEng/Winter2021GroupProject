package com.example.demoTapMyBeer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoTapMyBeer.model.Payment;
import com.example.demoTapMyBeer.model.PaymentRepository;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api") 
public class PaymentController {

	@Autowired
	PaymentRepository paymentRepository;
	
	@GetMapping("/payments")
	public ResponseEntity<List<Payment>> getAllPayMethod(
			@RequestParam(required = false) String payType){
		try {
			List<Payment> payments = new ArrayList<Payment>();
			if(payType == null) {
				paymentRepository.findAll().forEach(payments::add);
				
			}else {
				paymentRepository.findByPayType(payType).forEach(payments::add);

			}if(payments.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(payments,HttpStatus.OK );
		
		}catch(Exception e){
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR );

			
		}
	}
	
	@GetMapping("/payments/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("id") long id){
		Optional<Payment> payTypeData = paymentRepository.findById(id);
	
		if(payTypeData.isPresent()) {
			return new ResponseEntity<>(payTypeData.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/payments")
	public ResponseEntity<Payment> createPayMethod(@RequestBody Payment payment){
		try {
			Payment _payment = paymentRepository.save(new Payment(payment.getPayType()));
			return new ResponseEntity<>(_payment, HttpStatus.CREATED);
		}
		
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@PutMapping("/payments/{id}")
	public ResponseEntity<Payment> updatePayMethod(@PathVariable("id") long id, @RequestBody Payment payment) {
		Optional<Payment> payTypeData = paymentRepository.findById(id);

		if (payTypeData.isPresent()) {
			Payment _payment = payTypeData.get();
			
			_payment.setPayType(payment.getPayType());
			return new ResponseEntity<>(paymentRepository.save(_payment), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	@DeleteMapping("/payments/{id}")
	public ResponseEntity<HttpStatus> deletePayMethod(@PathVariable("id") long id) {
		try {
			paymentRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/payments")
	public ResponseEntity<HttpStatus> deleteAllMethods() {
		try {
			paymentRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
}
