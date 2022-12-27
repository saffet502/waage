package waage;

import java.text.SimpleDateFormat;

public class Messung {
	
	private int messungId;	
	private String gewichtDatum;
	private String stueckZahl;
	private double gewicht;
	private Artikel artikelId;
	private Waage waageId;

	public Messung() {
		
	}
	public Messung(int messungId, String gewichtDatum, String stueckZahl, double gewicht, Artikel artikelId,
			Waage waageId) {
		super();
		this.messungId = messungId;
		this.gewichtDatum = gewichtDatum;
		this.stueckZahl = stueckZahl;
		this.gewicht = gewicht;
		this.artikelId = artikelId;
		this.waageId = waageId;
	}
	
	public int getMessungId() {
		return messungId;
	}

	public void setMessungId(int messungId) {
		this.messungId = messungId;
	}
	
	public String getGewichtDatum() {		
		return wiegeDatum();
	}
	
	public void setGewichtDatum(String gewichtDatum) {
		this.gewichtDatum = gewichtDatum;
		wiegeDatum();
	}

	public String getStueckZahl() {		
		return stueckZahl;
	}

	public void setStueckZahl(String stueckZahl) {
		this.stueckZahl = stueckZahl;
	}

	public double getGewicht() {
		return gewicht;
	}

	public void setGewicht(double Gewicht) {
		this.gewicht = Gewicht;
	}
	
	public Artikel getArtikelId() {
		return artikelId;
	}

	public void setArtikelId(Artikel artikelId) {
		this.artikelId = artikelId;
	}

	public Waage getWaageId() {
		return waageId;
	}

public void setWaageId(Waage waageId) {	
		this.waageId = waageId;
	}

// Stückzahl berechnen	
public String stueckZahlKalkulation(double Gewicht, double stueckGewicht) {
	
	this.gewicht = Gewicht;	 
		 
	if(stueckGewicht>50 || this.gewicht>50) {		
			this.stueckZahl = "Error";			
			}
	
	else if((gewicht<=50 && gewicht>0)&&(stueckGewicht<=50 && stueckGewicht>0)){									
			Double st = (double) Math.round(gewicht/stueckGewicht);				
			System.out.println(st);	 
			String s = String.valueOf(st);
			this.stueckZahl = s;					
			}
	
	else if(stueckGewicht==0.0) {			
			this.stueckZahl = null;		
			}	
	
		return this.stueckZahl;	
	}

	public String ueberschreitung(String ergebnis) {
		String e = ergebnis;
		return e;	
	}
	
    // Automatisch aktuell Messungsdatum und -Uhrzeit erstellen. 
	public String wiegeDatum() {
		
		String date = (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").
				       format(new java.util.Date()));
		
		return date;
	}

}
