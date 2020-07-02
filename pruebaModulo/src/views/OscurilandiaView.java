package views;

import java.util.InputMismatchException;
import java.util.Scanner;
import Model.Coordinates;
import controller.EndingController;
import controller.GameController;
import controller.ShootController;
import controller.StartController;

public class OscurilandiaView {
    private Scanner teclado = new Scanner(System.in);

    public void invocate(GameController controller) throws Exception {

        if (controller instanceof ShootController) {
            this.viewInGame((ShootController) controller);

        } else if (controller instanceof StartController) {
            this.viewInStart((StartController) controller);
        } else {
            this.viewEnd((EndingController) controller);
        }
    }

    private void viewInStart(StartController controller) {
        System.out.println("----- CONSECUENCIAS -----");
        System.out.println("El gobierno de Oscurilandia esta corrompido y el pueblo se a levantado");
        System.out.println("y asi ha nacido la FirstLine, un grupo de super heroes que luchan contra");
        System.out.println("la camara secreta de Oscurilandia.");
        System.out.println("");
        System.out.println("Ayuda a FirtsLine en su lucha para derrocar a los corruptos");
        System.out.println("Debes lanzarles huevos a:");
        System.out.println("");
        System.out.println("Trupalla 	: 1 punto");
        System.out.println("Kromi	 	: 3 puntos y si la inutilizas +10 puntos");
        System.out.println("Caguano		: 2 puntos y si la inutilizas +7 puntos");
        System.out.println("");
        System.out.println("Contamos contigo en esta misión.");
        System.out.println("");
        controller.start();
    }

    private void viewInGame(ShootController controller) throws Exception {

        try {
            System.out.println(controller.getState());
            System.out.println("lanzar huevo o para salir presione 'S' ");
            System.out.println("1. coordenada fila");
            int fila = this.teclado.nextInt();
            System.out.println("2. coordenada columna");
            int columna = this.teclado.nextInt();
            Coordinates coordinate = new Coordinates(fila, columna);
            controller.shoot(coordinate);
        } catch (InputMismatchException e) {
            if (this.teclado.nextLine().equalsIgnoreCase("s")) {
                controller.changeEndGame(true);
            } else {
                throw new Exception("error coordenada");
            }
            ;
        }
    }

    private void viewEnd(EndingController controller) {
        switch (controller.getRanking()) {
            case Malo:
                System.out.println("Malo sigue intentandolo");
                break;
            case Medium:
                System.out.println("Puedes mejorar");
                break;
            case Bueno:
                System.out.println("Buen juego!!");
                break;
        }
    }

}