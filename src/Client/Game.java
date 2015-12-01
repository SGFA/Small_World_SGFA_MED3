package Client;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Map.MapHandler;
import Map.MapTwoPlayer;

public class Game extends BasicGameState {

	GameController gameController = new GameController();
	Image clientBackground;
	boolean quit = false;

	public Game(int state) {
		// TODO Auto-generated constructor stub

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, org.newdawn.slick.Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		clientBackground.draw();
		
		
		
		if (quit == true) {
			g.drawString("Resume (R)", 20, 50);
			g.drawString("Menu (M)", 20, 100);
			g.drawString("Quit Game (Q)", 20, 150);
			if (quit == false) {
				g.clear();
			}
		}

	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		clientBackground = new Image("res/map.png");

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		Input input = gc.getInput();

		// escape the game
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			quit = true;
		}
		if (quit == true) {
			if (input.isKeyDown(Input.KEY_R)) {
				quit = false;
			}
			if (input.isKeyDown(Input.KEY_M)) {
				sbg.enterState(0);
			}
			if (input.isKeyDown(Input.KEY_Q)) {
				System.exit(0);
			}
		}
	}

	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}

}
