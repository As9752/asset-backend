package com.kloudspot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kloudspot.model.Asset;

@Repository
public interface AssetRepository extends MongoRepository<Asset, String> {

}
