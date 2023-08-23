package com.kloudspot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kloudspot.model.AssetOwner;

@Repository
public interface AssetOwnerRepository extends MongoRepository<AssetOwner, String> {

}
