package vista;

public class Ranking {
	String[] nombre;
	int[] turnos;
	int partida;

	public Ranking() {
		nombre = new String[50];
		turnos = new int[50];
		partida = -1;
	}

	public String[] getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre[partida] = nombre;
	}

	public int[] getTurnos() {
		return turnos;
	}

	public void setTurnos(int i) {
		this.turnos[partida] = i;
	}

	public int getPartida() {
		return partida;
	}

	public void setPartida() {
		this.partida++;
	}

	public int getTurnosPartida(int partida) {
		return turnos[partida];
	}

}
