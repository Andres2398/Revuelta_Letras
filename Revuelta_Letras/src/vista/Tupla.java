package vista;
/**
 * Clase tupla en la que guardaremos las posiciones de las casillas que quiere intercambiar el usuario y la dificultad del juego que introdujo el usuario
 */
public class Tupla {
	private int columnaCasilla1;
	private int filasCasilla1;
	private int columnaCasilla2;
	private int filasCasilla2;
	private int dificultad;
	
	/**
	 * Metodo para saber que dificultad introdujo el usario representada en int
	 * @return un int que representa la dificultad
	 */
	public int getDificultad() {
		return dificultad;
	}
	/**
	 * Metodo para establecer la dificultad elegida por el usuario
	 * @param dificultad elegidad por el usuario
	 */
	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}
	/**
	 * Metodo que devuelve la columna de la primera casilla elegida por el usuario
	 * @return un int de la columna de la primera casillas elegida por el usuario
	 */
	public int getColumnaCasilla1() {
		return columnaCasilla1;
	}
	/**
	 * Metodo para establecer la primera columna elegida por el usuario
	 * @param columnaCasilla1 columna de la primera casilla elegida por el usuario
	 */
	public void setColumnaCasilla1(int columnaCasilla1) {
		this.columnaCasilla1 = columnaCasilla1;
	}
	/**
	 * Metodo que devuelve la fila de la primera casilla elegida por el usuario
	 * @return un int de la fila de la primera casillas elegida por el usuario
	 */
	public int getFilasCasilla1() {
		return filasCasilla1;
	}
	/**
	 * Metodo para establecer la fila de la primera casilla elegida por el usuario
	 * @param columnaCasilla1 fila de la primera casilla elegida por el usuario
	 */
	public void setFilasCasilla1(int filasCasilla1) {
		this.filasCasilla1 = filasCasilla1;
	}
	/**
	 * Metodo que devuelve la columna de la segunda casilla elegida por el usuario
	 * @return un int de la columna de la segunda casillas elegida por el usuario
	 */
	public int getColumnaCasilla2() {
		return columnaCasilla2;
	}
	/**
	 * Metodo para establecer la segunda columna elegida por el usuario
	 * @param columnaCasilla1 columna de la segunda casilla elegida por el usuario
	 */
	public void setColumnaCasilla2(int columnaCasilla2) {
		this.columnaCasilla2 = columnaCasilla2;
	}
	/**
	 * Metodo que devuelve la fila de la segunda casilla elegida por el usuario
	 * @return un int de la fila de la segunda casillas elegida por el usuario
	 */
	public int getFilasCasilla2() {
		return filasCasilla2;
	}
	/**
	 * Metodo para establecer la fila de la segunda casilla elegida por el usuario
	 * @param columnaCasilla1 fila de la segunda casilla elegida por el usuario
	 */
	public void setFilasCasilla2(int filasCasilla2) {
		this.filasCasilla2 = filasCasilla2;
	}


}
