package map_package;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;

public class MapAttributes {

	Image img;
	GameContainer gc;
	
	int x, y;
	
	public MapAttributes(GameContainer gc ,Image img, int x, int y) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.gc = gc;
		
	}
	
	public void display() {
		img.draw(x, y, 0.5f);
	}
}
