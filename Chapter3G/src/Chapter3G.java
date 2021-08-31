/* Egor Kolyshkin, CS 210, 11/4/2020
 * Exercises 1 and 2, 3 and 4, 5 and 6 */

import java.awt.*;

public class Chapter3G
{
	public static void main(String[] args)
	{
		// sets up graphics and drawing panel
		DrawingPanel panel = new DrawingPanel(450, 150);
		panel.setBackground(Color.YELLOW);
		Graphics g = panel.getGraphics();
		
		// Exercise 2 output
		drawFigure(g, 50, 25);
		drawFigure(g,  250, 45);
		
		// Exercise 4 output
		panel = new DrawingPanel(520, 180);
		panel.setBackground(Color.WHITE);
		g = panel.getGraphics();
		Face(g, 10, 30);
		Face(g, 110, 30);
		Face(g, 210, 30);
		Face(g, 310, 30);
		Face(g, 410, 30);
		
		// Exercise 6 output
		showDesign(300, 100);
	}

	public static void drawFigure(Graphics g, int x, int y)
	{
		// draws ovals
		g.setColor(Color.BLUE);
		g.fillOval(x, y, 40, 40);
		g.fillOval(x + 80, y, 40, 40);
		
		// draws square
		g.setColor(Color.RED);
		g.fillRect(x + 20, y + 20, 80, 80);
		
		// draws line
		g.setColor(Color.BLACK);
		g.drawLine(x + 20, y + 60, x + 100, y + 60);
	}

	public static void Face(Graphics g, int x, int y)
	{
		g.setColor(Color.BLACK);
		g.drawOval(x, y, 100, 100);   // face outline
	
		g.setColor(Color.BLUE);
		g.fillOval(x + 20, y + 30, 20, 20);     // eyes
		g.fillOval(x + 60, y + 30, 20, 20);
	
		g.setColor(Color.RED);          // mouth
		g.drawLine(x + 30, y + 70, x + 70, y + 70);
	}

	public static void showDesign(int x, int y)
	{
		DrawingPanel panel = new DrawingPanel(x, y);
		panel.setBackground(Color.WHITE);
		Graphics g = panel.getGraphics();
		
		g.setColor(Color.BLACK);
		
		int xx = x / 10;
		int yy = y / 10;
		
		for (int i = 1; i <= 4; i++)
		{
			g.drawRect(xx, yy, x - (xx * 2), y - (yy * 2));
			xx += x / 10;
			yy += y / 10;
		}
	}
}
