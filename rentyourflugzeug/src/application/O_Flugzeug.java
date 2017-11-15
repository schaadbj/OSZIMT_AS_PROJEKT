package application;

public class O_Flugzeug {
	private int sitze, id;
	private String modell;
	private static int nextID=1;

//---Konstruktor
	public O_Flugzeug() {}
	public O_Flugzeug(String modell, int sitze) {
		this.id = nextID;
		nextID++;
		this.modell = modell;
		this.sitze = sitze;		
	}
//---Getter & Setter	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModell() {
		return modell;
	}
	public void setModell(String modell) {
		this.modell = modell;
	}
	public int getSitze() {
		return sitze;
	}
	public void setSitze(int sitze) {
		this.sitze = sitze;
	}
	
//---Methoden	
	
	
	
}
