package com.kloudspot.service;

import java.util.List;

import com.kloudspot.exception.AssetLocationNotFoundException;
import com.kloudspot.model.record.AssetLocationRecord;

public interface IAssetLocation {

	AssetLocationRecord addAssetLocation(AssetLocationRecord assetLocationRecord);

	AssetLocationRecord updateAssetLocation(String assetLocationid, AssetLocationRecord assetLocationRecord)
			throws AssetLocationNotFoundException;

	void deleteAssetLocation(String assetLocationid);

	List<AssetLocationRecord> getAllAssetsLocations();

	AssetLocationRecord getAssetLocationById(String assetLocationid) throws AssetLocationNotFoundException;

}
