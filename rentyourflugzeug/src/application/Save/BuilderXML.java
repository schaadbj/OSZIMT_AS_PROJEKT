package application.Save;

import java.sql.SQLException;
import java.util.List;

import application.Objects.Flugzeug;
import application.Objects.Kunde;

public class BuilderXML {

//Erstellt Objekte
	//Flugzeug
	public static Flugzeug newflu(int id, String modell, int sitze) throws SQLException {
		Flugzeug flugzeug = new Flugzeug(id, modell, sitze);	//erstellt Objekt aus übergebenen Werten
		//TODO
		//flugzeug in XML speichern
		return flugzeug;
	}
	//Kunde
	public static Kunde newku(int id, String nname, String vname, String str, int strnr, int plz, String ort) throws SQLException {
		Kunde kunde = new Kunde(id, plz, strnr, vname, nname, str, ort);	//erstellt Objekt aus übergebenen Werten
		//TODO
		//kunde in XML speichern
		return kunde;
	}
//Löscht Objekte
	//Flugzeug
	public static void delflu(int id) throws SQLException {
		//TODO
		//flugzeug (id-> wird übergeben) wird gelöscht aus XML
	}
	//Kunde
	public static void delku(int id) throws SQLException {
		//TODO
		//kunde (id-> wird übergeben) wird gelöscht aus XML
	}
	
//erzeugt aus XML Liste mit Objekten	
	//Flugzeug
	public static List<Flugzeug> getflu() throws SQLException {
		List<Flugzeug> flugzeuge=null;
		//TODO
		//die List muss aus der XML Datei gefüllt werden (null ersetzen)
		if (flugzeuge != null) return flugzeuge;
		else return null;
	}
	//Kunde
	public static List<Kunde> getku() throws SQLException {
		List<Kunde> kunden=null;
		//TODO
		//die List muss aus der XML Datei gefüllt werden (null ersetzen)
		if (kunden != null) return kunden;
		else return null;
	}	
}
