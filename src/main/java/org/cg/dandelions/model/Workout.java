package org.cg.dandelions.model;

import java.util.Set;
import java.util.UUID;

public class Workout {

	/*-
	 * 
	 * Relations:
	 * Workout have-many Movements
	 * Workout have-many Results
	 * 
	 */

	public UUID id;
	public Set<Movement> movements;
	public Set<Result> results;
	public String details;

}
