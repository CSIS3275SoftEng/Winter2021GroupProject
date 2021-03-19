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
	ApplicationRunner init(ProductRepository productRepository, 
			AddressRepository addressRepository, 
			OrderRepository orderRepository, 
			CustomerRepository customerRepository, 
			WebmasterRepository webmasterRepository, 
			SellerRepository sellerRepository, 
			CategoryRepository categoryRepository) {
		return args -> {
			
			// populate Products
			Product[] products = { // Seller: Dageraad
									new Product("Imperial Session Kveik IPA (4-pack cans)", 15.35, 30), // seller: dageraad
									new Product("Multigrain Dry-Hopped Pale Ale (4-pack cans)", 16.50, 10), // seller: dageraad
									new Product("Dry-Hopped Belgian-Style Pale Ale (4-pack cans)", 16.50, 15), // seller: dageraad
									new Product("Imperial Stout with Caao & Miso 650ml bottle", 10.74, 15), // seller: dageraad
									new Product("Amber 650ml bottle", 6.54, 50), // seller: dageraad
									new Product("Blonde 650ml bottle", 7.29, 20), // seller: dageraad
									new Product("Brune 650ml bottle", 7.29, 40), // seller: dageraad
									new Product("Burnabarian 650ml bottle", 6.08, 70), // seller: dageraad
									new Product("Sterke Soelaas 650ml bottle", 9.88, 10), // seller: dageraad
									// Seller: Steel & Oak
									new Product("Shiny Things IPA (4-pack cans)", 14.49, 20), // seller: steel & oak
									new Product("Dark Lager (4-pack cans)", 14.49, 25), // seller: steel & oak
									new Product("Red Pilsner (4-pack cans)", 14.49, 30), // seller: steel & oak
									new Product("Royal City Ale (4-pack cans)", 14.49, 50), // seller: steel & oak
									new Product("Mimeo Ale 650ml bottle", 9.30, 20) }; // seller: steel & oak
					
			for (int i = 0; i < products.length; i++) {
				productRepository.save(products[i]);
			}
						
			productRepository.findAll().forEach(System.out::println);
			
			
			// populate Addresses
			addressRepository.save(new Address(1, 63,"Broadway","Burnaby","BC","V4B2A4"));
			addressRepository.findAll().forEach(System.out::println);
			
			
			
			
			// populate Webmasters
			Webmaster[] webmasters = { new Webmaster("Joanne Richmond", "joanrich", "9999"),
										new Webmaster("Paul Lynch", "p_lynch", "1111")};
		
			for (int i = 0; i < webmasters.length; i++) {
				webmasterRepository.save(webmasters[i]);
			}
			
			webmasterRepository.findAll().forEach(System.out::println);
			
			
			
			// populate Customers
			Customer[] customers = { new Customer("Mary Joan Stewart", "123 Glenbroke Street, Abbotsford, BC, Canada", "3455552525252520", "maryj", "1212"),
					new Customer("Peter Johanson", "998A Hope Avenue, Langley, BC, Canada", "9999000012127777", "pjohanson", "9999") };
		
			for (int i = 0; i < customers.length; i++) {
				customerRepository.save(customers[i]);
			}

			customerRepository.findAll().forEach(System.out::println);

			
			// populate Sellers
			Seller[] sellers = { new Seller("Dageraad Brewing", "dageraad", "9090"),
									new Seller("Green Leaf Brew", "green_leaf", "4444"),
									new Seller("Steamworks Brewing Company", "steamy", "6732"),
									new Seller("Steel & Oak Brewing Company", "s&o", "1010") };
			

			for (int i = 0; i < sellers.length; i++) {
				sellerRepository.save(sellers[i]);
			}
			

			sellerRepository.findAll().forEach(System.out::println);
			
			
			// populate Categories
			Category[] categories = { new Category("Lager"),
										new Category("Stout"),
										new Category("Pale Ale"),
										new Category("Pilsen"),
										new Category("IPA") };
			
			for (int i = 0; i < categories.length; i++) {
				categoryRepository.save(categories[i]);
			}
						
			categoryRepository.findAll().forEach(System.out::println);
			
			
			
			
			
			// populate Orders
			//Order[] orders = { new Order(2019, 01, 19, 3), 
			//					new Order(2020, 9, 17, 1),
			//					new Order(2020, 10, 23, 2),
			//					new Order(2021, 01, 27, 3) };
						
			//orderRepository.findAll().forEach(System.out::println);

			//for (int i = 0; i < orders.length; i++) {
			//	orderRepository.save(orders[i]);
			//}
						
		
		};
	}

}
