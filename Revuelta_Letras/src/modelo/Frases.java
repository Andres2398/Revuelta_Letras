package modelo;

public class Frases {
	String[] frasesTotales;
	String[] frasesTablero;

	public Frases() {
		frasesTotales = new String[30];
		frasesTablero = new String[6];
		frasesTotales [0] = "Todo_es_posible";
		frasesTotales [1] = "Responsabilidad";
		frasesTotales [2] = "Entretenimiento";
		frasesTotales [3] = "Descoordinacion";
		frasesTotales [4] = "Espontáneamente";
		frasesTotales [5] = "Inevitablemente";
		frasesTotales [6] = "Inadecuadamente";
		frasesTotales [7] = "trastrocamiento";
		frasesTotales [8] = "Iran_es_un_pais";
		frasesTotales [9] = "Juego_de_tronos";
		frasesTotales [10] = "El_agua_del_mar";
		frasesTotales [11] = "La_luna_es_azul";
		frasesTotales [12] = "Hace_calor_aqui";
		frasesTotales [13] = "La_paz_interior";
		frasesTotales [14] = "Soy_programador";
		frasesTotales [15] = "La_bola_botando";
		frasesTotales [16] = "El_periquito_es";
		frasesTotales [17] = "El_aguila_vuela";
		frasesTotales [18] = "Me_llamo_Andres";
		frasesTotales [19] = "Mostrar_tablero";
		frasesTotales [20] = "Yendo_para_casa";
		frasesTotales [21] = "Hoy_juego_tenis";
		frasesTotales [22] = "Ronaldo_Nazario";
		frasesTotales [23] = "La_silla_bonita";
		frasesTotales [24] = "Coche_deportivo";
		frasesTotales [25] = "Fernando_Alonso";
		frasesTotales [26] = "El_pulpo_grande";
		frasesTotales [27] = "El_tiburon_caza";
		frasesTotales [28] = "El_caballo_come";
		frasesTotales [29] = "El_primer_barco";
		
		
	}

	public String[] getFrasesTotales() {
		return frasesTotales;
	}

	public void setFrasesTotales(String[] frasesTotales) {
		this.frasesTotales = frasesTotales;
	}

	public String[] getFrasesTablero() {
		return frasesTablero;
	}

	public void setFrasesTablero(String[] frasesTablero) {
		this.frasesTablero = frasesTablero;
	}

}
