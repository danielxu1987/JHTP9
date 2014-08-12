package org.drawings;

import javax.swing.JFrame;

public class DrawFanningLines1Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create a panel that contains our drawing
		DrawFanningLines1 panel = new DrawFanningLines1();
		
		JFrame appliaction = new JFrame();
		
		appliaction.add(panel);
		appliaction.setSize(250, 250);
		appliaction.setVisible(true);
	}

}