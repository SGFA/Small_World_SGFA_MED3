package example;
 
import java.lang.reflect.Array;
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
        ArrayList<Template> pair = new ArrayList<Template>();
        ArrayList<ArrayList<Template>> stack = new ArrayList<ArrayList<Template>>();
       
        // The id of races and abilities
        int[] raceId;
        int[] abilityId;
 
        public void initDb() {
 
                // Initialize races
                raceDb.add(new Race("Amazon 1", 8, "backup", "conquer"));
                raceDb.add(new Race("Amazon 2", 8, "backup", "conquer"));
                raceDb.add(new Race("Amazon 3", 8, "backup", "conquer"));
                raceDb.add(new Race("Amazon 4", 8, "backup", "conquer"));
               
                // Initialize abilities
                abilityDb.add(new Ability("1", 5, "fly", "none"));
                abilityDb.add(new Ability("2", 5, "fly", "none"));
                abilityDb.add(new Ability("3", 5, "fly", "none"));
                abilityDb.add(new Ability("4", 5, "fly", "none"));
               
                // Set the size of raceId and abilityId
                raceId = new int[raceDb.size()];
                abilityId = new int[abilityDb.size()];
 
 
        }
 
        public void createStack() {
       
                for (int i = 0; i < raceDb.size(); i++) {
 
                        if (i > 0)
                                raceId[i] = raceId[i - 1] + 1;
 
                }
 
                for (int i = 0; i < abilityDb.size(); i++) {
 
                        if (i > 0)
                                abilityId[i] = abilityId[i - 1] + 1;
 
                }
 
        }
 
        public void debugStack() {
 
                System.out.println("Race: ");
                for (int i = 0; i < raceDb.size(); i++) {
 
                        System.out.println(raceId[i]);
 
                }
               
                System.out.println("Ability: ");
                for (int i = 0; i < abilityDb.size(); i++) {
 
                        System.out.println(abilityId[i]);
 
                }
 
        }
 
}