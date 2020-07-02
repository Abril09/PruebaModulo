package controller;
import Model.Game;
import utils.State;

public class Logic {
    private Game game;
    private LocaleStartController startController;
    private LocaleShootController putController;
    private LocalEndingController endingController;

    public Logic(){
        this.game = new Game();
        this.startController = new LocaleStartController(game);
        this.putController = new LocaleShootController(game);
        this.endingController = new LocalEndingController(game);
    }

    public GameController getController(){
        switch (this.game.getState()) {
            case START:
                 return  this.startController;
            case GAME:
                 return this.putController;  
            case BEFORE_END:
                 return this.endingController;           
            default:
                return  this.startController;                   
          }
    }

    public State getGameState(){
        return this.game.getState();
    }

    public void printBoard(){
        this.game.getBoard().print();
    }

    public String getState(){
        return this.game.toString();
    }
}