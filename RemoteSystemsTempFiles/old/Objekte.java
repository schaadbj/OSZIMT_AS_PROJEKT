package application.old;

public class Objekte {
	//hinzufügen
	public static String[][] flugzeug_eintrag(int id, String modell, String flugzeug[][], int sitze){
	    String ssitze=""+sitze;
	    flugzeug[id][0]=modell;
	    flugzeug[id][1]=ssitze;
	    return flugzeug;
	}  
	public static String[][] kunde_eintrag(String kunde[][], int id, String vname, String nname, String str, int adrnr, int plz, String ort){
		kunde[id][0]=vname;
		kunde[id][1]=nname;
		kunde[id][2]=str;
		String sadrnr=""+adrnr;
		kunde[id][3]=sadrnr;
		String splz=""+plz;
		kunde[id][4]=splz;
		kunde[id][5]=ort;		
		return kunde;
	}
	
	//Objekte entfernen
	public static String[][] flugzeug_loeschen(String flugzeug[][], int id){
	    flugzeug[id][0]=null;
	    flugzeug[id][1]=null;
	    return flugzeug;
	}
	public static String[][] kunde_loeschen(String kunde[][], int id){
		kunde[id][0]=null;
		kunde[id][1]=null;
		kunde[id][2]=null;
		kunde[id][3]=null;
		kunde[id][4]=null;
		kunde[id][5]=null;
		return kunde;
	}
	
	
}
