package controlador;

import vista.Interfaz;
import modelo.Logica;

/**
 * Clase que trata de hacer la logica del programa y conecta las clases de los paquetes vista y modelo
 */
public class Control {
	private Interfaz interfaz;
	private Logica logica;
	/**
	 * Se inicia el control con un objeto de la calse logica y de la clase interfaz
	 */
	Control() {
		interfaz = new Interfaz();
		logica = new Logica();
	}
	/**
	 * Bucle del juego, primer while para un juego infinito hasta que no se quiera acabar y el segundo while para el bucle de cada juego
	 * este metodo conecta al paquete interfaz con el paquete vista
	 */
	public void start() {
		boolean fin = false;
		while (!fin) {
			boolean victoria = false;
			logica.vaciarTablero();
			logica.empezar();
			interfaz.pedirNombreUsuario();
			int dificultad = interfaz.elegirDifucultad();
			logica.dificultad(dificultad);

			while (!victoria) {
				
				interfaz.mostrarTablero(logica.getTablero(),logica.comprobarPorcentaje());

				victoria = logica.comprobarVictoria(interfaz.PedirCasillas());
				logica.comprobarPorcentaje();
			}
			if (victoria) {

				interfaz.mostrarTablero(logica.getTablero(),logica.comprobarPorcentaje());
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
