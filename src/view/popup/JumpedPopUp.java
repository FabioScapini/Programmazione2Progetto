package view.popup;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.ChessModel;

public class JumpedPopUp extends JFrame {
		
	private static final long serialVersionUID = 1L;
	private int DEFAULT_WIDTH = 350;
	private int DEFAULT_HEIGHT = 225;
	private Color color = new Color(205, 92, 92);
	
	public JumpedPopUp(int x, int y, ChessModel model){
		
		setTitle("Invalid Move!");
		setBackground(color);
		
		JPanel complete = new JPanel();
		complete.setBackground(color);
		
		JPanel top = new JPanel();
		top.setBackground(color);
		JPanel bottom = new JPanel();
		bottom.setBackground(color);
	
		final JButton OK = new JButton("OK");
		
		complete.setLayout(new GridLayout(2,1));
		top.setLayout(new GridLayout(2,1));
		bottom.setLayout(new GridLayout(1,2));
		
		JLabel image = new JLabel(model.getTable()[x][y].printImage());
		image.setBackground(color);
		image.setSize(80, 80);
		bottom.add(image);
		
		JLabel message = new JLabel("The " + model.getTable()[x][y].getColor()+" "
				+model.getTable()[x][y].getName());
		message.setBackground(color);
		
		message.setFont(new Font("Ubuntu Mono", Font.BOLD, 30));
		message.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel message2 = new JLabel("has been jumped!");
		message2.setBackground(color);
		
		message2.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		message2.setHorizontalAlignment(JLabel.CENTER);
		
		top.add(message);
		top.add(message2);
		
		OK.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
			
		});
		
		OK.setVerticalAlignment(JButton.CENTER);
		
		JPanel p = new JPanel();
		p.setBackground(color);
		
		p.add(OK);
		p.setAlignmentX(SwingConstants.CENTER);
		p.setAlignmentY(SwingConstants.CENTER);
		bottom.add(p);
		
		complete.add(top);
		complete.add(bottom);
		
		add(complete, BorderLayout.CENTER);
		
		pack();
		
		setVisible(true);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setAlwaysOnTop(true);
		setLocation(500,300);
	}
		
}
