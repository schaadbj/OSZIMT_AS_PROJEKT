package application;

import java.sql.SQLException;
import java.util.List;

public class builder {

//Erstellt Objekte
	public static O_Flugzeug newflu(int id, String modell, int sitze) throws SQLException {
		O_Flugzeug flugzeug = new O_Flugzeug(modell, sitze);
		String newFlugzeug = Sqlquery.newFlugzeug(id, modell, sitze);
		DBconnection.updateDB(newFlugzeug);
		return flugzeug;
	}
	public static O_Kunde newku(int id, String nname, String vname, String str, int strnr, int plz, String ort) throws SQLException {
		O_Kunde kunde = new O_Kunde(id, plz, strnr, vname, nname, str, ort);
	    String newKunde = Sqlquery.newKunde(id, nname, vname, str, strnr, plz, ort);
	    DBconnection.updateDB(newKunde);
		return kunde;
	}
//L�scht Objekte
	public static void delflu(int id) throws SQLException {
		String delete = Sqlquery.delFlugzeug(id);
    	DBconnection.updateDB(delete);
	}
	public static void delku(int id) throws SQLException {
		String delete = Sqlquery.delFlugzeug(id);
		DBconnection.updateDB(delete);
	}
	
	
	
//erzeugt aus DB Liste mit Objekten	
	public static List<O_Flugzeug> getflu() throws SQLException {
		//erzeuge ArrayList mit allen in DB(t_flugzeuge) vorhandenen Eintr�gen
		String sqlquery = Sqlquery.getFlugzeuge();
		List<O_Flugzeug> flugzeuge=DBconnection.showDBflu(sqlquery);
		return flugzeuge;
	}
	public static List<O_Kunde> getku() throws SQLException {
		String sqlquery = Sqlquery.getKunden();
		List<O_Kunde> kunden=DBconnection.showDBku(sqlquery);
		return kunden;
	}
	
	
}
