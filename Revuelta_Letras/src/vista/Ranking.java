package vista;

/**
 * Clase ranking que guardara todos los datos necasarios para mostrar el ranking
 * de las partidas jugadas
 */
public class Ranking {
	String[] nombre;
	int[] turnos;
	int partida;
	/**
	 * Constructor de la clase tablero donde iniciamos un array de string para los nombres otro de int para los turnos y un int para la partida
	 * que se esta jugando en ese momento
	 */
	public Ranking() {
		nombre = new String[50];
		turnos = new int[50];
		partida = -1;
	}
	/**
	 * Metodo que te devuelve el array con todos los nombres introducidos por el usuario
	 * @return array de String
	 */
	public String[] getNombre() {
		return nombre;
	}
	/**
	 * Metodo para establecer el nombre que ha introducido el usario en la posicion de la partida que se esta jugando, y en caso de que el array este lleno
	 * se llama al metodo para aumentar su tamaño
	 * @param nombre introducido por el usuario
	 */
	public void setNombre(String nombre) {
		if (partida == nombre.length() - 1)
			aumentarTamañoArrayNombre();
		this.nombre[partida] = nombre;
	}
	/**
	 * Aumenta el tamaño del array de los nombres en caso de que este lleno
	 */
	private void aumentarTamañoArrayNombre() {
		String[] nombre = new String[this.nombre.length * 2];
		for (int i = 0; i < this.nombre.length; i++) {
			nombre[i] = this.nombre[i];
		}
		this.nombre = nombre;

	}
	/**
	 * metodo para obtener el array con todos los turnos de cada partida
	 * @return array de int que representan los turnos
	 */
	public int[] getTurnos() {
		return turnos;
	}
	/**
	 *
	 * Metodo para aumentar en uno los turnos de la partida que se esta jugando y en caso de que el array este lleno
	 * se llama al metodo para aumentar su tamaño
	 * 
	 */
	
	public void setTurnos() {
		if(partida==turnos.length-1)
			aumentarTamañoArrayTurnos();
		this.turnos[partida]++;
	}
	/**
	 * Aumenta el tamaño del array de los turnos en caso de que este lleno
	 */
	private void aumentarTamañoArrayTurnos() {
		int[] turnos = new int[this.turnos.length * 2];
		for (int i = 0; i < this.turnos.length; i++) {
			turnos[i] = this.turnos[i];
		}
		this.turnos = turnos;
		
	}
	/**
	 * Metodo que te devuelve la partida que se esta jugando
	 * @return un int que representa la partida
	 */
	public int getPartida() {
		return partida;
	}
	/**
	 * En cada inicio de juego se llama a este metodo para aumentar en uno la partida
	 */
	public void setPartida() {
		this.partida++;
	}
	/**
	 * Metodo para obtener los turnos de la partida en concreto
	 * @return un int que son la cantida de turnos que ha pasado hasta ese momento en la partida
	 */
	public int getTurnosPartida() {
		return turnos[partida];
	}

}
