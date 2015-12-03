package menu_package;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.gui.MouseOverArea;

public class Button {

	Image img;
	MouseOverArea moa;
	GameContainer gc;
	
	int x, y;
	
	Button(GameContainer gc ,Image img, int x, int y) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.gc = gc;
		
		init();
	}
	
	void init() {
		moa = new MouseOverArea(gc, img, x, y);		
	}
	
	void display() {
		img.draw(x, y);
	}
	
	boolean isPressed() {
		if (moa.isMouseOver()) {
			if (gc.getInput().isMousePressed(0)) {
				return true;
			}
		}
		return false;
	}
}
