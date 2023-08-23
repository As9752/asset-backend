package com.kloudspot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kloudspot.exception.AssetLocationNotFoundException;
import com.kloudspot.mapper.AssetLocationMapper;
import com.kloudspot.model.AssetLocation;
import com.kloudspot.model.record.AssetLocationRecord;
import com.kloudspot.repository.AssetLocationRepository;
import com.kloudspot.service.IAssetLocation;

@Service
public class AssetLocationImpl implements IAssetLocation {

	@Autowired
	private AssetLocationRepository assetLocationRepository;

	@Autowired
	private AssetLocationMapper assetLocationMapper;

	@Override
	public AssetLocationRecord addAssetLocation(AssetLocationRecord assetLocationRecord) {
		// TODO Auto-generated method stub
		AssetLocation assetLocation = assetLocationRepository
				.save(assetLocationMapper.convertToAssetLocation(assetLocationRecord));

		return assetLocationMapper.convertToAssetLocationRecord(assetLocation);
	}

	@Override
	public AssetLocationRecord updateAssetLocation(String assetLocationId, AssetLocationRecord assetLocationRecord)
			throws AssetLocationNotFoundException {

		AssetLocation existingAssetLocation = assetLocationRepository.findById(assetLocationId).orElseThrow(
				() -> new AssetLocationNotFoundException("Asset location not found with ID: " + assetLocationId));

		// Update the existing asset location with new values from assetLocationRecord
		existingAssetLocation.setLocationId(assetLocationRecord.assetLocationId());
		existingAssetLocation.setAddress(assetLocationRecord.address());
		existingAssetLocation.setName(assetLocationRecord.name());

		// Save the updated asset location
		AssetLocation updatedAssetLocation = assetLocationRepository.save(existingAssetLocation);

		// Convert and return the updated asset location record
		return assetLocationMapper.convertToAssetLocationRecord(updatedAssetLocation);

	}

	@Override
	public void deleteAssetLocation(String assetLocationid) {
		// TODO Auto-generated method stub
		assetLocationRepository.deleteById(assetLocationid);
	}

	@Override
	public List<AssetLocationRecord> getAllAssetsLocations() {
		// TODO Auto-generated method stub

		List<AssetLocation> assetLocation = assetLocationRepository.findAll();
		List<AssetLocationRecord> assetLocationRecord = convertToList(assetLocation);
		return assetLocationRecord;
	}

	private List<AssetLocationRecord> convertToList(List<AssetLocation> assetLocations) {
		// TODO Auto-generated method stub
		return assetLocations.stream()
				.map((assetLocation) -> assetLocationMapper.convertToAssetLocationRecord(assetLocation)).toList();
	}

	@Override
	public AssetLocationRecord getAssetLocationById(String assetLocationId) throws AssetLocationNotFoundException {
		// TODO Auto-generated method stub

		AssetLocation assetLocation = assetLocationRepository.findById(assetLocationId)
				.orElseThrow(() -> new AssetLocationNotFoundException("AssetLocation Not Foundable "));
		return assetLocationMapper.convertToAssetLocationRecord(assetLocation);
	}

}
