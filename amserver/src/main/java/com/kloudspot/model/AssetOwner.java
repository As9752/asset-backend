package com.kloudspot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AssetOwner {
	@Id
	private String ownerId;
	private String name;

	public AssetOwner() {
		super();
	}

	public AssetOwner(String ownerId, String name) {
		super();
		this.ownerId = ownerId;
		this.name = name;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AssetOwner [ownerId=" + ownerId + ", name=" + name + "]";
	}

}
