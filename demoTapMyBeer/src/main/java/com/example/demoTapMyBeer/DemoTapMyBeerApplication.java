package com.example.demoTapMyBeer;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demoTapMyBeer.model.Address;
import com.example.demoTapMyBeer.model.AddressRepository;
import com.example.demoTapMyBeer.model.Category;
import com.example.demoTapMyBeer.model.CategoryRepository;
import com.example.demoTapMyBeer.model.Customer;
import com.example.demoTapMyBeer.model.CustomerRepository;
import com.example.demoTapMyBeer.model.OrderRepository;
import com.example.demoTapMyBeer.model.Product;
import com.example.demoTapMyBeer.model.ProductRepository;
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
	ApplicationRunner init(ProductRepository productRepository, AddressRepository addressRepository, OrderRepository orderRepository, 
			CustomerRepository customerRepository, WebmasterRepository webmasterRepository, SellerRepository sellerRepository, CategoryRepository categoryRepository) {
		return args -> {
			productRepository.save(new Product("Stella Artois (6-pack)", 12.99, 20 ));
			productRepository.findAll().forEach(System.out::println);
			
			addressRepository.save(new Address(1, 63,"Broadway","Burnaby","BC","V4B2A4"));
			addressRepository.findAll().forEach(System.out::println);
			
			
			// populate Webmasters
			Webmaster[] webmasters = { new Webmaster("Joanne Richmond", "joanrich", "9999") };
		
			for (int i = 0; i < webmasters.length; i++) {
				webmasterRepository.save(webmasters[i]);
			}
			
			webmasterRepository.findAll().forEach(System.out::println);

			
			// populate Orders
			//Order[] orders = { new Order(2019, 01, 19, 3), 
			//					new Order(2020, 9, 17, 1),
			//					new Order(2020, 10, 23, 2),
			//					new Order(2021, 01, 27, 3) };
			
			//orderRepository.findAll().forEach(System.out::println);

			
			// populate Customers
			Customer[] customers = { new Customer("Mary Joan Stewart", "123 Glenbroke Street, Abbotsford, BC, Canada", "3455552525252520", "maryj", "1212"),
					new Customer("Peter Johanson", "998A Hope Avenue, Langley, BC, Canada", "9999000012127777", "pjohanson", "9999") };
		
			//for (int i = 0; i < orders.length; i++) {
			//	orderRepository.save(orders[i]);
			//}
			
			// populate Sellers
			Seller[] sellers = { new Seller("Lennox Pub", "lennox_pub", "9090"),
									new Seller("The Moose", "moose", "4444"),
									new Seller("Johnnie Fox's Irish Snug", "johnnie_foxs", "1010") };
								
			// populate Categories
			Category[] categories = { new Category("Lager"),
										new Category("Stout"),
										new Category("Pilsen"),
										new Category("IPA") };
						
			
			for (int i = 0; i < sellers.length; i++) {
				sellerRepository.save(sellers[i]);
			}
			
			for (int i = 0; i < categories.length; i++) {
				categoryRepository.save(categories[i]);
			}
			
			for (int i = 0; i < customers.length; i++) {
				customerRepository.save(customers[i]);
			}

			
			sellerRepository.findAll().forEach(System.out::println);
			categoryRepository.findAll().forEach(System.out::println);
			customerRepository.findAll().forEach(System.out::println);
		
		};
	}

}
