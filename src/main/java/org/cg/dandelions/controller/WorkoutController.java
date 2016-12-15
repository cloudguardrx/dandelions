package org.cg.dandelions.controller;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.cg.dandelions.db.DBService;
import org.cg.dandelions.generator.Generator;
import org.cg.dandelions.model.Movement;
import org.cg.dandelions.model.Workout;
import org.cg.dandelions.repository.WorkoutRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {

	static final Logger logger = LoggerFactory.getLogger(WorkoutController.class);

	@Autowired
	DBService dbService;
	
	@Autowired
	private WorkoutRepository workoutRepository;

	@PostConstruct
	public void init() {
		dbService.movementColl.drop();
		dbService.workoutColl.drop();

		Set<Movement> movements = Generator.generateMovements();
		for (Movement movement : movements) {
			movement = dbService.save(movement);
		}

		Workout workout = Generator.generateWorkout(movements);
		workout = dbService.save(workout);
	}

	@RequestMapping(value = "/workout", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> workout(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
			Principal principal) {
		logger.info("workout user.{}.date.{}", principal.getName(), date);

		Map<String, Object> model = new HashMap<String, Object>();

		Workout workout = dbService.getWorkout(date);
		if (workout == null) {
			init();
			workout = dbService.getWorkout(date);
		}

		model.put("id", workout.id);
		model.put("date", date.toString());
		model.put("details", workout.details);
		model.put("movements", workout.movements);
		model.put("results", workout.results);

		return model;
	}

}
