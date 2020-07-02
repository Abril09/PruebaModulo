package utils;

public enum NivelJugador {
    Malo(15),Medium(30),Bueno(40);
    
    private int nivel;

    private NivelJugador(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }


}