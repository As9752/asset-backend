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

import com.kloudspot.exception.VendorNotFoundException;
import com.kloudspot.model.record.VendorRecord;
import com.kloudspot.service.IVendorService;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

	@Autowired
	private IVendorService ivendorService;

	@GetMapping
	public ResponseEntity<List<VendorRecord>> getallVendors() {
		return ResponseEntity.ok(ivendorService.getAllVendors());
	}

	@GetMapping("/{id}")
	public ResponseEntity<VendorRecord> getVendorById(@PathVariable String id) throws VendorNotFoundException {
		VendorRecord vendorRecord = ivendorService.getVendorById(id);
		return new ResponseEntity<>(vendorRecord, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<VendorRecord> createVendor(@RequestBody VendorRecord vendorRecord) {
		return new ResponseEntity<>(ivendorService.addVendor(vendorRecord), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<VendorRecord> updateVendor(@PathVariable String id, @RequestBody VendorRecord vendorRecord)
			throws VendorNotFoundException {
		return new ResponseEntity<>(ivendorService.updateVendor(id, vendorRecord), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVendor(@PathVariable String id) throws VendorNotFoundException {
		ivendorService.deleteVendor(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
