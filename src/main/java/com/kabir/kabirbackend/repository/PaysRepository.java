package com.kabir.kabirbackend.repository;

import com.kabir.kabirbackend.entities.Pays;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaysRepository extends MongoRepository<Pays, String> {
}
