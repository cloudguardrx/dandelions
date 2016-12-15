//package org.cg.dandelions.db;
//
//import static org.junit.Assert.assertNotNull;
//
//import java.util.Date;
//import java.util.Set;
//
//import org.cg.dandelions.config.MongoConfig;
//import org.cg.dandelions.db.DBServiceTest.ApplicationContext;
//import org.cg.dandelions.generator.Generator;
//import org.cg.dandelions.model.Movement;
//import org.cg.dandelions.model.Workout;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = ApplicationContext.class)
//public class DBServiceTest {
//
//	public static class ApplicationContext {
//		@Bean
//		DBService dbService() {
//			return new DBService();
//		}
//
//		@Bean
//		MongoConfig mongoConfig() {
//			return new MongoConfig();
//		}
//
//	}
//
//	@Autowired
//	DBService dbService;
//
//	@Test
//	public void test() {
//		assertNotNull(dbService);
//
//		Set<Movement> movements = Generator.generateMovements();
//		for (Movement movement : movements) {
//			movement = dbService.save(movement);
//			assertNotNull(movement);
//			assertNotNull(movement.id);
//		}
//
//		Workout workout = Generator.generateWorkout(movements);
//		workout = dbService.save(workout);
//		assertNotNull(workout);
//
//		dbService.getWorkout(new Date());
//		
//	}
//
//}
