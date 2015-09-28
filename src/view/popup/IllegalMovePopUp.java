package view.popup;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IllegalMovePopUp extends JFrame{
	
	private static final long serialVersionUID = 1L;

	private final int DEFAULT_WIDTH = 250;
	private final int DEFAULT_HEIGHT = 100;
	
	public IllegalMovePopUp() {
		
		setTitle("THIS IS ILLEGAL");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setBackground(Color.WHITE);
		
		JPanel north = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();
		
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		
		final JButton OK = new JButton("OK");
		OK.setBorderPainted(false);
        OK.setFocusPainted(false); 
        OK.setBackground(Color.WHITE);
		
		/* Panel p1 */
		JLabel InvalidMove = new JLabel("Invalid Move!");
		InvalidMove.setFont(new Font("Ubuntu Mono", Font.BOLD, 25));
		JLabel tryAgain = new JLabel("Try Again! You'll be luckier :)");
		tryAgain.setFont(new Font("Ubuntu Mono", Font.ITALIC, 15));
		
		north.setBackground(new Color(153, 77, 77));
		center.setBackground(new Color(153, 77, 77));
		south.setBackground(new Color(153, 77, 77));
		
		south.setLayout(new GridLayout(2,1));
		//Color backgroundColor = new Color(255,255,255);
		
		//SsetBackground(backgroundColor);
		
	
		p2.setBackground(new Color(153, 77, 77));
		p2.add(InvalidMove);
		center.add(p2);
		
		p3.setBackground(new Color(153, 77, 77));
		p3.add(tryAgain);
		south.add(p3);
		
		OK.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
			
		});
		
		p4.add(OK);
		p4.setBackground(new Color(153, 77, 77));
		 
		south.add(p3);
		south.add(p4);
		
		add(north, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		
		pack();
		
		setVisible(true);
		setAlwaysOnTop(true);
		this.setLocation(500, 300);
	}

}
