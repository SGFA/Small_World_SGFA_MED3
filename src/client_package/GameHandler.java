package client_package;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import menu_package.Lobby_Screen;
import menu_package.Server_Screen;
import menu_package.Welcome_Screen;
import server_package.Client;
import server_package.Server;

public class GameHandler extends StateBasedGame {

	
	public static final String gamename = "SmallWorlds";
	public static final int WELCOME_SCREEN = 0;
	public static final int SERVER_SCREEN = 1;
	public static final int LOBBY_SCREEN = 2;
	public static final int GAME = 3;

	
	public GameHandler(String gamename) {
		
		super(gamename);
		this.addState(new Welcome_Screen(WELCOME_SCREEN));
		this.addState(new Server_Screen(SERVER_SCREEN));
		this.addState(new Lobby_Screen(LOBBY_SCREEN));
		this.addState(new Game(GAME));

	}
	
	public void initStatesList (GameContainer gc) throws SlickException {
		this.getState(SERVER_SCREEN).init(gc, this);;
		this.getState(LOBBY_SCREEN).init(gc, this);;
		this.getState(GAME).init(gc, this);
		
		
		this.enterState(WELCOME_SCREEN);

	}

	public static void setup() {
				
		Server server = new Server();
		server.listen();
		
		Client client = new Client();
		client.connect("82.211.210.205");
		
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