package client_package;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import map_package.Map;


public class Game extends BasicGameState {
	
	GameController gameController = new GameController();

	public Game(int state) {
		// TODO Auto-generated constructor stub

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, org.newdawn.slick.Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < Map.fields.size(); i++) {
			Map.fields.get(i).image.draw(Map.fields.get(i).getPosX(),Map.fields.get(i).getPosY());
		}

	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		GameController.initialize();

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException {

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}


}
