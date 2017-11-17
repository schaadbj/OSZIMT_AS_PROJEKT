package application;

import java.util.Scanner;

public class IO_verm {
	static Scanner sc = new Scanner(System.in);
//---Vermietung
	public static void vermietung(String[][] flugzeug, String[][] kunde) {
		System.out.println("\n----------Vermietung-----------");
		System.out.print("\nGeben Sie die Kundennummer ein: ");
		int knr=sc.nextInt();
		int i=0;
		while (i==0) { 
			if ((knr<=500) && (knr>0)) {
				i=1;
				if (kunde[knr][0]==null) {
					System.out.println("\nEs gibt keinen Kunden zu dieser Nummer");
					i=0;
				}
				else i=1;
			}
		    else {
		        System.out.println("Es können maximal 500 Kunden verwaltet werden geben Sie eine Zahl von 1-500 ein:");
		        knr = sc.nextInt();
		        i=0;  
		    } // end of if-else
		} // end of while   
		System.out.print("\nGeben Sie die Flugzeugnummer ein: ");
		int fnr=sc.nextInt();
		i=0;
		while (i==0) { 
			if ((fnr<=24) && (fnr>0)) {
				i=1;
				if (flugzeug[fnr][0]==null) {
					System.out.println("\nEs gibt kein Flugzeug zu dieser Nummer");
					i=0;
				}
				else i=1;
			}
		    else {
		        System.out.println("Es können maximal 24 Flugzeuge verwaltet werden geben Sie eine Zahl von 1-24 ein:");
		        fnr = sc.nextInt();
		        i=0;  
		    } // end of if-else
		} // end of while  
		
		String sfnr=""+fnr;
		kunde[knr][7]=sfnr;
		String sknr=""+knr;
		flugzeug[fnr][3]=sknr;
		System.out.println("\nSie haben Flugzeug "+fnr+" an Kunde "+knr+" vermietet.");
	}
//---Rückgabe
	public static void ruckgabe(String[][] flugzeug, String[][] kunde) {
		System.out.println("\n----------Rückgabe-----------");
		System.out.print("\nGeben sie die Flugzeugnummer ein: ");
		int fnr=sc.nextInt();
		int i=0;
		while (i==0) { 
			if ((fnr<=24) && (fnr>0)) {
				i=1;
				if (flugzeug[fnr][0]==null) {
					System.out.println("\nEs gibt kein Flugzeug zu dieser Nummer");
					i=0;
				}
				else i=1;
			}
		    else {
		        System.out.println("Es können maximal 24 Flugzeuge verwaltet werden geben Sie eine Zahl von 1-24 ein:");
		        fnr = sc.nextInt();
		        i=0;  
		    } // end of if-else
		} // end of while  
		int knr=Integer.parseInt(flugzeug[fnr][3]);
		
		System.out.println("\nFlugzeug "+fnr+" wurde von Kunde "+knr+" zurückgegeben.");
		flugzeug[fnr][3]=null;
		kunde[knr][7]=null;
	}
//---Suche (Kundennumer)
	public static void suche_knr(String[][] flugzeug, String[][] kunde) {
		System.out.println("\n----------Suche (Kundennummer)-----------");
		 System.out.print("\nGeben Sie die Kundennummer ein:");
		 int knr=sc.nextInt();
		 int i=0;
			while (i==0) { 
				if ((knr<=500) && (knr>0)) {
					i=1;
					if (kunde[knr][0]==null) {
						System.out.println("\nEs gibt keinen Kunden zu dieser Nummer");
						i=0;
					}
					else i=1;
				}
			    else {
			        System.out.println("Es können maximal 500 Kunden verwaltet werden geben Sie eine Zahl von 1-500 ein:");
			        knr = sc.nextInt();
			        i=0;  
			    } // end of if-else
			} // end of while   
			int check=0;
			System.out.println("\nFolgende Flugzeug sind an Kunde "+knr+" vermietet:");
			for (i=1; i<=24 ;i++ ) { 				//überprüfe auf Arraystelle i den wert 3(Kundennummer)
				 if (flugzeug[i][3].equals(""+knr)) {
					 System.out.println("\nFlugzeugnr:" +i);
					 check=1;
				 }
			 }
			if (check==0) System.out.println("\nDieser Kunde hat keine Flugzeuge gemietet.");
	}
//---Suche (Flugzeugnummer)
	public static void suche_fnr(String[][] flugzeug, String[][] kunde) {
		System.out.println("\n----------Suche (Flugzeugnummer)-----------");
		System.out.print("\nGeben Sie die Flugzeugnummer ein:");
		int fnr=sc.nextInt();
		int i=0;
		while (i==0) { 
			if ((fnr<=24) && (fnr>0)) {
				i=1;
				if (kunde[fnr][0]==null) {
					System.out.println("\nEs gibt kein Flugzeug zu dieser Nummer");
					i=0;
				}
				else i=1;
			}
			else {
				System.out.println("Es können maximal 24 Flugzeuge verwaltet werden geben Sie eine Zahl von 1-24 ein:");
			    fnr = sc.nextInt();
			    i=0;  
			} // end of if-else
		} // end of while   
		if (flugzeug[fnr][3]!=null) System.out.println("\nFlugzeug "+fnr+" wurde von Kunde "+flugzeug[fnr][3]+" ausgeliehen.");
		else System.out.println("\nFlugzeug "+fnr+" ist im Lager");
	}
}
