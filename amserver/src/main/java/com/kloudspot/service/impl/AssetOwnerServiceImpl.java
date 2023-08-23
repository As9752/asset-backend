package com.kloudspot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kloudspot.exception.AssetOwnerNotFoundException;
import com.kloudspot.mapper.AssetOwnerMapper;

import com.kloudspot.model.AssetOwner;
import com.kloudspot.model.record.AssetOwnerRecord;

import com.kloudspot.repository.AssetOwnerRepository;

import com.kloudspot.service.IAssetOwnerService;

@Service
public class AssetOwnerServiceImpl implements IAssetOwnerService {

	@Autowired
	private AssetOwnerRepository assetOwnerRepository;

	@Autowired
	private AssetOwnerMapper assetOwnerMapper;

	@Override
	public List<AssetOwnerRecord> getAllAssetOwners() {
		List<AssetOwner> assetOwners = assetOwnerRepository.findAll();
		List<AssetOwnerRecord> assetOwnerRecords = convertAssetOwnerList(assetOwners);
		return assetOwnerRecords;
	}

	@Override
	public AssetOwnerRecord getAssetOwnerById(String assetOwnerId) throws AssetOwnerNotFoundException {
		AssetOwner asset = assetOwnerRepository.findById(assetOwnerId)
				.orElseThrow(() -> new AssetOwnerNotFoundException("Asset owner with given id not found"));
		return assetOwnerMapper.convertToAssetOwnerRecord(asset);
	}

	@Override
	public AssetOwnerRecord addAssetOwner(AssetOwnerRecord assetOwnerRecord) {
		AssetOwner addedAssetOwner = assetOwnerRepository.save(assetOwnerMapper.convertToAssetOwner(assetOwnerRecord));
		return assetOwnerMapper.convertToAssetOwnerRecord(addedAssetOwner);
	}

	@Override
	public AssetOwnerRecord updateAssetOwner(String assetOwnerId, AssetOwnerRecord assetOwnerRecord)
			throws AssetOwnerNotFoundException {
		AssetOwner assetOwner = assetOwnerRepository.findById(assetOwnerId)
				.orElseThrow(() -> new AssetOwnerNotFoundException("Asset owner with given id not found"));

		assetOwner.setName(assetOwnerRecord.name());

		AssetOwner updatedAssetOwner = assetOwnerRepository.save(assetOwner);
		return assetOwnerMapper.convertToAssetOwnerRecord(updatedAssetOwner);
	}

	@Override
	public void deleteAssetOwner(String assetOwnerId) {
		assetOwnerRepository.deleteById(assetOwnerId);

	}

	private List<AssetOwnerRecord> convertAssetOwnerList(List<AssetOwner> assetOwners) {
		return assetOwners.stream().map((assetOwner) -> assetOwnerMapper.convertToAssetOwnerRecord(assetOwner))
				.toList();
	}

}
