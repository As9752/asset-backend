package com.kloudspot.mapper;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.kloudspot.model.Asset;
import com.kloudspot.model.record.AssetRecord;
import com.kloudspot.util.MonthsToDateMapper;

@Component
public class AssetMapper {

	public Asset convertToAsset(AssetRecord assetRecord) {
		Asset asset = new Asset();
		asset.setAssetId(assetRecord.assetId());
		asset.setName(assetRecord.name());
		asset.setCompany(assetRecord.company());
		asset.setDescription(assetRecord.description());
		asset.setStatus(assetRecord.status());
		asset.setUser(assetRecord.user());
		asset.setVendor(assetRecord.vendor());
		asset.setAssetOwner(assetRecord.assetOwner());
		asset.setBillUpload(assetRecord.billUpload());
		asset.setLifespan(assetRecord.lifespan());
		asset.setDateOfPurchase(assetRecord.dateOfPurchase());
		asset.setWarrantyMonths(assetRecord.warrantyMonths());
		Date warranty = MonthsToDateMapper.monthsToDate(assetRecord.dateOfPurchase(), assetRecord.warrantyMonths());
		asset.setWarrantyTill(warranty);
		asset.setCategory(assetRecord.category());
		asset.setMeta(assetRecord.meta());
		asset.setBaseLocation(assetRecord.baseLocation());
		asset.setCurrentLocation(assetRecord.currentLocation());
		return asset;
	}

	public AssetRecord convertToAssetRecord(Asset asset) {

		AssetRecord assetRecord = new AssetRecord(asset.getAssetId(), asset.getName(), asset.getCompany(),
				asset.getDescription(), asset.getStatus(), asset.getUser(), asset.getVendor(), asset.getAssetOwner(),
				asset.getBillUpload(), asset.getLifespan(), asset.getDateOfPurchase(), asset.getWarrantyMonths(),
				asset.getCategory(), asset.getMeta(), asset.getBaseLocation(),asset.getCurrentLocation());


		return assetRecord;
	}

}
