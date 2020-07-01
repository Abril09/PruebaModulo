package controller;
import Model.Game;
import utils.State;

public class Logic {
    private Game game;
    private LocaleStartController startController;
    private LocalePutController putController;

    public Logic(){
        this.game = new Game();
        this.startController = new LocaleStartController(game);
        this.putController = new LocalePutController(game);
    }

    public ColocateController getController(){
        switch (this.game.getState()) {
            case START:
                 return  this.startController;
            case GAME:
                 return this.putController;      
            default:
                return  this.startController;                   
          }
    }

    public State getGameState(){
        return this.game.getState();
    }
}