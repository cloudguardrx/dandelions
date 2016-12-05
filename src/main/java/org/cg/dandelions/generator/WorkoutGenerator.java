package org.cg.dandelions.generator;

import java.util.HashSet;

import org.cg.dandelions.model.Movement;
import org.cg.dandelions.model.Workout;

public class WorkoutGenerator {

	public static Workout generate() {
		Workout workout = new Workout();
		workout.details = "### Score is number of Rounds Completed\n - 10 burpies\n - 200m Run Brisk Pace\n  - 20 1POOD KB Swings American\n";

		Movement burpies = new Movement();
		burpies.name = "Burpies";
		burpies.description = "Soul-Crushing burpies UGH";

		Movement run = new Movement();
		run.name = "Run";
		run.description = "Running Sucks";

		Movement kbSwings = new Movement();
		kbSwings.name = "Kettlebell Swings";
		kbSwings.description = "Overhead Dummy";

		workout.movements = new HashSet<>();
		workout.movements.add(burpies);
		workout.movements.add(run);
		workout.movements.add(kbSwings);

		return workout;
	}

}
