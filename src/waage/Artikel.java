package waage;


		public class Artikel{
			private int artikelId;
			private String produktName;
			private double stueckGewicht;
			private String menge;
			
			public Artikel() {
				
			}

			public Artikel(int artikelId) {
				this.artikelId = artikelId;
			}
			
			public Artikel(String produktName) {
				this.produktName = produktName;
			}
			
			public Artikel(int artikelId, String produktName, double stueckGewicht, String menge) {
				this.artikelId = artikelId;
				this.produktName = produktName;
				this.stueckGewicht = stueckGewicht;
				this.menge = menge;
			}
			
			public int getArtikelId() {
				return artikelId;
			}

			public void setArtikelId(int artikelId) {
				this.artikelId = artikelId;
			}

			public String getProduktName() {
				return produktName;
			}

			public void setProduktName(String name) {
				this.produktName = name;
			}

			public double getStueckGewicht() {
				return stueckGewicht;
			}

			public void setStueckGewicht(double stueckGewicht) {
				this.stueckGewicht = stueckGewicht;
			}
			public String getMenge() {
				return menge;
			}

			public void setMenge(String menge) {
				this.menge = menge;
			}
			
		}





