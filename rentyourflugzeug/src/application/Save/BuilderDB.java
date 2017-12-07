package application.Save;

import java.sql.SQLException;
import java.util.List;

import application.Objects.Flugzeug;
import application.Objects.Kunde;

public class BuilderDB {

//Erstellt Objekte
	//Flugzeug
	public static Flugzeug newflu(int id, String modell, int sitze) throws SQLException {
		Flugzeug flugzeug = new Flugzeug(id, modell, sitze);			//JavaObjekt wird erstellt
		String newFlugzeug = Sqlquery.newFlugzeug(id, modell, sitze);	//SQL Query wird erstellt
		DBconnection.updateDB(newFlugzeug);								//Datenbank wird upgedatet
		return flugzeug;
	}
	//Kunde
	public static Kunde newku(int id, String nname, String vname, String str, int strnr, int plz, String ort) throws SQLException {
		Kunde kunde = new Kunde(id, plz, strnr, vname, nname, str, ort);				//JavaObjekt wird erstellt
	    String newKunde = Sqlquery.newKunde(id, nname, vname, str, strnr, plz, ort);	//SQL Query wird erstellt
	    DBconnection.updateDB(newKunde);												//Datenbank wird upgedatet
		return kunde;
	}
//Löscht Objekte
	//Flugzeug
	public static void delflu(int id) throws SQLException {
		String delete = Sqlquery.delFlugzeug(id);			//SQL Query wird erstellt
    	DBconnection.updateDB(delete);						//DB wird geupdatet
	}
	//Kunde
	public static void delku(int id) throws SQLException {
		String delete = Sqlquery.delKunde(id);				//SQL Query wird erstellt
		DBconnection.updateDB(delete);						//DB wird geupdatet
	}
	
//erzeugt aus DB Liste mit Objekten	
	//Flugzeug
	public static List<Flugzeug> getflu() throws SQLException {
		String sqlquery = Sqlquery.getFlugzeuge();					//SQL Query wird erstellt
		List<Flugzeug> flugzeuge=DBconnection.showDBflu(sqlquery);	//Liste mit allen Flugzeugen die in DB gespeichert sind wird erstellt
		if (flugzeuge != null) return flugzeuge;					//wenn Liste nicht leer return die Liste
		else return null;											//wenn sie leer dann return null
	}
	//Kunde
	public static List<Kunde> getku() throws SQLException {
		String sqlquery = Sqlquery.getKunden();						//SQL Query wird erstellt
		List<Kunde> kunden=DBconnection.showDBku(sqlquery);			//Liste mit allen Kunden die in DB gespeichert sind wird erstellt
		if (kunden != null) return kunden;							//wenn Liste nicht leer return die Liste
		else return null;											//wenn sie leer dann return null
	}
	
	
}
