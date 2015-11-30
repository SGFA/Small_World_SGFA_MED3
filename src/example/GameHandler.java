package example;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.Color;

public class GameHandler extends BasicGame
{
	
	Image field = null;
	MouseOverArea moa;
	
	public GameHandler(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		field = new Image("assets/abc.png");
		moa = new MouseOverArea(gc, field, 0, 0);

	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
			
		int mouseX = Mouse.getX();
		int mouseY = gc.getHeight() - Mouse.getY();
				
		if (moa.isMouseOver()) {
			
			if (mouseX > 0 && mouseX < field.getWidth() && mouseY > 0 && mouseY < field.getHeight() ) { 
			
				Color c = field.getColor(mouseX, mouseY);
				int alpha = c.getAlpha();
				
				if (alpha > 0) {
					System.out.println(alpha);
				} else {
					System.out.println("Nothing");
				}
			}
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		g.drawString("Hello World!", 250, 200);
		
		field.draw();
	}
	
	public static void setup() {
				try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new GameHandler("Simple Slick Game"));
			appgc.setDisplayMode(640, 480, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}	