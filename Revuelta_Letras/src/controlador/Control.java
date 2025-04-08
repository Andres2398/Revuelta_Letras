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
			System.out.println("holaaaaaaaaaaa");
			boolean victoria = false;
			logica.vaciarTablero();
			logica.empezar();
			interfaz.pedirNombreUsuario();
			int dificultad = interfaz.elegirDifucultad();
			logica.dificultad(dificultad);

			while (!victoria) {
				System.out.println("adiosssss");
				interfaz.mostrarTablero(logica.getTablero());
				victoria = logica.comprobarVictoria(interfaz.PedirCasillas());
			}
			if (victoria) {

				interfaz.mostrarTablero(logica.getTablero());
				interfaz.mensajeVictoria();
				int input = interfaz.preguntarReiniciar();
				if (input == 1) {
					interfaz.mostrarTablaPuntuaciones();
					input = interfaz.preguntarReinicarDepuesRanking();

				}
				if (input == 9)
					fin = true;

			}

		}
	}
}
