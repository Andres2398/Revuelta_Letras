package modelo;

/**
 * Clase con un array con todas las frases elegibles para el tablero y otro array con las 6 frases del tablero
 */
public class Frases {
	String[] frasesTotales;
	String[] frasesTablero;
	
	/**
	 * constructor del tablero inicalizando las 30 posibles frases del tablero y el array con 6 que se incluiran en el tablero
	 */
	public Frases() {
		frasesTotales = new String[30];
		frasesTablero = new String[6];
		frasesTotales[0] = "TODO_ES_POSIBLE";
		frasesTotales[1] = "RESPONSABILIDAD";
		frasesTotales[2] = "ENTRETENIMIENTO";
		frasesTotales[3] = "DESCOORDINACION";
		frasesTotales[4] = "ESPONTANEAMENTE";
		frasesTotales[5] = "INEVITABLEMENTE";
		frasesTotales[6] = "INADECUADAMENTE";
		frasesTotales[7] = "TRASTROCAMIENTO";
		frasesTotales[8] = "IRAN_ES_UN_PAIS";
		frasesTotales[9] = "JUEGO_DE_TRONOS";
		frasesTotales[10] = "EL_AGUA_DEL_MAR";
		frasesTotales[11] = "LA_LUNA_ES_AZUL";
		frasesTotales[12] = "HACE_CALOR_AQUI";
		frasesTotales[13] = "LA_PAZ_INTERIOR";
		frasesTotales[14] = "SOY_PROGRAMADOR";
		frasesTotales[15] = "LA_BOLA_BOTANDO";
		frasesTotales[16] = "EL_PERIQUITO_ES";
		frasesTotales[17] = "EL_AGUILA_VUELA";
		frasesTotales[18] = "ME_LLAMO_ANDRES";
		frasesTotales[19] = "MOSTRAR_TABLERO";
		frasesTotales[20] = "YENDO_PARA_CASA";
		frasesTotales[21] = "HOY_JUEGO_TENIS";
		frasesTotales[22] = "RONALDO_NAZARIO";
		frasesTotales[23] = "LA_SILLA_BONITA";
		frasesTotales[24] = "COCHE_DEPORTIVO";
		frasesTotales[25] = "FERNANDO_ALONSO";
		frasesTotales[26] = "EL_PULPO_GRANDE";
		frasesTotales[27] = "EL_TIBURON_CAZA";
		frasesTotales[28] = "EL_CABALLO_COME";
		frasesTotales[29] = "EL_PRIMER_BARCO";
	}
	
	/**
	 * metodo para obtener el array con todas las frases 
	 * @return Retorna el array con las 30 frases 
	 */
	public String[] getFrasesTotales() {
		return frasesTotales;
	}
	
	/**
	 * metodo para obtener el array con las 6 frases introducidas en el tablero
	 * @return retorna el array de las frases que tenemos en el tablero 
	 */
	public String[] getFrasesTablero() {
		return frasesTablero;
	}
	/**
	 * metodo para esatablecer las frases del tablero
	 * @param frasesTablero array con 6 frases
	 */
	
	public void setFrasesTablero(String[] frasesTablero) {
		this.frasesTablero = frasesTablero;
	}

}
