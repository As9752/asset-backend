package com.kloudspot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kloudspot.model.Vendor;

@Repository
public interface VendorRepository extends MongoRepository<Vendor, String> {

}
