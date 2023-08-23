package com.kloudspot.mapper;

import org.springframework.stereotype.Component;

import com.kloudspot.model.AssetOwner;
import com.kloudspot.model.record.AssetOwnerRecord;

@Component
public class AssetOwnerMapper {

	public AssetOwner convertToAssetOwner(AssetOwnerRecord assetOwnerRecord) {
		AssetOwner assetOwner = new AssetOwner();
		assetOwner.setOwnerId(assetOwnerRecord.ownerId());
		assetOwner.setName(assetOwnerRecord.name());
		return assetOwner;
	}

	public AssetOwnerRecord convertToAssetOwnerRecord(AssetOwner assetOwner) {
		AssetOwnerRecord assetOwnerRecord = new AssetOwnerRecord(assetOwner.getOwnerId(), assetOwner.getName());
		return assetOwnerRecord;
	}

}
