package menu_package;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.*;

public class Welcome_Screen extends BasicGameState {

	private Image play_img;
	private Image exit_img;
	private Image background_img;
	
	Button play_btn;
	Button exit_btn;

	public Welcome_Screen(int state) {

	}


	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background_img = new Image("res/small world.png");

		play_btn = new Button(gc, new Image("res/Play now button.png"), 180, 270 );
		
		exit_btn = new Button(gc,new Image("res/exit.png"), 320, 440 );
		

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		background_img.draw(0, 0, 800, 600);
		play_btn.display();
		exit_btn.display();
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

		if (play_btn.isPressed()) {
			
					sbg.enterState(1);
			
		}

		if (exit_btn.isPressed()) {
			
					System.exit(0);
		}
	}

	public int getID() {
		return 0;
	}
}