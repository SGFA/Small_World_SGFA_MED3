package menu_package;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.MouseOverArea;

public class Button {

	Image img;
	MouseOverArea moa;
	GameContainer gc;
	
	int x, y;
	
	public Button(GameContainer gc ,Image img, int x, int y) {
		this.img = img;
		this.x = x - img.getWidth() / 2;
		this.y = y - img.getHeight() / 2;
		this.gc = gc;
		
		init();
	}
	
	public void init() {
		moa = new MouseOverArea(gc, img, x, y);		
	}
	
	public void display() {
		img.draw(x, y);
	}
	
	public boolean isPressed() {
		if (moa.isMouseOver()) {
			if (gc.getInput().isMousePressed(0)) {
				return true;
			}
		}
		return false;
	}
}
