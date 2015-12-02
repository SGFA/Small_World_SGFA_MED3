package client_package;

import java.util.*;

/**
 *
 * The {@code GameController} is responsible for handling events during the game
 * session e.g. keeping track of the card stack.
 *
 */
public class Stack implements java.io.Serializable{

	// Databases for races and abilities
	private ArrayList<Race> raceDb = new ArrayList<Race>();
	private ArrayList<Ability> abilityDb = new ArrayList<Ability>();
	
	// The id of races and abilities
	ArrayList<Race> raceStack = new ArrayList<Race>();
	ArrayList<Ability> abilityStack = new ArrayList<Ability>();

	public void initDb() {

		
		// Initialize races
//		raceDb.add(new Race("AMAZONS",      6, "Bonus", "addUnits",  4, "isConquering:true"));           //effect: adds 4 units | req: only while conquering 
		raceDb.add(new Race("DWARVES",      3, "Bonus", "addPoints", 1, "hasMine","true"));                //effect: additional coins for X fulfilled requirement | req: has mine
//		raceDb.add(new Race("ELVES",        6, "special: withdrawUnits",    "isConquered" ,"true"));            //effect: withdraw units when conquered | req: losses a battle
//		raceDb.add(new Race("GHOULS",       5, "buff: setImmortal (true)",  "inDecline:true"));              //effect: stays active on map when going into decline |req: when in decline
//		raceDb.add(new Race("GIANTS",       6, "buff: addStrengh (+1)",     "isAdjacentToMountain: true"));  //effect: conquer region with one giant token less | req: region should be next to a mountain
		raceDb.add(new Race("HUMANS",       5, "Bonus", "addPoints",  1, "hasFarm","true"));                //effect: additional coins for X fulfilled requirement | req: has farm
		raceDb.add(new Race("ORCS",         5, "Bonus", "addPoints",  1, "isEmptyRegion", "false"));         //effect: additional coins for each non-empty region conquered. | req: The region should be non-empty
//		raceDb.add(new Race("SKELETONS",    6, "Bonus", "addUnits",  1/2,  "isEmptyRegion:false"));         //effect: 1+ unit for every two non-empty region conquered in the turn | req: region should be non-empty 
//		raceDb.add(new Race("TRITONS",      6, "buff: addStrengh (+1)",     "isAdjacentToWater: true"));     //effect: conquer region with one triton token less | req: region should be next to a lake or sea.
//		raceDb.add(new Race("TROLLS",       5, "special: createTrollLair",    "isConquered:true"));            //effect: create troll lair in each occupied region | reg: region is occupied 
		raceDb.add(new Race("WIZARD",       5, "Bonus", "addPoints", 1,     "hasMagic","true"));               //effect: additional coins for X fulfilled requirement | req: has magic source 

//  	raceDb.add(new Race("RATMEN", 8)); 

//		raceDb.add(new Race("HALFLINGS",    6, {"special: fly", "bonus: createHobbitHole"}, {"ifFirstMove:true", "ifHobbitHoleCount != 2"}));               //effect: First two regions are immune    need to make a new constructor to overwrite the constructor.
//		raceDb.add(new Race("SORCERES",     5, "special: substitute",       {"isActive:true", "opponentSubstituted:false", "isAdjacentOpponent:true"})); //effect: Substitute adjacent 


		// Initialize abilities
		abilityDb.add(new Ability("ALCHEMIST",     4, "bonus: addPoints (+2)",    "isOnTheMap","true"));    // effect: Add 2+ bonus coins in your own turn  | req: if tokens are on the map (cheek in decline) 
		abilityDb.add(new Ability("BIVOUACKING",   5, "bonus: createCamp (5)",   "isConquered","true"));    // effect: Deploy 5 Encampments in your Region(s). Defense +1 | req: region is owned by player
		abilityDb.add(new Ability("COMMANDO",      4, "buff: addStrengh (+1)",   "isConquering","true"));   // effect:
		abilityDb.add(new Ability("DRAGON MASTER", 5, "special: createDragon", "isRedeploying","true"));    // effect: Conquered one region by single token and the region will be immune| req: 
		abilityDb.add(new Ability("FLYING",        5, "special: special: setFly","true", "none"));          // effect: Conquer any region on the map | req: 
		abilityDb.add(new Ability("FOREST",        4, "bonus: addPoints(+1)", "hasForest","true"));         // effect: Points +1 for each forest region | req: 
		abilityDb.add(new Ability("HILL",          4, "bonus: addPoints (+1)", "rollDie", "true"));    // effect: Points +1 for each Hill region the player occupied | req: 
		abilityDb.add(new Ability("MERCHANT",      2, "special: reinforcement", "rollDie", "true"));   // effect: Points +1 for each regions the player occupied  | req: 
		abilityDb.add(new Ability("MOUNTED",       5,"special: reinforcement", "rollDie",    "true"));   // effect: Use less 1 token to conquer one Hill or farm-land | req: 
		abilityDb.add(new Ability("PILLAGING",     5, "special: reinforcement", "rollDie",    "true"));   // effect: Points +1 for each non-empty region the player conquered | req: 
		abilityDb.add(new Ability("SEAFARING",     5, "special: reinforcement", "rollDie",    "true"));   // effect: Conquer the sea & lake region,remain those regions after the decline  | req: Players race should active  
		abilityDb.add(new Ability("SPIRIT",        5, "special: reinforcement", "rollDie",    "true"));   // effect: Doesn't count as one token  | req: when go into decline 
		abilityDb.add(new Ability("STOUT",         4, "special: reinforcement", "rollDie",    "true"));   // effect: Can go in decline after one regular turn of conquest
		abilityDb.add(new Ability("SWAMP",         4, "special: reinforcement", "rollDie",    "true"));   // effect: Points +1 for each swamp region | req: 
		abilityDb.add(new Ability("UNDERWORLD",    4, "special: reinforcement", "rollDie",    "true"));   // effect: Use less than 1 token to conquer one region | req: 
		abilityDb.add(new Ability("WEALTHY",       4, "special: reinforcement", "rollDie",    "true"));   // effect: Points +7  | req:At the first turn on the  map 

//		abilityDb.add(new Ability("DIPLOMATE",     5, "special: setDiplomacy (true)",     {"attackedPlayer:false", "hasDiplomacy:false"}));   // effect:
//		abilityDb.add(new Ability("BESERK",        4, "special: reinforcement",  {"rollDie:true", "isConquered:true"});        // effect: Use the reinforcement die | req: before every conquest
//		abilityDb.add(new Ability("FORTIFIED",     3, {"special: createFortress", "usedAbility: false" }{"bonus: addPoint (+1), "isActive:true")});   // effect: 
//		abilityDb.add(new Ability("HEROIC"         5, "special: createHero", {"endPhase:true", "createdHeroes:false"}));           // effect:



	}

