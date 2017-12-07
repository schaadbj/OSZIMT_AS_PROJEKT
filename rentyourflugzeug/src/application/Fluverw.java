package application;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import application.Objects.Helper;
import application.Save.BuilderDB;
import application.Save.DBconnection;
import application.Save.Sqlquery;
import application.Objects.Flugzeug;

public class Fluverw {
	static Scanner sc = new Scanner(System.in);
//NEUES FLUGZEUG
	// CONSOLE + SQL =========================	
	public static void new_con_sql(Helper help) throws SQLException {
		//Eingaben
		System.out.println("\n----------Neues Flugzeug hinzufügen-----------"); 
		System.out.print("\nGeben Sie das Flugzeugmodell ein: ");
	    String modell=sc.next();
		System.out.print("\nGeben Sie die Sitzplätze des Flugzeugs ein: ");
	    int sitze=sc.nextInt();
		//ID aus Datenbank einlesen
		int id=1;
		List<Flugzeug> flugzeuge=BuilderDB.getflu();
	    try {
	    	id=flugzeuge.get(flugzeuge.size()-1).getId()+1;
	    }
	    catch (ArrayIndexOutOfBoundsException e) {
	    	System.out.println("\nDies ist der erste Datensatz. ID=1");
	    }
	    //Objekt erstellen
		Flugzeug flugzeug = new Flugzeug(id, modell, sitze);
		//Speichern in DB
		String newFlugzeug = Sqlquery.newFlugzeug(id, modell, sitze);
		DBconnection.updateDB(newFlugzeug);			
		//Ausgabe
		System.out.println("\nSie haben folgendes Flugzeug hinzugefügt:");                                                  
    	System.out.println("Flugzeugnummer: "+id);
    	System.out.println("Modell: "+flugzeug.getModell());
    	System.out.println("Sitzplätze: "+flugzeug.getSitze()); 
    	//Menü wieder öffnen
    	Menu.fortfahrenfluverw(help);
	}
	// CONSOLE + XML =========================	
	public static void new_con_xml(Helper help) {
		
	}
	// GUI + SQL =============================	
	public static void new_gui_sql(Helper help) {
		
	}
	// GUI + XML =============================	
	public static void new_gui_xml(Helper help) {
		
	}
	
	
//FLUGZEUG LÖSCHEN
	// CONSOLE + SQL =========================	
	public static void del_con_sql(Helper help) throws SQLException {
		//erzeuge ArrayList mit allen in DB(t_flugzeuge) vorhandenen Einträgen
		List<Flugzeug> flugzeuge=BuilderDB.getflu();
		System.out.println("\n----------Flugzeug entfernen-----------");                                            	
	    System.out.print("\nGeben Sie die Nummer des Flugzeugs ein: ");	
	    int id=sc.nextInt();
	    
	    int i=0;
		while (i==0) {
	    	for (Flugzeug flugzeug: flugzeuge) {//foreach Schleife, für jedes Flugzeugobjekt in Array Flugzeug
	    		if (id==flugzeug.getId()) {
	    			//Ausgabe Check
	    			System.out.println("\nSie löschen folgendes Flugzeug:");
	    		    System.out.println("Flugzeugnummer: "+ id );
	    		    System.out.println("Modell: "+ flugzeug.getModell());
	    		    System.out.println("Sitzplätze: "+ flugzeug.getSitze());
	    		    i=0;
	    		    while (i==0) {//löschen bestätigen
	    		    	System.out.println("Löschen bestätigen (Y/N)");
	    		    	char del=sc.next().toLowerCase().charAt(0);
	    		    	switch (del) {
	    		    	case 'y' ://wird gelöscht
	    			    	i=1;
	    			    	BuilderDB.delflu(id);
	    			    	System.out.println("Erfolgreich gelöscht");
	    			    break;
	    		    	case 'n' ://wird nicht gelöscht
	    		    		i=1;
	    			    	System.out.println("Löschen beendet");
	    			    break;
	    			    default:
	    			    	i=0;
	    			    }//end of switch
	    			}//end of while
	    		}
	    			
	    	}//end of for
	    	if (i==0) { 
	    		System.out.print("\nDie eingegebene Kundenummer existiert nicht. Geben Sie eine andere ein: (0=Beenden)");
	    		id=sc.nextInt();
	    	}
	    	if (id==0) break;//break weil User 0=beenden gewählt hat
		}//end of while
		Menu.fortfahrenfluverw(help);
	}
	// CONSOLE + XML =========================	
	public static void del_con_xml(Helper help) {
		
	}
	// GUI + SQL =============================	
	public static void del_gui_sql(Helper help) {
		
	}
	// GUI + XML =============================	
	public static void del_gui_xml(Helper help) {
		
	}
	
	
//1 FLUGZEUG ANZEIGEN
	// CONSOLE + SQL =========================	
	public static void show_con_sql(Helper help) throws SQLException {
		//erzeuge ArrayList mit allen in DB(t_flugzeuge) vorhandenen Einträgen
		List<Flugzeug> flugzeuge=BuilderDB.getflu();
		   
		
		System.out.println("\n----------Anzeigen eines Flugzeugs-----------");
		System.out.print("\nGeben Sie die Nummer des Flugzeugs ein: ");	
		int id=sc.nextInt();
		
		//Überprüfung ob Flugzeugnummer vorhanden
		int i=0;
		while (i==0) { 
			for (Flugzeug flugzeug: flugzeuge) {
				if (id==flugzeug.getId()) {
					i=1;
					System.out.println("Flugzeugnummer: "+ id );
	    		    System.out.println("Modell: "+ flugzeug.getModell());
	    		    System.out.println("Sitzplätze: "+ flugzeug.getSitze());
	    		    break;
				}//end of if
			}//end of for
			if (i==0) {
				System.out.print("\nDie eingegebene Flugzeugnummer existiert nicht. Geben Sie eine andere ein: (0=Beenden)");
				id=sc.nextInt();
			}//end of if
			if (id==0) break; //wenn User 0=beenden gewählt hat
		} // end of while 
		Menu.fortfahrenfluverw(help);		
	}
	// CONSOLE + XML =========================	
	public static void show_con_xml(Helper help) {
		
	}
	// GUI + SQL =============================	
	public static void show_gui_sql(Helper help) {
		
	}
	// GUI + XML =============================	
	public static void show_gui_xml(Helper help) {
		
	}
	
//ALLE FLUGZEUGE ANZEIGEN
	// CONSOLE + SQL =========================	
	public static void showall_con_sql(Helper help) throws SQLException {
		//erzeuge ArrayList mit allen in DB(t_flugzeuge) vorhandenen Einträgen
		List<Flugzeug> flugzeuge=BuilderDB.getflu();
					
		System.out.println("\n----------Anzeigen aller Flugzeuge-----------");
	    for (Flugzeug flugzeug: flugzeuge) {
	        System.out.println("\nFlugzeugnummer: "+flugzeug.getId());
	        System.out.println("Modell: "+flugzeug.getModell());
	        System.out.println("Sitzplätze: "+flugzeug.getSitze());
	      
	    } // end of for
	    Menu.fortfahrenfluverw(help);
	}
	// CONSOLE + XML =========================	
	public static void showall_con_xml(Helper help) {
		
	}
	// GUI + SQL =============================	
	public static void showall_gui_sql(Helper help) {
		
	}
	// GUI + XML =============================	
	public static void showall_gui_xml(Helper help) {
		
	}
}
