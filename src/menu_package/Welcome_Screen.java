package menu_package;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.*;

public class Welcome_Screen extends BasicGameState {

	private Image play_img;
	private Image exit_img;
	private Image background_img;

	public Welcome_Screen(int state) {

	}

	MouseOverArea moa_play;
	MouseOverArea moa_exit;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background_img = new Image("res/small world.png");

		play_img = new Image("res/Play now button.png");
		moa_play = new MouseOverArea(gc, play_img, 180, 270);

		exit_img = new Image("res/exit.png");
		moa_exit = new MouseOverArea(gc, play_img, 320, 440);

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		background_img.draw(0, 0, 800, 600);
		play_img.draw(180, 270);
		exit_img.draw(320, 440);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

		if (moa_play.isMouseOver()) {
			if (gc.getInput().isMousePressed(0)) {
					sbg.enterState(1);
			}
		}

		if (moa_exit.isMouseOver()) {
			if (gc.getInput().isMousePressed(0)) {
					System.exit(0);
			}
		}
	}

	public int getID() {
		return 0;
	}
}