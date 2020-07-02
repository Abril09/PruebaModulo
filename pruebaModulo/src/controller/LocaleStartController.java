package controller;

import java.util.ArrayList;
import java.util.List;
import Model.Caguano;
import Model.Coordinates;
import Model.Game;
import Model.Kromi;
import Model.Trupalla;
import utils.Configuracion;
import utils.State;

public class LocaleStartController extends LocalGameController implements StartController {
    private static int LIFE = Configuracion.PTS_LIFE_GAME;

    public LocaleStartController(Game game) {
        super(game);
        this.game.setLife(LIFE);
    }

    public void start() {
        for (int i = 0; i < Configuracion.CANTIDAD_KROMIS; i++) {
            this.createkromi();
        }
        for (int i = 0; i < Configuracion.CANTIDAD_CAGUANOS; i++) {
            this.createCaguano();
        }
        for (int i = 0; i < Configuracion.CANTIDAD_TRUPALLAS; i++) {
            this.createTrupaya();
        }

        this.printBoard();
        this.game.setState(State.GAME);
    }

    private void createkromi() {
        Kromi kromi = new Kromi();
        List<Coordinates> list = this.verticalCoordinatesValid();
        kromi.setCoordinates(list);
        this.addCarro(kromi);

    }

    private void createTrupaya() {
        Trupalla trupaya = new Trupalla();
        trupaya.addCoordinates(this.firstCoordinateValid());
        this.addCarro(trupaya);
    }

    private void createCaguano() {
        Caguano caguano = new Caguano();
        List<Coordinates> list = this.HorizontalCoordinateValid();
        caguano.setCoordinates(list);
        this.addCarro(caguano);
    }

    private List<Coordinates> verticalCoordinatesValid() {
        List<Coordinates> coordenadas = new ArrayList<>();
        do {
            Coordinates coordinateRef = this.firstCoordinateValid();
            Coordinates cordinateUP = this.coordinateVerticalUp(coordinateRef);
            Coordinates cordinaDown = this.coordinateVerticalDown(coordinateRef);
            if (this.isValidCoordinates(cordinateUP) && this.isValidCoordinates(cordinaDown)) {
                coordenadas.add(coordinateRef);
                coordenadas.add(cordinateUP);
                coordenadas.add(cordinaDown);
            }
        } while (coordenadas.isEmpty());

        return coordenadas;
    }

    private List<Coordinates> HorizontalCoordinateValid() {
        List<Coordinates> coordenadas = new ArrayList<>();
        do {
            Coordinates coordinateRef = this.firstCoordinateValid();
            Coordinates coordinateRight = this.coordinateHorizontalRight(coordinateRef);
            Coordinates coordinateLeft = this.coordinateHorizontalLeft(coordinateRef);
            if (this.isValidCoordinates(coordinateRight)) {
                coordenadas.add(coordinateRef);
                coordenadas.add(coordinateRight);
            } else if (this.isValidCoordinates(coordinateLeft)) {
                coordenadas.add(coordinateRef);
                coordenadas.add(coordinateLeft);
            }
        } while (coordenadas.isEmpty());

        return coordenadas;
    }

}