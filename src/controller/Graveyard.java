package controller;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.pieces.Chessman;

public class Graveyard {
	
	private HashSet<Chessman> Wgraves= new HashSet<>();
	private HashSet<Chessman> Bgraves= new HashSet<>();
	private int Wdeath= 0;
	private int Bdeath= 0;
		
	public Graveyard (){
	}
	
	public void add(Chessman piece){
		if(piece.getColor()==Teams.WHITE){
			if(contains(piece)==0)
				Wdeath++;
			Wgraves.add(piece);
		}else{
			if(contains(piece)==0)
				Bdeath++;
			Bgraves.add(piece);
		}
	}
	
	private int contains(Chessman piece) {
		return contains(piece.getName(), piece.getColor());
	}
	
	private int contains(Piece name, Teams color) {
		int count=0;
		
		HashSet<Chessman> graves = color == Teams.WHITE ? Wgraves : Bgraves;
	
		for(Chessman b:graves)
			if(b.getName() == name)	
				count++;
		
		return count;
	}

	public JPanel toVideo(Teams color){
		JPanel panel = new JPanel();
		
		Color col = color == Teams.WHITE ? Color.WHITE : Color.BLACK;
		Color inv = color == Teams.BLACK ? Color.WHITE : Color.BLACK;
				
		int length = color == Teams.WHITE ? Wdeath : Bdeath;
		ImageIcon image = null;
		
		int count;
		
		panel.setBackground(col);
		
		if(length == 0){
			JLabel label = new JLabel("The "+ color +" graveyard is still Empty");
			label.setForeground(inv);
			panel.add(label);
			
		}else{
			panel.setLayout(new GridLayout(length,1));
			
				for(Piece a : Piece.values()){
					count=contains(a,color);
					image= new ImageIcon("img/piece/"+color+"_"+a+".png"); 
					
					JPanel tile = null;
					if(count!=0){
						tile = new JPanel();
						tile.setLayout(new GridLayout(1,3));
						JPanel num = new JPanel();
						JPanel ima = new JPanel();
						JPanel name = new JPanel();
						JLabel label1= new JLabel(count+"x");
						label1.setVerticalAlignment(JLabel.CENTER);
						JLabel label2= new JLabel(a+"");

							num.setBackground(col);
							label1.setForeground(inv);
							ima.setBackground(col);
							name.setBackground(col);
							label2.setForeground(inv);
						
						num.add(label1);
						ima.add(new JLabel(image));
						name.add(label2);
						tile.add(num);
						tile.add(ima);
						tile.add(name);
						panel.add(tile);
					}
				}
			
		}
		return panel;
	}

}
