package Menu;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Welcome_Screen extends BasicGameState {
	
	private Image play_img;
	private Image exit_img;
	private Image background_img;

	public Welcome_Screen(int state) {

	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background_img = new Image("res/small world.png");
		play_img = new Image("res/Play now button.png");
		exit_img = new Image("res/exit.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		background_img.draw(0, 0, 800, 600);
		play_img.draw(180, 270);
		exit_img.draw(320, 440);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		// Play Button
		if ((posX > 180 && posX < 631) && (posY < 270 && posY > 270 - 94)) {
			if (Mouse.isButtonDown(0)) {
				sbg.enterState(1);
			}
		}
		
		// Exit button
		if ((posX > 320 && posX < 480) && (posY < 440 && posY > 440 - 60)) {
			if (Mouse.isButtonDown(0)) {
				System.exit(0);
			}
		}
	}

	public int getID() {
		return 0;
	}
}