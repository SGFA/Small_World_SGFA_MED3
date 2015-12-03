package menu_package;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import client_package.GameController;
import map_package.MapHandler;
import server_package.Client;
import server_package.Server;

public class Lobby_Screen extends BasicGameState {
	private Image background;

	Button launch_btn;
	Button back_btn;

	static boolean isHost;

	public Lobby_Screen(int state) {

	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub

		launch_btn = new Button(gc, new Image("res/launch_btn.png"), 600, 500);
		
		back_btn = new Button(gc, new Image("res/back.png"), 20, 500);

		background = new Image("res/lobby background.png");

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		background.draw(0, 0, 800, 600);
		back_btn.display();

		if (GameController.players.size() > 1 && isHost) {
			launch_btn.display();
		}

		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < 3; i++) {

				Rectangle rect = new Rectangle(50 + 200 * i, 50 + 200 * j, 100, 100);

				if (i + j * 3 < GameController.players.size())
					g.setColor(new Color(50, 255, 50));
				else
					g.setColor(new Color(50, 50, 50));

				g.fill(rect);
				g.draw(rect);

				g.setColor(Color.white);
				g.drawString("Player " + (int) (i + 1 + (j + 2) * j), 50 + 200 * i, 50 + 200 * j);
			}
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException {
		// TODO Auto-generated method stub

		if (launch_btn.isPressed() && isHost && GameController.players.size() > 1) {
			System.out.println("PlayerAmount: " + GameController.players.size());
			GameController.launched = true;
			MapHandler.initialize(GameController.players.size());
			
			GameController.serializationHandler.serialize(Server.out);
			
			sbg.enterState(3);
		} else if (!isHost && GameController.launched) {
			System.out.println("Launch client");
		}

		if (back_btn.isPressed()) {
			sbg.enterState(1);
			
			if(isHost){
				GameController.removePlayer(1);
				isHost = false;
			}
				Server.stop();
				Client.stop();
				return;
		}

		if (isHost && Server.running == false) {
			Server.listen();
		} else if (!isHost && Client.running == false) {
			Client.connect("127.0.0.1");
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}
}
