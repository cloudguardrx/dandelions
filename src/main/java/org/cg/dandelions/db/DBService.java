package org.cg.dandelions.db;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.cg.dandelions.config.MongoConfig;
import org.cg.dandelions.model.Movement;
import org.cg.dandelions.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

@Component
public class DBService {

	@Autowired
	MongoConfig mongo;

	public MongoCollection<Document> workoutColl;
	public MongoCollection<Document> movementColl;

	public DBService() {
	}

	@PostConstruct
	public void init() {
		Assert.notNull(mongo.database, "datbase is null");

		workoutColl = mongo.database.getCollection("workout");
		workoutColl.drop();
		Assert.notNull(workoutColl, "workoutColl is null");

		movementColl = mongo.database.getCollection("movement");
		movementColl.drop();
		Assert.notNull(movementColl, "movementColl is null");
	}

	public Workout save(Workout workout) {
		Document document = new Document();

		if (workout.id == null) {
			workout.id = new ObjectId().toHexString();
		}

		document.append("_id", new ObjectId(workout.id)).append("date", workout.date)
				.append("movements", workout.getMovementIds()).append("results", workout.getResultIds())
				.append("details", workout.details);

		workoutColl.insertOne(document);

		return workout;
	}

	public Movement save(Movement movement) {
		Document document = new Document();

		if (movement.id == null) {
			movement.id = new ObjectId().toHexString();
		}

		document.append("_id", new ObjectId(movement.id)).append("name", movement.name).append("description",
				movement.description);

		movementColl.insertOne(document);

		return movement;
	}

	public Workout getWorkout(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date start = cal.getTime();

		cal.set(Calendar.HOUR, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		Date end = cal.getTime();

		Document search = new Document();
		search.append("date", new Document().append("$gte", start).append("$lt", end));

		Workout result = null;

		FindIterable<Document> documents = workoutColl.find(search);
		Iterator<Document> iter = documents.iterator();
		if (iter.hasNext()) {
			Document document = iter.next();

			result = new Workout(document);
			if (document.containsKey("movements")) {
				Set<Movement> movements = new HashSet<>();

				List<String> ids = (List<String>) document.get("movements");
				for (String id : ids) {
					movements.add(getMovement(id));
				}
				result.movements = movements;
			}
		}
		return result;
	}

	public Movement getMovement(String id) {
		Document search = new Document("_id", new ObjectId(id));

		FindIterable<Document> documents = movementColl.find(search);
		Document document = documents.iterator().next();

		return new Movement(document);

	}

}
