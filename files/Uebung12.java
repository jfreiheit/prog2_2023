package uebungen.uebung12;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Shape;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Uebung12 extends JFrame
{
	Canvas canvas;
	JLabel label;
	
	Uebung12()
	{
		super();
		this.setTitle("Uebung 12");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setSize(500,500);
		this.setLocation(200,100);
		this.canvas = new Canvas();
		this.getContentPane().add(this.canvas, BorderLayout.CENTER);
		this.getContentPane().add(this.createNorthPanel(), BorderLayout.NORTH);
		this.getContentPane().add(this.createSouthPanel(), BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	JPanel createNorthPanel()
	{
		JPanel north = new JPanel();
		north.setBackground(Color.GRAY);
		
		// befuellen
		this.label = new JLabel("Quadrat");
		this.label.setForeground(Color.WHITE);
		this.label.setFont(new Font("Verdana", Font.BOLD, 18));
		north.add(this.label);
		
		return north;
	}
	
	JPanel createSouthPanel()
	{
		JPanel south = new JPanel();
		south.setBackground(Color.GRAY);
		JButton shapeBtn = new JButton("circle");
		JButton createBtn = new JButton("create");
		
		south.add(shapeBtn);
		south.add(createBtn);
		
		return south;
	}
	
	class Canvas extends JPanel
	{
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			
			int widthPanel = this.getWidth();
			int heightPanel = this.getHeight();
			
			double xDashed,yDashed,lengthDashed;
			
			if(widthPanel > heightPanel)
			{
				yDashed = heightPanel/10.0;
				lengthDashed = heightPanel - 2.0 * yDashed;
				xDashed = (widthPanel - lengthDashed) / 2.0;

			}
			else
			{
				xDashed = widthPanel/10.0;
				lengthDashed = widthPanel - 2.0 * xDashed;
				yDashed = (heightPanel - lengthDashed) / 2.0;
			}
			
			g2.setStroke(new BasicStroke(3.0f, 
					BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER,
                    10.0f, 
                    new float[] {10.0f}, 
                    0.0f));
			Shape s = new Rectangle2D.Double(xDashed, yDashed, lengthDashed, lengthDashed);
			g2.draw(s);
		}
	}
	
	public static void main(String[] args) 
	{
		new Uebung12();

	}

}
