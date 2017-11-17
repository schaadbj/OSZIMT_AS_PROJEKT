package application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class IO_fluverw {
	static Scanner sc = new Scanner(System.in);
	//====Neues Objekt====	
	public static void neuobj() throws SQLException {
		//Eingaben
		System.out.println("\n----------Neues Flugzeug hinzuf�gen-----------");                                            //--Eingabe Beginn
	    System.out.print("\nGeben Sie das Flugzeugmodell ein: ");
	    String modell=sc.next();
	    System.out.print("\nGeben Sie die Sitzpl�tze des Flugzeugs ein: ");
	    int sitze=sc.nextInt();
	    
	    //n�chste freie ID wird aus DB geladen
	    String sqlquery = Sqlquery.getFlugzeuge();
	    List<O_Flugzeug> flugzeuge=DBconnection.showDBflu(sqlquery);
	    
	    int id=1;
	    try {
	    	id=flugzeuge.get(flugzeuge.size()-1).getId()+1;
	    }
	    catch (ArrayIndexOutOfBoundsException e) {
	    	System.out.println("\nDies ist der erste Datensatz. ID=1");
	    }
	    //Flugzeug Objekt erstellen
	    O_Flugzeug flugzeug = new O_Flugzeug(modell, sitze);
	    String newFlugzeug = Sqlquery.newFlugzeug(id, modell, sitze);
	    DBconnection.updateDB(newFlugzeug);
	   
	    //Ausgabe Check
	    System.out.println("\nSie haben folgendes Flugzeug hinzugef�gt:");                                                     //--Ausgabe Beginn
	    System.out.println("Flugzeugnummer: "+flugzeug.getId());
	    System.out.println("Modell: "+flugzeug.getModell());
	    System.out.println("Sitzpl�tze: "+flugzeug.getSitze()); 
	    IO_Menu.fortfahrenMainMenu();
	}//end of method neuobj
		
	//====Objekt l�schen	
	public static void delobj() throws SQLException {
		int i=0, id=0;
		
		//erzeuge ArrayList mit allen in DB(t_kunden) vorhandenen Eintr�gen
	    String sqlquery = Sqlquery.getFlugzeuge();
	    List<O_Flugzeug> flugzeuge=DBconnection.showDBflu(sqlquery);
	    
		
		System.out.println("\n----------Flugzeug entfernen-----------");                                            	
	    System.out.print("\nGeben Sie die Nummer des Flugzeugs ein: ");	
	    id=sc.nextInt();
	    
		//Pr�fung ob ID vergeben
	    while (i==0) {
	    	for (O_Flugzeug flugzeug: flugzeuge) {//foreach Schleife, f�r jedes Flugzeugobjekt in Array Flugzeug
	    		if (id==flugzeug.getId()) {
	    			//Ausgabe Check
	    			System.out.println("\nSie l�schen folgendes Flugzeug:");
	    		    System.out.println("Flugzeugnummer: "+ id );
	    		    System.out.println("Modell: "+ flugzeug.getModell());
	    		    System.out.println("Sitzpl�tze: "+ flugzeug.getSitze());
	    		    i=0;
	    		    while (i==0) {//l�schen best�tigen
	    		    	System.out.println("L�schen best�tigen (Y/N)");
	    		    	char del=sc.next().toLowerCase().charAt(0);
	    		    	switch (del) {
	    		    	case 'y' ://wird gel�scht
	    			    	i=1;
	    			    	String delete = Sqlquery.delFlugzeug(id);
	    			    	DBconnection.updateDB(delete);
	    			    	System.out.println("Erfolgreich gel�scht");
	    			    break;
	    		    	case 'n' ://wird nicht gel�scht
	    		    		i=1;
	    			    	System.out.println("L�schen beendet");
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
	    	if (id==0) break;//break weil User 0=beenden gew�hlt hat
	    }//end of while
	    
		IO_Menu.fortfahrenMainMenu();
	}//end of method delobj

	//===Objekt anzeigen
		public static void showobj() throws SQLException {
			int i=0;
			
			//erzeuge ArrayList mit allen in DB(t_kunden) vorhandenen Eintr�gen
			String sqlquery = Sqlquery.getFlugzeuge();
			List<O_Flugzeug> flugzeuge=DBconnection.showDBflu(sqlquery);
			   
			
			System.out.println("\n----------Anzeigen eines Flugzeugs-----------");
			System.out.print("\nGeben Sie die Nummer des Flugzeugs ein: ");	
			int id=sc.nextInt();
			
			//�berpr�fung ob Flugzeugnummer vorhanden
			while (i==0) { 
				for (O_Flugzeug flugzeug: flugzeuge) {
					if (id==flugzeug.getId()) {
						i=1;
						System.out.println("Flugzeugnummer: "+ id );
		    		    System.out.println("Modell: "+ flugzeug.getModell());
		    		    System.out.println("Sitzpl�tze: "+ flugzeug.getSitze());
		    		    break;
					}//end of if
				}//end of for
				if (i==0) {
					System.out.print("\nDie eingegebene Flugzeugnummer existiert nicht. Geben Sie eine andere ein: (0=Beenden)");
					id=sc.nextInt();
				}//end of if
				if (id==0) break; //wenn User 0=beenden gew�hlt hat
			} // end of while 
			IO_Menu.fortfahrenMainMenu();
		}//end of method showobj

	
		public static void showall() throws SQLException {
			//erzeuge ArrayList mit allen in DB(t_kunden) vorhandenen Eintr�gen
			String sqlquery = Sqlquery.getFlugzeuge();
			List<O_Flugzeug> flugzeuge=DBconnection.showDBflu(sqlquery);
						
			System.out.println("\n----------Anzeigen aller Flugzeuge-----------");
		    for (O_Flugzeug flugzeug: flugzeuge) {
		        System.out.println("\nFlugzeugnummer: "+flugzeug.getId());
		        System.out.println("Modell: "+flugzeug.getModell());
		        System.out.println("Sitzpl�tze: "+flugzeug.getSitze());
		      
		    } // end of for
		    IO_Menu.fortfahrenMainMenu();
		}//end of method showall

}//end of class Objektverwaltung
