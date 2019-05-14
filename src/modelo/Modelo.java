package modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vista.*;

public class Modelo {
	
	private ObservableList<Persona> personas;
	
	
	public Modelo() {
		personas = FXCollections.observableArrayList();
		personas.add(new Persona("Juean","Aparicio","444444444"));
	}
	
	public void addPersona(Persona nueva) {
		personas.add(nueva);
	}
	
	public void dropPersona(int index) {
		personas.remove(index);
	}


	/**
	 * @return the personas
	 */
	public ObservableList<Persona> getPersonas() {
		return personas;
	}
	
}
