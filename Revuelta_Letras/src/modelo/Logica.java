package modelo;

import vista.Tupla;

/**
 * Clase logica se trata de conectar a control con tablero y
 * viceversa tambien realiza metodos como vaciar tablero y elegir la cantidad de
 * caracteres buenos y malos que habra en el tablero
 */
public class Logica {
	private Tablero tablero;
	private Tablero[] arrayTableros;
	private int turnosTablero;
	private int turnosPartida;

	/**
	 * constructor de la logica con un tablero
	 */
	public Logica() {
		tablero = new Tablero();
		turnosTablero = 0;
		turnosPartida = 0;
		arrayTableros = new Tablero[50];

	}

	/**
	 * 
	 * @return el tablero
	 */
	public Tablero getTablero() {

		return tablero;

	}

	/**
	 * metodo para llamar a vaciar frases y elegir frases de la clase tablero
	 */
	public void empezar() {
		tablero.vaciarFrases();
		tablero.elegirFrases();

	}

	/**
	 * Metodo que llama al metodo introducir caracteres para asi introducir los
	 * caracteres a la tabla de cada frase y a continuacio segun la dificultad que
	 * el usuario elija manda tantos caracteres para poner en posicion correcta al
	 * metodo RandomizarCaracteres
	 * 
	 * @param dificultad recibe 3 posibles valores para dificultad facil media o
	 *                   dificil
	 */
	public void dificultad(int dificultad) {
		tablero.introducirCaracteresTabla();

		tablero.RandomizarCaracteres(dificultad);

	}

	/**
	 * Metodo que recibe la tupla desde control y la pasa al tablero para
	 * intercambiar las casillas y una vez intercambiadas comprueba si se ha ganado
	 * el juego
	 * 
	 * @param pedirCasillas Tupla con las 2 casillas a intercambiar
	 * @return True si se ha ganado o false si no
	 */
	public boolean comprobarVictoria(Tupla pedirCasillas) {
		tablero.intercambiarCasillas(pedirCasillas);
		arrayTableros[turnosTablero] = tablero.copiar();
		turnosTablero++;
		turnosPartida++;

		return tablero.comprobarVictoria();
	}

	/**
	 * Metodo para vaciar el tablero al inicio de cada partida, poniendo el valor
	 * por defecto
	 */
	public void vaciarTablero() {
		for (int i = 0; i < tablero.getFilas(); i++) {
			for (int j = 0; j < tablero.getColumnas(); j++) {
				tablero.getTablero()[i][j] = '\u0000';
			}
		}

	}
	/**
	 * Metodo para saber la cantidad de turnos que se han movido en el tablero, no los turnos totales
	 * de la partida
	 * @return cantidad de turnos 
	 */
	public int getTurnosTablero() {
		return turnosTablero;
	}
	/**
	 * Metodo para establecer la cantidad de turnos que se han jugado en el tablero
	 * @param turnosTablero la cantidad de turnos a establecer
	 */
	public void setTurnosTablero(int turnosTablero) {
		this.turnosTablero = turnosTablero;
	}
	/**
	 * Metodo para saber la cantidad de turnos de la partida
	 * @return cantidad de turnos 
	 */
	public int getTurnosPartida() {
		return turnosPartida;
	}
	/**
	 * Metodo para establecer la cantidad de turnos que se han jugado en la partida 
	 * @param turnosPartida cantidad de turnos de la partida
	 */
	public void setTurnosPartida(int turnosPartida) {
		this.turnosPartida = turnosPartida;
	}

	/**
	 * metodo que conecta control con tablero, este sirve para llamar a la funcion
	 * para calcular porcentajes de cada fila
	 * 
	 * @return array con los porcentajes calculados
	 */
	public float[] comprobarPorcentaje() {

		return tablero.calcularPorcentajes();

	}
	/**
	 * Metodo para retroceder los turnos en el tablero
	 * @param turnosRetroceder turnos que quiere retroceder el usuario
	 */
	public void retrocederTurnos(int turnosRetroceder) {

		Tablero estadoAnterior = arrayTableros[turnosTablero - turnosRetroceder].copiar();
		turnosTablero -= turnosRetroceder;
		tablero = estadoAnterior;
	}

}
