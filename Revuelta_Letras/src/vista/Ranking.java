package vista;

public class Ranking {
	String[] nombre;
	int[] turnos;
	int partida;

	public Ranking() {
		nombre = new String[10];
		turnos = new int[50];
		partida = 0;
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

	public void setTurnos() {
		this.turnos[partida]++;
	}

	public int getPartida() {
		return partida;
	}

	public void setPartida() {
		this.partida++;
	}

}
