package org.cg.dandelions.model;

import java.time.Instant;

public class Result {

	/*-
	 * For recording the results of a Workout
	 * 
	 * Relations:
	 * 
	 * Results have-one User
	 * Results have-one Workout (NOT REQUIRED)
	 * 
	 */

	User user;
	Workout workout;
	Instant date;

	Integer hours;
	Integer minutes;
	Integer seconds;

	Integer weight;
	Integer reps;

}
