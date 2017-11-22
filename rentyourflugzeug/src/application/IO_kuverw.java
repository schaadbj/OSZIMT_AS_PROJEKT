package application;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

//KLASSE ZUR KUNDENVERWALTUNG (Men�punkt 2)

public class IO_kuverw {
	static Scanner sc = new Scanner(System.in);
//====Neuer Kunde====	
		public static void neuobj() throws SQLException {
			//Eingaben
			System.out.println("\n----------Neuen Kunden hinzuf�gen-----------");                                            //--Eingabe Beginn
		    System.out.print("\nVorname: ");
		    String vname=sc.next();
		    System.out.print("\nNachname: ");
		    String nname=sc.next();
		    System.out.print("\n---Adresse--- ");
		    System.out.print("\nStra�e: ");
		    String str=sc.next();
		    System.out.print("\nNummer: ");
		    int strnr=sc.nextInt();
		    System.out.print("\nPLZ: ");
		    int plz=sc.nextInt();
		    System.out.print("\nOrt: ");
		    String ort=sc.next();
		    //n�chste freie ID wird aus DB geladen
		    String sqlquery = Sqlquery.getKunden();
		    List<O_Kunde> kunden=DBconnection.showDBku(sqlquery);
		    int id=1;
		    try {
		    	id=kunden.get(kunden.size()-1).getId()+1;
		    }	    	
		    catch (ArrayIndexOutOfBoundsException e) {//kunden.size()-1 wirft diese Exception wenn das Array Kunden keine Elemente enth�lt (Size=0)
		    	System.out.println("\nDies ist der erste Datensatz, ID=1");
		    }
		    catch (NullPointerException e) {
		    	System.out.println("\nNullPointerException");
		    }
		
		    //Kunden Objekt erstellen
		    O_Kunde kunde=builder.newku(id, nname, vname, str, strnr, plz, ort);
		    
		    //Ausgabe Check
		    System.out.println("\nSie haben folgenden Kunden hinzugef�gt:");                                                     
		    System.out.println("Kundennummer: "+kunde.getId());
		    System.out.println("Name: "+kunde.getNname()+ ", " +kunde.getVname());
		    System.out.println("Adresse: "+kunde.getStr()+" "+kunde.getStrnr()+", "+kunde.getPlz()+" "+kunde.getOrt()); 
		    IO_Menu.fortfahrenkuverw();
		}//end of method neuobj
		
//====Kunde l�schen====		
		public static void delobj() throws SQLException {	                                         
		    int i=0, id = 0;
		    
		    //erzeuge ArrayList mit allen in DB(t_kunden) vorhandenen Eintr�gen
		    List<O_Kunde> kunden=builder.getku();
		    
		    
		    System.out.println("\n----------Kunde entfernen-----------");
			System.out.print("\nGeben Sie die Kundennummer ein: ");
			id=sc.nextInt();
			
			//Pr�fung ob ID vergeben
			while (i==0) {
				for (O_Kunde kunde: kunden) { //foreach Schleife, f�r jedes Kundenobjekt in Array Kunden
					if (id==kunde.getId()) {
						System.out.println("\nSie l�schen folgenden Kunden:");                                                     
					    System.out.println("Kundennummer: "+id);
					    System.out.println("Name: "+kunde.getNname()+ ", " +kunde.getVname());
					    System.out.println("Adresse: "+kunde.getStr()+" "+kunde.getStrnr()+", "+kunde.getPlz()+" "+kunde.getOrt()); 
						i=0;
						while (i==0) {//l�schen best�tigen
							System.out.println("L�schen best�tigen (Y/N)");
							char del=sc.next().toLowerCase().charAt(0);
							switch (del) {
							case 'y' : //wird gel�scht
								i=1;
								builder.delku(id);
								System.out.println("Erfolgreich gel�scht");
								break;
							case 'n' : //wird nicht gel�scht
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
				if (id==0) break;//break weil User 0=beenden ausgew�hlt hat
			}//end of while	
			
			
			IO_Menu.fortfahrenkuverw();
			
		}//end of method delobj
		
//====Bestimmten Kunden anzeigen====	
		public static void showobj() throws SQLException {
			int i=0;
			
			//erzeuge ArrayList mit allen in DB(t_kunden) vorhandenen Eintr�gen
			List<O_Kunde> kunden=builder.getku();
			
			
			System.out.println("\n----------Anzeigen eines Kunden-----------");
			System.out.print("\nGeben Sie die Kundennummer ein:");
			int id=sc.nextInt();
			
			//�berpr�fung ob Kundennummer vorhanden
			while (i==0) {	
				for (O_Kunde kunde: kunden) { //foreach Schleife, f�r jedes Kundenobjekt in Array Kunden
					if (id==kunde.getId()) { //wenn Kundenobjekt mit gesuchter ID gefunden wird
						i=1;
						System.out.println("Kundennummer: "+id);
						System.out.println("Name: "+kunde.getNname()+ ", " +kunde.getVname());
						System.out.println("Adresse: "+kunde.getStr()+" "+kunde.getStrnr()+", "+kunde.getPlz()+" "+kunde.getOrt());
						break;
					}//end of if
				}//end of for
				if (i==0) {
					System.out.print("\nDie eingegebene Kundenummer existiert nicht. Geben Sie eine andere ein: (0=Beenden)");
					id=sc.nextInt();
				}//end of if			
				if (id==0) break; //wenn User 0=beenden gew�hlt hat
			}//end of while	
			IO_Menu.fortfahrenkuverw();
		}//end of method showobj
		
//====Alle Kunden anzeigen====			
		public static void showall() throws SQLException {
			//erzeuge ArrayList mit allen in DB(t_kunden) vorhandenen Eintr�gen
			List<O_Kunde> kunden=builder.getku();
			
			System.out.println("\n----------Anzeigen aller Kunden-----------");
			for (O_Kunde kunde: kunden) { //foreach Schleife, f�r jedes Kundenobjekt in Array Kunden
					System.out.println("Kundennummer: "+kunde.getId());
					System.out.println("Name: "+kunde.getNname()+ ", " +kunde.getVname());
					System.out.println("Adresse: "+kunde.getStr()+" "+kunde.getStrnr()+", "+kunde.getPlz()+" "+kunde.getOrt()+"\n");
			}
		    IO_Menu.fortfahrenkuverw();
	}//end of method showall

}
