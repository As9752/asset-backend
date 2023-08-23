package com.kloudspot.model;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "asset")
public class Asset {

	@Id
	private String assetId;
	private String name; // DELL latitude 3499
	private String company; // DELL
	private String description; // DELL latitude GTX 1650 16gb ram 1tb rom ....
	private AssetStatus status; // Consider using an Enum

	@DBRef
	private User user;

	@DBRef
	private Vendor vendor;

	@DBRef
	private AssetOwner assetOwner;

	private String billUpload; // let's see this after some time

	private double lifespan;

	private Date dateOfPurchase;

	private double warrantyMonths; // dto

	private Date warrantyTill; // main asset

	private boolean isArchived; // asset

	@DBRef
	private Category category;

	private Map<String, Object> meta; // Consider using a Map or a custom class

	@DBRef
	private AssetLocation baseLocation; // dto
	@DBRef
	private AssetLocation currentLocation;
	// ---------------------------------------------------------------------

	public Asset() {
		super();
	}

	public Asset(String assetId, String name, String company, String description, AssetStatus status, User user,
			Vendor vendor, AssetOwner assetOwner, String billUpload, double lifespan, Date dateOfPurchase,
			double warrantyMonths, Date warrantyTill, boolean isArchived, Category category, Map<String, Object> meta,
			AssetLocation baseLocation, AssetLocation currentLocation) {
		super();
		this.assetId = assetId;
		this.name = name;
		this.company = company;
		this.description = description;
		this.status = status;
		this.user = user;
		this.vendor = vendor;
		this.assetOwner = assetOwner;
		this.billUpload = billUpload;
		this.lifespan = lifespan;
		this.dateOfPurchase = dateOfPurchase;
		this.warrantyMonths = warrantyMonths;
		this.warrantyTill = warrantyTill;
		this.isArchived = isArchived;
		this.category = category;
		this.meta = meta;
		this.baseLocation = baseLocation;
		this.currentLocation = currentLocation;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AssetStatus getStatus() {
		return status;
	}

	public void setStatus(AssetStatus status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public AssetOwner getAssetOwner() {
		return assetOwner;
	}

	public void setAssetOwner(AssetOwner assetOwner) {
		this.assetOwner = assetOwner;
	}

	public String getBillUpload() {
		return billUpload;
	}

	public void setBillUpload(String billUpload) {
		this.billUpload = billUpload;
	}

	public double getLifespan() {
		return lifespan;
	}

	public void setLifespan(double lifespan) {
		this.lifespan = lifespan;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public double getWarrantyMonths() {
		return warrantyMonths;
	}

	public void setWarrantyMonths(double warrantyYears) {
		this.warrantyMonths = warrantyYears;
	}

	public Date getWarrantyTill() {
		return warrantyTill;
	}

	public void setWarrantyTill(Date warrantyTill) {
		this.warrantyTill = warrantyTill;
	}

	public boolean isArchived() {
		return isArchived;
	}

	public void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Map<String, Object> getMeta() {
		return meta;
	}

	public void setMeta(Map<String, Object> meta) {
		this.meta = meta;
	}

	public AssetLocation getBaseLocation() {
		return baseLocation;
	}

	public void setBaseLocation(AssetLocation baseLocation) {
		this.baseLocation = baseLocation;
	}

	public AssetLocation getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(AssetLocation currentLocation) {
		this.currentLocation = currentLocation;
	}

	@Override
	public String toString() {
		return "Asset [assetId=" + assetId + ", name=" + name + ", company=" + company + ", description=" + description
				+ ", status=" + status + ", user=" + user + ", vendor=" + vendor + ", assetOwner=" + assetOwner
				+ ", billUpload=" + billUpload + ", lifespan=" + lifespan + ", dateOfPurchase=" + dateOfPurchase
				+ ", warrantyYears=" + warrantyMonths + ", warrantyTill=" + warrantyTill + ", isArchived=" + isArchived
				+ ", category=" + category + ", meta=" + meta + ", baseLocation=" + baseLocation + ", currentLocation="
				+ currentLocation + "]";
	}

}
