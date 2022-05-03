import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.QuadCurve2D.Float;

import javax.swing.*;

public class StartPage {
	
	JFrame startFrame;
	JPanel heading;
	JPanel map;
	JPanel input;
	JLabel X, Y;
	Canvas draw;
	JComboBox<?> from, to;
	
	String[] toData = {"TO","DEL","BOM","BLR","HYD","CCU","MAA","AMD","GOI","PAT","COK","LKO","GAU","PNQ","JAI","SXR","BBI","IXB","VNS",
			"IXC","IXR"};
	String[] fromData = {"FROM","DEL","BOM","BLR","HYD","CCU","MAA","AMD","GOI","PAT","COK","LKO","GAU","PNQ","JAI","SXR","BBI","IXB","VNS",
			"IXC","IXR"};
	
	String[] xco = {"0","211","109","211","238","458","277","107","130","398","182","288","540","156","182","162","413","460","336","206","392"};
	String[] yco = {"0","190","390","524","427","318","530","301","466","249","586","222","227","405","223","63","355","223","259","143","297"};
	
	JButton connect;
	
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
		X = new JLabel("x: ");
		Y = new JLabel("y: ");
		draw = new Canvas() {
			private static final long serialVersionUID = 1L;

			public void paint(Graphics g)
			{
				ImageIcon i = new ImageIcon("src\\Map.png"); 
				Image image = i.getImage();
				g.drawImage(image, 0, 0, this);
			}
		};
		from = new JComboBox<Object>(fromData);
		to = new JComboBox<Object>(toData);
		connect = new JButton("FIND!");
		
		// Component Properties
		
		X.setVisible(true);
		X.setBounds(320,615,40,30);
		
		
		Y.setVisible(true);
		Y.setBounds(360,615,40,30);
		
		draw.setBounds(0,0,660,680);
		draw.setVisible(true);
		
		heading.setBounds(0,0,1080,100);
		heading.setBackground(Color.yellow);
		
		from.setBounds(50,50,100,20);
		from.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		to.setBounds(200,50,100,20);
		to.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		connect.setBounds(125, 100, 80, 30);
		connect.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		//Listeners and Actions
		draw.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					int framex = e.getX();
					int framey = e.getY();
					System.out.println("x: "+framex+", y: "+framey);
					X.setText("x: "+(int)framex);
					Y.setText("y: "+(int)framey);
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
		
		to.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(to.getItemAt(to.getSelectedIndex()).equals(from.getItemAt(from.getSelectedIndex())))
					to.setSelectedIndex(0);
				
			}
			
		});
		
		from.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(to.getItemAt(to.getSelectedIndex()).equals(from.getItemAt(from.getSelectedIndex())))
					from.setSelectedIndex(0);
			}
			
		});
		
		connect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resetCanvas(draw);
				drawLine(draw, new Point(Integer.parseInt(xco[from.getSelectedIndex()]),Integer.parseInt(yco[from.getSelectedIndex()])), new Point(Integer.parseInt(xco[to.getSelectedIndex()]),Integer.parseInt(yco[to.getSelectedIndex()])));
			}
			
		});
		
		//Panel Properties
		map.setBounds(0,100,660,680);
		map.add(draw);
		
		input.setBounds(660,100,420,680);
		input.add(X);
		input.add(Y);
		input.add(from);
		input.add(to);
		input.add(connect);
		
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
	
	public void drawLine(Canvas c, Point start, Point end) {
		
		Graphics g = c.getGraphics();
		Graphics2D g2 = (Graphics2D) g;
		final float dash1[] = {10.0f};
	    final BasicStroke dashed = new BasicStroke(1.0f,
	                        BasicStroke.CAP_BUTT,
	                        BasicStroke.JOIN_MITER,
	                        10.0f, dash1, 0.0f);
	    g2.setStroke(dashed);
		g2.drawLine(start.x, start.y, end.x, end.y);
		
		Float q = new QuadCurve2D.Float();
		q.setCurve(start, new Point(330,340), end);
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(2));
		g2.draw(q);
		
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
