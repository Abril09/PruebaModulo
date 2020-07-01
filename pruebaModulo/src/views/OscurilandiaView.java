package views;

import java.util.Scanner;

import Model.Coordinates;
import controller.ColocateController;
import controller.ShootController;
import controller.StartController;

public class OscurilandiaView {
    private Scanner teclado = new Scanner(System.in);

    public  void invocate(ColocateController controller){
        if( controller instanceof ShootController){

            this.viewInGame((ShootController)controller);

        }else if( controller instanceof StartController){
            this.viewInStart((StartController)controller);
        }
      
    }

    private void viewInStart(StartController controller){
        controller.start();
    }

    private void viewInGame(ShootController controller){
        System.out.println("volver a lanzar");
        System.out.println("1. coordenada x");       
        int x =this.teclado.nextInt();         
        System.out.println("2. coordenada y");
        int y =this.teclado.nextInt();            
        Coordinates coordinate = new Coordinates(x,y);
        controller.shoot(coordinate);
    }

}