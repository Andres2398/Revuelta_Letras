package vista;

import java.util.Scanner;

import modelo.Tablero;
/**
 * Clase que se dedica a la comunicacion con el usuario tanto el pedir nombres o dificultades como mostrar los 
 * tableros
 */
public class Interfaz {
	private static final String ROJO = "\u001b[31m"; // codigo para colorear el texto rojo
	private static final String RESET = "\u001B[0m"; //// codigo para establecer el color por defecto
	private static final String VERDE = "\033[32m"; // codigo para colorear el texto rojo
	private static final String NARANJA = "\033[38;5;214m"; // codigo para colorear el texto naranja
	private static final String AZUL = "\033[38;5;153m"; // codigo para colorear el texto azul
	private static final String DORADO = "\033[38;5;220m";// codigo para colorear el texto en dorado
	private static final String PLATA = "\033[38;5;250m"; //  codigo para colorear el texto ep plateado
	private static final String BRONCE = "\033[38;5;136m"; // codigo para colorear el texto en bronce
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
	 * metodod para mostra por pantalla la tabla de puntuaciones, necesitamos reco
	 */

	public void mostrarTablaPuntuaciones() {
		
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		int jugadoresValidos = 0;
		for (int i = 0; i < ranking.getNombre().length; i++) {
			if (ranking.getNombre()[i] != null) {
				jugadoresValidos++;
			}
		}

		String[] nombresValidos = new String[jugadoresValidos];
		int[] turnosValidos = new int[jugadoresValidos];
		int indice = 0;
		/**
		 * bucle para conseguir los nombres del array que no son null asi sabemos que partidas se han jugado
		 */
		for (int i = 0; i < ranking.getNombre().length; i++) {
			if (ranking.getNombre()[i] != null) {
				nombresValidos[indice] = ranking.getNombre()[i];
				turnosValidos[indice] = ranking.getTurnos()[i];
				indice++;
			}
		}

		boolean cambio = true;
		/**
		 * bucle para ordenar los turnos de menor a mayor
		 */
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
			String nombre;
			String medalla;
			if (i == 0) {
				medalla = DORADO + "🥇 " + RESET;
				nombre = medalla + nombresValidos[i];
			} else if (i == 1) {
				medalla = PLATA + "🥈 " + RESET;
				nombre = medalla + nombresValidos[i];
			} else if (i == 2) {
				medalla = BRONCE + "🥉 " + RESET;
				nombre = medalla + nombresValidos[i];
			} else
				nombre = nombresValidos[i];
			String espacios = "";
			String nombreVisible= eliminarColores(nombre);
			for (int j = 0; j < 20 - nombreVisible.length(); j++) {
				espacios += " ";
			}
			if (turnosValidos[i] < 10)
				System.out
						.println("║  " + (i + 1) + "  ║ " + nombre + espacios + "║     " + turnosValidos[i] + "     ║");
			else
				System.out
						.println("║  " + (i + 1) + "  ║ " + nombre + espacios + "║     " + turnosValidos[i] + "    ║");
		}

