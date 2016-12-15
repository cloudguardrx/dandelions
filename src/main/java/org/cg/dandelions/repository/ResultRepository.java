package org.cg.dandelions.repository;

import java.util.Date;
import java.util.List;

import org.cg.dandelions.model.Result;
import org.cg.dandelions.model.User;
import org.cg.dandelions.model.Workout;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResultRepository extends MongoRepository<Result, String>  {
	
	public Result findById(String id);
	public List<Result> findByUser(User user);
	public List<Result> findByWorkout(Workout workout);
	public List<Result> findByDate(Date date);
	
}
