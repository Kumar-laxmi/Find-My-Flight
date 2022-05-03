import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class StartPage {
	
	JFrame startFrame;
	JPanel heading;
	JPanel map;
	JPanel input;
	Point start, end;
	JLabel X, Y;
	Canvas draw;
	JToggleButton tStart;
	
	public StartPage()
	{
		init();
	}
	
	public void init()
	{
		// Instantiation of Frame Components
		startFrame = new JFrame();
		heading = new JPanel();
		map = new JPanel();
		input = new JPanel();
		tStart = new JToggleButton("Start");
		X = new JLabel("X Coordinate is: ");
		Y = new JLabel("Y Coordinate is: ");
		start = new Point(109,389);
		end = new Point(459,318);
		draw = new Canvas() {
			private static final long serialVersionUID = 1L;

			public void paint(Graphics g)
			{
				ImageIcon i = new ImageIcon("src\\Map.png"); 
				Image image = i.getImage();
				g.drawImage(image, 0, 0, this);
			}
		};
		
		// Component Properties
		tStart.setBounds(50, 500, 100, 50);
		
		X.setVisible(true);
		X.setBounds(50,200,170,40);
		
		Y.setVisible(true);
		Y.setBounds(50,300,170,40);
		
		draw.setBounds(0,0,660,680);
		draw.setVisible(true);
		
		heading.setBounds(0,0,1080,100);
		heading.setBackground(Color.yellow);
		
		//Listeners and Actions
		draw.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					int framex = e.getX();
					int framey = e.getY();
					System.out.println("x: "+framex+", y: "+framey);
					X.setText("X Coordinate is: "+framex);
					Y.setText("Y Coordinate is: "+framey);
					drawLine(draw,start,end);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
			
		});
		
		//Panel Properties
		map.setBounds(0,100,660,680);
		map.add(draw);
		
		input.setBounds(660,100,420,620);
		input.add(X);
		input.add(Y);
		input.add(tStart);
		
		map.setLayout(null);
		input.setLayout(null);
		heading.setLayout(null);
		
		//Frame Properties
		startFrame.setLayout(null);
		startFrame.add(heading);
		startFrame.add(map);
		startFrame.add(input);
		startFrame.setResizable(false);
		startFrame.setVisible(true);
		startFrame.setSize(1080,780);
	}
	
	public void drawLine(Canvas c, Point start, Point mouseEntered) {
		
		Graphics g = c.getGraphics();
		Graphics2D g2 = (Graphics2D) g;
		final float dash1[] = {10.0f};
	    final BasicStroke dashed = new BasicStroke(1.0f,
	                        BasicStroke.CAP_BUTT,
	                        BasicStroke.JOIN_MITER,
	                        10.0f, dash1, 0.0f);
	    g2.setStroke(dashed);
	    g2.setBackground(Color.RED);
		g2.drawLine(start.x, start.y, end.x, end.y);
		
	}
	
	public void resetCanvas(Canvas c)
	{
		Graphics g = c.getGraphics();
		g.clearRect(0,0,660,680);
		ImageIcon i = new ImageIcon("src\\Map.png"); 
		Image image = i.getImage();
		g.drawImage(image, 0, 0, c);
		
	}
	
	
	
	

}
