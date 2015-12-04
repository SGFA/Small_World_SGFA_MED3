package client_package;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Image;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.newdawn.slick.AppletGameContainer;
import org.newdawn.slick.AppletGameContainer.Container;
import org.newdawn.slick.Game;

import javafx.stage.PopupWindow;

public class Popup extends JDialog {

	
	private final int shopSize = 4;
	
	public Popup () {

		this.setTitle("Combo Shop");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(shopSize, 2));
		this.getContentPane().setBackground(new Color(248, 245, 228));
		this.setResizable(false);
		//this.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
		
		for (int i = 0; i < shopSize; i++) {
			
			JPanel abilityPane = new JPanel(new FlowLayout(10, 10, 10));
			abilityPane.setBackground(new Color(248, 245, 228));
			JLabel ability = new JLabel(getComboImage("abilities/" + GameController.stack.abilityStack.get(i).name));
			abilityPane.add(ability);
			this.add(abilityPane);
			
			JPanel racePane = new JPanel(new FlowLayout(10,10,10));
			racePane.setBackground(new Color(248, 245, 228));
			JLabel race = new JLabel(getComboImage("races/" + GameController.stack.raceStack.get(i).name));
			racePane.add(race);
			this.add(racePane);
			
		}
		
		this.setVisible(true);
		
		
	}
	
	/**
	 * Method to fetch the image from assets/races corresponding to the target race.
	 * @param location the race image you want to fetch, eg. "races/orcs" or "abilities/seafaring".
	 * @return the corresponding image as an ImageIcon
	 * @see javax.swing.ImageIcon
	 */
	public ImageIcon getComboImage(String location) {
		ImageIcon localImage;
		
		localImage = new ImageIcon("./assets/" 
                + location + ".png");
		 
        Image localimg = localImage.getImage();
        Image newimg = localimg.getScaledInstance(
                240,
                80, 
                java.awt.Image.SCALE_SMOOTH);
        localImage = new ImageIcon(newimg);
        return localImage;
       
	}
	
}
