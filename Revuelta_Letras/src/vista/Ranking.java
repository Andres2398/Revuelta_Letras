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

	public void setTurnos() {
		this.turnos[partida]++;
	}

	public int getPartida() {
		return partida;
	}

	public void setPartida() {
		this.partida++;
	}

	public int getTurnosPartida() {
		return turnos[partida];
	}

//	public static void main(String[] args) {
//		Ranking ranking = new Ranking();
//		ranking.setPartida();
//		ranking.setNombre("aaaa");
//		ranking.setTurnos(15);
//
//		for (int i = 0; i < ranking.getTurnos().length; i++) {
//			System.out.println(ranking.getTurnos()[i]);
//			System.out.println(ranking.getNombre()[i]);
//		}
//	}
}
