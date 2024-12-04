package com.massafra.club.dispatch.repositories;

import com.massafra.club.dispatch.entities.FidemaxRedemption;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FidemaxRedemptionRepository extends MongoRepository<FidemaxRedemption, String> {

}
