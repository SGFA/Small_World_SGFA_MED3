package client_package;

import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;

import org.newdawn.slick.AppletGameContainer;
import org.newdawn.slick.AppletGameContainer.Container;
import org.newdawn.slick.Game;

import javafx.stage.PopupWindow;

public class Popup extends JDialog {

	public Popup () {
	
	this.setTitle("Stack Shop");
    this.setSize(230, 200);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.getContentPane().setLayout(new GridLayout(4, 2));
    this.setResizable(false);
    this.setVisible(true);

	}
}
