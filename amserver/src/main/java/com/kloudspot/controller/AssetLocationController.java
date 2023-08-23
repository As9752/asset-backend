package com.kloudspot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kloudspot.exception.AssetLocationNotFoundException;
import com.kloudspot.model.record.AssetLocationRecord;
import com.kloudspot.service.IAssetLocation;

@RestController
@RequestMapping("/api/assetLocation")
public class AssetLocationController {

	@Autowired
	private IAssetLocation iassetLocationService;

	@GetMapping
	public ResponseEntity<List<AssetLocationRecord>> getallAssetLocations() {
		return ResponseEntity.ok(iassetLocationService.getAllAssetsLocations());
	}

	@GetMapping("/{id}")
	public ResponseEntity<AssetLocationRecord> getAssetLocationById(@PathVariable String id)
			throws AssetLocationNotFoundException {
		AssetLocationRecord assetLocationRecord = iassetLocationService.getAssetLocationById(id);
		return new ResponseEntity<>(assetLocationRecord, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<AssetLocationRecord> createAssetLocation(
			@RequestBody AssetLocationRecord assetLocationRecord) {
		return new ResponseEntity<>(iassetLocationService.addAssetLocation(assetLocationRecord), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AssetLocationRecord> updateAssetLocation(@PathVariable String id,
			@RequestBody AssetLocationRecord assetLocationRecord) throws AssetLocationNotFoundException {
		return new ResponseEntity<>(iassetLocationService.updateAssetLocation(id, assetLocationRecord), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAssetLocation(@PathVariable String id) throws AssetLocationNotFoundException {
		iassetLocationService.deleteAssetLocation(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
