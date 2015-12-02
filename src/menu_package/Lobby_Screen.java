package menu_package;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import client_package.GameController;

public class Lobby_Screen extends BasicGameState {
	private Image background;
	private Image player_1;
	private Image player_2;
	private Image back_btn_img;

	public Lobby_Screen(int state) {

	}

	MouseOverArea moa_launch, moa_back;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		background = new Image("res/lobby background.png");

		back_btn_img = new Image("res/back.png");
		moa_back = new MouseOverArea(gc, back_btn_img, 20, 400);
		

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		background.draw(0, 0, 800, 600);
		back_btn_img.draw(20, 400);
		
		
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < 3; i++) {
		Rectangle rect = new Rectangle(50 + 200 * i, 50 + 200 * j, 100, 100);
		
		
		if (i + j * 3 < GameController.players.size()) 
			g.setColor(new Color(50, 255, 50));
		else 
			g.setColor(new Color(50, 50, 50));

		g.fill(rect);
		g.draw(rect);

		g.setColor(Color.white);
		g.drawString("Player " + (int)(i + 1 + (j + 2) * j), 50 + 200 * i, 50 + 200 * j);
			}
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException {
		// TODO Auto-generated method stub

		// Launch game for host
		// if (moa_launch.isMouseOver()) {
		// if (Mouse.isButtonDown(0)) {
		// System.out.println("launch");
		// }
		// }

		// Back to the main screen
		if (moa_back.isMouseOver()) {
			if (gc.getInput().isMousePressed(0)) {
				sbg.enterState(1);
			}
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}
}
