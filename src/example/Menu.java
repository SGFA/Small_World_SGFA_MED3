package example;

import org.lwjgl.input.Mouse; 
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState
{
	Image playNow;
	Image exitGame; 
	
	private Image backGround; 
	
	public Menu (int state) {
		
		
	}
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		backGround = new Image("res/small world.png");
		playNow = new Image("res/Play now button.png");
		exitGame = new Image("res/exit.png"); 
		
	}
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		backGround.draw();
		playNow.draw(180, 270);
		exitGame.draw(320,440);
		
	}
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		// playNow button 
		if ((posX > 180 && posX < 631) && (posY < 270 && posY > 270- 94)) {
			if (Mouse.isButtonDown(0)){
				sbg.enterState(1);
				 System.out.println(posX);
				 System.out.println(posY);
			}	
		}
		// exit button
		if ((posX > 320 && posX < 480) && (posY < 440 && posY > 440 - 60)){
			if (Mouse.isButtonDown(0)){
				 System.out.println(posX);
				 System.out.println(posY);
				System.exit(0);
			}
		}
		
		
		
	}
	public int getID() {
		return 0 ; 
		
	}

}