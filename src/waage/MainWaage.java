package waage;

public class MainWaage {

	public static void main(String[] args) {
		
		 artikelPlastikrolleBeschreibung();	
		 
	}

	public static void artikelPlastikrolleBeschreibung() {
			
		System.out.println("**********Waage Eigenschaften**********");
		Waage waage = new Waage();
		
		waage.setWaageId(1);
		System.out.println("Waage-ID : " + waage.getWaageId());
		
		waage.setName("Waage 15-L");
		System.out.println("Waagename : " + waage.getName() +"\n");
		
		System.out.println("**********Produkt Eigenschaften**********");
		Artikel artikel = new Artikel();
		
		artikel.setArtikelId(1);
		System.out.println("Artikel ID: " + artikel.getArtikelId());
		
		artikel.setProduktName("Plastikrolle");
		System.out.println("Artikelname : " + artikel.getProduktName() +"\n");
			
		System.out.println("**********Messung Eigenschaften**********");
		Messung mess = new Messung();
		
		System.out.println(artikel.getProduktName() + " " +  mess.stueckZahlKalkulation(12.0, 0.5) + " Stück");

	}
	 
}
