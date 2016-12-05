package org.cg.dandelions.controller;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.cg.dandelions.generator.WorkoutGenerator;
import org.cg.dandelions.model.Workout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {

	static final Logger logger = LoggerFactory.getLogger(WorkoutController.class);

	@RequestMapping(value = "/workout", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> workout(@RequestParam("date") Instant date) {
		logger.info("workout date.{}", date);

		Map<String, Object> model = new HashMap<String, Object>();

		Workout workout = WorkoutGenerator.generate();

		model.put("id", workout.id);
		model.put("date", date.toString());
		model.put("details", workout.details);
		model.put("movements", workout.movements);
		model.put("results", workout.results);

		return model;
	}

}
