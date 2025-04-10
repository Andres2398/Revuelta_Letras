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
		frasesTotales [0] = "Abababababababb";
		frasesTotales [1] = "Cdcdcdcdcdcdcdd";
		frasesTotales [2] = "Efefefefefefeff";
		frasesTotales [3] = "Ghghghghghghghh";
		frasesTotales [4] = "Ijijijijijijijj";
		frasesTotales [5] = "Klklklklklklkll";
		frasesTotales [6] = "Abababababababb";
		frasesTotales [7] = "Cdcdcdcdcdcdcdd";
		frasesTotales [8] = "Efefefefefefeff";
		frasesTotales [9] = "Ghghghghghghghh";
		frasesTotales [10] = "Ijijijijijijijj";
		frasesTotales [11] = "Klklklklklklkll";
		frasesTotales [12] = "Abababababababb";
		frasesTotales [13] = "Cdcdcdcdcdcdcdd";
		frasesTotales [14] = "Efefefefefefeff";
		frasesTotales [15] = "Ghghghghghghghh";
		frasesTotales [16] = "Ijijijijijijijj";
		frasesTotales [17] = "Klklklklklklkll";
		frasesTotales [18] = "Abababababababb";
		frasesTotales [19] = "Cdcdcdcdcdcdcdd";
		frasesTotales [20] = "Efefefefefefeff";
		frasesTotales [21] = "Ghghghghghghghh";
		frasesTotales [22] = "Ijijijijijijijj";
		frasesTotales [23] = "Klklklklklklkll";
		frasesTotales [24] = "Abababababababb";
		frasesTotales [25] = "Cdcdcdcdcdcdcdd";
		frasesTotales [26] = "Efefefefefefeff";
		frasesTotales [27] = "Ghghghghghghghh";
		frasesTotales [28] = "Ijijijijijijijj";
		frasesTotales [29] = "Klklklklklklkll";
		
		
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
