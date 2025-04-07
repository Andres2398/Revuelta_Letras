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
		boolean fin = false;
		while (!fin) {
			boolean victoria = false;
			logica.empezar();
			int dificultad = interfaz.elegirDifucultad();
			if (dificultad == 9)
				fin = true;
			logica.dificultad(dificultad);

			while (!victoria && !fin) {
				interfaz.mostrarTablero(logica.getTablero());
				victoria = logica.comprobarVictoria(interfaz.PedirCasillas());
			}
		}
	}
}
