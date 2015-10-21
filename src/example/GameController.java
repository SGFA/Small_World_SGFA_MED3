package example;

import java.util.*;

public class GameController {

ArrayList<Ability> abilityDb = new ArrayList<Ability>();
ArrayList<Race>	raceDb = new ArrayList<Race>();

	public void initDb() {
		
		//Initialize abilities
		abilityDb.add(new Ability("1",5,"fly","none"));
		abilityDb.add(new Ability("2",5,"fly","none"));
		abilityDb.add(new Ability("3",5,"fly","none"));
		abilityDb.add(new Ability("4",5,"fly","none"));
		
		//Initialize races 
		raceDb.add(new Race("Amazon 1",8,"backup","conquer"));
		raceDb.add(new Race("Amazon 2",8,"backup","conquer"));
		raceDb.add(new Race("Amazon 3",8,"backup","conquer"));
		raceDb.add(new Race("Amazon 4",8,"backup","conquer"));
		
	}
	
}
