public class Flugzeugverwaltung {
  public static void objverw(String flugzeug[][]){
    int menu=1;
    while (menu!=0) { 
      menu=Oberfläche.objverw();
      
      switch (menu) {
        case  1:    //Objekt hinzufügen
        Oberfläche.neuobj(flugzeug);
        break;
        case  2:    //Objekt entfernen
        Oberfläche.delobj(flugzeug);
        break;
        case  3:    //Ein Objekt anzeigen
        Oberfläche.show1obj(flugzeug);
        break;
        case  4:    //Alle Objekte anzeigen
        Oberfläche.showobjs(flugzeug);
        break;
        case  0:    //Beenden
        
        break;
        default: 
        
      } // end of switch
    } // end of while
  }
  
  
  
  public static void main(String[] args) {
    int menu=1;
    String flugzeug[][] = new String[24][2];  
    while (menu!=0) { 
      menu=Oberfläche.menu();
      
      switch (menu) {
        case  1:   //Objektverwaltung
        Flugzeugverwaltung.objverw(flugzeug);
        break;
        case  2:   //
        
        break;
        case  0:   //Beenden
        
        break;
        default: 
        
      } // end of switch
    } // end of while
  } // end of main
  
} // end of class Flugzeugverwaltung
