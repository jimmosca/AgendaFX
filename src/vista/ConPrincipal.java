package vista;

import controlador.Main;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Persona;

public class ConPrincipal extends Main {
	@FXML
	private TableView<Persona> tvContactos;
	@FXML
	private TableColumn<Persona, String> tcNombre;
	@FXML
	private TableColumn<Persona, String> tcApellido;
	@FXML
	private TableColumn<Persona, String> tcTelefono;
	@FXML
	private Button btnNuevo;
	@FXML
	private Button btnBorrar;
	@FXML
	private Button btnEditar;

	private Alert alert;

	@FXML
	public void initialize() {
		tcNombre.setCellValueFactory(new PropertyValueFactory<Persona, String>("Nombre"));
		tcApellido.setCellValueFactory(new PropertyValueFactory<Persona, String>("Apellido"));
		tcTelefono.setCellValueFactory(new PropertyValueFactory<Persona, String>("Telefono"));
		refrescarTabla();
	}

	public void refrescarTabla() {
		try {
			tvContactos.setItems(miModel.getPersonas());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void nuevaPersona() {
		indice = -1;
		mostrarVentanaAnadir();
	}

	public void borrarPersona() {
		if (tvContactos.getSelectionModel().isEmpty()) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR EN LA ELECCION");
			alert.setHeaderText("No eligio ninguna opcion");
			alert.showAndWait();
		} else {
			miModel.dropPersona(tvContactos.getSelectionModel().getSelectedIndex());
			tvContactos.getSelectionModel().clearSelection();
			refrescarTabla();
		}
	}

	public void editarPersona() {
		if (tvContactos.getSelectionModel().isEmpty()) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR EN LA ELECCION");
			alert.setHeaderText("No eligio ninguna opcion");
			alert.showAndWait();
		} else {
			indice = tvContactos.getSelectionModel().getSelectedIndex();
			editando = true;
			mostrarVentanaAnadir();

		}

	}

}
