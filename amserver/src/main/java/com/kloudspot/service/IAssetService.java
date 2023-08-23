package com.kloudspot.service;

import java.util.List;

import com.kloudspot.exception.AssetLocationNotFoundException;
import com.kloudspot.exception.AssetNotFoundException;
import com.kloudspot.exception.AssetOwnerNotFoundException;
import com.kloudspot.exception.CategoryNotFoundException;
import com.kloudspot.exception.UserNotFoundException;
import com.kloudspot.exception.VendorNotFoundException;
import com.kloudspot.model.record.AssetRecord;

public interface IAssetService {
	public List<AssetRecord> getAllAssets();

	public AssetRecord getAssetById(String id) throws AssetNotFoundException;

	public AssetRecord addAsset(AssetRecord asset) throws UserNotFoundException, VendorNotFoundException, AssetOwnerNotFoundException, CategoryNotFoundException, AssetLocationNotFoundException;

	public void deleteAsset(String id);

	public AssetRecord updateAsset(String id, AssetRecord assetRecord) throws AssetNotFoundException;
}
