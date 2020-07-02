package controller;

import java.util.List;
import Model.Carro;
import Model.Coordinates;
import Model.Game;

public class LocalGameController {
    protected Game game;

    public LocalGameController(Game game) {
        this.game = game;
    }

    protected Boolean isValidCoordinates(Coordinates coordinates) {
        return this.game.getBoard().isValid(coordinates.getFile(), coordinates.getColumn());
    }

    protected void deletedCoordinates(Coordinates coordinates) {
        this.game.getBoard().delete(coordinates.getFile(), coordinates.getColumn());
    }

    protected Coordinates firstCoordinateValid() {
        Coordinates coordinateRef = new Coordinates();
        while (!this.isValidCoordinates(coordinateRef)) {
            coordinateRef = new Coordinates();
        }
        return coordinateRef;
    }

    protected Coordinates coordinateHorizontalLeft(Coordinates coordinate) {
        return new Coordinates(coordinate.getFile(), coordinate.getColumn() - 1);
    }

    protected Coordinates coordinateHorizontalRight(Coordinates coordinate) {
        return new Coordinates(coordinate.getFile(), coordinate.getColumn() + 1);
    }

    protected Coordinates coordinateVerticalUp(Coordinates coordinate) {
        return new Coordinates(coordinate.getFile() - 1, coordinate.getColumn());
    }

    protected Coordinates coordinateVerticalDown(Coordinates coordinate) {
        return new Coordinates(coordinate.getFile() + 1, coordinate.getColumn());
    }

    protected int getPuntos() {
        return this.game.getPuntos();
    }

    protected void setPuntos(int puntos) {
        this.game.setPuntos(puntos);
    }

    protected void addCarro(Carro carro) {
        this.game.getCarros().add(carro);
    }

    protected List<Carro> getCarro() {
        return this.game.getCarros();
    }

    protected void setLife(int life) {
        this.game.setLife(life);
    }

    protected int getLife() {
        return this.game.getLife();
    }

    protected Boolean getLoose() {
        return this.game.getLife() == 0;
    }

    protected String getStateGame() {
        return this.game.toString();
    }

    protected void printBoard() {
        for (Carro carro : this.getCarro()) {
            carro.getCoordinates().stream().forEach((x) -> {
                this.game.getBoard().put(x.getFile(), x.getColumn(), String.valueOf(carro.getColorToString()));
            });
        }

    }

}