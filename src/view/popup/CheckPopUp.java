package view.popup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ChessModel;


public class CheckPopUp extends JFrame {
		
	private static final long serialVersionUID = 1L;

	public CheckPopUp(ChessModel model)	{
		
		/* Setting center panel */
		
		String color = "Hei " + (model.isWhiteTurn() ? "BLACK! " : "WHITE! ");
		
		JPanel center = new JPanel();
		center.setBackground(new Color(51,51,102));
		setTitle("OH NO!");
		
		JLabel pic = new JLabel(new ImageIcon("img/chesses.png"));
		pic.setBackground(new Color(51, 51, 102));
		center.add(pic);
		
		/* South panel */
		
		JPanel south = new JPanel();
				
		south.setLayout(new GridLayout(3, 1));
		south.setBackground(new Color(51, 51, 102));
		
		JPanel southFirst = new JPanel();
		southFirst.setBackground(new Color(51, 51, 102));
		southFirst.setLayout(new GridLayout(2, 1));
		
		JPanel southButton = new JPanel();
		southButton.setBackground(new Color(51,51,102));
	
		JLabel message = new JLabel(color+"Warning: THERE'S A CHECK.");
		message.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
		message.setForeground(Color.WHITE);
		message.setHorizontalAlignment(JLabel.CENTER);
		southFirst.add(message);
		south.add(southFirst);
		
		JLabel doom = new JLabel("Suggest: move away your king!");
		doom.setFont(new Font("Ubuntu Mono", Font.ITALIC, 15));
		doom.setHorizontalAlignment(JLabel.CENTER);
		doom.setForeground(Color.WHITE);
		southFirst.add(doom);
		south.add(southFirst);
		
		final JButton OK = new JButton("OK");
		OK.setBackground(Color.WHITE);
		OK.setPreferredSize(new Dimension(200, 50));
		OK.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
			
		});
		
		southButton.add(OK);
		south.add(southButton);
		
	
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
		setAlwaysOnTop(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
