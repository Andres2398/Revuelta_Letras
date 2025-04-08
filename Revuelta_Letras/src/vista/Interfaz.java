package vista;

import java.util.Scanner;

import modelo.Tablero;

public class Interfaz {
	private static final String ROJO = "\u001b[31m"; // codigo para colorear el texto rojo
	private static final String AZUL = "\033[34m"; // codigo para colorear el texto azul
	private static final String RESET = "\u001B[0m";
	private static final String VERDE = "\033[32m";
	private Scanner sc;
	private char[] casillaFilas = { 'A', 'B', 'C', 'D', 'E', 'F' };
	Tupla tupla;
	Ranking ranking;

	public Interfaz() {
		sc = new Scanner(System.in);
		tupla = new Tupla();
		ranking = new Ranking();
	}

	public void mostrarTablaPuntuaciones() {

		// Contar cuántos jugadores válidos hay
		int jugadoresValidos = 0;
		for (int i = 0; i < ranking.getNombre().length; i++) {
			if (ranking.getNombre()[i] != null) {
				jugadoresValidos++;
			}
		}

		// Crear arrays nuevos solo con jugadores válidos
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

		// Mostrar ranking
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

			// Rellenar con espacios para alinear a 20 caracteres
			for (int j = 0; j < 20 - nombre.length(); j++) {
				espacios += " ";
			}

			String linea = "║  " + pos + "  ║ " + nombre + espacios + "║     " + turnosValidos[i] + "    ║";
			System.out.println(linea);
		}

		System.out.println("╚═════╩═════════════════════╩═══════════╝");
	}

	public void pedirNombreUsuario() {
		System.out.println("Introduce el nombre de Jugador");
		ranking.setNombre(sc.nextLine());
		ranking.setPartida();
	}

	public void mostrarTablero(Tablero tablero) {
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

			}
			System.out.println();
			if (i < tablero.getFilas() - 1) {
				System.out.print("  ╠");
				for (int j = 1; j < tablero.getColumnas(); j++) {
					if (j != tablero.getColumnas() - 1)
						System.out.print("═════╬");
					else
						System.out.print("═════╣");
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

	public int elegirDifucultad() {
		System.out.println(
				"Introduce:\n1 para la dificultad facil\n2 para la difuculdad media\n3 para la dificultad dificl\n9 para acabar el juego");
		String input = sc.nextLine();
		while (!depurarEntradaDificultad(input)) {
			System.out.println("Has introducido un caracter incorrecto");
			System.out.println(
					"Introduce:\n1 para la dificultad facil\n2 para la difuculdad media\n3 para la dificultad dificl\n9 para acabar el juego");
			input = sc.nextLine();
		}
		return tupla.getDificultad();

	}

	private boolean depurarEntradaDificultad(String input) {
		if (input.length() == 1 && input.charAt(0) - '0' >= 1 && input.charAt(0) - '0' <= 3
				|| input.charAt(0) - '0' == 9) {
			System.out.println(input.charAt(0) - '0');
			tupla.setDificultad(input.charAt(0) - '0');
			return true;
		} else
			return false;

	}

	public Tupla PedirCasillas() {
		String input;
		System.out.println("Introduce la primera casilla para intercambiar");
		input = sc.nextLine();
		while (!depurarEntradaCasilla(input, 1)) {
			System.out.println("Has introducido un caracter incorrecto");
			System.out.println("Introduce la primera casilla para intercambiar");
			input = sc.nextLine();

		}
		System.out.println("Introduce la casilla con la que quieres intercambiar");
		input = sc.nextLine();
		while (!depurarEntradaCasilla(input, 2)) {
			System.out.println("Has introducido un caracter incorrecto");
			System.out.println("Introduce la casilla con la que quieres intercambiar");
			input = sc.nextLine();

		}
		ranking.setTurnos();
		return tupla;
	}

	private boolean depurarEntradaCasilla(String input, int casilla) {
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
				n *=10;
				n+= input.charAt(2) - '0';
			}
			else if (caracterBueno && input.length() == 2)
				n = input.charAt(1) - '0';
		}
		System.out.println(n);
		if (caracterBueno && n <= 15 && n >= 1 && casilla == 1) {
			tupla.setFilasCasilla1(fila);
			tupla.setColumnaCasilla1(n);
			return true;
		} else if (caracterBueno && n <= 15 && n >= 1 && casilla == 2) {
			tupla.setFilasCasilla2(fila);
			tupla.setColumnaCasilla2(n);
			return true;
		} else
			return false;

	}

	public void mostrarMensajeVictoria() {
		System.out.println("Felicidades has ganado en " + ranking.getTurnos());
		
	}

	public boolean preguntarReiniciar() {
		// TODO Auto-generated method stub
		return false;
	}

}
