package menu_package;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import client_package.GameController;
import server_package.Client;
import server_package.Server;

public class Server_Screen extends BasicGameState {

	private Image back_btn_img;
	private Image host_btn_img;
	private Image join_btn_img;
	private String serverList;
	boolean playerNumber = false;

	private Image background_img;
	
	Button join_btn;
	Button host_btn;
	Button back_btn;

	public Server_Screen(int state) {

	}


	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		background_img = new Image("res/small world.png");

		join_btn = new Button(gc,new Image("res/join_btn_img.png"), 600, 200);

		host_btn = new Button(gc,new Image("res/host server.png"), 600, 100);

		back_btn = new Button(gc, new Image("res/back.png"), 20, 500);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		background_img.draw(0, 0, 800, 600);

		join_btn.display();

		host_btn.display();

		back_btn.display();

		g.drawString("The list of avilable server : " + serverList, 20, 100);

		// check is the player has been connected to the system or not.
		/*
		 * if (ArrayList play = 1) { playerWhite.draw(20,50); if (ArrayList play
		 * = 1 && player is connected) { playerBlack.draw(20,50); } }
		 *
		 * // check if two players have been registered online then the start
		 * button will shows up on the screen. if (ArrayList play = 2) {
		 * playerWhite.draw(20,120); if (ArrayList play = 2 && player is
		 * connected) { playerBlack.draw(20,120); startButton.draw(310,300);
		 * playNumber = true; } }
		 *
		 */

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException {
		// TODO Auto-generated method stub

		// if two players has been connected to the system then press the start
		// key the game will start.

		if (join_btn.isPressed()) {
				sbg.enterState(2);
		}

		if (host_btn.isPressed()) {
				Lobby_Screen.isHost = true;
				GameController.addPlayers(1);
				sbg.enterState(2);
			}
		

		if (back_btn.isPressed()) {
				sbg.enterState(0);
			}
		}
		
	

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}
}
