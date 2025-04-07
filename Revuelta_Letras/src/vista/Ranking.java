package vista;

public class Ranking {
	String[] nombre;
	int[] turnos;
	int partida;

	public String getNombre() {
		return nombre[partida];
	}

	public void setNombre(String nombre) {
		this.nombre[partida] = nombre;
	}

	public int getTurnos() {
		return turnos[partida];
	}

	public void setTurnos() {
		this.turnos[partida   ]++;
	}
}
