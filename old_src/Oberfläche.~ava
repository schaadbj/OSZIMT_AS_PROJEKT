public class Oberfläche {
  public static int menu(){
    int menu, i=0;
    System.out.println("==========FLUGZEUGVERWALTUNG==========\n______________________________________\n");
    System.out.println("----Menü----");
    System.out.println("1. Mietobjektverwaltung");
    System.out.println("2. Menüpunkt");
    System.out.println("3. Menüpunkt");
    System.out.println("4. Menüpunkt");
    System.out.println("5. Menüpunkt");
    System.out.println("6. Menüpunkt");
    System.out.println("0. Beenden");
    menu=Tastatur.liesInt();
    while (i==0) { 
      if ((menu>6)||(menu<0)) {
        System.out.print("\nSie haben keinen der Menüpunkte gewählt.\n Erneute Eingabe:");
        menu=Tastatur.liesInt();
      } // end of if
      else {
        i=1;
      } // end of if-else
    } // end of while
    return menu;
  }
  //Untermenü zu 1-------------------------------------------------------------------------------------------
  public static int objverw(){
    int menu, i=0;
    System.out.println("\n==========Mietobjektverwaltung==========\n________________________________________\n");
    System.out.println("----Menü----");
    System.out.println("1. Objekt hinzufügen");
    System.out.println("2. Objekt entfernen");
    System.out.println("3. Ein Objekt anzeigen");
    System.out.println("4. Alle Objekte anzeigen");
    System.out.println("0. Beenden");
    menu=Tastatur.liesInt();
    while (i==0) { 
      if ((menu>4)||(menu<0)) {
        System.out.print("\nSie haben keinen der Menüpunkte gewählt.\n Erneute Eingabe:");
        menu=Tastatur.liesInt();
      } // end of if
      else {
        i=1;
      } // end of if-else
    } // end of while
    return menu;
  }
  //----------------------------------------------------------------------------
  //Menüpunkte
  //----------------------------------------------------------------------------
  
  //==========Mietobjektverwaltung==============================================
  //----------Objekt hinzufügen------------------------------------------------
  public static void neuobj(String flugzeug[][]){                                                                                           
    int nr, sitze;                                                                                              //--Deklaration Beginn
    String mod;                                                                                                        //--Deklaration Ende
    
    System.out.println("\n----------Neues Flugzeug hinzufügen-----------");                                            //--Eingabe Beginn
    System.out.print("\nGeben Sie das Flugzeugmodell ein: ");
    mod=Tastatur.liesString();
    System.out.print("\nGeben Sie die Sitzplätze des Flugzeugs ein: ");
    sitze=Tastatur.liesInt();
    System.out.println("\nGeben Sie die Nummer des Flugzeugs ein:");
    System.out.println("Achtung wenn die Nummer bereits vergeben ist wird diese überschrieben!");
    nr= Tastatur.liesInt()-1;  
    int i=0;
    while (i==0) { 
      if ((nr<=23) && (nr>=0)) {
        i=1;
      } // end of if
      else {
        System.out.println("Es können maximal 24 Objekte verwaltet werden geben Sie eine Zahl von 1-24 ein:");
        nr = Tastatur.liesInt()-1;
        i=0;  
      } // end of if-else
    } // end of while                                                                                                  //--Eingabe Ende
    
    flugzeug=Mietobjekte.eintrag(nr, mod, flugzeug, sitze);                                                     //--Verarbeitung
    
    System.out.println("\nSie haben folgende Werte eingetragen:");                                                     //--Ausgabe Beginn
    System.out.println("Flugzeugnummer: "+(nr+1));
    System.out.println("Modell: "+flugzeug[nr][0]);
    System.out.println("Sitzplätze: "+flugzeug[nr][1]);                                                             //--Ausgabe Ende
  }
  //----------Objekt entfernen--------------------------------------------------
  public static void delobj(String flugzeug[][]){
    
    System.out.println("\n----------Entfernen eines Flugzeugs-----------"); 
    System.out.print("\nGeben Sie die Nummer des Flugzeugs ein:");
    int lnr=Tastatur.liesInt();
    int i=0;
    while (i==0) { 
      if ((lnr<=24) && (lnr>0)) {
        i=1;
      } // end of if
      else {
        System.out.println("Es können maximal 24 Objekte verwaltet werden geben Sie eine Zahl von 1-24 ein:");
        lnr = Tastatur.liesInt();
        i=0;  
      } // end of if-else
    } // end of while   
    Mietobjekte.löschen(flugzeug, lnr);
  }
  //----------Ein Objekt anzeigen-----------------------------------------------
  public static void show1obj(String flugzeug[][]){
    System.out.println("\n----------Anzeigen eines Flugzeugs-----------");
    System.out.print("\nGeben Sie die Nummer des Flugzeugs ein:");
    int lnr=Tastatur.liesInt();
    int i=0;
    while (i==0) { 
      if ((lnr<=24) && (lnr>0)) {
        i=1;
      } // end of if
      else {
        System.out.println("Es können maximal 24 Objekte verwaltet werden geben Sie eine Zahl von 1-24 ein:");
        lnr = Tastatur.liesInt();
        i=0;  
      } // end of if-else
    } // end of while   
    if ((flugzeug[lnr-1][0]!=null)&&(flugzeug[lnr-1][1]!=null)) {
      System.out.println("\nFlugzeugnummer: "+(lnr));
      System.out.println("Modell: "+flugzeug[lnr-1][0]);
      System.out.println("Sitzplätze: "+flugzeug[lnr-1][1]);
    } // end of if
    else {
      System.out.println("\nEs gibt kein Flugzeug mit der Nummer "+lnr+"\n");
    } // end of if-else
    
  }
  //----------Alle Objekte anzeigen---------------------------------------------
  public static void showobjs(String flugzeug[][]){
    System.out.println("\n----------Anzeigen aller Flugzeuge-----------");
    for (int i=0; i<24 ;i++ ) {
      if ((flugzeug[i][0]!=null)&&(flugzeug[i][1]!=null)) {
        System.out.println("\nFlugzeugnummer: "+(i+1));
        System.out.println("Modell: "+flugzeug[i][0]);
        System.out.println("Sitzplätze: "+flugzeug[i][1]);
      } // end of if
    } // end of for
  }
} // end of class Oberfläche
