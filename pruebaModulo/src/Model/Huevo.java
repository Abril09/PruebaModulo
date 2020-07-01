package Model;

public class Huevo {

	private int fila;
	private int columna;
	private int puntaje;
	
	public Huevo(int fila, int columna, int puntaje) {
		this.fila = fila;
		this.columna = columna;
		this.puntaje = puntaje;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	
}


