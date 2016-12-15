package org.cg.dandelions.repository;

import java.util.Date;
import java.util.List;

import org.cg.dandelions.model.Workout;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkoutRepository extends MongoRepository<Workout, String> {
	
	public Workout findById(String id);
	public List<Workout> findByDate(Date date);
	public List<Workout> findAll();
}
