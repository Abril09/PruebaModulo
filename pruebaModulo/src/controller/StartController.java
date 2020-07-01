package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Model.Caguano;
import Model.Carro;
import Model.Coordinates;
import Model.Game;
import Model.Trupaya;


public class StartController extends GameController {
    private int caguanos =30;
    private int trupaya = 10;

    public StartController(Game game) {
        super(game);
    }

    @Override
    public void controller() {
        for (int i = 0; i < trupaya; i++) {
            this.printBoard(this.createTrupaya());    
         }
        for (int i = 0; i < caguanos; i++) {
            this.printBoard(this.createCaguano());    
        }
            
     
       
       this.game.getBoard().print();
        this.carros.stream().map(x->x.getCoordinates()).iterator().next().forEach(System.out::println);
    }

    private void printBoard(Carro carro){
        carro.getCoordinates().stream().forEach((x)->{
                this.game.getBoard().put(x.getFile(),x.getColumn(),String.valueOf( carro.getLife()));
         });            
         this.addCarro(carro);       
     }


    private Trupaya createTrupaya(){
        Trupaya trupaya = new Trupaya();
        trupaya.addCoordinates(this.firstCoordinateValid());
        return trupaya;
    }

    private Caguano createCaguano(){
        Caguano caguano = new Caguano();
        List<Coordinates> list = this.HorizontalCoordinateValid();      
        caguano.setCoordinates(list);
        return caguano;
    }

  

    
    
}