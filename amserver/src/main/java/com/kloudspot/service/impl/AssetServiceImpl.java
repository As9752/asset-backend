package com.kloudspot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kloudspot.exception.AssetLocationNotFoundException;
import com.kloudspot.exception.AssetNotFoundException;
import com.kloudspot.exception.AssetOwnerNotFoundException;
import com.kloudspot.exception.CategoryNotFoundException;
import com.kloudspot.exception.UserNotFoundException;
import com.kloudspot.exception.VendorNotFoundException;
import com.kloudspot.mapper.AssetMapper;
import com.kloudspot.model.Asset;
import com.kloudspot.model.record.AssetRecord;
import com.kloudspot.repository.AssetLocationRepository;
import com.kloudspot.repository.AssetOwnerRepository;
import com.kloudspot.repository.AssetRepository;
import com.kloudspot.repository.CategoryRepository;
import com.kloudspot.repository.UserRepository;
import com.kloudspot.repository.VendorRepository;
import com.kloudspot.service.IAssetService;

@Service
public class AssetServiceImpl implements IAssetService {

	@Autowired
	private AssetRepository assetRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VendorRepository vendorRepository;

	@Autowired
	private AssetOwnerRepository assetOwnerRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private AssetLocationRepository assetLocationRepository;

	@Autowired
	private AssetMapper assetMapper;

	@Override
	public List<AssetRecord> getAllAssets() {
		List<Asset> assets = assetRepository.findAll();
		List<AssetRecord> assetRecords = convertList(assets);
		return assetRecords;
	}

	@Override
	public AssetRecord getAssetById(String id) throws AssetNotFoundException {
		Asset asset = assetRepository.findById(id)
				.orElseThrow(() -> new AssetNotFoundException("Asset with given id not found"));
		return assetMapper.convertToAssetRecord(asset);
	}

	@Override
	public AssetRecord addAsset(AssetRecord assetRecord) throws UserNotFoundException, VendorNotFoundException,
			AssetOwnerNotFoundException, CategoryNotFoundException, AssetLocationNotFoundException {
		if (!userRepository.existsById(assetRecord.user().getUserId()))
			throw new UserNotFoundException("User with given id not found");

		if (!vendorRepository.existsById(assetRecord.vendor().getVendorId()))
			throw new VendorNotFoundException("Vendor with given id not found");

		if (!assetOwnerRepository.existsById(assetRecord.assetOwner().getOwnerId()))
			throw new AssetOwnerNotFoundException("Asset owner with given id not found");

		if (categoryRepository.existsById(assetRecord.category().getCategoryId()))
			throw new CategoryNotFoundException("Category with given id not found");

		if (!assetLocationRepository.existsById(assetRecord.baseLocation().getLocationId())
				|| !assetLocationRepository.existsById(assetRecord.currentLocation().getLocationId()))
			throw new AssetLocationNotFoundException("Asset location with given id not found");

		Asset addedAsset = assetRepository.save(assetMapper.convertToAsset(assetRecord));

		return assetMapper.convertToAssetRecord(addedAsset);
	}

	@Override
	public void deleteAsset(String id) {
		assetRepository.deleteById(id);

	}

	@Override
	public AssetRecord updateAsset(String id, AssetRecord assetRecord) throws AssetNotFoundException {
		Asset asset = assetRepository.findById(id)
				.orElseThrow(() -> new AssetNotFoundException("Asset with given id not found"));
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
		asset.setCategory(assetRecord.category());
		asset.setMeta(assetRecord.meta());
		asset.setBaseLocation(assetRecord.baseLocation());

		Asset updatedAsset = assetRepository.save(asset);
		return assetMapper.convertToAssetRecord(updatedAsset);

	}

	private List<AssetRecord> convertList(List<Asset> assets) {
		return assets.stream().map((asset) -> assetMapper.convertToAssetRecord(asset)).toList();
	}

}
