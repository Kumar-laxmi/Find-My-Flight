import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
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
	
	String[] cities = Result.data;
	
	int[] xco = Result.xco;
	int[] yco = Result.yco;
	
	JButton connect, reset;
	JLabel lblTo, lblFrom;
	JPanel result;
	JLabel lblHeading;
	JLabel backgroundImage;
	JLabel logoMain;
	
	public StartPage()
	{
		init();
	}
	
	public void init()
	{
		// Instantiation of Frame Components
		backgroundImage = new JLabel(new ImageIcon("Image\\ResultPanelBg.png"));
		startFrame = new JFrame("FindMyflight");
		heading = new JPanel();
		map = new JPanel();
		input = new JPanel();
		X = new JLabel("x: ");
		Y = new JLabel("y: ");
		draw = new Canvas() {
			private static final long serialVersionUID = 1L;

			public void paint(Graphics g)
			{
				ImageIcon i = new ImageIcon("Image\\Map.png"); 
				Image image = i.getImage();
				g.drawImage(image, 0, 0, this);
				Graphics2D g2 = (Graphics2D) g;
				
				g2.setColor(new Color(7, 47, 95));
				g2.setStroke(new BasicStroke(15));
				g2.drawLine(0, 0, 660, 0); // Top
				g2.setStroke(new BasicStroke(10));
				g2.drawLine(0,645, 680, 645); // bottom
				g2.drawLine(0,0,0,660); // left
				g2.drawLine(660, 0, 660, 660); // right
				
				ImageIcon i2 = new ImageIcon("Image\\BinaryCoders.png"); 
				Image image2 = i2.getImage();
				g.drawImage(image2, 0, 530, 120,120, this);
				
			}
		};
		from = new JComboBox<Object>(cities);
		to = new JComboBox<Object>(cities);
		connect = new JButton("FIND");
		reset = new JButton("RESET");
		lblFrom = new JLabel("From: ");
		lblTo = new JLabel("To: "); 
		lblHeading = new JLabel(new ImageIcon("Image\\heading2.png"));
		logoMain = new JLabel(new ImageIcon("Image\\LogoMain.png"));
		
		
		// Component Properties
		
		backgroundImage.setBounds(0,0,420,680); 	
		
		X.setVisible(true);
		X.setBounds(320,615,40,30);
		
		
		Y.setVisible(true);
		Y.setBounds(360,615,40,30);
		
		draw.setBounds(0,0,660,680);
		draw.setVisible(true);
		
		heading.setBounds(0,0,1080,100);
		
		from.setBounds(120,380,230,25);
		from.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		lblFrom.setBounds(50,380,230,25);
		lblFrom.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		to.setBounds(120,430,230,25);
		to.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		
		lblTo.setBounds(50,430,230,25);
		lblTo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		connect.setBounds(85, 500, 80, 30);
		connect.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		reset.setBounds(220, 500, 80, 30);
		reset.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lblHeading.setVisible(true);
		lblHeading.setBounds(0,0,1080,100);
		
		logoMain.setBounds(70,50,280,280);
		
		
		
		
		
		//Listeners and Actions
		draw.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					int framex = e.getX();
					int framey = e.getY();
					System.out.println("x: "+framex+", y: "+framey);
					X.setText("x: "+(int)framex);
					Y.setText("y: "+(int)framey);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				for(int i = 0; i < 21; i++)
				{
					boolean checker = e.getX() <= xco[i]+8 && e.getX() >= xco[i]-8 && e.getY() <= yco[i]+8 && e.getY() >= yco[i]-8;
					if(checker)
					{
						
						if(from.getSelectedIndex() == 0)
						{
							from.setSelectedIndex(i);
							greenCircle(draw, new Point(e.getX(), e.getY()),13);
							break;
						}
						else if(to.getSelectedIndex() == 0)
						{
							to.setSelectedIndex(i);
							greenCircle(draw, new Point(e.getX(), e.getY()),13);
							break;
						}
						else
						{
							greenCircle(draw, new Point(e.getX(), e.getY()),13);
							break;
						}
					}
					else
					{
						redCircle(draw, new Point(e.getX(), e.getY()),13);
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
			
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
				boolean checkout = to.getSelectedIndex() == 0 || from.getSelectedIndex() == 0;
				if(!checkout)
				{
					resetCanvas(draw);
					connectDots(draw, Result.random);
//					drawLine(draw, new Point(xco[from.getSelectedIndex()],yco[from.getSelectedIndex()]), new Point(xco[to.getSelectedIndex()],yco[to.getSelectedIndex()]));
					resultPanel(input, (from.getItemAt(from.getSelectedIndex())).toString(), (to.getItemAt(to.getSelectedIndex())).toString());
				}
			}
			
		});
		
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				to.setSelectedIndex(0);
				from.setSelectedIndex(0);
				resetCanvas(draw);
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
		input.add(reset);
		input.add(lblFrom);
		input.add(lblTo);
		input.add(logoMain);
		input.add(backgroundImage);
		
		
		heading.setBounds(0,0,1080,100);
		heading.add(lblHeading);
		
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
		startFrame.setIconImage(new ImageIcon("Image\\Logo.png").getImage());
	}
	
	public void drawLine(Canvas c, Point start, Point end) {
		
		
		Point curve = new Point();
		curve.x = (start.x + end.x)/2 + 20;
		curve.y = (start.y + end.y)/2 + 20;
		
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
		q.setCurve(start, curve, end);
		g2.setColor(new Color(56, 149, 211));
		g2.setStroke(new BasicStroke(3));
		g2.draw(q);
		
		
	}
	
	public void resetCanvas(Canvas c)
	{
		Graphics g = c.getGraphics();
		g.clearRect(0,0,660,680);
		ImageIcon i = new ImageIcon("Image\\Map.png"); 
		Image image = i.getImage();
		g.drawImage(image, 0, 0, c);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(new Color(7, 47, 95));
		g2.setStroke(new BasicStroke(15));
		g2.drawLine(0, 0, 660, 0); // Top
		g2.setStroke(new BasicStroke(10));
		g2.drawLine(0,645, 680, 645); // bottom
		g2.drawLine(0,0,0,660); // left
		g2.drawLine(660, 0, 660, 660); // right
		
		ImageIcon i2 = new ImageIcon("Image\\BinaryCoders.png"); 
		Image image2 = i2.getImage();
		g.drawImage(image2, 0, 530, 120,120, c);
	}
	
	public void redCircle(Canvas c, Point center, int radius)
	{
		Graphics g = c.getGraphics();
		g.setColor(Color.red);
		Graphics2D g2 = (Graphics2D) g;
		for(double i = 0; i < radius; i += 0.5)
		{
			Shape circle = new Ellipse2D.Double(center.x-(i/2), center.y-(i/2), i, i);
			g2.draw(circle);
		}
	}
	
	public void greenCircle(Canvas c, Point center, int radius)
	{
		Graphics g = c.getGraphics();
		g.setColor(Color.green);
		Graphics2D g2 = (Graphics2D) g;
		for(double i = 0; i < radius; i += 0.5)
		{
			Shape circle = new Ellipse2D.Double(center.x-(i/2), center.y-(i/2), i, i);
			g2.draw(circle);
		}
	}
	
	public void resultPanel(JPanel panel, String From, String To) {
		
		// Initialzation
		panel.setVisible(false);
		result = new JPanel();
		result.setBounds(panel.getBounds());
		result.setVisible(true);
		
		From = From.split(" ", 2)[0];
		To = To.split(" ", 2)[0];
		
		
		// Initializations and Declarations
		JLabel logoMain = new JLabel(new ImageIcon("Image\\LogoMain.png"));
		JButton back = new JButton("BACK");
		JLabel background = new JLabel(new ImageIcon("Image\\ResultPanelBg.png"));
		JPanel pDistance = new JPanel(new FlowLayout());
		JPanel pTime = new JPanel(new FlowLayout());
		JPanel pCost = new JPanel(new FlowLayout());
		JTabbedPane tab = new JTabbedPane();
		
		JLabel effDistance = new JLabel();
		JLabel effCost = new JLabel();
		JLabel effTime = new JLabel();
		
		effDistance.setText("<html><b><center><h3>"+From+" -> "+To+"</h3></center><h3></b><font color = \"green\">Distance: "+
				Result.shortestDistance()[0]+"</font><br>Cost: "+Result.shortestDistance()[1]+"<br>Time: "+
				Result.shortestDistance()[2]+"</h3><center><h3>-----ROUTE-----</h3><font color = \"red\">SXR -> DEL -> JAI</center></html>");
		effCost.setText("<html><b><center><h3>"+From+" -> "+To+"</h3></center><h3></b>Distance: "+
				Result.shortestDistance()[0]+"<br><font color = \"green\">Cost: "+Result.shortestDistance()[1]+"<br></font>Time: "+
				Result.shortestDistance()[2]+"</h3><center><h3>-----ROUTE-----</h3><font color = \"red\">SXR -> DEL -> JAI</center></html>");
		effTime.setText("<html><b><center><h3>"+From+" -> "+To+"</h3></center><h3></b>Distance: "+
				Result.shortestDistance()[0]+"<br>Cost: "+Result.shortestDistance()[1]+"<br><font color = \"green\">Time: "+
				Result.shortestDistance()[2]+"</font></h3><center><h3>-----ROUTE-----</h3><font color = \"red\">SXR -> DEL -> JAI</center></html>");
		
		
		// Component Properties
		logoMain.setBounds(70,50,280,280);
		
		back.setBounds(170, 580, 80, 30);
		back.setVisible(true);
		
		background.setBounds(0,0,420,680);
		background.setVisible(true);
		
		tab.setBounds(70,330,280,220);
		tab.setVisible(true);
		
		
		
		// Component Actions and Listeners
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				result.setVisible(false);
				panel.setVisible(true);
			}
			
		});
		
		
		pDistance.add(effDistance);
		pCost.add(effCost);
		pTime.add(effTime);
		
		tab.add("Distance",pDistance);
		tab.add("Cost",pCost);
		tab.add("Time",pTime);
		
		result.add(back);
		result.add(logoMain);
		result.add(tab);
		result.add(background);
		result.setLayout(null);
		startFrame.add(result);
	}
	
	public Point toPoint(String s)
	{
		int i = 1;
		String temp = "Inside to Point";
		System.out.println(temp);
		boolean check = false;
		for(i = 1; i < 21; i++)
		{
			temp = cities[i].split(" ", 2)[1];
			System.out.println(temp);
			temp = temp.substring(1, temp.length()-1);
			System.out.println(temp);
			if(temp.equals(s))
			{
				check = true;
				break;
			}
		}
		if(check)
		{
			System.out.println(temp);
			System.out.println(xco[i]+", "+yco[i]);
			return new Point(xco[i],yco[i]);
		}
		else {
			return new Point(0,0);
		}
		
	}
	
	public void connectDots(Canvas c, String[] list)
	{
		for(int i = 0; i < list.length-1; i++)
		{
			System.out.println("Inside Draw Line");
			greenCircle(c, toPoint(list[i]),13);
			greenCircle(c, toPoint(list[i+1]),13);
			drawLine(c,toPoint(list[i]),toPoint(list[i+1]));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
