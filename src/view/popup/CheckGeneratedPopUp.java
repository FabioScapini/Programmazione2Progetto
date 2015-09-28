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


public class CheckGeneratedPopUp extends JFrame {

	private static final long serialVersionUID = 1L;

	public CheckGeneratedPopUp ()	{
			
	JPanel center = new JPanel();
	center.setBackground(new Color(204, 84, 68));
	
	setTitle("GAME OVER!");
			
	JLabel pic = new JLabel(new ImageIcon("img/chesses3.png"));
	pic.setBackground(new Color(204, 84, 68));
	center.add(pic);
			
	/* South panel */
			
	JPanel south = new JPanel();
					
	south.setLayout(new GridLayout(3, 1));
	south.setBackground(new Color(204, 84, 68));
			
	JPanel southFirst = new JPanel();
	southFirst.setBackground(new Color(204, 84, 68));
	/*southFirst.setLayout(new GridLayout(2, 1));*/
			
	JPanel southSecond = new JPanel();
	southSecond.setBackground(new Color(204, 84, 68));	
			
	JPanel southThird = new JPanel();
	southThird.setBackground(new Color(204, 84, 68));
		
	JLabel message = new JLabel("WARNING");
	message.setFont(new Font("Ubuntu Mono", Font.BOLD, 30));
	message.setForeground(Color.WHITE);
	message.setHorizontalAlignment(JLabel.CENTER);
	southFirst.add(message);
	south.add(southFirst);
			
	JLabel messageBelow = new JLabel("This move generates a check!");
	messageBelow.setFont(new Font("Ubuntu Mono", Font.ITALIC, 25));
	messageBelow.setForeground(Color.WHITE);
	messageBelow.setHorizontalAlignment(JLabel.CENTER);
	southSecond.add(messageBelow);
	south.add(southSecond);
			
	final JButton OK = new JButton("OK");
	OK.setBackground(Color.WHITE);
	OK.setPreferredSize(new Dimension(200, 50));
	OK.addActionListener(new ActionListener(){

	public void actionPerformed(ActionEvent arg0) {
		dispose();
		}
	});
			
	southThird.add(OK);
	south.add(southThird);
		
	add(center, BorderLayout.CENTER);
	add(south, BorderLayout.SOUTH);
			
	pack();
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setAlwaysOnTop(true);

	this.setLocation(584, 184);
	}
}
		


