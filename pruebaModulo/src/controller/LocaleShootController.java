package controller;

import Model.Carro;
import Model.Coordinates;
import Model.Game;
import utils.Colors;
import utils.Configuracion;
import utils.State;

public class LocaleShootController extends LocalGameController implements ShootController {
    public LocaleShootController(Game game) {
        super(game);
    }

    public void shoot(Coordinates coordinates) throws Exception {

        for (Carro carro : this.getCarro()) {
            if (carro.removeCoordinates(coordinates)) {
                this.deletedCoordinates(coordinates);
                this.setPuntos(this.assignedPts(carro.getColor(), carro.isDead()));
                if (carro.isDead()) {
                    this.getCarro().remove(carro);
                }
                break;
            }
        }
        this.setLife(this.getLife() - 1);
        this.changeEndGame(this.getLoose());
        this.printBoard();

    }

    public void changeEndGame(Boolean end) {
        if (end) {
            this.game.setState(State.BEFORE_END);
        }
    }

    public String getState() {
        return this.getStateGame();
    };

    private int assignedPts(Colors color, Boolean dead) {
        switch (color) {
            case CAGUANOS:
                return dead ? (Configuracion.PTS_CAGUANOS_SHOOT + Configuracion.PTS_CAGUANOS_DEAD)
                        : Configuracion.PTS_CAGUANOS_SHOOT;
            case KROMIS:
                return dead ? (Configuracion.PTS_KROMIS_SHOOT + Configuracion.PTS_KROMIS_DEAD)
                        : Configuracion.PTS_KROMIS_SHOOT;
            default:
                return Configuracion.PTS_TRUPALLA_SHOOT;
        }
    }

}