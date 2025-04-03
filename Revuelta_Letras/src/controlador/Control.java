package controlador;

import vista.Interfaz;
import modelo.Logica;

public class Control {
	Interfaz interfaz;
	Logica logica;

	Control() {
		interfaz = new Interfaz();
		logica = new Logica();
	}

	public void start() {

		interfaz.mostrarTablero(logica.getTablero());
		
	}
	
	

}
