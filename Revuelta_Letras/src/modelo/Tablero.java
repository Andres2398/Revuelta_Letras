package modelo;

import java.util.Random;

import controlador.Control;
import vista.Tupla;

/**
 * La clase representa un tablero con caracteres de una frase de la clase frase algunos aleatorios y otros no, tambien se hace todo sobre
 * los cambios de casillas y comprobaciones de victoria del juego 
 */
public class Tablero {
	private char tablero[][];
	private Frases frases = new Frases();
	private Random r;
	
	/**
	 * constructor del tablero iniciamos el tablero en 6x16 
	 */
	public Tablero() {
		tablero = new char[6][16];
		r = new Random();

	}
	/**
	 * Metodo para obtener el tablero
	 * @return el tablero
	 */
	public char[][] getTablero() {
		return tablero;
	}
	/**
	 * metodo para 	saber cuantas columnastiene un tablero
	 * @return columnas del tablero
	 */
	public int getColumnas() {

		return tablero[0].length;
	}
	/**
	 * metodo para 	saber cuantas filas tiene un tablero
	 * @return filas del tablero
	 */
	public int getFilas() {

		return tablero.length;
	}
	/**
	 * Elegimos las 6 frases que compondran el tablero mediante un random de las 30 posibles
	 */
	public void elegirFrases() {

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
	/**
	 * Introducimos todos los caracteres de cada frase en el tablero, mediante un random de boolean elgimos si estara de izquierda a derecha o viceversa
	 * y la primera casilla de cada fila estara destinada a saber si esta escrita la frase de izquierda a derecha o viceversa
	 */
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
	/**
	 * cogemos cada caracter que esta a partir de los caracteres fijos y llamos a la funcion randomizarCarater
	 * @param posiciones son la cantidad de letras ordenadas que tiene que tener la frase segun la dificultad que se elija
	 */
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
	/**
	 * Elegimos una fila aleatoria del tablero y en base a esa fila hacemos el rango del random de la columna segun si la frase esta de 
	 * izquierde a derecha o viceversa
	 * @param i la fila de la casilla que queremos randomizar
	 * @param j la columna de la casilla que queremos randomizar
	 * @param posiciones son la cantidad de letras ordenadas que tiene que tener la frase segun la dificultad que se elija
	 */
	private void randomizarCarater(int i, int j, int posiciones) {

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
	
	/**
	 * se intercambia las casillas que ha elegido el usuario
	 * @param tupla un objeto con 4 variables para intercambiar las casillas
	 */
	public void intercambiarCasillas(Tupla tupla) {

		char ayuda = tablero[tupla.getFilasCasilla1()][tupla.getColumnaCasilla1()];

		tablero[tupla.getFilasCasilla1()][tupla.getColumnaCasilla1()] = tablero[tupla.getFilasCasilla2()][tupla
				.getColumnaCasilla2()];
		tablero[tupla.getFilasCasilla2()][tupla.getColumnaCasilla2()] = ayuda;

	}
	/**
	 * Se trata de comprobar la victoria comprobando cada casilla de la celda con su respectivo caracter de la frase
	 * @return true si se ha ganadao false si no
	 */
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

		return victoria;

	}
	/**
	 * Se vacian el array de frases del tablero al empezar una nueva partida
	 */
	public void vaciarFrases() {
		for (int i = 0; i < frases.frasesTablero.length; i++) {
			frases.frasesTablero[i] = null;
		}

	}
	/**
	 * Se trara de un metodo para calcular el porcentaje correcto de cada frase en el tablero 
	 * @return un array con todos los porcentajes de acierto con respecto al tablero y las frases 
	 */
	public float[] calcularPorcentajes() {
		float suma = 0;
		float[] porcentaje = new float[tablero.length];
		for (int i = 0; i < tablero.length; i++) {
			suma = 0;
			if (tablero[i][0] == 'T') {
				for (int j = 1; j < tablero[0].length; j++ ) {
					
					if (frases.frasesTablero[i]!=null && tablero[i][j] == frases.frasesTablero[i].charAt(j-1))
						suma++;

				}
			} else {
				int k = 0;
				for (int j = tablero[0].length - 1; j >= 1; j--) {
					if ( frases.frasesTablero[i]!=null && tablero[i][j] == frases.frasesTablero[i].charAt(k) )
						suma++;
					k++;
				}
			}
			porcentaje[i] = suma*100f / 15f;
			
		}
		
		return porcentaje;
	}
	/**
	 * Metodo para copiar los tableros y las frases del tablero
	 * @return el talbero copidado
	 */
	public Tablero copiar() {
	    int filas = tablero.length;
	    int columnas = tablero[0].length;
	    char[][] nuevoTablero = new char[filas][columnas];
	    String[] nuevasFrasesTablero = new String[frases.frasesTablero.length];
	    for (int i = 0; i < frases.frasesTablero.length; i++) {
	        nuevasFrasesTablero[i] = frases.frasesTablero[i];  
	    }
	    
	    for (int i = 0; i < tablero.length; i++) {
	        for (int j = 0; j < tablero[0].length; j++) {
	            nuevoTablero[i][j] = tablero[i][j];
	        }
	    }

	    Tablero copia = new Tablero();
	    copia.setTablero(nuevoTablero);
	    copia.frases.setFrasesTablero(nuevasFrasesTablero);
	    return copia;
	}
	
	public void setTablero(char[][] tablero) {
		this.tablero = tablero;
	}
	
	
}
