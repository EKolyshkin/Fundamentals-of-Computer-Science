/* Egor Kolyshkin, CS 210, 11/4/2020
 * Chapter 3G Quiz */

import java.awt.*;

public class SquareFaceX
{
	public static void main(String[] args)
	{
		// sets drawing panel and graphics
		DrawingPanel panel = new DrawingPanel(800, 800);
		panel.setBackground(Color.WHITE);
		Graphics g = panel.getGraphics();
		
		int x = 25;	// initial x and y positions
		int y = 25;	// ((800 - (50 * 15)) / 2)
		
		for (int i = 1; i <= 15; i++)		// loops 15 times for each column
		{
			for (int j = 1; j <= 2; j++)	// loops 2 times for each square in row
			{								// (center square is drawn twice)
				g.setColor(Color.BLACK);
				g.drawRect(x, y, 50, 50);			// face outline
			
				g.setColor(Color.BLUE);
				g.fillOval(x + 10, y + 15, 10, 10);	// eyes
				g.fillOval(x + 30, y + 15, 10, 10);
			
				g.setColor(Color.RED);				// mouth
				g.drawLine(x + 15, y + 35, x + 35, y + 35);
				
				y = 750 - y;
			}
			x += 50;			// moves x and y to next square
			y = 25 + 50 * i;	// (starting from top one)
		}
	}
}
