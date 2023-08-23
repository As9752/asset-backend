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

import com.kloudspot.exception.AssetOwnerNotFoundException;
import com.kloudspot.model.record.AssetOwnerRecord;
import com.kloudspot.service.IAssetOwnerService;

@RestController
@RequestMapping("/api/v1/asset-owners")
public class AssetOwnerController {
	@Autowired
	private IAssetOwnerService assetOwnerService;

	// Endpoint to fetch all asset owners
	@GetMapping
	public ResponseEntity<List<AssetOwnerRecord>> getAllAssetOwners() {
		return new ResponseEntity<>(assetOwnerService.getAllAssetOwners(), HttpStatus.OK);
	}

	// Endpoint to fetch a specific asset by its ID
	@GetMapping("/{assetOwnerId}")
	public ResponseEntity<AssetOwnerRecord> getAssetOwnerById(@PathVariable String assetOwnerId)
			throws AssetOwnerNotFoundException {
		AssetOwnerRecord assetOwnerRecord = assetOwnerService.getAssetOwnerById(assetOwnerId);
		return new ResponseEntity<>(assetOwnerRecord, HttpStatus.OK);
	}

	// Endpoint to create a new asset
	@PostMapping
	public ResponseEntity<AssetOwnerRecord> createAssetOwner(@RequestBody AssetOwnerRecord assetOwnerRecord) {
		return new ResponseEntity<>(assetOwnerService.addAssetOwner(assetOwnerRecord), HttpStatus.CREATED);
	}

	// Endpoint to update an existing asset by its ID
	@PutMapping("/{assetOwnerId}")
	public ResponseEntity<AssetOwnerRecord> updateAssetOwner(@PathVariable String assetOwnerId,
			@RequestBody AssetOwnerRecord assetOwnerRecord) throws AssetOwnerNotFoundException {
		return new ResponseEntity<AssetOwnerRecord>(assetOwnerService.updateAssetOwner(assetOwnerId, assetOwnerRecord),
				HttpStatus.OK);
	}

	// Endpoint to delete an asset by its ID
	@DeleteMapping("/{assetOwnerId}")
	public ResponseEntity<Void> deleteAssetOwner(@PathVariable String assetOwnerId) {
		assetOwnerService.deleteAssetOwner(assetOwnerId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
