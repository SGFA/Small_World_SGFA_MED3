package Menu;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class CheckPlayer extends BasicGameState {

	Image playerBlack;
	Image playerWhite;
	Image startButton;
	boolean playerNumber = false;
	private Image backGround;

	public CheckPlayer(int state) {

	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		backGround = new Image("res/small world.png");
		playerBlack = new Image("res/player black.png");
		playerWhite = new Image("res/player white.png");
		startButton = new Image("res/start-button.png");

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics arg2) throws SlickException {
		// TODO Auto-generated method stub
		backGround.draw();
		startButton.draw(310, 300);
		playerWhite.draw(20, 50);
		playerBlack.draw(20, 50);
		playerWhite.draw(20, 120);
		playerBlack.draw(20, 120);

		// check is the player has been connected to the system or not.
		/*
		 * if (ArrayList play = 1) { playerWhite.draw(20,50); if (ArrayList play
		 * = 1 && player is connected) { playerBlack.draw(20,50); } }
		 * 
		 * // check if two players have been registered online then the start
		 * button will shows up on the screen. if (ArrayList play = 2) {
		 * playerWhite.draw(20,120); if (ArrayList play = 2 && player is
		 * connected) { playerBlack.draw(20,120); startButton.draw(310,300);
		 * playNumber = true; } }
		 * 
		 */

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		int posX = Mouse.getX();
		int posY = Mouse.getY();

		// if two players has been connected to the system then press the start
		// key the game will start.

		if (playerNumber) {

			if ((posX > 310 && posX < 310 + 100) && (posY < 300 && posY > 300 - 95)) {
				if (Mouse.isButtonDown(0)) {
					System.out.println("working");
					sbg.enterState(2);
				}
			}
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
