import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class PointConnect extends Canvas{
	
	
	private static final long serialVersionUID = 1L;
	Point start;
	Point end;

	PointConnect(Point a, Point b)
	{
		start = new Point(a.x,a.y);
		end = new Point(b.x,b.y);
		setForeground(Color.RED);
	}
	
	public void paint(Graphics g)
	{
		ImageIcon i = new ImageIcon("./src/Map.png"); 
		Image image = i.getImage();
		g.drawImage(image, 0, 0, this);
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(3));
		g.drawLine(start.x, start.y, end.x, end.y);
	}

}
