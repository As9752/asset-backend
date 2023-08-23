package com.kloudspot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AssetLocation {

	@Id
	private String locationId;
	private Address address;
	private String name;

	public AssetLocation() {
		super();
	}

	public AssetLocation(String locationId, Address address, String name) {
		super();
		this.locationId = locationId;
		this.address = address;
		this.name = name;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AssetLocation [locationId=" + locationId + ", address=" + address + ", name=" + name + "]";
	}

}
