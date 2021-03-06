package Model;

import java.util.ArrayList;
import java.util.List;

import utils.*;

public class Game {
    private State state;
    private Board board;
    private List<Carro> carros;
    private int puntos;
    private int life;
    
    public  Game(){
        this.state = State.START;
        this.board = new Board();
        this.carros = new ArrayList<>();
        this.puntos = 0;
        this.life = 0;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = this.puntos +puntos;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }


    @Override
    public String toString() {
        return "Life=" + life + ", Puntos=" + puntos + ", State=" + state + "]";
    }

  
    
    
}