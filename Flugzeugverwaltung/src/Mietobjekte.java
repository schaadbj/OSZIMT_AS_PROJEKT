public class Mietobjekte {
  //Objekte hinzufügen
  public static String[][] eintrag(int nr, String mod, String flugzeug[][], int sitze){
    String ssitze=""+sitze;
    flugzeug[nr][0]=mod;
    flugzeug[nr][1]=ssitze;
    return flugzeug;
  }  
  //Objekte entfernen
  public static void löschen(String flugzeug[][], int platz){
    flugzeug[platz-1][0]=null;
    flugzeug[platz-1][1]=null;
    }
  
} // end of class 
