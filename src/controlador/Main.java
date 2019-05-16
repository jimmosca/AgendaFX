package controlador;
	

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import modelo.Modelo;
import modelo.Persona;
import vista.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	private Stage primaryStage;
	private AnchorPane rootLayout;
	private Stage secondaryStage;
	static protected Modelo miModel;
	static protected ConPrincipal principal;
	
	static protected int indice;
	static protected boolean editando;

	@Override
	public void start(Stage primaryStage) {
		miModel = new Modelo();
		principal = new ConPrincipal();		
		
		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Agenda JavaFX");
			this.primaryStage.getIcons().add(new Image("file:resources/images/icon_address.png"));
			
// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../vista/VistaPrincipal.fxml"));
			rootLayout = (AnchorPane) loader.load();
			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void mostrarVentanaAnadir() {
		try {
			FXMLLoader loader2 = new FXMLLoader();

			loader2.setLocation(Main.class.getResource("../vista/VistaEdicion.fxml"));
			rootLayout = (AnchorPane) loader2.load();
			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			secondaryStage = new Stage();
            secondaryStage.getIcons().add(new Image("file:resources/images/icon_address.png"));
			secondaryStage.setTitle("Editar Persona");
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}
	
	public void mostrarVentanaPrincipal(ActionEvent event) {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.close();
		principal.refrescarTabla();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
