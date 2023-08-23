package com.kloudspot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kloudspot.exception.VendorNotFoundException;
import com.kloudspot.mapper.VendorMapper;
import com.kloudspot.model.Vendor;
import com.kloudspot.model.record.VendorRecord;
import com.kloudspot.repository.VendorRepository;
import com.kloudspot.service.IVendorService;

@Service
public class VendorServiceImpl implements IVendorService {

	@Autowired
	private VendorRepository vendorRepository;

	@Autowired
	private VendorMapper vendorMapper;

	@Override
	public VendorRecord addVendor(VendorRecord vendorRecord) {
		Vendor vendor = vendorRepository.save(vendorMapper.convertToVendor(vendorRecord));
		return vendorMapper.convertToVendorRecord(vendor);

	}

	@Override
	public VendorRecord updateVendor(String id, VendorRecord vendorRecord) throws VendorNotFoundException {

		Vendor vendorToUpdate = vendorMapper.convertToVendor(vendorRecord);

		Optional<Vendor> existingVendorOptional = vendorRepository.findById(id);

		if (existingVendorOptional.isPresent()) {
			Vendor existingVendor = existingVendorOptional.get();

			existingVendor.setAddress(vendorToUpdate.getAddress());

			Vendor updatedVendor = vendorRepository.save(existingVendor);

			VendorRecord updatedVendorRecord = vendorMapper.convertToVendorRecord(updatedVendor);

			return updatedVendorRecord;
		} else {
			throw new VendorNotFoundException("Vendor Not found with this id");
		}
	}

	@Override
	public void deleteVendor(String id) {
		vendorRepository.deleteById(id);
	}

	@Override
	public List<VendorRecord> getAllVendors() {
		List<Vendor> vendors = vendorRepository.findAll();
		List<VendorRecord> vendorRecord = convertToList(vendors);
		return vendorRecord;
	}

	private List<VendorRecord> convertToList(List<Vendor> vendors) {
		return vendors.stream().map((vendor) -> vendorMapper.convertToVendorRecord(vendor)).toList();
	}

	@Override
	public VendorRecord getVendorById(String id) throws VendorNotFoundException {

		Vendor vendor = vendorRepository.findById(id)
				.orElseThrow(() -> new VendorNotFoundException("Vendor Not Found "));
		return vendorMapper.convertToVendorRecord(vendor);

	}

}
