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
		
		@Column(name = "customerId")
	    private long customerId;
		
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
		
		public Address(long customerId, int addNo ,String street, String city, String province, String postalCode ) {
			this.customerId = customerId;
			this.addNo =addNo;
			this.street= street;
			this.city = city;
			this.province = province;
			this.postalCode= postalCode;
			
		}

		public long getAddId() {
			return addId;
		}

		public void setAddId(long addId) {
			this.addId = addId;
		}

		public long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(long customerId) {
			this.customerId = customerId;
		}

		public int getAddNo() {
			return addNo;
		}

		public void setAddNo(int addNo) {
			this.addNo = addNo;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getProvince() {
			return province;
		}

		public void setProvince(String province) {
			this.province = province;
		}

		public String getPostalCode() {
			return postalCode;
		}

		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}
		
		
		
}
