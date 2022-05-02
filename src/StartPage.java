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
		startFrame = new JFrame();
		
		input = new JPanel();
		X = new JLabel("X Coordinate is: ");
		Y = new JLabel("Y Coordinate is: ");
		
		
		
		
		
		start = new Point(109,389);
		end = new Point(459,318);
		
		heading = new JPanel();
		map = new JPanel();
		{
			tStart = new JToggleButton("Start");
			tStart.setBounds(50, 500, 100, 50);
			
			
		}
		
		
		X.setVisible(true);
		Y.setVisible(true);
		X.setBounds(50,200,170,40);
		Y.setBounds(50,300,170,40);
		
		draw = new Canvas() {
			private static final long serialVersionUID = 1L;

			public void paint(Graphics g)
			{
				ImageIcon i = new ImageIcon("src\\Map.png"); 
				Image image = i.getImage();
				g.drawImage(image, 0, 0, this);
			}
		};
		draw.setBounds(0,0,660,680);
		draw.setVisible(true);
		
		
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
					
					Graphics g = draw.getGraphics();
					g.drawLine(framex, framey, framex, framey);
					Graphics2D g2 = (Graphics2D) g;
				    g2.setStroke(new BasicStroke(3));
					g.drawLine(start.x, start.y, end.x, end.y);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		heading.setBounds(0,0,1080,100);
		heading.setBackground(Color.yellow);
		
		
		
		map.setBounds(0,100,660,680);
		map.add(draw);
		
		input.setBounds(660,100,420,620);
		input.add(X);
		input.add(Y);
		input.add(tStart);
		
		map.setLayout(null);
		input.setLayout(null);
		heading.setLayout(null);
		
		startFrame.setLayout(null);
		startFrame.add(heading);
		startFrame.add(map);
		startFrame.add(input);
		startFrame.setResizable(false);
		startFrame.setVisible(true);
		startFrame.setSize(1080,780);
	}
	
	
	
	

}
