package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Model.Carro;
import Model.Coordinates;
import Model.Game;

public abstract class GameController {
    protected Game game;
    protected List<Carro> carros;

    public GameController(Game game) {
        this.game = game;
        this.carros = new ArrayList<>();

    }
    public abstract void controller();

    public void addCarro(Carro carro){
        this.carros.add(carro);
    }

    private Boolean isValidCoordinates(Coordinates coordinates) {
        return this.game.getBoard().isValid(coordinates.getFile(), coordinates.getFile());
    }

    protected Coordinates firstCoordinateValid() {
        Coordinates coordinateRef = new Coordinates();
        while (!this.isValidCoordinates(coordinateRef)) {
            coordinateRef = new Coordinates();
        }
        return coordinateRef;
    }

    protected Coordinates coordinateHorizontalLeft(Coordinates coordinate){
          return new Coordinates(coordinate.getFile(),coordinate.getColumn()-1);
    }

    protected Coordinates coordinateHorizontalRight(Coordinates coordinate){
        return new Coordinates(coordinate.getFile(),coordinate.getColumn()+1);
    }

    protected List<Coordinates> HorizontalCoordinateValid() {   
        List<Coordinates> coordenadas = new ArrayList<>();
         do {
            Coordinates coordinateRef = this.firstCoordinateValid();
            Coordinates coordinateRight = this.coordinateHorizontalRight(coordinateRef);
            Coordinates coordinateLeft = this.coordinateHorizontalLeft(coordinateRef);            
            if(this.isValidCoordinates(coordinateRight)){
                coordenadas.add(coordinateRef);
                coordenadas.add(coordinateRight);
            }else if(this.isValidCoordinates(coordinateLeft)){
                coordenadas.add(coordinateRef);
                coordenadas.add(coordinateLeft);
            }
        } while (coordenadas.isEmpty());

        return coordenadas;
    }

  

}   