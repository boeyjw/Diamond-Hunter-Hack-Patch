// The entry point of the game.
// This class loads up a JFrame window and
// puts a GamePanel into it.

package com.neet.DiamondHunter.Main;

import javax.swing.JFrame;

public class Game {

	private static JFrame window;
	
	public static void main(String[] args) {
		window = new JFrame("Diamond Hunter");
		GamePanel gp = new GamePanel();
		window.add(gp);
		
		window.setResizable(false);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static JFrame getWindow() {
		return window;
	}
	
}


