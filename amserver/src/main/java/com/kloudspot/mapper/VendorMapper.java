package com.kloudspot.mapper;

import org.springframework.stereotype.Component;

import com.kloudspot.model.Vendor;
import com.kloudspot.model.record.VendorRecord;

@Component
public class VendorMapper {
	public Vendor convertToVendor(VendorRecord vendorRecord) {

		Vendor vendor = new Vendor();
		vendor.setAddress(vendorRecord.address());
		return vendor;

	}

	public VendorRecord convertToVendorRecord(Vendor vendor) {

		VendorRecord vendorRecord = new VendorRecord(vendor.getVendorId(), vendor.getAddress());
		return vendorRecord;
	}

}
