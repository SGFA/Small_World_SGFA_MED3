package example;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class SimpleSlickGame extends BasicGameState
{
	Image playNow;
	Image exitGame; 
	private Image backGround; 
	
	public SimpleSlickGame(String gamename)
	{
		super();
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		backGround = new Image("res/small world.png");
		playNow = new Image("res/Play now button.png");
		exitGame = new Image("res/exit.png"); 
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics arg2) throws SlickException {
		// TODO Auto-generated method stub
		backGround.draw();
		playNow.draw(180, 270);
		exitGame.draw(320,440);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException {
		// TODO Auto-generated method stub
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

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
/*	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			SimpleSlickGame a = new SimpleSlickGame("Small World");
			appgc = new AppGameContainer( a );
			appgc.setDisplayMode(800, 505, false);
			appgc.start();
		} 
		catch (SlickException e)
		{
			e.printStackTrace();
		}
	}
*/
}