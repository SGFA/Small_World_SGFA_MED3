package example;

import java.util.*;

/**
 * 
 * The {@code GameController} is responsible for handling events during the game session e.g. keeping track of the card stack.  
 *
 */
public class GameController {

	// Databases for races and abilities
	ArrayList<Ability> abilityDb = new ArrayList<Ability>();
	ArrayList<Race> raceDb = new ArrayList<Race>();

	// The stack of races and abilities
	ArrayList<ArrayList<Template>> stack = new ArrayList<ArrayList<Template>>();

	public void initDb() {

		// Initialize abilities
		abilityDb.add(new Ability("1", 5, "fly", "none"));
		abilityDb.add(new Ability("2", 5, "fly", "none"));
		abilityDb.add(new Ability("3", 5, "fly", "none"));
		abilityDb.add(new Ability("4", 5, "fly", "none"));

		// Initialize races
		raceDb.add(new Race("Amazon 1", 8, "backup", "conquer"));
		raceDb.add(new Race("Amazon 2", 8, "backup", "conquer"));
		raceDb.add(new Race("Amazon 3", 8, "backup", "conquer"));
		raceDb.add(new Race("Amazon 4", 8, "backup", "conquer"));

	}

	public void createStack() {

	}

}
