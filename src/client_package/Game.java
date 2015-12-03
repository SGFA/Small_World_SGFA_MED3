package client_package;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import map_package.Map;


public class Game extends BasicGameState {
	
	GameController gameController = new GameController();
	
    public ArrayList<MouseOverArea> moa = new ArrayList<MouseOverArea>();
    

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
		
		for(int i = 0; i < Map.fields.size(); i++ ){
			
		moa.add(new MouseOverArea(gc,Map.fields.get(i).image,Map.fields.get(i).getPosX(),Map.fields.get(i).getPosY()));
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException {

		int mouseX = Mouse.getX();
		int mouseY = gc.getHeight() - Mouse.getY();

		for (int i = 0;  i < Map.fields.size()-1; i++) { 

			if (moa.get(17).isMouseOver()) {


				if (mouseX > moa.get(i).getX() && mouseX < moa.get(i).getX() + moa.get(i).getWidth()
						&& mouseY > moa.get(i).getY() && mouseY > moa.get(i).getY() + moa.get(i).getHeight()) { 
					System.out.println("hello");
					System.out.println(Map.fields.size());

//					Color c = Map.fields.get(i-1).image.getColor(mouseX, mouseY);
//					int alpha = c.getAlpha();
//
//					if (alpha > 0) {
//						System.out.println(alpha);							
//					} else {	
//						System.out.println("Nothing");							}
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
