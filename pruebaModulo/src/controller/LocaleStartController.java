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


public class LocaleStartController extends GameController implements StartController{
    public LocaleStartController(Game game) {
        super(game);
    }


    public void start() {
        for (int i = 0; i < Configuracion.CANTIDAD_KROMIS; i++) {
            this.printBoard(this.createkromi());
        }
        for (int i = 0; i < Configuracion.CANTIDAD_CAGUANOS; i++) {
            this.printBoard(this.createCaguano());    
        }
        for (int i = 0; i < Configuracion.CANTIDAD_TRUPALLAS; i++) {
            this.printBoard(this.createTrupaya());    
        }
    
                 
        this.game.getBoard().print();
        this.game.setState(State.GAME);
    }
   
    private Kromi createkromi(){
        Kromi  kromi= new Kromi();
        List<Coordinates> list = this.verticalCoordinatesValid();
        kromi.setCoordinates(list);
        return kromi;
    }
    
    private Trupalla createTrupaya(){
        Trupalla trupaya = new Trupalla();
        trupaya.addCoordinates(this.firstCoordinateValid());
        return trupaya;
    }

    private Caguano createCaguano(){
        Caguano caguano = new Caguano();
        List<Coordinates> list = this.HorizontalCoordinateValid();      
        caguano.setCoordinates(list);
        return caguano;
    }



    private List<Coordinates> verticalCoordinatesValid(){
        List<Coordinates> coordenadas = new ArrayList<>();
        do {
            Coordinates coordinateRef = this.firstCoordinateValid();
            Coordinates cordinateUP = this.coordinateVerticalUp(coordinateRef);
            Coordinates cordinaDown = this.coordinateVerticalDown(coordinateRef);
            if(this.isValidCoordinates(cordinateUP)&& this.isValidCoordinates(cordinaDown)){
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

    @Override
    public void controller() {
        // TODO Auto-generated method stub

    }
    
}