package client_package;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.text.DefaultEditorKit.DefaultKeyTypedAction;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import map_package.Map;
import map_package.MapAttributes;
import menu_package.Button;
import menu_package.Toast;

public class Game extends BasicGameState {

	Button launchbtn;
	Button decline_btn;
	Button end_turn_btn;
	StackShop popup;

	int mouseX = 0;
	int mouseY = 0;


	MapAttributes mountainsField1pt4;
	MapAttributes mountainsField2pt1;
	MapAttributes mountainsField3pt4;

	MapAttributes magicField1pt2;
	MapAttributes magicField2pt6;
	MapAttributes magicField3pt3;
	MapAttributes magicField4pt1;
	
	MapAttributes miningField1pt3;
	MapAttributes miningField2pt1;
	MapAttributes miningField3pt5;
	MapAttributes miningField4pt3;


	
	TrueTypeFont font;

	
	GameController gameController = new GameController();

	public ArrayList<MouseOverArea> moa = new ArrayList<MouseOverArea>();

	public Game(int state) {
		// TODO Auto-generated constructor stub

	}

	/**
	 * Predefined Slick2D method.
	 * @see BasicGameState
	 */
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, org.newdawn.slick.Graphics g) throws SlickException {

		for (int i = 0; i < Map.fields.size(); i++) {
			Map.fields.get(i).image.draw(Map.fields.get(i).getPosX(), Map.fields.get(i).getPosY());
		}

		g.drawString("YOUR SCORE: " + GameController.players.get(GameController.PLAYER_ID - 1).getScore(), 20, 500);
		g.drawString("PLAYER: " + GameController.PLAYER_ID + " waiting for PLAYER " + GameController.CURRENT_ACTIVE_PLAYER, 20, 20);
		
		
		if (GameController.players.get(GameController.PLAYER_ID - 1).pair[0] != null) {
		g.drawString("Active race: " + GameController.players.get(GameController.PLAYER_ID - 1).pair[0].race.name, 200, 500);
		g.drawString("Active ability: " + GameController.players.get(GameController.PLAYER_ID - 1).pair[0].ability.name, 200, 520);
		g.drawString("Unit amount: " + GameController.players.get(GameController.PLAYER_ID - 1).pair[0].getUnits(), 200, 540);

		}
		
		Toast.draw(g);

		launchbtn.display();
		decline_btn.display();
		end_turn_btn.display();
		
		mountainsField1pt4.display();
		mountainsField2pt1.display();
		mountainsField3pt4.display();
		
		magicField1pt2.display();
		magicField2pt6.display();
		magicField3pt3.display();
		magicField4pt1.display();
		
		miningField1pt3.display();
		miningField2pt1.display();
		miningField3pt5.display();
		miningField4pt3.display();

	}


	/**
	 * Predefined Slick2D method.
	 * @see BasicGameState
	 */
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
//		 GameController.createStack();
//		 GameController.addPlayers(2);
//		 GameController.setPair(0, 0);
//		 System.out.println(GameController.players.get(0).pair[0].race.name);
		 
		// MapHandler.initialize(GameController.players.size());
		// GameController.launched = true;
		// GameController.addPlayers(2);
		// GameController.setPair(0, 0);

		// GameController.initialize()
		
	
		Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(awtFont, false);

		launchbtn = new Button(gc, new Image("res/combo_shop.png"), 650, 520);
		decline_btn = new Button(gc, new Image("res/decline.png"), 450, 30);
		end_turn_btn = new Button(gc, new Image("res/end.png"), 650, 30);
		
		mountainsField1pt4 = new MapAttributes(gc, new Image("assets/mountain.png"), 480, 65);
		mountainsField2pt1 = new MapAttributes(gc, new Image("assets/mountain.png"), 155, 150);
		mountainsField3pt4 = new MapAttributes(gc, new Image("assets/mountain.png"), 585, 235);
		
		magicField1pt2 = new MapAttributes(gc, new Image("assets/magic.png"), 240, 70);
		magicField2pt6 = new MapAttributes(gc, new Image("assets/magic.png"), 739, 135);
		magicField3pt3 = new MapAttributes(gc, new Image("assets/magic.png"), 450, 320);
		magicField4pt1 = new MapAttributes(gc, new Image("assets/magic.png"), 100, 354);
		
		miningField1pt3 = new MapAttributes(gc, new Image("assets/mining.png"), 350, 66);
		miningField2pt1 = new MapAttributes(gc, new Image("assets/mining.png"), 50, 181);
		miningField3pt5 = new MapAttributes(gc, new Image("assets/mining.png"), 725, 225);
		miningField4pt3 = new MapAttributes(gc, new Image("assets/mining.png"), 350, 430);

		// MapHandler.initialize(GameController.players.size());
		// GameController.launched = true;
	}

	/**
	 * Predefined Slick2D method.
	 * @see BasicGameState
	 */
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException {

		updateFields(gc);
		
		if (launchbtn.isPressed()) {
			popup = new StackShop();
			popup.display();
		}
		
		if (decline_btn.isPressed()) {
			gameController.decline(gameController.CURRENT_ACTIVE_PLAYER.get());
		}

		if (end_turn_btn.isPressed() && GameController.PLAYER_ID == GameController.CURRENT_ACTIVE_PLAYER.get()) {
			GameController.endTurn();
		}
		
	}


	/**
	 * Runs through and updates the rendering of all fields. Also runs the conquer method on the field you click.
	 * @param gc the GameContainer where the mouse positions and MouseOverAreas should be handled
	 */
	public void updateFields(GameContainer gc) {

		// If the MouseOverArea ArrayList is empty then it should be populated.
		if (moa.isEmpty()) {
			for (int i = 0; i < Map.fields.size(); i++) {
				moa.add(new MouseOverArea(gc, Map.fields.get(i).image, Map.fields.get(i).getPosX(),
						Map.fields.get(i).getPosY()));
			}
		}

		// if (mouseX < 0 && mouseX > gc.getWidth())
		mouseX = gc.getInput().getAbsoluteMouseX();
		//
		// if (mouseY < 0 && mouseY > gc.getHeight())
		mouseY = gc.getInput().getAbsoluteMouseY();

		for (int i = 0; i < Map.fields.size(); i++) {

			if ((mouseX - moa.get(i).getX()) > 0 && (mouseX - moa.get(i).getX()) < moa.get(i).getWidth()
					&& (mouseY - moa.get(i).getY()) > 0 && (mouseY - moa.get(i).getY()) < moa.get(i).getHeight()
					&& moa.get(i).isMouseOver()) {

				if (mouseX - moa.get(i).getX() > 0 && mouseY - moa.get(i).getY() > 0) {
					Color c = Map.fields.get(i).image.getColor(mouseX - moa.get(i).getX(), mouseY - moa.get(i).getY());
					int alpha = c.getAlpha();

					if (alpha > 0 && gc.getInput().isMousePressed(0)) {
						GameController.players.get(0).conquer(Map.fields.get(i));
					}
				}
			}
		}
	}


	/**
	 * Predefined Slick2D method.
	 * @see BasicGameState
	 */
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}
}
