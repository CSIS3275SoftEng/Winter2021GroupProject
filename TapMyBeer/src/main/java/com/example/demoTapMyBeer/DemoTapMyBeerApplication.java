package com.example.demoTapMyBeer;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demoTapMyBeer.model.Customer;
import com.example.demoTapMyBeer.model.CustomerRepository;
import com.example.demoTapMyBeer.model.Seller;
import com.example.demoTapMyBeer.model.SellerRepository;
import com.example.demoTapMyBeer.model.Webmaster;
import com.example.demoTapMyBeer.model.WebmasterRepository;

@SpringBootApplication
public class DemoTapMyBeerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTapMyBeerApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(CustomerRepository customerRepository, WebmasterRepository webmasterRepository, SellerRepository sellerRepository) {

		return args -> {
			
			// 1 -Customers populating tables
			Customer[] customers = { new Customer("Andrea Abjaud", "87 Dane Street, Vancouver, BC, V4R 1T5", "4333 1233 4566 7865", "andreaa", "12345"),
					new Customer("Joel Giladi", "5664-A Aurora Road, Langley, BC, V7T 9S3", "5435 8876 3421 9078", "joelg", "12346"), 
					new Customer("Zoe Nguyen", "990-45 River Lane, Burnaby, BC, V7X 5K8", "7766 4573 9675 1010", "zoen", "12347"), 
					new Customer("Eduardo Silva", "121-899 Queens Avenue, Abbottsford, BC, V2O 2P7", "9900 3322 7788 2121", "eduardos", "12348") };

			for (int i = 0; i < customers.length; i++) {
				customerRepository.save(customers[i]);
			}

			customerRepository.findAll().forEach(System.out::println);
			// end of customers --------------------------
			
			
			// 2 - Webmasters populating tables
			Webmaster[] webmasters = { new Webmaster("Mary Stevens", "marystevens", "1111"),
					new Webmaster("Tim Johnson", "timjohnson", "2222") };

			for (int i = 0; i < webmasters.length; i++) {
				webmasterRepository.save(webmasters[i]);
			}

			webmasterRepository.findAll().forEach(System.out::println);
			// end of webmasters  --------------------------
			
			// 3 - Sellers populating tables
			Seller[] sellers = { new Seller("Kelly O'Brien", "kellyob", "1212"),
								new Seller("The Hub", "thehub", "1313"),
								new Seller("Piva", "piva", "1414"),
								new Seller("White Spot", "whitespot", "1515") };

			for (int i = 0; i < sellers.length; i++) {
				sellerRepository.save(sellers[i]);
			}

			sellerRepository.findAll().forEach(System.out::println);
			// end of sellers  --------------------------
			
		};

	}
	

}
