package com.kabir.kabirbackend.repository;

import com.kabir.kabirbackend.entities.Ville;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends MongoRepository<Ville, String> {
}
