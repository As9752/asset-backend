package com.kloudspot.model.record;

import java.util.Date;
import java.util.Map;

import com.kloudspot.model.AssetLocation;
import com.kloudspot.model.AssetOwner;
import com.kloudspot.model.AssetStatus;
import com.kloudspot.model.Category;
import com.kloudspot.model.User;
import com.kloudspot.model.Vendor;


public record AssetRecord(String assetId, String name, String company, String description, AssetStatus status,
		User user, Vendor vendor, AssetOwner assetOwner, String billUpload, double lifespan, Date dateOfPurchase,
		double warrantyMonths, Category category, Map<String, Object> meta, AssetLocation baseLocation,AssetLocation currentLocation) {


	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}
}
