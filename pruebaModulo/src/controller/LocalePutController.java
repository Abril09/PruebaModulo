package controller;
import java.util.Scanner;
import Model.Carro;
import Model.Coordinates;
import Model.Game;
import utils.Colors;
import utils.Configuracion;

public class LocalePutController extends GameController implements ShootController{
    public LocalePutController(Game game) {
        super(game);
    }

    @Override
    public void controller() {

    }

    public void shoot(Coordinates coordinates) {
        for (Carro carro : this.getCarro()) {
            if (carro.removeCoordinates(coordinates)) {
                   this.deletedCoordinates(coordinates);
                   this.setPuntos(this.assignedPts(carro.getColor(),carro.isDead()));
                   if(carro.isDead()){
                       this.getCarro().remove(carro);
                   }
                break;
            }
        }
        this.printBoard();
        System.out.println("pts " + this.getPuntos());
    }

    
    private int  assignedPts(Colors color,Boolean dead){
        switch (color) {               
            case CAGUANOS:
                return dead ? (Configuracion.PTS_CAGUANOS_SHOOT+Configuracion.PTS_CAGUANOS_DEAD)
                            : Configuracion.PTS_CAGUANOS_SHOOT;
            case KROMIS:
                return dead ? (Configuracion.PTS_KROMIS_SHOOT+Configuracion.PTS_KROMIS_DEAD)
                                :Configuracion.PTS_KROMIS_SHOOT;                
            default:
                return Configuracion.PTS_TRUPALLA_SHOOT;            
        }
    }
    
    private void printBoard(){
        for (Carro carro : this.getCarro()) {
            carro.getCoordinates().stream().forEach((x)->{
                this.game.getBoard().put(x.getFile(),x.getColumn(),String.valueOf( carro.getColorToString()));
         });   
        }
        this.game.getBoard().print();
    }

}