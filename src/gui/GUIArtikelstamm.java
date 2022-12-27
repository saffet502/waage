package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import waage.Artikel;

public class GUIArtikelstamm extends JFrame implements ActionListener {		

	private static final long serialVersionUID = 1L;

	JFrame f;
	JPanel p1, p2, p3;
	JLabel l_datenlabel, l_lupe, l4, l_nu, l_id, l_produkt, l_stueckgewicht, l_menge;
	JTextField t_lupe, t2, t3, t4, t5;
	JMenuBar mb;
	JMenu m;
	JMenuItem mi1, mi2, mi3, mi4;
	JButton btn_nueanlage, btn_löschen, btn_eandern, btn_besteatigung, btn_zurücknehmen, btn_excel_export, btn_lupe;
	JComboBox<?> cb_menge, cb_teaglich, cb_monatlich1, cb_monatlich2,cb_jeahrlich1, cb_jeahrlich2, cb_jeahrlich3;
	ImageIcon icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8;
	JScrollPane sp1;
	JTabbedPane tp;
	JTable table;
	
	DefaultTableModel model = new DefaultTableModel();
	Object[][] objects;
	ArrayList<String> list = new ArrayList<String>();
		
	public GUIArtikelstamm() {
		
		JFrame f;
		f = new JFrame("Artikelstamm - Ihre Firma");
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
		icon7 = new ImageIcon("C:\\Users\\CC-Student\\eclipse-workspace\\waage\\bilder\\artikelstamm_bild.png");
		icon8 = new ImageIcon("C:\\Users\\CC-Student\\eclipse-workspace\\waage\\bilder\\excel1.png");

		model.addColumn("Nu");
		model.addColumn("ID");
		model.addColumn("Artikel");
		model.addColumn("Stückgewicht");
		model.addColumn("Menge");
		table = new JTable(model);
		
		btn_nueanlage = new JButton(icon1);
		btn_nueanlage.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btn_nueanlage) {
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					cb_menge.setSelectedIndex(0);
					
					t2.setEnabled(true);
					t3.setEnabled(true);
					t4.setEnabled(true);
					t5.setEnabled(true);
					cb_menge.setEnabled(true);																					
						 													
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
					String idName = table.getColumnName(rowPos);
					
						// List durchsuchen und Eintrag löschen	
						javax.swing.JOptionPane.showConfirmDialog(null, "Möchten Sie löschen?");
						
					/* Für Löschen unter folgende Internetseite kann benutzt werden 
					 * https://stackoverflow.com/questions/53393609/deleting-data-in-table-sqlite-through-java-eclipse								
					 */
						Artikel ar = new Artikel();
						int i = ar.getArtikelId();
					String a = String.valueOf(i);
					DatabaseDAO dao = new DatabaseDAO();
				
						
						if(idName.equals(idName)) {
							//artikelDelete(i);
							model.removeRow(rowPos);
						}
											
				
					List<Object[]> results;
//					try {
//						results = dao.artikelDelete();
//						dao.kontaktieren();
//						for(Object result : results) {
//							System.out.println(result+"\t");
//						}															
//								if(a.equals(idName)) {
//									dao.artikelDelete().remove(0);
//								}
//								else if(a.equals(idName)) {
//									dao.artikelDelete().remove(1);
//								}
//								else if(a.equals(idName)) {
//									dao.artikelDelete().remove(2);
//								}
//								else if(a.equals(idName)) {
//									dao.artikelDelete().remove(3);
//								}
//								else if(a.equals(idName)) {
//									dao.artikelDelete().remove(4);
//								}
//					} catch (Exception e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
			
											
				}

			}
		});
		btn_löschen.setBounds(40, 0, 40, 34);
		l_datenlabel.add(btn_löschen);

		btn_eandern = new JButton(icon3);
		btn_eandern.setBounds(80, 0, 40, 34);
		btn_eandern.addActionListener(new ActionListener() {
	    		    
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
										
			Artikel ar = new Artikel();
			ar.setProduktName(t4.getText());
			double parse = Double.parseDouble(t5.getText());
			ar.setStueckGewicht(parse);
			ar.setMenge((String) cb_menge.getSelectedItem());
			DatabaseDAO dao = new DatabaseDAO();
				try {
						dao.kontaktieren();
					try {
						  dao.ausgeben();
							} catch (SQLException e1) {									
								e1.printStackTrace();								
							}
						} catch (ClassNotFoundException e1) {							
							e1.printStackTrace();
						}						
						dao.createArtikel(ar);									
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
							List<Object[]> results = d.ausgeben();
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

		Color blue = new Color(51, 153, 255);
		Color ivory = new Color(255, 255, 208);
		
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		tp = new JTabbedPane();
		tp.setBounds(240, 54, 750, 610);

		l4 = new JLabel(icon7);
		l4.setBounds(1000, 74, 200, 600);
		l4.setVerticalAlignment(SwingConstants.TOP);
		f.getContentPane().add(l4);
		p1.setLayout(null);

		l_nu = new JLabel("Nu");
		l_nu.setBounds(40, 40, 100, 20);
		p1.add(l_nu);

		l_id = new JLabel("ID");
		l_id.setBounds(40, 80, 100, 20);
		p1.add(l_id);

		l_produkt = new JLabel("Artikel");
		l_produkt.setBounds(40, 120, 100, 20);
		p1.add(l_produkt);

		l_stueckgewicht = new JLabel("Stückgewicht");
		l_stueckgewicht.setBounds(40, 160, 100, 20);
		p1.add(l_stueckgewicht);

		l_menge = new JLabel("Menge");
		l_menge.setBounds(40, 200, 100, 20);
		p1.add(l_menge);

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

		String mengeArt[] = { "", "Stück", "Kilo" };
		cb_menge = new JComboBox(mengeArt);
		cb_menge.setEnabled(false);
		cb_menge.setBounds(200, 200, 80, 20);
		p1.add(cb_menge);
		 
		 tp.add("Grunddaten", p1);
		 f.getContentPane().add(tp);
		 f.getContentPane().add(l_lupe);
		 f.getContentPane().add(t_lupe);
		 f.setVisible(true);			
		
	}

	public void close() {
		System.exit(0);
	}
	
	public void listAdd(){
		
		String column_produkt = t4.getText();
		String column_menge = (String) cb_menge.getSelectedItem();
		int column_nu_int = model.getRowCount()+1;
		String column_nu_str = Integer.toString(column_nu_int);
		t2.setText(column_nu_str);
		String column_stueckgewicht = t5.getText();		 
        
        list.add(column_nu_str);
		list.add(column_produkt);
		list.add(column_stueckgewicht);
		list.add(column_menge);
		
		model.addRow(new Object[] { column_nu_str, "", column_produkt,
				column_stueckgewicht, column_menge });				
   }

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}

