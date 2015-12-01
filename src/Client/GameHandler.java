package Client;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.StateBasedGame;

import Menu.CheckPlayer;
import Menu.Server_menu;

public class GameHandler extends StateBasedGame {

	public static final String gamename = "SmallWorlds";
	public static final int menu = 0;
	public static final int server = 1;
	public static final int client = 2;
	
	public GameHandler(String gamename) {
		
		super(gamename);
		this.addState(new Server_menu(menu));
		this.addState(new Game(client));
		this.addState(new CheckPlayer(server));
	}
	
	public void initStatesList (GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(client).init(gc, this);
		this.enterState(menu);
	}

	Image field = null;
	MouseOverArea moa;

	public static void setup() {
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new GameHandler("SmallWorlds"));
			appgc.setDisplayMode(800, 600, false);
			appgc.start();
		} catch (SlickException ex) {
			Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
		}
	}




}