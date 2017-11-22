package application;

import javafx.fxml.FXML;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;

import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Controller_MainMenu {
	@FXML
	private Pane pane;
	@FXML
	private MenuBar menubar;
	@FXML
	private MenuItem menu_newflu;
	@FXML
	private MenuItem menu_delflu;
	@FXML
	private MenuItem menu_showflu;
	@FXML
	private MenuItem menu_allflu;
	@FXML
	private MenuItem menu_newku;
	@FXML
	private MenuItem menu_delku;
	@FXML
	private MenuItem menu_showku;
	@FXML
	private MenuItem menu_allku;
	@FXML
	private MenuItem menu_verm;
	@FXML
	private MenuItem menu_ruck;
	@FXML
	private MenuItem menu_sknr;
	@FXML
	private MenuItem menu_sfnr;
//	@FXML
//	private Separator notvisible;
	@FXML
	private Pane newflu_pane;
	@FXML
	private Button newflu_button;
	@FXML
	private TextField newflu_input_modell;
	@FXML
	private Spinner<Integer> newflu_input_sitze;
	@FXML
	private Pane delflu_pane;
	@FXML
	private Button delflu_button;
	@FXML
	private ComboBox<Integer> delflu_input_id;
	@FXML
	private Pane showflu_pane;
	@FXML
	private Button showflu_button;
	@FXML
	private ComboBox showflu_input_id;
	@FXML
	private TableColumn showflu_table_ID;
	@FXML
	private TableColumn showflu_table_Modell;
	@FXML
	private TableColumn showflu_table_Sitze;
	@FXML
	private Pane allflu_pane;
	@FXML
	private TableColumn allflu_table_ID;
	@FXML
	private TableColumn allflu_table_Modell;
	@FXML
	private TableColumn allflu_table_Sitze;
//	@FXML
//	private Separator notvisible;
	@FXML
	private Pane newku_pane;
	@FXML
	private Button newku_button;
	@FXML
	private Spinner newku_input_strnr;
	@FXML
	private Spinner newku_input_plz;
	@FXML
	private Pane delku_pane;
	@FXML
	private Button delku_button;
	@FXML
	private ComboBox delku_input_id;
	@FXML
	private Pane showku_pane;
	@FXML
	private Button showku_button;
	@FXML
	private ComboBox showku_input_id;
	@FXML
	private TableColumn showku_table_id;
	@FXML
	private TableColumn showku_table_modell;
	@FXML
	private TableColumn showku_table_sitze;
	@FXML
	private Pane allku_pane;
	@FXML
	private TableColumn allku_table_id;
	@FXML
	private TableColumn allku_table_vname;
	@FXML
	private TableColumn allku_table_nname;
	@FXML
	private TableColumn allku_table_str;
	@FXML
	private TableColumn allku_table_strnr;
	@FXML
	private TableColumn allku_table_plz;
	@FXML
	private TableColumn allku_table_ort;
	@FXML
	private Separator notvisible;
	@FXML
	private Pane verm_pane;
	@FXML
	private Button verm_button;
	@FXML
	private ComboBox verm_input_knr;
	@FXML
	private ComboBox verm_input_fnr;
	@FXML
	private Label verm_output;
	@FXML
	private Pane ruck_pane;
	@FXML
	private Button ruck_button;
	@FXML
	private ComboBox ruck_input_fnr;
	@FXML
	private Label ruck_output;
	@FXML
	private Pane sknr_pane;
	@FXML
	private Button sknr_button;
	@FXML
	private ComboBox sknr_input_knr;
	@FXML
	private TableView sknr_table;
	@FXML
	private TableColumn sknr_table_id;
	@FXML
	private TableColumn sknr_table_modell;
	@FXML
	private TableColumn sknr_table_sitze;
	@FXML
	private Pane sfnr_pane;
	@FXML
	private Button sfnr_button;
	@FXML
	private ComboBox sfnr_input_knr;
	@FXML
	private TableView sfnr_table;
	@FXML
	private TableColumn sfnr_table_id;
	@FXML
	private TableColumn sfnr_table_modell;
	@FXML
	private TableColumn sfnr_table_sitze;
	
	@FXML
	public void setNotVisible() {
		if (newflu_pane.isVisible())newflu_pane.setVisible(false);
		if (delflu_pane.isVisible())delflu_pane.setVisible(false);
		if (showflu_pane.isVisible())showflu_pane.setVisible(false);
		if (allflu_pane.isVisible())allflu_pane.setVisible(false);
		
		if (newku_pane.isVisible())newku_pane.setVisible(false);
		if (delku_pane.isVisible())delku_pane.setVisible(false);
		if (showku_pane.isVisible())showku_pane.setVisible(false);
		if (allku_pane.isVisible())allku_pane.setVisible(false);
		
		if (verm_pane.isVisible())verm_pane.setVisible(false);
		if (ruck_pane.isVisible())ruck_pane.setVisible(false);
		if (sknr_pane.isVisible())sknr_pane.setVisible(false);
		if (sfnr_pane.isVisible())sfnr_pane.setVisible(false);
	}
	
	
	// Event Listener on MenuItem[#menu_newflu].onAction
	@FXML
	public void menu_newflu_klick(ActionEvent event) {
		setNotVisible();
		//Setzt Werte f�r Spinner 1-1000, Startwert=1
		int initialValue = 1;
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000, initialValue);
		newflu_input_sitze.setValueFactory(valueFactory);
		newflu_input_sitze.setEditable(true);
		
		newflu_pane.setVisible(true);
	}
	// Event Listener on MenuItem[#menu_delflu].onAction
	@FXML
	public void menu_delflu_klick(ActionEvent event) throws SQLException {
		setNotVisible();
		//Setzt Werte f�r ComboBox (alle vorhandenen FlugzeugIDs)
		List<O_Flugzeug> flugzeuge = builder.getflu();
		for (O_Flugzeug flugzeug: flugzeuge) {
			delflu_input_id.getItems().add(flugzeug.getId());
		}
		delflu_pane.setVisible(true);
	}
	// Event Listener on MenuItem[#menu_showflu].onAction
	@FXML
	public void menu_showflu_klick(ActionEvent event) {
		setNotVisible();
		showflu_pane.setVisible(true);
	}
	// Event Listener on MenuItem[#menu_allflu].onAction
	@FXML
	public void menu_allflu_klick(ActionEvent event) {
		setNotVisible();
		allflu_pane.setVisible(true);
	}
	// Event Listener on MenuItem[#menu_newku].onAction
	@FXML
	public void menu_newku_klick(ActionEvent event) {
		setNotVisible();
		newku_pane.setVisible(true);
	}
	// Event Listener on MenuItem[#menu_delku].onAction
	@FXML
	public void menu_delku_klick(ActionEvent event) {
		setNotVisible();
		delku_pane.setVisible(true);
	}
	// Event Listener on MenuItem[#menu_showku].onAction
	@FXML
	public void menu_showku_klick(ActionEvent event) {
		setNotVisible();
		showku_pane.setVisible(true);
	}
	// Event Listener on MenuItem[#menu_allku].onAction
	@FXML
	public void menu_allku_klick(ActionEvent event) {
		setNotVisible();
		allku_pane.setVisible(true);
	}
	// Event Listener on MenuItem[#menu_verm].onAction
	@FXML
	public void menu_verm_klick(ActionEvent event) {
		setNotVisible();
		verm_pane.setVisible(true);
	}
	// Event Listener on MenuItem[#menu_ruck].onAction
	@FXML
	public void menu_ruck_klick(ActionEvent event) {
		setNotVisible();
		ruck_pane.setVisible(true);
	}
	// Event Listener on MenuItem[#menu_sknr].onAction
	@FXML
	public void menu_sknr_klick(ActionEvent event) {
		setNotVisible();
		sknr_pane.setVisible(true);
	}
	// Event Listener on MenuItem[#menu_sfnr].onAction
	@FXML
	public void menu_sfnr_klick(ActionEvent event) {
		setNotVisible();
		sfnr_pane.setVisible(true);
	}
	
	
	// Event Listener on Button[#newflu_button].onAction
		@FXML
		public void newflu_button_klick(ActionEvent event) throws SQLException {
			//Liest Werte ein
			String modell = newflu_input_modell.getText();
			int sitze = (int) newflu_input_sitze.getValue();
			
			//erzeugt ID
			List<O_Flugzeug> flugzeuge=builder.getflu();
			int id=1;
		    try {
		    	id=flugzeuge.get(flugzeuge.size()-1).getId()+1;
		    }
		    finally {
		    	//erzeugt Flugzeug Objekt & speichert in DB
		    	builder.newflu(id, modell, sitze);
		    }
		}
		// Event Listener on Button[#delflu_button].onAction
		@FXML
		public void delflu_button_click(ActionEvent event) throws SQLException {
			//Liest Wert ein
			int id = (int) delflu_input_id.getValue();
			//erzeugt Flugzeug Objekte
			List<O_Flugzeug> flugzeuge=builder.getflu();
			for (O_Flugzeug flugzeug: flugzeuge) {
				if (id==flugzeug.getId()) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Flugzeug l�schen");
					alert.setHeaderText("Wollen sie folgendes Flugzeug wirklich l�schen:");
					alert.setContentText("Flugzeugnummer: "+id +"\nModell: "+flugzeug.getModell()+"\nSitzpl�tze: "+flugzeug.getSitze());
					
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						//L�schen
						builder.delflu(id);
					}
					break;
				}
			}
			
			//Best�tigungsdialog
			
		}
		// Event Listener on Button[#showflu_button].onAction
		@FXML
		public void showflu_button_klick(ActionEvent event) {
			// TODO Autogenerated
		}
		// Event Listener on Button[#newku_button].onAction
		@FXML
		public void newku_button_klick(ActionEvent event) {
			// TODO Autogenerated
		}
		// Event Listener on Button[#delku_button].onAction
		@FXML
		public void delku_button_click(ActionEvent event) {
			// TODO Autogenerated
		}
		// Event Listener on Button[#showku_button].onAction
		@FXML
		public void showku_button_klick(ActionEvent event) {
			// TODO Autogenerated
		}
		// Event Listener on Button[#verm_button].onAction
		@FXML
		public void verm_button_click(ActionEvent event) {
			// TODO Autogenerated
		}
		// Event Listener on Button[#ruck_button].onAction
		@FXML
		public void ruck_button_click(ActionEvent event) {
			// TODO Autogenerated
		}
		// Event Listener on ComboBox[#ruck_input_fnr].onAction
		@FXML
		public void ruck_input_select(ActionEvent event) {
			// TODO Autogenerated
		}
		// Event Listener on Button[#sknr_button].onAction
		@FXML
		public void sknr_button_click(ActionEvent event) {
			// TODO Autogenerated
		}
		// Event Listener on Button[#sfnr_button].onAction
		@FXML
		public void sfnr_button_click(ActionEvent event) {
			// TODO Autogenerated
		}
		
		@FXML
		public void ruck_input_fnr_select(ActionEvent event) {
			
		}
}
