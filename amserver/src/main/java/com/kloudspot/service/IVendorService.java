package com.kloudspot.service;

import java.util.List;

import com.kloudspot.exception.VendorNotFoundException;
import com.kloudspot.model.record.VendorRecord;

public interface IVendorService {

	VendorRecord addVendor(VendorRecord vendorRecord);

	VendorRecord updateVendor(String id, VendorRecord vendorRecord) throws VendorNotFoundException;

	void deleteVendor(String id);

	List<VendorRecord> getAllVendors();

	VendorRecord getVendorById(String id) throws VendorNotFoundException;

}
