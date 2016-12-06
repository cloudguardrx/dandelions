package org.cg.dandelions.generator;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.cg.dandelions.model.Movement;
import org.cg.dandelions.model.Workout;

public class Generator {

	public static Workout generateWorkout(Set<Movement> movements) {
		Workout workout = new Workout();

		Calendar date = Calendar.getInstance();
		date.set(Calendar.HOUR, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);
		workout.date = date.getTime();

		workout.details = "### Score is number of Rounds Completed\n - 10 burpies\n - 200m Run Brisk Pace\n  - 20 1POOD KB Swings American\n";

		workout.movements = movements;
		return workout;
	}

	public static Set<Movement> generateMovements() {
		Set<Movement> movements = new HashSet<>();

		Movement burpies = new Movement();
		burpies.name = "Burpies";
		burpies.description = "Soul-Crushing burpies UGH";

		Movement run = new Movement();
		run.name = "Run";
		run.description = "Running Sucks";

		Movement kbSwings = new Movement();
		kbSwings.name = "Kettlebell Swings";
		kbSwings.description = "Overhead Dummy";

		movements.add(burpies);
		movements.add(run);
		movements.add(kbSwings);

		return movements;

	}

}
