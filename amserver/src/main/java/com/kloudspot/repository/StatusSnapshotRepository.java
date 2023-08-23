package com.kloudspot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kloudspot.model.StatusSnapshot;

@Repository
public interface StatusSnapshotRepository extends MongoRepository<StatusSnapshot, String> {

}
