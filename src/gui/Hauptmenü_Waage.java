package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class Hauptmenü_Waage extends JFrame{
	JFrame f;
	JMenuBar mb;
	JMenu m1, submenu1, submenu2, submenu3;
	JMenuItem mi1, mi2;
	JLabel l1, l2;
	ImageIcon icon1,icon2, icon3, icon4, icon5;
	JButton btn_artikelstamm, btn_waagestamm;
	
	private static final long serialVersionUID = 1L;
	
	public Hauptmenü_Waage(){
		
		// Wurde icon1 ImageIcon erstellt, um das Bild von Ihrer Firma hinzuzufügen. 
		f = new JFrame();
		
		// Dieses Bild als icon1 wurde über erstellte JLabel hinzugefügt. 
		f = new JFrame("Ihre Firma 0.5"+"             "
				+ "                                   "
				+ "                                   "
				+ "                                   "
				+ "                          Hauptmenü");
		
		// Wurde die Messe von JFrame bestimmt. 
		f.setSize(1200,800);
		
		// Wurde Label auf dem Frame hinzugefügt. 
		icon1 = new ImageIcon("C:\\Users\\CC-Student\\eclipse-workspace\\waage\\bilder\\Ihre_Firma_Bild.png");
		//Dieses Bild als icon1 wurde über erstellte JLabel hinzugefügt. 
		l1 = new JLabel(icon1);
		l1.setBounds(0, 0, 1036, 800);
		
		icon2 = new ImageIcon("C:\\Users\\CC-Student\\eclipse-workspace\\waage\\bilder\\stammabteilung.png");
		// Dieses Bild als icon1 wurde über erstellte JLabel hinzugefügt. 
		l2 = new JLabel(icon2);
	    l2.setVerticalAlignment(SwingConstants.TOP);
		l2.setBounds(1038, 197, 122, 494);
		
		icon3 = new ImageIcon("C:\\Users\\CC-Student\\eclipse-workspace\\waage\\bilder\\artikelstamm_button_bild.png");
		JButton btn_artikelstamm = new JButton(icon3);
		btn_artikelstamm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				
				
				new GUIArtikelstamm(); 
				f.dispose();
				
			}
			
		});
		btn_artikelstamm.setBounds(1038, 11, 122, 93);
		
		icon5 = new ImageIcon("C:\\Users\\CC-Student\\eclipse-workspace\\waage\\bilder\\waage_logo_bild.png");
		JButton btn_waagestamm = new JButton(icon5);
		btn_waagestamm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				
				
				new GUIWaagestamm(); 
				f.dispose();
				
			}
			
		});
		btn_waagestamm.setBounds(1038, 104, 122, 93);
		mb=new JMenuBar();
		m1 = new JMenu("Vertrieb");
		submenu1 = new JMenu("Stammdaten  ");
		submenu2 = new JMenu("Artikel  ");
		submenu3 = new JMenu("Waage");
		mi1 = new JMenuItem("Artikelstamm  ");		
		mi1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GUIArtikelstamm();	
				f.dispose();
				
			}
			
		});
		
		mi2 = new JMenuItem("Waagestamm");
		mi2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new GUIWaagestamm();	
				f.dispose();
			}
			
		});
				
		mb.add(m1);
		m1.add(submenu1);
		submenu1.add(submenu2);
		submenu1.add(submenu3);
		submenu2.add(mi1);
		submenu3.add(mi2);
		f.getContentPane().setLayout(null);
		f.getContentPane().add(l1);
		f.getContentPane().add(l2);	
		f.setJMenuBar(mb);
		f.getContentPane().add(btn_artikelstamm);
		f.getContentPane().add(btn_waagestamm);
		f.setVisible(true);
		
	}

}

