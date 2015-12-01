package map_package;

public class MapHandler {
	
	static Map map;
	
	public static void initialize (int playerCount) {

		
		
		switch (playerCount) {
		case 1:
			break;
		case 2:
			map = new MapTwoPlayer();
			
			break;
		case 3:
			break;

		case 4:
			break;

		case 5:
			break;

		case 6:
			break;

		}
	}
}
