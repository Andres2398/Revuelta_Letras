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
		tablero.introducirFrases();

	}

	public void dificultad(int dificultad) {
		tablero.introducirCaracteresTabla();

		if (dificultad == 1) {

			tablero.RandomizarCaracteres(8);

		} else if (dificultad == 2)

		{
			tablero.RandomizarCaracteres(4);

		} else {

			tablero.RandomizarCaracteres(1);
		}

	}

	public boolean comprobarVictoria(Tupla pedirCasillas) {

		return tablero.intercambiarCasillas(pedirCasillas);
	}

}
