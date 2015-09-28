package view.popup;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;

public class Exit extends JFrame {

	
	private static final long serialVersionUID = 1L;


	public Exit()	{
		setTitle("Are you sure?");
		
		JPanel north = new JPanel();
		north.setLayout(new GridLayout(2, 1));
		north.setBackground(new Color(34,74,68));
		
		JLabel message = new JLabel("Do you really wanna exit?");
		message.setFont(new Font("Ubuntu Mono", Font.PLAIN, 20));
		message.setForeground(Color.WHITE);
		message.setBackground(new Color(34,74,68));
		message.setHorizontalAlignment(JLabel.CENTER);
		north.add(message);
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(2,3));
		
		
		JPanel col1 = new JPanel();
		col1.setBackground(new Color(34, 74, 68));
		center.add(col1);
		
		JButton YES = new JButton("Sure.");
		YES.setBackground(Color.WHITE);
		YES.setForeground(Color.BLACK);
		YES.setBorderPainted(false);
		YES.setFocusPainted(false);
		
		
		JPanel col2 = new JPanel();
		col2.setBackground(new Color(34, 74, 68));
		
		
		JButton NO = new JButton("Just Kidding!");
		NO.setBackground(Color.BLACK);
		NO.setForeground(Color.WHITE);
		NO.setBorderPainted(false);
		NO.setFocusPainted(false);
		
		YES.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
			
		});
		
		center.add(YES);
		center.add(col2);
		
		NO.addActionListener(new ActionListener()	{

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		JPanel col3 = new JPanel();
		col3.setBackground(new Color(34, 74, 68));
		center.add(col3);
		
		center.add(NO);
		
		JPanel col4 = new JPanel();
		col4.setBackground(new Color(34, 74, 68));
		center.add(col4);
		
		JPanel south = new JPanel();
		south.setBackground(new Color(34,74,68));
		
		add(north, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		
		
		
		setVisible(true);
		this.setLocation(500, 300);
		pack();
		
	}



}