	public void initialize() {

		for (int i = 0; i < raceDb.size(); i++) {
			raceStack.add(raceDb.get(i));
		}

		for (int i = 0; i < abilityDb.size(); i++) {
			abilityStack.add(abilityDb.get(i));
		}
	}

	/**
	 * The {@code shuffle()} method is responsible for shuffling the race id's
	 * and ability id's before creating the stack.
	 */
	public void shuffle() {

		Random r1 = new Random(Double.doubleToLongBits(Math.random()));
		Random r2 = new Random(Double.doubleToLongBits(Math.random()));

		Collections.shuffle(raceStack, r1);
		Collections.shuffle(abilityStack, r2);
	}

	public void addPair(Race race, Ability ability) {
		raceStack.add(race);
		abilityStack.add(ability);
	}

	public void removePair() {
		raceStack.remove(0);
		abilityStack.remove(0);
	}

	public String toString() {
		
		StringBuilder s = new StringBuilder(); 
		
		// list Race-id in the order it appears in the stack
		s.append("Race: \n");
		
		for (int i = 0; i < raceStack.size(); i++) {

			s.append("Id: " + i + " Name: " + raceStack.get(i).name + "\n");
			
		}
		
		// list Ability-id in the order it appears in the stack
		s.append("Ability: \n");
		
		for (int i = 0; i < abilityStack.size(); i++) {
			
			s.append("Id: " + i + " Name: " + abilityStack.get(i).name + "\n");

		}
		return s.toString();
	}
}