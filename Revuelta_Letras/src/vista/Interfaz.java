package vista;

import java.util.Scanner;

import modelo.Tablero;

public class Interfaz {
	private static final String ROJO = "\u001b[31m"; // codigo para colorear el texto rojo
	private static final String RESET = "\u001B[0m"; //// codigo para establecer el color por defecto
	private static final String VERDE = "\033[32m"; // codigo para colorear el texto rojo
	private static final String NARANJA = "\033[38;5;214m"; // codigo para colorear el texto naranja
	private static final String AZUL = "\033[38;5;153m"; // codigo para colorear el texto azul
	private Scanner sc;
	private char[] casillaFilas = { 'A', 'B', 'C', 'D', 'E', 'F' };
	private Tupla tupla;
	private Ranking ranking;
	/**
	 * constructor de la clase interfaz donde iniciamos el objeto ranking y tupla
	 */
	public Interfaz() {
		sc = new Scanner(System.in);
		tupla = new Tupla();
		ranking = new Ranking();
	}

	/**
	 * metodod para mostra por pantalla la tabla de puntuaciones EXPLICAR A FONDO
	 */
	
	public void mostrarTablaPuntuaciones() {

		int jugadoresValidos = 0;
		for (int i = 0; i < ranking.getNombre().length; i++) {
			if (ranking.getNombre()[i] != null) {
				jugadoresValidos++;
			}
		}

		String[] nombresValidos = new String[jugadoresValidos];
		int[] turnosValidos = new int[jugadoresValidos];
		int indice = 0;

		for (int i = 0; i < ranking.getNombre().length; i++) {
			if (ranking.getNombre()[i] != null) {
				nombresValidos[indice] = ranking.getNombre()[i];
				turnosValidos[indice] = ranking.getTurnos()[i];
				indice++;
			}
		}

		for (int i = 0; i < turnosValidos.length; i++) {
			System.out.println("turnos " + turnosValidos[i]);
			System.out.println("nombres " + nombresValidos[i]);
		}
		for (int i = 0; i < turnosValidos.length; i++) {
			System.out.println(turnosValidos[i]);
		}

		boolean cambio = true;

		while (cambio) {
			cambio = false;
			for (int i = 0; i < jugadoresValidos - 1; i++) {
				if (turnosValidos[i] > turnosValidos[i + 1]) {
					int ayuda = turnosValidos[i];
					turnosValidos[i] = turnosValidos[i + 1];
					turnosValidos[i + 1] = ayuda;

					String ayudaNombres = nombresValidos[i];
					nombresValidos[i] = nombresValidos[i + 1];
					nombresValidos[i + 1] = ayudaNombres;
					cambio = true;
				}

			}
		}

		System.out.println();
		System.out.println("╔═══════════════════════════════════════╗");
		System.out.println("║        RANKING DE PARTIDAS            ║");
		System.out.println("╠═════╦═════════════════════╦═══════════╣");
		System.out.println("║ Pos ║ Jugador             ║ Turnos    ║");
		System.out.println("╠═════╬═════════════════════╬═══════════╣");

		for (int i = 0; i < jugadoresValidos; i++) {
			int pos = i + 1;
			String nombre = nombresValidos[i];
			String espacios = "";

			for (int j = 0; j < 20 - nombre.length(); j++) {
				espacios += " ";
			}
			if (turnosValidos[i] < 10)
				System.out.println("║  " + pos + "  ║ " + nombre + espacios + "║     " + turnosValidos[i] + "     ║");
			else
				System.out.println("║  " + pos + "  ║ " + nombre + espacios + "║     " + turnosValidos[i] + "    ║");
		}

		System.out.println("╚═════╩═════════════════════╩═══════════╝");
	}
	/**
	 * Pedir un nombre al usuario y se guarda en la varible nombre de la clase ranking
	 */
	public void pedirNombreUsuario() {
		System.out.println("Introduce el nombre de Jugador");
		ranking.setPartida();
		ranking.setNombre(sc.nextLine());

	}

	
	/**
	 * metodo para mostrar por pantalla el tablero de juego
	 * @param tablero recibe el tablero de juego
	 * @param porcentajes recibe el array con los porcentajes de letras acertadas en cada fila del tablero
	 */
	public void mostrarTablero(Tablero tablero, float[] porcentajes) {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		for (int i = 1; i < tablero.getColumnas(); i++) {
			if (i < 10)
				System.out.print(VERDE + "     " + (i) + "" + RESET);
			else
				System.out.print(VERDE + "    " + (i) + "" + RESET);
		}
		System.out.println();
		System.out.print("  ╔");
		for (int i = 1; i < tablero.getColumnas(); i++) {
			if (i != tablero.getColumnas() - 1)
				System.out.print("═════╦");
			else
				System.out.print("═════╗");

		}
		System.out.println();

		for (int i = 0; i < tablero.getFilas(); i++) {
			System.out.print(VERDE + casillaFilas[i] + RESET + " ║");
			for (int j = 1; j < tablero.getColumnas(); j++) {
				System.out.print("  " + tablero.getTablero()[i][j] + "  ║");
				if(j==tablero.getColumnas()-1) {
					if(porcentajes[i]<33)
						System.out.print("  "+ROJO+porcentajes[i] +" %" + RESET);
					else if(porcentajes[i]<66 && porcentajes[i]>33 )
						System.out.print("  "+NARANJA+porcentajes[i] +" %" + RESET);
					else if(porcentajes[i]>66 && porcentajes[i]<100)
						System.out.print("  "+AZUL+porcentajes[i] +" %" + RESET);
					else if(porcentajes[i]==100)
							System.out.print("  "+VERDE+porcentajes[i] +" %" + RESET);

				}
					
			}
			System.out.println();
			if (i < tablero.getFilas() - 1) {
				System.out.print("  ╠");
				for (int j = 1; j < tablero.getColumnas(); j++) {
					if (j != tablero.getColumnas() - 1)
						System.out.print("═════╬");
					else {
						System.out.print("═════╣");

					}
				}

				System.out.println();
			}

		}
		System.out.print("  ╚");
		for (int i = 1; i < tablero.getColumnas(); i++) {
			if (i != tablero.getColumnas() - 1)
				System.out.print("═════╩");
			else
				System.out.print("═════╝");
		}
	}
	/**
	 * Metodo para elegir la dificultad de la partida
	 * @return devulve un int con el tipo de dificultad
	 */
	public int elegirDifucultad() {
		System.out.println(
				"Introduce:\n1 para la dificultad facil\n2 para la difuculdad media\n3 para la dificultad dificl");
		String input = sc.nextLine();
		while (!depurarEntradaDificultad(input)) {
			System.out.println("Has introducido un caracter incorrecto");
			System.out.println(
					"Introduce:\n1 para la dificultad facil\n2 para la difuculdad media\n3 para la dificultad dificl");
			input = sc.nextLine();
		}
		return tupla.getDificultad();

	}
	/**
	 * Metodo para comprobar que lo recibido por el usuario es valido en la dificultad
	 * @param input son los caracteres que ha escrito el usuario
	 * @return retorna false si la entrada no ha sido buena true si es buena
	 */
	private boolean depurarEntradaDificultad(String input) {
		if (input.length() == 1 && input.charAt(0) - '0' >= 1 && input.charAt(0) - '0' <= 3) {
			tupla.setDificultad(input.charAt(0) - '0');
			return true;
		} else
			return false;

	}
	/**
	 * Metodo para pedir casillas a intercambiar 
	 * @return devulve un objeto tupla
	 */
	public Tupla PedirCasillas() {
		String input;
		System.out.println();
		System.out.println("Introduce la primera casilla para intercambiar");
		System.out.println();
		System.out.println();
		input = sc.nextLine();
		System.out.println();
		System.out.println();
		while (!depurarEntradaCasilla(input, 'B')) {
			System.out.println("Has introducido un caracter incorrecto");
			System.out.println("Introduce la primera casilla para intercambiar");
			input = sc.nextLine();
			System.out.println();
			System.out.println();
			

		}
		System.out.println("Introduce la casilla con la que quieres intercambiar");
		input = sc.nextLine();
		System.out.println();
		System.out.println();
		while (!depurarEntradaCasilla(input, 'M')) {
			System.out.println("Has introducido un caracter incorrecto");
			System.out.println("Introduce la casilla con la que quieres intercambiar");
			input = sc.nextLine();
			System.out.println();
			System.out.println();

		}
		ranking.setTurnos();
		return tupla;
	}
	/**
	 * Metodo para depurar la entrada del usuario sobre las casillas que quiere cambiar 
	 * @param input la casilla que quiere cambiar el usuario
	 * @param casilla B para la casilla 1 M para la casilla 2
	 * @return true si la entrada es valida, false si no es valida
	 */
	private boolean depurarEntradaCasilla(String input, char casilla) {
		boolean caracterBueno = false;
		int n = 0;
		int fila = 0;
		if (input.length() == 2 || input.length() == 3) {
			for (int i = 0; i < casillaFilas.length; i++) {
				if (input.charAt(0) == casillaFilas[i] || input.charAt(0) - 32 == casillaFilas[i]) {
					caracterBueno = true;
					fila = i;
				}
			}
			if (input.length() == 2 && caracterBueno) {
				if (input.charAt(1) - '0' >= 1 || input.charAt(1) - '0' <= 9 && caracterBueno)
					caracterBueno = true;
				else
					caracterBueno = false;
			} else {
				if (input.charAt(1) - '0' >= 1 || input.charAt(1) - '0' <= 9 && caracterBueno)
					caracterBueno = true;
				else
					caracterBueno = false;
				if (input.charAt(2) - '0' >= 1 || input.charAt(2) - '0' <= 9 && caracterBueno)
					caracterBueno = true;

				else
					caracterBueno = false;
			}
			if (caracterBueno && input.length() == 3) {
				n = input.charAt(1) - '0';
				n *= 10;
				n += input.charAt(2) - '0';
			} else if (caracterBueno && input.length() == 2)
				n = input.charAt(1) - '0';
		}
		System.out.println(n);
		if (caracterBueno && n <= 15 && n >= 1 && casilla == 'B') {
			tupla.setFilasCasilla1(fila);
			tupla.setColumnaCasilla1(n);
			return true;
		} else if (caracterBueno && n <= 15 && n >= 1 && casilla == 'M') {
			tupla.setFilasCasilla2(fila);
			tupla.setColumnaCasilla2(n);
			return true;
		} else
			return false;

	}
	/**
	 * Mensaje que sale una vez terminado la partida 
	 */
	public void mensajeVictoria() {
		System.out.println();
		System.out.println("Felicidades has ganado en " + ranking.getTurnosPartida() + " turnos");
	}
	/**
	 * Metodo que se llama una vez terminado el juego para saber lo que quiere hacer el usuario
	 * @return int con las posibilidades de 1 para ranking 2 para jugar de nuevo 9 para salir
	 */
	public int preguntarReiniciar() {
		System.out.println("Selecciona:\n1 para mostrar Ranking\n2 para jugar de nuevo\n9 para salir del programa");
		String input = sc.nextLine();

		while (!depurarFin(input)) {
			System.out.println("Caracterer incorrecto");
			System.out.println("Selecciona:\n1 para mostrar Ranking\n2 para jugar de nuevo\n9 para salir del programa");
			input = sc.nextLine();
		}

		return input.charAt(0) - '0';
	}
	/**
	 * Metodo para depurar la entrada del usuario cuando termina un juego solo validos los numeros 1,2,3
	 * @param input es la entrada del usuario
	 * @return true si la entrada es valida, false si no
	 */
	private boolean depurarFin(String input) {
		if (input.length() != 1)
			return false;
		else if (input.charAt(0) - '0' == 1 || input.charAt(0) - '0' == 2 || input.charAt(0) - '0' == 9)
			return true;
		else
			return false;

	}
	/**
	 * Metodo para preguntar si quiere seguir jugando o parar tras mostrar el rankinh
	 * @return devuelve un int 2 para jugar de nuevo o 9 para acabar el programa
	 */
	public int preguntarReinicarDepuesRanking() {
		System.out.println("Selecciona:\n2 para jugar de nuevo\n9 para salir del programa");
		String input = sc.nextLine();
		while (!depurarFinRanking(input)) {
			System.out.println("Caracterer incorrecto");
			System.out.println("Selecciona:\n2 para jugar de nuevo\n9 para salir del programa");
			input = sc.nextLine();
		}

		return input.charAt(0) - '0';
	}
	/**
	 * Metodo para depurar la entrada 
	 * @param input entrada que recibe el programa del usuario
	 * @return true si es valida, false si no lo es
	 */
	private boolean depurarFinRanking(String input) {
		if (input.length() != 1)
			return false;
		else if (input.charAt(0) - '0' == 2 || input.charAt(0) - '0' == 9)
			return true;
		else
			return false;

	}

}
