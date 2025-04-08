package modelo;

import vista.Tupla;

public class Logica {
	private Tablero tablero;

	public Logica() {
		tablero = new Tablero();
	}

	public Tablero getTablero() {

		return tablero;
	}

	public void empezar() {
		tablero.vaciarFrases();
		tablero.introducirFrases();

	}

	public void dificultad(int dificultad) {
		tablero.introducirCaracteresTabla();

		if (dificultad == 1) {

			tablero.RandomizarCaracteres(14);

		} else if (dificultad == 2)

		{
			tablero.RandomizarCaracteres(4);

		} else {

			tablero.RandomizarCaracteres(1);
		}

	}

	public boolean comprobarVictoria(Tupla pedirCasillas) {
		tablero.intercambiarCasillas(pedirCasillas);
		boolean ganar = tablero.comprobarVictoria();
		return ganar;
	}

	public void vaciarTablero() {
		for (int i = 0; i < tablero.getFilas(); i++) {
			for (int j = 0; j < tablero.getColumnas(); j++) {
				tablero.getTablero()[i][j] ='\u0000';
			}
		}

	}

}
