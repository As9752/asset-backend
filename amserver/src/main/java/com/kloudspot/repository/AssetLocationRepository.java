package com.kloudspot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kloudspot.model.AssetLocation;

@Repository
public interface AssetLocationRepository extends MongoRepository<AssetLocation, String> {

}
