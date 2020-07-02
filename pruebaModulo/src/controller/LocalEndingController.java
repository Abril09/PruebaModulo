package controller;

import Model.Game;
import utils.NivelJugador;
import utils.State;

public class LocalEndingController extends LocalGameController implements EndingController {

    public LocalEndingController(Game game) {
        super(game);

    }

    @Override
    public NivelJugador getRanking() {
        this.game.setState(State.END);

        if (NivelJugador.Bueno.getNivel() <= this.getPuntos()) {
            return NivelJugador.Bueno;

        } else if (NivelJugador.Medium.getNivel() <=  this.getPuntos()) {
            return NivelJugador.Medium;

        } else {
            return NivelJugador.Malo;
        }
        
    }

}