package vista;

import controlador.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import modelo.Modelo;
import modelo.Persona;

public class ConEdicion extends Main {

	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtApellido;
	@FXML
	private TextField txtTelefono;
	@FXML
	private Button btnAceptar;
	@FXML
	private Button btnCancelar;

	private Alert alert;

	public void guardar(ActionEvent event) {
		if (txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtTelefono.getText().equals("")) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR EN LA ELECCION");
			alert.setHeaderText("No ha introducido todos los campos");
			alert.showAndWait();
		} else {
			if (editando) {
				miModel.getPersonas().set(indice,
						new Persona(txtNombre.getText(), txtApellido.getText(), txtTelefono.getText()));

				indice = -1;
				editando = false;
			} else {
				miModel.addPersona(new Persona(txtNombre.getText(), txtApellido.getText(), txtTelefono.getText()));
			}
			mostrarVentanaPrincipal(event);
		}
	}
	
	public void cancelar(ActionEvent event) {
		mostrarVentanaPrincipal(event);
	}

	@FXML
	public void initialize() {
		if (indice != -1) {
			txtNombre.setText(miModel.getPersonas().get(indice).getNombre());
			txtApellido.setText(miModel.getPersonas().get(indice).getApellido());
			txtTelefono.setText(miModel.getPersonas().get(indice).getTelefono());

		}

	}
}
