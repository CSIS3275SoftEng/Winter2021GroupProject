package com.example.demoTapMyBeer.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByStreet (String street);
	
	List<Address> findByCity (String city);
	
	List<Address> findByProvince (String province);
	
	List<Address> findByPostalCode (String postalCode);
}
