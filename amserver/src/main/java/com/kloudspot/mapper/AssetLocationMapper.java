package com.kloudspot.mapper;

import org.springframework.stereotype.Component;

import com.kloudspot.model.AssetLocation;
import com.kloudspot.model.record.AssetLocationRecord;

@Component
public class AssetLocationMapper {

	public AssetLocation convertToAssetLocation(AssetLocationRecord assetLocationRecord) {

		AssetLocation assetLocation = new AssetLocation();
		assetLocation.setAddress(assetLocationRecord.address());
		assetLocation.setName(assetLocationRecord.name());
		return assetLocation;

	}

	public AssetLocationRecord convertToAssetLocationRecord(AssetLocation assetLocation) {

		AssetLocationRecord assetLocationRecord = new AssetLocationRecord(assetLocation.getLocationId(),
				assetLocation.getAddress(), assetLocation.getName());
		return assetLocationRecord;
	}

}
