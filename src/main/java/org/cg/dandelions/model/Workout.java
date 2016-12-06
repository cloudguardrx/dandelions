package org.cg.dandelions.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.bson.Document;
import org.springframework.util.CollectionUtils;

public class Workout {

	/*-
	 * 
	 * Relations:
	 * Workout have-many Movements
	 * Workout have-many Results
	 * 
	 */

	public String id;
	public Date date;
	public Set<Movement> movements;
	public Set<Result> results;
	public String details;

	public Workout() {
	}

	public Workout(Document document) {
		id = document.getObjectId("_id").toHexString();
		date = document.getDate("date");
		details = document.getString("details");
	}

	public Set<String> getMovementIds() {
		Set<String> ids = new HashSet<String>();
		if (!CollectionUtils.isEmpty(movements)) {
			for (Movement movement : movements) {
				ids.add(movement.id);
			}
		}
		return ids;
	}

	public Set<String> getResultIds() {
		Set<String> ids = new HashSet<String>();
		if (!CollectionUtils.isEmpty(results)) {
			for (Result result : results) {
				ids.add(result.id);
			}
		}
		return ids;
	}

}