		System.out.println("╚═════╩═════════════════════╩═══════════╝");
		
	}
	
	/**
	 * Funcion para eliminar los caracteres de color del nombre, para cuadrar el ranking
	 * @param nombre del usuario de la partida
	 * @return nombre sin los caracteres de colores
	 */
	
	public String eliminarColores(String nombre) {
		String resultado="";
		boolean colores=false;
		for (int i = 0; i < nombre.length(); i++) {
			if(nombre.charAt(i)=='\033')
				colores=true;
			if(!colores)
				resultado+=nombre.charAt(i);
			if(nombre.charAt(i)=='m')
				colores=false;
		}
		
		
		return resultado;
		
	}

	/**
	 * Pedir un nombre al usuario y se guarda en la varible nombre de la clase
	 * ranking
	 */
	public void pedirNombreUsuario() {
		System.out.println("Introduce el nombre de Jugador");
		ranking.setPartida();
		ranking.setNombre(sc.nextLine());

	}

	/**
	 * metodo para mostrar por pantalla el tablero de juego
	 * 
	 * @param tablero     recibe el tablero de juego
	 * @param porcentajes recibe el array con los porcentajes de letras acertadas en
	 *                    cada fila del tablero
	 */
	public void mostrarTablero(Tablero tablero, float[] porcentajes) {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		for (int i = 1; i < tablero.getColumnas(); i++) {
			if (i < 10)
				System.out.print(DORADO + "     " + (i) + "" + RESET);
			else
				System.out.print(DORADO + "    " + (i) + "" + RESET);
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
			System.out.print(DORADO + casillaFilas[i] + RESET + " ║");
			for (int j = 1; j < tablero.getColumnas(); j++) {
				if (porcentajes[i] == 100)
					System.out.print("  "+ VERDE + tablero.getTablero()[i][j] + RESET + "  ║");
				else
					System.out.print("  " + tablero.getTablero()[i][j] + "  ║");
				if (j == tablero.getColumnas() - 1) {
					if (porcentajes[i] < 33)
						System.out.print("  " + ROJO + porcentajes[i] + " %" + RESET);
					else if (porcentajes[i] < 66 && porcentajes[i] > 33)
						System.out.print("  " + NARANJA + porcentajes[i] + " %" + RESET);
					else if (porcentajes[i] > 66 && porcentajes[i] < 100)
						System.out.print("  " + AZUL + porcentajes[i] + " %" + RESET);
				

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
	 * 
	 * @return devulve un int con el tipo de dificultad
	 */
	public int elegirDifucultad() {
		System.out.println(
				"Introduce:\n1 para la dificultad facil\n2 para la difuculdad media\n3 para la dificultad dificl\n4 para dificultad personalizada");
		String input = sc.nextLine();
		while (!depurarEntradaDificultad(input)) {
			System.out.println("Has introducido un caracter incorrecto");
			System.out.println(
					"Introduce:\n1 para la dificultad facil\n2 para la difuculdad media\n3 para la dificultad dificl\n4 para dificultad personalizada");
			input = sc.nextLine();
		}
		return tupla.getDificultad();

	}

	/**
	 * Metodo para comprobar que lo recibido por el usuario es valido en la
	 * dificultad
	 * 
	 * @param input son los caracteres que ha escrito el usuario
	 * @return retorna false si la entrada no ha sido buena true si es buena
	 */
	private boolean depurarEntradaDificultad(String input) {
		if (input.equals("1")) {
			tupla.setDificultad(8);
			return true;
		
			
			
		}else if(input.equals("2")) {
			tupla.setDificultad(4);
			return true;
		}
		else if(input.equals("3")) {
			tupla.setDificultad(1);
			return true;
		}
		else if(input.equals("4")) {
			dificultadPersonalizada();
			return true;
		}
		else
			return false;

	}
	/**
	 * Metdodo para elegir la dificultad personalizada
	 */
	private void dificultadPersonalizada() {
		System.out.println("Elige la cantidad de letras que quieres tener fijas, minimo 1 maximo 14");
		String dificultad=sc.nextLine();
		while(!depurardificultadPersonalizada(dificultad)) {
			System.out.println("Cantidad incorrecta, selecciona una cantidad entre 1 y 14");
			dificultad=sc.nextLine();
		}
		
	}
	/**
	 * Metodo para depurar la dificultad
	 * @param dificultad
	 * @return
	 */
	private boolean depurardificultadPersonalizada(String dificultad) {
		String [] numeros = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14"};
		int [] indices = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		for (int i = 0; i < numeros.length; i++) {
			if(dificultad.equals(numeros[i])) {
				tupla.setDificultad(indices[i]);
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo para pedir casillas a intercambiar
	 * @param turnos 
	 * @return devulve un objeto tupla
	 */
	public Tupla PedirCasillas(int turnos) {
		String input;
		if(turnos<2) {
			System.out.println();
			System.out.println("Introduce la primera casilla para intercambiar");
			input = sc.nextLine();
		}
		else {
			System.out.println();
			System.out.println("Introduce la primera casilla para intercambiar, pulsa r para retroceder turnos");
			input = sc.nextLine();
		}
		if(input.equals("r")||input.equals("R")) {
			tupla.setRetroceder(-1);
			return tupla;
		}
		tupla.setRetroceder(0);
		while (!depurarEntradaCasilla(input, 'B')) {
			System.out.println("Has introducido un caracter incorrecto");
			System.out.println("Introduce la primera casilla para intercambiar");
			input = sc.nextLine();
		}
		System.out.println("Introduce la casilla con la que quieres intercambiar");
		input = sc.nextLine();
		while (!depurarEntradaCasilla(input, 'M')) {
			System.out.println("Has introducido un caracter incorrecto");
			System.out.println("Introduce la casilla con la que quieres intercambiar");
			input = sc.nextLine();
			
		}
		ranking.setTurnos();
		return tupla;
	}


	/**
	 * Metodo para depurar la entrada del usuario sobre las casillas que quiere
	 * cambiar
	 * 
	 * @param input   la casilla que quiere cambiar el usuario
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
	 * Metodo que se llama una vez terminado el juego para saber lo que quiere hacer
	 * el usuario
	 * 
	 * @return int con las posibilidades de 1 para ranking 2 para jugar de nuevo 9
	 *         para salir
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
	 * Metodo para depurar la entrada del usuario cuando termina un juego solo
	 * validos los numeros 1,2,3
	 * 
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
	 * Metodo para preguntar si quiere seguir jugando o parar tras mostrar el
	 * rankinh
	 * 
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
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		return input.charAt(0) - '0';
	}

	/**
	 * Metodo para depurar la entrada
	 * 
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
	/**
	 * Metodo para pedir cuantos turnos retroceder
	 * @param turnos cantidad de turnos que se han jugado
	 * @return la cantidad de turnos que el usuario quiere retroceder
	 */
	public int retrocederTurnos(int turnos) {
		System.out
				.println("Cuantos turnos quieres retroceder, recuerda hasta ahora se han jugado " + turnos + " turnos");

		String input = sc.nextLine();
		while (!comprobarTurnos(input, turnos)) {
			System.out.println("Has seleccionado un numero de turnos incorrecto");
			System.out.println(
					"Cuantos turnos quieres retroceder, recuerda hasta ahora se han jugado " + turnos + " turnos");
			input = sc.nextLine();
		}
		return tupla.getRetroceder();
	}

	/**
	 * Metodo para depurar la entrada de los turnos que quiere retroceder el usuario 
	 * @param input la entrada del usuario
	 * @param turnos cantidad de turnos que se han jugado
	 * @return true si los turnos que quiere retroceder el usuario son menores o iguales a los turnos jugados
	 * false si no
	 */
	private boolean comprobarTurnos(String input, int turnos) {
		char[] numeros = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
		int correcto = 0;
		int numeroInput = 0;
		int multiplicar = 1;
		boolean permitido = false;

		for (int i = input.length() - 1; i >= 0; i--) {
			permitido = false;
			for (int j = 0; j < numeros.length; j++) {
				if (input.charAt(i) == numeros[j]) {
					correcto++;
					permitido = true;

				}

			}

			if (permitido) {
				numeroInput += (input.charAt(i) - '0') * multiplicar;
				multiplicar *= 10;

			}

		}
		if (numeroInput <= turnos) {
			tupla.setRetroceder(numeroInput);
			return true;
		}
		return false;

	}
	/**
	 * mensaje que se lanza al finalizar el programa
	 */
	public void mensajeFinal() {
		System.out.println("Gracias por jugar a Revuelta de Letras, vuelve cuando quieras");
		
	}
	

}
