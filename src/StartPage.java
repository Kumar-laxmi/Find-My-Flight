import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class StartPage {
	
	JFrame startFrame;
	JPanel heading;
	JPanel map;
	JPanel input;
	PointConnect connect;
	Point start, end;
	JLabel X, Y;
	
	public StartPage()
	{
		init();
	}
	
	public void init()
	{
		input = new JPanel();
		X = new JLabel("X Coordinate is: ");
		Y = new JLabel("Y Coordinate is: ");
		
		
		start = new Point(109,389);
		end = new Point(459,318);
		
		startFrame = new JFrame();
		heading = new JPanel();
		map = new JPanel();
		
		
		X.setVisible(true);
		Y.setVisible(true);
		X.setBounds(50,200,170,40);
		Y.setBounds(50,300,170,40);
		
		connect = new PointConnect(start,end);
		connect.setBounds(0,0,660,680);
		connect.setVisible(true);
		connect.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				double framex = e.getX();
				double framey = e.getY();
				X.setText("X Coordinate is: "+framex);
				Y.setText("Y Coordinate is: "+framey);
				
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
		
		
		
		map.setBounds(420,100,660,680);
		map.add(connect);
		
		input.setBounds(0,100,420,620);
		input.add(X);
		input.add(Y);
		
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
