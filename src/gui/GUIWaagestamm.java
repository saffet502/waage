package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import waage.Artikel;
import waage.Messung;
import waage.Waage;
import java.awt.Font;

public class GUIWaagestamm extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	JFrame f;
	JPanel p1, p2;                                            
	JLabel  l_datenlabel, l_lupe, l4, l_nu, l_id, l_name, l_model, l_ip, l_port, l_mess,											
			l_waage_bild, l_comserver_bild, l_kabel_bild, l_waage_stückzahl, l_waage_gewicht, l_waage_stückgewicht,
			l_waage_zeiger_stückzahl,l_waage_zeiger_stückgewicht,l_waage_zeiger_gewicht, l_waageausweahlen, l_artikelausweahlen, l_mess_zeit;
	
	JTextField t_lupe, t2, t3, t4, t5, t6, t7, t_waage_bild, t_comserver_bild, t_waage_stückzahl, t_waage_gewicht, t_waage_stückgewicht,
	           t_waage_zeiger_stückzahl,t_waage_zeiger_stückgewicht,t_waage_zeiger_gewicht, t_mess_zeit;        
	
	JMenuBar mb;
	JMenu m;
	JMenuItem mi1, mi2, mi3, mi4;
	JButton btn_nueanlage, btn_löschen, btn_eandern, btn_besteatigung, btn_zurücknehmen, btn_excel_export, btn_lupe,
			btn_plastikrolle, b_waage_ok, b_bericht, b_waage_reset;
	JComboBox<?> cb_menge, comboBox_waageauswaehlen, comboBox_artikelauswaehlen;
	ImageIcon icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8, icon9, icon10, icon11, icon12;
	JScrollPane sp1, sp2;
	JTabbedPane tp;
	JTable table, table2;
	
	DefaultTableModel model = new DefaultTableModel();
	DefaultTableModel model2 = new DefaultTableModel();
	Object[][] objects;
	ArrayList<String> list = new ArrayList<String>();
	
		
	public GUIWaagestamm() {
		
		JFrame f;
		f = new JFrame("Waagestamm - Ihre Firma");
		f.setSize(1200, 800);

		l_datenlabel = new JLabel();
		l_datenlabel.setBounds(0, 0, 1200, 33);
		f.getContentPane().add(l_datenlabel);

		mb = new JMenuBar();
		m = new JMenu("Daten");
		mi1 = new JMenuItem("Neuanlage");
		mi2 = new JMenuItem("Ändern");
		mi3 = new JMenuItem("Löschen");

		mb.add(m);
		m.add(mi1);
		m.add(mi2);
		m.add(mi3);
		f.setJMenuBar(mb);

		icon1 = new ImageIcon("C:\\Users\\CC-Student\\eclipse-workspace\\waage\\bilder\\Neuanlage_bild.png");
		icon2 = new ImageIcon("C:\\Users\\CC-Student\\eclipse-workspace\\waage\\bilder\\löschen_bild.png");
		icon3 = new ImageIcon("C:\\Users\\CC-Student\\eclipse-workspace\\waage\\bilder\\eander_bild.png");
		icon4 = new ImageIcon("C:\\Users\\CC-Student\\eclipse-workspace\\waage\\bilder\\bestätigung_bild.png");
		icon5 = new ImageIcon("C:\\Users\\CC-Student\\eclipse-workspace\\waage\\bilder\\zurückgehen_bild.png");
		icon6 = new ImageIcon("C:\\Users\\CC-Student\\eclipse-workspace\\waage\\bilder\\Lüpe_Bild.png");
		icon7 = new ImageIcon("C:\\Users\\CC-Student\\eclipse-workspace\\waage\\bilder\\waagestamm_bild.png");
		icon8 = new ImageIcon("C:\\Users\\CC-Student\\eclipse-workspace\\waage\\bilder\\excel1.png");
		icon9 = new ImageIcon("C:\\Users\\CC-Student\\eclipse-workspace\\waage\\bilder\\Waage_messung_bild.png");
		icon10 = new ImageIcon("C:\\Users\\CC-Student\\eclipse-workspace\\waage\\bilder\\comserver_bild.png");
		icon11 = new ImageIcon("C:\\Users\\CC-Student\\eclipse-workspace\\waage\\bilder\\kabel_bild.png");
		//icon12 = new ImageIcon("C:\\Users\\CC-Student\\eclipse-workspace\\waage\\bilder\\excel1.png");
		
		model.addColumn("Nu");
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Model");
		model.addColumn("IP");
		model.addColumn("Port");
		
		table = new JTable(model);
		
		model2.addColumn("Nu");
		model2.addColumn("Messung_id");
		model2.addColumn("Datum");
		model2.addColumn("Stückzahl");
		model2.addColumn("Gewicht(kg)");
		model2.addColumn("Artikelname");
		model2.addColumn("Waagename");
		
				
		Color blue = new Color(51, 153, 255);
		Color ivory = new Color(255, 255, 208);	
		table2 = new JTable(model2);	
		table2.getTableHeader().setBackground(blue);
		table2.setOpaque(false);
		table2.setBackground(ivory);
		table2.setBounds(300, 20, 740, 310);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		sp2 = new JScrollPane(table2);
		sp2.setBounds(300, 200, 740, 310);
		sp2.setVisible(true);
				
		btn_nueanlage = new JButton(icon1);
		btn_nueanlage.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btn_nueanlage) {
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					t6.setText("");
					t7.setText("");
					
					t2.setEnabled(true);
					t3.setEnabled(true);
					t4.setEnabled(true);
					t5.setEnabled(true);
					t6.setEnabled(true);
					t7.setEnabled(true);																					
						 													
					   }

				}

		});	
		btn_nueanlage.setBounds(0, 0, 40, 34);
		l_datenlabel.add(btn_nueanlage);

		btn_löschen = new JButton(icon2);
	
		btn_löschen.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btn_löschen) {
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int rowPos = table.getSelectedRow();
					
					if (rowPos >= 0) {
						
						// List durchsuchen und Eintrag löschen	
						javax.swing.JOptionPane.showConfirmDialog(null, "Möchten Sie löschen?");
						model.removeRow(rowPos);
													
					}

				}

			}
		});
		btn_löschen.setBounds(40, 0, 40, 34);
		l_datenlabel.add(btn_löschen);

		btn_eandern = new JButton(icon3);
		btn_eandern.setBounds(80, 0, 40, 34);
		btn_eandern.addActionListener(new ActionListener() {
			
			public void mouseClicked(MouseEvent e) {
				Object aValue = 0;
				int rowIndex;
				int columnIndex;
	    		int rowPos = table.getSelectedRow();
	    		rowIndex = table.getSelectedRow()-1;
				columnIndex = table.getSelectedColumn()-1;								
				//objects[rowIndex][columnIndex] = aValue.toString();	
				        
	    		if(e.getClickCount()==2) {
	    			System.out.println(rowPos);
	    			System.out.println(objects[rowIndex][columnIndex]);
	    		}
	    		
	    	}
			public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==btn_eandern) {
							    				    	
				    }
			    }			
		});
		f.getContentPane().setLayout(null);
		l_datenlabel.add(btn_eandern);

		btn_besteatigung = new JButton(icon4);
		btn_besteatigung.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {				
					javax.swing.JOptionPane.showConfirmDialog(null, "Möchten Sie hinzufügen");
										
						Waage w = new Waage();
						w.setName(t4.getText());
						w.setModel(t5.getText());
						w.setIpNummer(t6.getText());
						w.setPortNummer(t7.getText());
						DatabaseDAO dao = new DatabaseDAO();
						try {
							dao.kontaktieren();
							try {
								dao.ausgebenWaage();
							} catch (SQLException e1) {
								
								e1.printStackTrace();
							}
						} catch (ClassNotFoundException e1) {
							
							e1.printStackTrace();
						}
						
						dao.createWaage(w);
									
					listAdd();							
					}
			});
		btn_besteatigung.setBounds(120, 0, 40, 34);
		l_datenlabel.add(btn_besteatigung);

		btn_zurücknehmen = new JButton(icon5);
		btn_zurücknehmen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new Hauptmenü_Waage();
				f.dispose();
			}

		});
		btn_zurücknehmen.setBounds(160, 0, 40, 34);
		l_datenlabel.add(btn_zurücknehmen);

		btn_excel_export = new JButton(icon8);
		btn_excel_export.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {	
				new ExcelExport();
			}

		});
		btn_excel_export.setBounds(200, 0, 40, 34);
		l_datenlabel.add(btn_excel_export);

		btn_lupe = new JButton(icon6);
		btn_lupe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btn_lupe) {
					if(model.getRowCount()!=0) {
						model.setRowCount(0);
					}
					else {
						try {
							DatabaseDAO d = new DatabaseDAO();							
							List<Object[]> results = d.ausgebenWaage();
							for (Object[] result : results) {
								model.addRow(result);
							}
						} catch (Exception e1) {						
							e1.printStackTrace();
						   }		
					    }									
					}
				}						
		});
		btn_lupe.setSize(20, 20);
		
		t_lupe = new JTextField();
		t_lupe.setBounds(0, 34, 240, 20);
		t_lupe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btn_besteatigung.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
								
							}

						}
					);				
			  }

		});

		l_lupe = new JLabel();
		l_lupe.setBounds(240, 34, 20, 20);
		l_lupe.add(btn_lupe);
		
		table.getTableHeader().setBackground(blue);
		table.setOpaque(false);
		table.setBackground(ivory);
		table.setBounds(0, 54, 240, 610);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		sp1 = new JScrollPane(table);
		sp1.setBounds(0, 54, 240, 610);
		sp1.setVisible(true);
		
		f.getContentPane().add(sp1);

		p1 = new JPanel();
		p1.setBounds(0, 0, 750, 610);
		p2 = new JPanel();
		p2.setBounds(0, 0, 750, 610);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		tp = new JTabbedPane();
		tp.setBounds(240, 54, 750, 610);

		l4 = new JLabel(icon7);
		l4.setBounds(1000, 74, 200, 587);
		l4.setVerticalAlignment(SwingConstants.TOP);
		f.getContentPane().add(l4);
		p1.setLayout(null);

		l_nu = new JLabel("Nu");
		l_nu.setBounds(40, 40, 100, 20);
		p1.add(l_nu);

		l_id = new JLabel("ID");
		l_id.setBounds(40, 80, 100, 20);
		p1.add(l_id);

		l_name = new JLabel("Name");
		l_name.setBounds(40, 120, 100, 20);
		p1.add(l_name);

		l_model = new JLabel("Model");
		l_model.setBounds(40, 160, 100, 20);
		p1.add(l_model);

		l_ip = new JLabel("IP");
		l_ip.setBounds(40, 200, 100, 20);
		p1.add(l_ip);
		
		l_port = new JLabel("Port");
		l_port.setBounds(40, 240, 100, 20);
		p1.add(l_port);

		t2 = new JTextField();
		t2.setEnabled(false);
		t2.setBounds(160, 40, 120, 20);
		p1.add(t2);

		t3 = new JTextField();
		t3.setEnabled(false);
		t3.setBounds(160, 80, 120, 20);
		p1.add(t3);

		t4 = new JTextField();
		t4.setBounds(160, 120, 120, 20);
		t4.setEnabled(false);
		p1.add(t4);

		t5 = new JTextField();
		t5.setBounds(160, 160, 120, 20);
		t5.setEnabled(false);
		p1.add(t5);
		
		t6 = new JTextField();
		t6.setBounds(160, 200, 120, 20);
		t6.setEnabled(false);
		p1.add(t6);
		
		t7 = new JTextField();
		t7.setBounds(160, 240, 120, 20);
		t7.setEnabled(false);
		p1.add(t7);

		l_mess = new JLabel("Messung");
		l_mess.setBounds(400, 30, 80, 20);
		l_mess.setFont(new Font("Thoma", Font.PLAIN, 14));
		p2.add(l_mess);

		l_mess_zeit = new JLabel("Datum-Uhr");
		l_mess_zeit.setBounds(72, 30, 80, 20);
		p2.add(l_mess_zeit);
				
		t_mess_zeit = new JTextField();
		t_mess_zeit.setBounds(150, 30, 136, 20);
		p2.add(t_mess_zeit);
		String mess_zeit = t_mess_zeit.getText();

		l_waage_bild = new JLabel(icon9);
		l_waage_bild.setBounds(49, 160, 256, 270);
		p2.add(l_waage_bild);
		
		l_waage_bild = new JLabel(icon9);
		l_waage_bild.setBounds(49, 160, 256, 270);
		p2.add(l_waage_bild);
		
		t_waage_stückzahl = new JTextField();
		t_waage_stückzahl.setBounds(200, 1200, 50, 20);
		p2.add(t_waage_stückzahl);
		
		l_comserver_bild = new JLabel(icon10);
		l_comserver_bild.setBounds(420, 150, 260, 200);
		p2.add(l_comserver_bild);
		
		l_kabel_bild = new JLabel(icon11);
		l_kabel_bild.setBounds(290, 282, 224, 148);
		p2.add(l_kabel_bild);				
		p2.setLayout(null);		
		
		 tp.add("Grunddaten", p1);
		 tp.add("Messung", p2);
		 tp.add("Bericht", sp2);
		 t_waage_zeiger_stückzahl = new JTextField();
		 t_waage_zeiger_stückzahl.setBounds(69, 426, 53, 22);
		 p2.add(t_waage_zeiger_stückzahl);
		 t_waage_zeiger_stückzahl.setColumns(10);
		 t_waage_zeiger_stückzahl.setHorizontalAlignment(JTextField.CENTER);
		
		 t_waage_zeiger_stückgewicht = new JTextField();
		 t_waage_zeiger_stückgewicht.setBounds(122, 426, 58, 22);
		 p2.add(t_waage_zeiger_stückgewicht);
		 t_waage_zeiger_stückgewicht.setColumns(10);
		 t_waage_zeiger_stückgewicht.setHorizontalAlignment(JTextField.CENTER);
		 
		 t_waage_zeiger_gewicht = new JTextField();
		 t_waage_zeiger_gewicht.setBounds(180, 426, 57, 22);
		 p2.add(t_waage_zeiger_gewicht);
		 t_waage_zeiger_gewicht.setColumns(10);
		 t_waage_zeiger_gewicht.setHorizontalAlignment(JTextField.CENTER);
		 
		 b_waage_ok = new JButton("OK");
		 b_waage_ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				 // Werte Kontrol
				 String x = t_waage_zeiger_stückgewicht.getText();
				 double y = Double.parseDouble(x);
				 String t = t_waage_zeiger_gewicht.getText();
				 double z = Double.parseDouble(t);
				
				Messung m = new Messung();
				m.setGewichtDatum(m.getGewichtDatum());
				t_mess_zeit.setHorizontalAlignment(JTextField.CENTER); 							
				t_mess_zeit.setText(m.wiegeDatum());
				
				 Messung mess = new Messung();
				 
				 if(y>50 || z>50) {
					 t_waage_zeiger_stückzahl.setText(m.ueberschreitung("Error"));
					 String error = t_waage_zeiger_stückzahl.getText();
					 m.setStueckZahl(error);
				 }
				 else {
					 String a = m.stueckZahlKalkulation(z, y);
					 System.out.println(a);
				      t_waage_zeiger_stückzahl.setText(a);
				
				 m.setStueckZahl(a);
				 
				 }		
				
				Double gg = Double.parseDouble(t_waage_zeiger_gewicht.getText());
				m.setGewicht(gg);
								
				DatabaseDAO d = new DatabaseDAO();	
				try {
					d.kontaktieren();
				List<Object[]> results = d.ausgebenMessung();
				for(Object result : results) {
					System.out.println(result+"\t");
				}
				} catch (Exception e1) {					
					e1.printStackTrace();
				}
					
				String hf = (String) comboBox_artikelauswaehlen.getSelectedItem();
				
					if(hf.equals("Eisen")) {
						m.setArtikelId(new Artikel(3));
					}
					else if(hf.equals("Plastikrolle")) {
						m.setArtikelId(new Artikel(1));
					}
					else if(hf.equals("Schraube")) {
						m.setArtikelId(new Artikel(2));
					}
					else if(hf.equals("Schrott")) {
						m.setArtikelId(new Artikel(4));
					}					
							
				String ho = (String) comboBox_waageauswaehlen.getSelectedItem();
				if(ho.equals("Waage 15L")) {
						m.setWaageId(new Waage(1));			
				}
				else if(ho.equals("Waage 13E")) {
					    m.setWaageId(new Waage(2));		
				}
				else if(ho.equals("Waage 11B")) {
					   m.setWaageId(new Waage(3));	
				}
				else if(ho.equals("Waage 9G")) {
					   m.setWaageId(new Waage(4));	
				}

				d.createMessung(m);			
						
			}
			 
		 });
		 b_waage_ok.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 b_waage_ok.setBounds(236, 426, 56, 22);
		 p2.add(b_waage_ok);
		 
		 b_waage_reset = new JButton("Res");
		 b_waage_reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == b_waage_reset) {
				 t_waage_zeiger_stückzahl.setText(null);
				 t_waage_zeiger_gewicht.setText(null);
				 t_waage_zeiger_stückgewicht.setText(null);
				 t_mess_zeit.setText(null);
				 comboBox_artikelauswaehlen.setSelectedIndex(0);
				 comboBox_waageauswaehlen.setSelectedIndex(0);
				 
				}								
				
			}
			 
		 });
		 b_waage_reset.setBounds(236, 448, 56, 22);
		 p2.add(b_waage_reset);
		
		 l_waage_zeiger_stückzahl = new JLabel("Stückzahl");
		 l_waage_zeiger_stückzahl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 l_waage_zeiger_stückzahl.setBounds(68, 457, 60, 14);
		 p2.add(l_waage_zeiger_stückzahl);
		 
		 l_waage_zeiger_stückgewicht = new JLabel(" Stückgew.");
		 l_waage_zeiger_stückgewicht.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 l_waage_zeiger_stückgewicht.setBounds(121, 457, 70, 14);
		 p2.add(l_waage_zeiger_stückgewicht);
		 
		 l_waage_zeiger_gewicht = new JLabel("Gewicht");
		 l_waage_zeiger_gewicht.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 l_waage_zeiger_gewicht.setBounds(188, 457, 46, 14);
		 p2.add(l_waage_zeiger_gewicht);
		 
		 String waageauswaehlen [] = {"","Waage 15L", "Waage 13E", "Waage 11B", "Waage 9G"};
		 comboBox_waageauswaehlen = new JComboBox(waageauswaehlen);
		 comboBox_waageauswaehlen.setBounds(70, 141, 108, 22);
		 p2.add(comboBox_waageauswaehlen);
		 
		 String artikelauswaehlen [] = {"","Plastikrolle", "Schraube", "Eisen", "Handy-Schrott"};
		 comboBox_artikelauswaehlen = new JComboBox(artikelauswaehlen);
		 comboBox_artikelauswaehlen.setBounds(178, 141, 109, 22);
		 p2.add(comboBox_artikelauswaehlen);
		 
		 // ComboBox Werte ziehen
				 		 
		 l_waageausweahlen = new JLabel(" Waage Auswahl");
		 l_waageausweahlen.setBounds(70, 122, 110, 14);
		 l_waageausweahlen.setFont(new Font("Thoma", Font.PLAIN, 12));	 
		 p2.add(l_waageausweahlen);
		 
		 l_artikelausweahlen = new JLabel(" Artikel Auswahl");
		 l_artikelausweahlen.setBounds(178, 122, 112, 14);
		 l_artikelausweahlen.setFont(new Font("Thoma", Font.PLAIN, 12));
		 p2.add(l_artikelausweahlen);

		 b_bericht = new JButton("Bericht");
		 b_bericht.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if (e.getSource() == b_bericht) {
			
		 			if(model2.getRowCount()!=0) {
						model2.setRowCount(0);
					}
					else {
						try {
							DatabaseDAO d2 = new DatabaseDAO();							
							List<Object[]> results = d2.ausgebenErgebnis();
							for (Object[] result : results) {							
								model2.addRow(result);								
							}
						} catch (Exception e1) {						
							e1.printStackTrace();
						  }		
					  }								
				  }
		 	}
		 });
		 b_bericht.setBounds(653, 26, 80, 25);
		 p2.add(b_bericht);

		    f.getContentPane().add(tp);
		    f.getContentPane().add(l_lupe);
		    f.getContentPane().add(t_lupe);
		    f.setVisible(true);			
		
		}

	public void close() {
		System.exit(0);
	}
	
	public void listAdd(){
		int column_nu_int = model.getRowCount()+1;
		String column_nu_str = Integer.toString(column_nu_int);
		t2.setText(column_nu_str);
		String column_name = t4.getText();
		String column_model = t5.getText();		
		String column_ip = t6.getText();	
		String column_port = t7.getText();

        list.add(column_nu_str);	
		list.add(column_model);
		list.add(column_ip);
		list.add(column_port);
		
		model.addRow(new Object[] { column_nu_str, "", column_name, column_model,
				column_ip, column_port });				
   }
	

	@Override
	public void actionPerformed(ActionEvent e) {
			
	}
}

