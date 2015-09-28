package view.popup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.ChessModel;

import controller.ChessControl;


public class CheckMatePopUp extends JFrame	{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ChessControl controller;

	public CheckMatePopUp(final ChessModel model)	{
		
		controller = model.getController();
		
		JPanel center = new JPanel();
		center.setBackground(new Color(30, 123, 103));
		setTitle("GAME OVER!");
		
		JLabel pic = new JLabel(new ImageIcon("img/chesses2.png"));
		pic.setBackground(new Color(30, 123, 103));
		center.add(pic);
		
		/* South panel */
		
		JPanel south = new JPanel();
				
		south.setLayout(new GridLayout(2, 1));
		south.setBackground(new Color(30, 123, 103));
		
		JPanel southFirst = new JPanel();
		southFirst.setBackground(new Color(30, 123, 103));
		southFirst.setLayout(new GridLayout(3, 1));
		
		JPanel centralMenu = new JPanel();
		centralMenu.setBackground(new Color(30, 123, 103));
		
		JPanel southButton = new JPanel();
		southButton.setBackground(new Color(30, 123, 103));
	
		JLabel message = new JLabel("Warning: THERE'S A CHECKMATE.");
		message.setFont(new Font("Ubuntu Mono", Font.BOLD, 30));
		message.setForeground(Color.WHITE);
		message.setHorizontalAlignment(JLabel.CENTER);
		southFirst.add(message);
		//south.add(southFirst);
		
		String color = "Sorry " + ((controller.getModel()).isWhiteTurn() ? "BLACK! " : "WHITE! ");		
		JLabel youlost = new JLabel(color + "You lost! :(");
		youlost.setFont(new Font("Ubuntu Mono", Font.PLAIN, 30));
		youlost.setForeground(Color.YELLOW);
		youlost.setHorizontalAlignment(JLabel.CENTER);
		southFirst.add(youlost);
		south.add(southFirst);
		
		JLabel doom = new JLabel("Here's your doom");
		doom.setFont(new Font("Ubuntu Mono", Font.ITALIC, 15));
		doom.setHorizontalAlignment(JLabel.CENTER);
		doom.setForeground(Color.WHITE);
		southFirst.add(doom);
		south.add(southFirst);
		
		JMenuBar bar = new JMenuBar();
		
		JMenu menu = new JMenu("Press here, NOW!");
		menu.setBackground(Color.WHITE);
		final JMenuItem firstItem = new JMenuItem("Start again!");
		/*firstItem.setRolloverEnabled(false);*/
		firstItem.setBackground(Color.WHITE);
		final JMenuItem secondItem = new JMenuItem("I don't wanna play.");
		JMenuItem thirdItem = new JMenuItem("Undo");
		
		firstItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                
            	model.setController(new ChessControl());
				controller.getHistory().restart();
				controller.start();
				
				dispose();
				
				model.getView().onConfigurationChange();
            	
            }
        });
		
		secondItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	System.exit(0);
            }
        });
		
		thirdItem.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent arg0)	{
				dispose();
			}
		});
		
		
		centralMenu.add(bar);
		menu.add(firstItem);
		menu.add(secondItem);
		menu.add(thirdItem);
		centralMenu.add(menu);
		south.add(centralMenu);
		bar.add(menu);
				
	
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);

		
		this.setLocation(584, 184);
		
	}

		
		
		
}