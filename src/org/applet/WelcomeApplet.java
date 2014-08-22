package org.applet;

import java.awt.Graphics;
import javax.swing.JApplet;

public class WelcomeApplet extends JApplet{

	// draw text on applet's background
	public void paint(Graphics g)
	{
		// call superclass version 
		super.paint(g);
		
		// draw a String at x=25 and y=25
		g.drawString("Welcome to Java Web Programming!", 25, 25);
	}
}
