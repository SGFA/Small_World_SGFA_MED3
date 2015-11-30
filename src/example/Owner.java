package example;

public enum Owner {
	BOARD (0), PLAYER1 (1), PLAYER2 (2), PLAYER3 (3), PLAYER4 (4), PLAYER5 (5);
	
	Owner(int identity) {
		this.identity = identity;
	}
	
	int getIdentity() {
		return identity;
	}

	private int identity;

}
