package com.kloudspot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kloudspot.exception.AssetLocationNotFoundException;
import com.kloudspot.exception.AssetNotFoundException;
import com.kloudspot.exception.AssetOwnerNotFoundException;
import com.kloudspot.exception.CategoryNotFoundException;
import com.kloudspot.exception.UserNotFoundException;
import com.kloudspot.exception.VendorNotFoundException;
import com.kloudspot.model.record.AssetRecord;
import com.kloudspot.service.IAssetService;

/* APIs as of now
 * GET /api/v1/assets: Fetch all assets.
 * GET /api/v1/assets/{id}: Fetch a specific asset by its ID.
 * POST /api/v1/assets: Create a new asset.
 * DELETE /api/v1/assets/{id}: Delete an asset by its ID.
 * PUT /api/v1/assets/{id}: Update an existing asset by its ID.
 */

@RestController
@CrossOrigin(originPatterns="*")
@RequestMapping("/api/v1/assets") // Base endpoint for all asset-related operations
public class AssetController {

	@Autowired
	private IAssetService assetService;

	// Endpoint to fetch all assets
	@GetMapping
	public ResponseEntity<List<AssetRecord>> getAllAssets() {
		return new ResponseEntity<>(assetService.getAllAssets(), HttpStatus.OK);
	}

	// Endpoint to fetch a specific asset by its ID
	@GetMapping("/{id}")
	public ResponseEntity<AssetRecord> getAssetById(@PathVariable String id) throws AssetNotFoundException {
		AssetRecord assetRecord = assetService.getAssetById(id);
		return new ResponseEntity<>(assetRecord, HttpStatus.OK);
	}

	// Endpoint to create a new asset
	@PostMapping
	public ResponseEntity<AssetRecord> createAsset(@RequestBody AssetRecord asset) throws UserNotFoundException, VendorNotFoundException, AssetOwnerNotFoundException, CategoryNotFoundException, AssetLocationNotFoundException {
		return new ResponseEntity<>(assetService.addAsset(asset), HttpStatus.OK);
	}

	// Endpoint to update an existing asset by its ID
	@PutMapping("/{id}")
	public ResponseEntity<AssetRecord> updateAsset(@PathVariable String id, @RequestBody AssetRecord asset)
			throws AssetNotFoundException {
		return new ResponseEntity<AssetRecord>(assetService.updateAsset(id, asset), HttpStatus.OK);
	}

	// Endpoint to delete an asset by its ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAsset(@PathVariable String id) {
		assetService.deleteAsset(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
