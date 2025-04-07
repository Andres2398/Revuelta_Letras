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

	public Interfaz() {
		sc = new Scanner(System.in);
		tupla = new Tupla();
	}

	public void mostrarTablero(Tablero tablero) {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		for (int i = 1; i < tablero.getColumnas(); i++) {
			if (i < 11)
				System.out.print(VERDE + "   " + (i) + "  " + RESET);
			else
				System.out.print(VERDE + "  " + (i) + "  " + RESET);
		}
		System.out.println();
		System.out.print("╔");
		for (int i = 1; i < tablero.getColumnas(); i++) {
			if (i != tablero.getColumnas() - 1)
				System.out.print("═════╦");
			else
				System.out.print("═════╗");

		}
		System.out.println();

		for (int i = 0; i < tablero.getFilas(); i++) {
			System.out.print("║");
			for (int j = 1; j < tablero.getColumnas(); j++) {
				System.out.print("  " + tablero.getTablero()[i][j] + "  ║");

			}
			System.out.println();
			if (i < tablero.getFilas() - 1) {
				System.out.print("╠");
				for (int j = 1; j < tablero.getColumnas(); j++) {
					if (j != tablero.getColumnas() - 1)
						System.out.print("═════╬");
					else
						System.out.print("═════╣");
				}
				System.out.println();
			}

		}
		System.out.print("╚");
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
		if (input.length() == 1 && input.charAt(0) - '0' >= 1 && input.charAt(0) - '0' <= 3 || input.charAt(0)-'0' == 9) {
			System.out.println(input.charAt(0) - '0');
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
		return tupla;
	}

	private boolean depurarEntradaCasilla(String input, int casilla) {
		boolean caracter1Bueno = false;
		boolean caracter2Bueno = false;
		int fila = 0;
		if (input.length() == 2) {
			for (int i = 0; i < casillaFilas.length; i++) {
				if (input.charAt(0) == casillaFilas[i] || input.charAt(0) - 32 == casillaFilas[i]) {
					caracter1Bueno = true;
					fila = i;
				}
			}

			if (input.charAt(1) - '0' >= 1 || input.charAt(1) - '0' <= 15)
				caracter2Bueno = true;
		}
		if (caracter1Bueno && caracter2Bueno && casilla == 1) {
			tupla.setFilasCasilla1(fila);
			tupla.setColumnaCasilla1(input.charAt(1) - '0');
			return true;
		} else if (caracter1Bueno && caracter2Bueno && casilla == 2) {
			tupla.setFilasCasilla2(fila);
			tupla.setColumnaCasilla2(input.charAt(1) - '0');
			return true;
		} else
			return false;

	}

}
