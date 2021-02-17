package com.example.demoTapMyBeer.model;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name = "addresses")
	public class Address {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long addId;
		
		@Column(name = "AddressNo")
		private int addNo;
		
		@Column(name = "Street")
		private String street;
		
		@Column(name = "City")
		private String city;
		
		@Column(name = "Province")
		private String province;
		
		@Column(name = "PostalCode")
		private String postalCode;
		
		public Address() {}
		
		public Address(int addNo, String street, String city, String province, String postalCode ) {
			this.addNo =addNo;
			this.street= street;
			this.city = city;
			this.province = province;
			this.postalCode= postalCode;
			
		}
}
