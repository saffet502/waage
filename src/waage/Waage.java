package waage;

public class Waage {
	
	private int waageId;		      
	private String model;   
	private String name;  
	private String ipNummer;          
	private String portNummer; 
	
	public Waage() {
		
	}
	
	public Waage(int waageId) {
		this.waageId = waageId;
	}

	
	public Waage(String model) {
		this.model = model;
	}
	
	public Waage(int waageId, String model, String name, String ipNummer, String portNummer) {
		super();
		this.waageId = waageId;
		this.model = model;
		this.name = name;
		this.ipNummer = ipNummer;
		this.portNummer = portNummer;
	}
	
	public int getWaageId() {
		return waageId;
	}
	
	public void setWaageId(int waageId) {
		this.waageId = waageId;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	} 
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIpNummer() {
		return ipNummer;
	}
	
	public void setIpNummer(String ipNummer) {
		this.ipNummer = ipNummer;
	}
	
	public String getPortNummer() {
		return portNummer;
	}
	
	public void setPortNummer(String portNummer) {
		this.portNummer = portNummer;
	}
	

	
	@Override
	public String toString() {
		return "Waage_ID: "+ getWaageId() + " \nWaage Model: " + getModel() + "\nWaage Name: " + getName() + "\nWaage IP: " + getIpNummer() + "\nWaage Port: " + getPortNummer();		
	}

}
