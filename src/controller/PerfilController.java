package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Perfil;

public class PerfilController {

	@FXML 
	private GridPane gridpane;
	
	@FXML
	private Label lbNombre;
	
	@FXML
	private Label lbApellido;
	
	@FXML
	private Label lbSexo;

	@FXML
	private TextField tfNombre;
	@FXML
	private TextField tfApellido;
	@FXML
	private RadioButton rbMujer;
	@FXML
	private RadioButton rbHombre;
	@FXML
	private Button botonEditar;
	@FXML
	private Button botonVolver;
	@FXML
	private Button botonLimpiar;
	@FXML
	private ToggleGroup sexos;

	@FXML
	private void initialize() {

		gridpane.getStylesheets().add("/application/perfil.css");
		
		// usuario actual

		Perfil usuario = InicioController.usuario;

		tfNombre.setText(usuario.getNombre());
		tfApellido.setText(usuario.getApellidos());

		if (usuario.getSexo().equals("Mujer")) {
			rbMujer.setSelected(true);
		} else {
			rbHombre.setSelected(true);
		}
	}

	@FXML
	private void editar() {

		// modificar el usuario

		Perfil usuario = InicioController.usuario;

		usuario.setNombre(tfNombre.getText());
		usuario.setApellidos(tfApellido.getText());

		RadioButton SexoSeleccionado = (RadioButton) sexos.getSelectedToggle();

		if (rbMujer.isSelected()) {
			usuario.setSexo("Mujer");
		} else {
			usuario.setSexo("Hombre");
		}

		// alerta
		Alert alert = new Alert(AlertType.INFORMATION, "Se ha editado el perfil");
		alert.show();

	}

	// limpiar campos para editarlo mejor
	@FXML
	private void limpiar(ActionEvent e) {
		tfNombre.clear();
		tfApellido.clear();
		rbMujer.setSelected(false);
		rbHombre.setSelected(false);
	}

	// volver a la anterior ventana
	@FXML
	private void volver(ActionEvent e) {
		Stage stage = (Stage) this.botonVolver.getScene().getWindow();
		stage.close();
	}

}
