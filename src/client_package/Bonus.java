package client_package;

public class Bonus extends Template {
	
	Bonus(){
		
	}
	
	public void test(int i) {
		System.out.println("It worked");
	}
	
	public void addPoints(Player player, int num){
		
		player.score += num;
		
	}
	
	public int addUnits(int num){
		return num;
	}

}
