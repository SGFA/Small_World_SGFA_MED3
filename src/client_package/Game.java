package client_package;

import java.util.ArrayList;

import javax.swing.text.DefaultEditorKit.DefaultKeyTypedAction;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import map_package.Map;
import map_package.MapHandler;
import menu_package.Toast;

public class Game extends BasicGameState {

	GameController gameController = new GameController();

	public ArrayList<MouseOverArea> moa = new ArrayList<MouseOverArea>();

	public Game(int state) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, org.newdawn.slick.Graphics g) throws SlickException {

		for (int i = 0; i < Map.fields.size(); i++) {
			Map.fields.get(i).image.draw(Map.fields.get(i).getPosX(), Map.fields.get(i).getPosY());
		}

		Toast.draw(g);

	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		GameController.addPlayers(2);
		GameController.setPair(0, 0);
		MapHandler.initialize(GameController.players.size());
		// GameController.launched = true;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException {

		updateFields(gc);

	}

	int mouseX = 0;
	int mouseY = 0;

	public void updateFields(GameContainer gc) {

		// If the MouseOverArea ArrayList is empty then it should be populated.
		if (moa.isEmpty()) {
			for (int i = 0; i < Map.fields.size(); i++) {
				moa.add(new MouseOverArea(gc, Map.fields.get(i).image, Map.fields.get(i).getPosX(),
						Map.fields.get(i).getPosY()));
			}
		}

		// if (mouseX < 0 && mouseX > gc.getWidth())
		mouseX = gc.getInput().getAbsoluteMouseX();
		//
		// if (mouseY < 0 && mouseY > gc.getHeight())
		mouseY = gc.getInput().getAbsoluteMouseY();

		for (int i = 0; i < Map.fields.size(); i++) {

			if ((mouseX - moa.get(i).getX()) > 0 && (mouseX - moa.get(i).getX()) < moa.get(i).getWidth()
					&& (mouseY - moa.get(i).getY()) > 0 && (mouseY - moa.get(i).getY()) < moa.get(i).getHeight()
					&& moa.get(i).isMouseOver()) {

				if (mouseX - moa.get(i).getX() > 0 && mouseY - moa.get(i).getY() > 0) {
					Color c = Map.fields.get(i).image.getColor(mouseX - moa.get(i).getX(), mouseY - moa.get(i).getY());
					int alpha = c.getAlpha();

					if (alpha > 0 && gc.getInput().isMousePressed(0)) {
						GameController.players.get(0).conquer(Map.fields.get(i));
					}
				}
			}
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}
}
