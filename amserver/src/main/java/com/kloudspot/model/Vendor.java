package com.kloudspot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vendor")
public class Vendor {

	@Id
	private String vendorId;
	private Address address;

	public Vendor() {
		super();
	}

	public Vendor(String vendorId, Address address) {
		super();
		this.vendorId = vendorId;
		this.address = address;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", address=" + address + "]";
	}

}
