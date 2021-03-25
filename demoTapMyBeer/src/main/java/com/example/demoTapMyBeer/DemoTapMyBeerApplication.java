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
			
			// populate Addresses
			addressRepository.save(new Address(1, 63,"Broadway","Burnaby","BC","V4B2A4"));
			addressRepository.findAll().forEach(System.out::println);
		
			
			// populate Webmasters
			Webmaster[] webmasters = { new Webmaster("Joanne Richmond", "joanrich", "9999"),
										new Webmaster("Paul Lynch", "p_lynch", "1111")};
		
			
			// populate Customers
			Customer[] customers = { new Customer("Mary Joan Stewart", "123 Glenbroke Street, Abbotsford, BC, Canada", "3455552525252520", "maryj", "1212"),
					new Customer("Peter Johanson", "998A Hope Avenue, Langley, BC, Canada", "9999000012127777", "pjohanson", "9999") };
		
			
			// populate Sellers
			Seller[] sellers = { new Seller("Dageraad Brewing", "dageraad", "9090"),
									new Seller("Green Leaf Brew", "green_leaf", "4444"),
									new Seller("Steamworks Brewing Company", "steamy", "6732"),
									new Seller("Steel & Oak Brewing Company", "s&o", "1010") };
			
			// populate Categories
			Category[] categories = { new Category("Lager"),
										new Category("Stout"),
										new Category("Pale Ale"),
										new Category("Pilsen"),
										new Category("IPA") };
		
			// populate Products
			Product[] products = new Product[14];
			// Assign a Category to a Product - One to Many Relationship
			//0	Lager
			//1	Stout
			//2	Pale Ale
			//3	Pilsen
			//4	IPA
			
			for(int i = 0; i <= products.length; i++) {
				// Seller = Dageraad
				products[0] = new Product("Brune 650ml bottle", 7.29, 40);
				products[1] = new Product("Imperial Session Kveik IPA (4-pack cans)", 15.35, 30);
				products[2] = new Product("Multigrain Dry-Hopped Pale Ale (4-pack cans)", 16.50, 10);
				products[3] = new Product("Dry-Hopped Belgian-Style Pale Ale (4-pack cans)", 16.50, 15);
				products[4] = new Product("Imperial Stout with Caao & Miso 650ml bottle", 10.74, 15);
				products[5] = new Product("Amber 650ml bottle", 6.54, 50);
				products[6] = new Product("Blonde 650ml bottle", 7.29, 20);
				products[7] = new Product("Burnabarian 650ml bottle", 6.08, 70);
				products[8] = new Product("Sterke Soelaas 650ml bottle", 9.88, 10);
				// Seller: Steel & Oak
				products[9] = new Product("Shiny Things IPA (4-pack cans)", 14.49, 20);
				products[10] = new Product("Dark Lager (4-pack cans)", 14.49, 25);
				products[11] = new Product("Red Pilsner (4-pack cans)", 14.49, 30);
				products[12] = new Product("Royal City Ale (4-pack cans)", 14.49, 50);
				products[13] = new Product("Mimeo Ale 650ml bottle", 9.30, 20);
					
			}
			
			categories[3].addProduct(products[0]); // seller: dageraad
			categories[4].addProduct(products[1]); // seller: dageraad
			categories[2].addProduct(products[2]); // seller: dageraad
			categories[2].addProduct(products[3]); // seller: dageraad
			categories[1].addProduct(products[4]); // seller: dageraad
			categories[3].addProduct(products[5]); // seller: dageraad
			categories[3].addProduct(products[6]); // seller: dageraad
			categories[3].addProduct(products[7]); // seller: dageraad
			categories[1].addProduct(products[8]); // seller: dageraad		
			categories[4].addProduct(products[9]); // seller: steel & oak		
			categories[0].addProduct(products[10]); // seller: steel & oak		
			categories[3].addProduct(products[11]); // seller: steel & oak	
			categories[2].addProduct(products[12]); // seller: steel & oak
			categories[2].addProduct(products[13]); // seller: steel & oak
			
			for (int i = 0; i < categories.length; i++) {
				categoryRepository.save(categories[i]);
			}	
			
			
			// --->>>> Saving the populations to the db
			// Webmaster
			for (int i = 0; i < webmasters.length; i++) {
				webmasterRepository.save(webmasters[i]);
			}
			
			webmasterRepository.findAll().forEach(System.out::println);
			
			// Customers
			for (int i = 0; i < customers.length; i++) {
				customerRepository.save(customers[i]);
			}

			customerRepository.findAll().forEach(System.out::println);
			
			// Sellers
			for (int i = 0; i < sellers.length; i++) {
				sellerRepository.save(sellers[i]);
			}

			sellerRepository.findAll().forEach(System.out::println);

			// Products
//			for (int i = 0; i < products.length; i++) {
//				productRepository.save(products[i]);
//			}
						
			productRepository.findAll().forEach(System.out::println);
			
			// Categories
			//for (int i = 0; i < categories.length; i++) {
			//	categoryRepository.save(categories[i]);
			//}						
			
			categoryRepository.findAll().forEach(System.out::println);

			
			
			
			
			// DISCARDED
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
