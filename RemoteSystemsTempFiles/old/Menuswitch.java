package application.old;

public class Menuswitch {
	public static void main(String[][] flugzeug, String[][] kunde) {
		int untermenu;
		int hauptmenu=IO_MainMenu.hauptmenu();
		switch (hauptmenu) {
			case 1 : //Objektverwaltung
				untermenu=IO_MainMenu.menu_objverw();
				switch (untermenu) {
					case 1: //Objekt hinzufügen
						IO_objverw.neuobj(flugzeug, kunde);
					break;
					case 2: //Objekt entfernen
						IO_objverw.delobj(flugzeug, kunde);								
					break;
					case 3: //Ein Objekt anzeigen
						IO_objverw.showobj(flugzeug, kunde);
					break;
					case 4: //Alle Objekte anzeigen
						IO_objverw.showall(flugzeug, kunde);
					break;
					case 0: //beenden
						Menuswitch.main(flugzeug, kunde);
					break;
					default:
				}//end of switch untermenu
			break;
			case 2 : //Kundenverwaltung
				untermenu=IO_MainMenu.menu_kuverw();
				switch (untermenu) {
					case 1: //Objekt hinzufügen
						IO_kuverw.neuobj(flugzeug, kunde);
					break;
					case 2: //Objekt entfernen
						IO_kuverw.delobj(flugzeug, kunde);								
					break;
					case 3: //Ein Objekt anzeigen
						IO_kuverw.showobj(flugzeug, kunde);
					break;
					case 4: //Alle Objekte anzeigen
						IO_kuverw.showall(flugzeug, kunde);
					break;
					case 0: //beenden
						Menuswitch.main(flugzeug, kunde);
					break;
					default:
				}//end of switch untermenu
			break;
			case 3 : //Vermietung
				untermenu=IO_MainMenu.menu_verm();
				switch (untermenu) {
					case 1:
						
					break;
					case 2:
					
					break;
					case 0: //beenden
						Menuswitch.main(flugzeug,  kunde);
					break;
				}
			break;
			case 0: //beenden
			break;
			default:
		} //end of switch hauptmenu
	}
}
