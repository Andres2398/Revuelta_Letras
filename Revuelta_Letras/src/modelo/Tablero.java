package modelo;

import java.util.Random;

import controlador.Control;
import vista.Tupla;

public class Tablero {
	private char tablero[][];
	private Frases frases = new Frases();
	private Random r;
	private static final String ROJO = "\u001b[31m"; // codigo para colorear el texto rojo
	private static final String AZUL = "\033[34m"; // codigo para colorear el texto azul
	private static final String RESET = "\u001B[0m";
	private static final String VERDE = "\033[32m";

	public Tablero() {
		tablero = new char[6][16];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				tablero[i][j] = ' ';
			}
		}
		r = new Random();

	}

	public char[][] getTablero() {
		return tablero;
	}

	public int getColumnas() {

		return tablero[0].length;
	}

	public int getFilas() {

		return tablero.length;
	}

	public void introducirFrases() {

		int i = 0;
		int j = 0;
		boolean esta = false;
		String frase[] = frases.getFrasesTablero();
		int fraseSelccionada;

		while (i < frase.length) {
			esta = false;
			j = 0;
			fraseSelccionada = r.nextInt(30);
			while (j < frase.length && !esta) {
				if (frases.getFrasesTotales()[fraseSelccionada].equals(frase[j]))
					esta = true;
				j++;
			}
			if (!esta) {
				frase[i] = frases.getFrasesTotales()[fraseSelccionada];
				i++;
			}

		}
		frases.setFrasesTablero(frase);

	}

	public void introducirCaracteresTabla() {
		int k = 0;
		for (int i = 0; i < tablero.length; i++) {
			if (r.nextBoolean()) {
				tablero[i][0] = 'T';
				for (int j = 1; j < tablero[0].length; j++) {
					tablero[i][j] = frases.getFrasesTablero()[i].charAt(j - 1);

				}
			} else {
				tablero[i][0] = 'F';
				k = 0;
				for (int j = tablero[0].length - 1; j >= 1; j--) {
					tablero[i][j] = frases.getFrasesTablero()[i].charAt(k);
					k++;

				}
			}
		}

	}

	public void RandomizarCaracteres(int posiciones) {

		for (int i = 0; i < frases.frasesTablero.length; i++) {
			if (tablero[i][0] == 'T') {
				for (int j = posiciones + 1; j < tablero[0].length; j++) {
					randomizarCarater(i, j, posiciones);
				}
			} else {
				for (int j = tablero[0].length - posiciones - 1; j >= 1; j--) {
					randomizarCarater(i, j, posiciones);
				}
			}
		}
	}

	private void randomizarCarater(int i, int j, int posiciones) {
		// Preguntar si puedo usar asi los random
		boolean colocada = false;
		int randomColumnas;
		int randomFilas = r.nextInt(tablero.length);
		if (tablero[randomFilas][0] == 'T')
			randomColumnas = r.nextInt(posiciones + 1, tablero[0].length);

		else
			randomColumnas = r.nextInt(1, tablero[0].length - posiciones);

		char ayuda = tablero[i][j];
		tablero[i][j] = tablero[randomFilas][randomColumnas];
		tablero[randomFilas][randomColumnas] = ayuda;
	}

	public void intercambiarCasillas(Tupla tupla) {

		char ayuda = tablero[tupla.getFilasCasilla1()][tupla.getColumnaCasilla1()];
		System.out.println("eeee" + tupla.getColumnaCasilla1());
		System.out.println("aaaa" + tupla.getColumnaCasilla2());

		tablero[tupla.getFilasCasilla1()][tupla.getColumnaCasilla1()] = tablero[tupla.getFilasCasilla2()][tupla
				.getColumnaCasilla2()];
		tablero[tupla.getFilasCasilla2()][tupla.getColumnaCasilla2()] = ayuda;

	}

	public boolean comprobarVictoria() {
		boolean victoria = true;
		String comprobar = "";
		for (int i = 0; i < tablero.length; i++) {
			comprobar = "";
			if (tablero[i][0] == 'T') {
				for (int j = 1; j < tablero[0].length; j++) {
					comprobar += tablero[i][j];
				}

			} else {
				for (int j = tablero[0].length - 1; j >= 1; j--) {
					comprobar += tablero[i][j];
				}
			}

			if (comprobar.compareTo(frases.frasesTablero[i]) != 0)
				victoria = false;

		}
		System.out.println("victoria" + victoria);
		return victoria;

	}

	public void vaciarFrases() {
		for (int i = 0; i < frases.frasesTablero.length; i++) {
			frases.frasesTablero[i] = null;
		}

	}

}
