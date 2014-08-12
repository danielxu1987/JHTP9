package org.drawings;

import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JPanel;

/** Draw lines from the top-left corner, 
 fanning them out until they cover the 
 upper-left half of the panel */
public class DrawFanningLines1 extends JPanel {

	public void paintComponent(Graphics g)
	{
		// call super class to ensure the panel displays correctly
		super.paintComponent(g);
		
		int width = getWidth(); // total width of display
		int height = getHeight(); // total height
		
		double dx = width / 15;
		double dy = height / 15;
		
		int[][] corners = getCornerCoordinates(width, height);
		
		double[][] slashPoints = 
				getEndPointsSlash(dx, dy, width, height);
		double[][] backSlashPoints = 
				getEndPointsBackSlash(dx, dy, width, height);
	
		for(int i = 0; i < slashPoints.length; i++)
		{
			g.drawLine((int)backSlashPoints[0][0], (int)backSlashPoints[0][1], 
					(int)slashPoints[i][0], (int)slashPoints[i][1]);
			
			g.drawLine((int)backSlashPoints[backSlashPoints.length - 1][0], 
					(int)backSlashPoints[backSlashPoints.length - 1][1], 
					(int)slashPoints[i][0], (int)slashPoints[i][1]);
		}
		
		for(int j = 0; j < backSlashPoints.length; j++)
		{
			g.drawLine((int)slashPoints[0][0], (int)slashPoints[0][1], 
					(int)backSlashPoints[j][0], (int)backSlashPoints[j][1]);
			
			g.drawLine((int)slashPoints[slashPoints.length - 1][0], 
					(int)slashPoints[slashPoints.length - 1][1], 
					(int)backSlashPoints[j][0], 
					(int)backSlashPoints[j][1]);
		}
		
//		int startPointX, startPointY;
//		double endPointX, endPointY;
//		
//		// start from top-left corner
//		startPointX = 0;
//		startPointY = 0;
//		endPointX = width;
//		endPointY = 0;
//		
//		// this function draws fanning lines from all the 4 corners
//		while (endPointX > 0)
//		{
//			g.drawLine(startPointX, startPointY, 
//					(int)endPointX, (int)endPointY);
//			endPointX = endPointX - dx;
//			endPointY = endPointY + dy;
//		}
//		
//		// start from bottom-left corner
//		startPointX = 0;
//		startPointY = height;
//		endPointX = 0;
//		endPointY = 0;
//		
//		while (endPointX < width)
//		{
//			g.drawLine(startPointX, startPointY,
//					(int)endPointX, (int)endPointY);
//			endPointX = endPointX + dx;
//			endPointY = endPointY + dy;
//		}
//		
//		// start from top-right corner
//		startPointX = width;
//		startPointY = 0;
//		endPointX = 0;
//		endPointY = 0;
//		
//		while (endPointX < width)
//		{
//			g.drawLine(startPointX, startPointY, 
//					(int)endPointX, (int)endPointY);
//			endPointX = endPointX + dx;
//			endPointY = endPointY + dy;
//		}
//		
//		// start from bottom-right corner
//		startPointX = width;
//		startPointY = height;
//		endPointX = width;
//		endPointY = 0;
//		
//		while (endPointX > 0)
//		{
//			g.drawLine(startPointX, startPointY, 
//					(int)endPointX, (int)endPointY);
//			endPointX = endPointX - dx;
//			endPointY = endPointY + dy;
//		}
	}

	/** construct the corner coordinates */
	private int[][] getCornerCoordinates(int width, int height) {
		// assign corner coordinate values to 2D array (4 x 2)
		// element order: top-left, top-right, bottom-left, bottom-right 
		int[][] corners = new int[4][2];
		
		corners[0] = new int[] {0, 0};
		corners[1] = new int[] {width, 0};
		corners[2] = new int[] {0, height};
		corners[3] = new int[] {width, height};
		
		return corners;
	}

	private double[][] getEndPointsBackSlash(double dx, double dy,
			int width, int height)
	{	
		double[][] backSlashPoints = new double[16][2];
		
		double[] previousPoint = new double[] {0, 0};
		backSlashPoints[0] = previousPoint;
		
		double widthIncrement = width / 15;
		double heightIncrement = height / 15;
		
		for(int i = 1; i < backSlashPoints.length; i++)
		{
			// assign coordinate values to the 2D array (16 x 2)
			// element order: from top to bottom
			backSlashPoints[i] = new double[] 
					{previousPoint[0] + widthIncrement, 
					previousPoint[1] + heightIncrement}; 
			
			previousPoint = backSlashPoints[i];
		}
		
		return backSlashPoints;
	}

	private double[][] getEndPointsSlash(double dx, double dy, 
			int width, int height) 
	{
		double[][] slashPoints = new double[16][2];
		
		double[] previousPoint = new double[] {width, 0};
		slashPoints[0] = previousPoint;
		
		double widthIncrement = width / 15;
		double heightIncrement = height / 15;
		
		for(int i = 1; i < slashPoints.length; i++)
		{
			// assign coordinate values to the 2D array (16 x 2)
			// element order: from top to bottom
			slashPoints[i] = new double[] 
					{previousPoint[0] - widthIncrement, 
					previousPoint[1] + heightIncrement}; 
			
			previousPoint = slashPoints[i];
		}
		
		return slashPoints;
	}
}