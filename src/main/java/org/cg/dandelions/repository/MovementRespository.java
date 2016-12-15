package org.cg.dandelions.repository;

import java.util.List;

import org.cg.dandelions.model.Movement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovementRespository extends MongoRepository<Movement, String> { 
    public Movement findById(String id);
    public Movement findByName(String name);
    public Movement findByDescription(String description);
    public List<Movement> findAll();   
}
