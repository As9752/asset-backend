package com.kloudspot.service;

import java.util.List;

import com.kloudspot.exception.AssetOwnerNotFoundException;
import com.kloudspot.model.record.AssetOwnerRecord;

public interface IAssetOwnerService {

	public List<AssetOwnerRecord> getAllAssetOwners();

	public AssetOwnerRecord getAssetOwnerById(String assetOwnerId) throws AssetOwnerNotFoundException;

	public AssetOwnerRecord addAssetOwner(AssetOwnerRecord assetOwnerRecord);

	public AssetOwnerRecord updateAssetOwner(String assetOwnerId, AssetOwnerRecord assetOwnerRecord)
			throws AssetOwnerNotFoundException;

	public void deleteAssetOwner(String assetOwnerId);
}
