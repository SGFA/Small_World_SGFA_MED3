package example;

public enum Owner {
	BOARD (0), PLAYER_1 (1), PLAYER_2 (2), PLAYER_3 (3), PLAYER_4 (4), PLAYER_5 (5);
	
	private int identity;
	
	Owner(int identity) {
		this.identity = identity;
	}
	
	int getIdentity() {
		return identity;
	}

}