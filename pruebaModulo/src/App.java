import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Model.Coordinates;
import controller.GameController;
import controller.Logic;
import utils.Direction;

public class App {
    private static Logic logic;
    private static GameController controller;


    private static void play(){
        logic = new Logic();  
        logic.getController().controller();;
            
    }

    public static void main(String[] args) throws Exception {



        play();

    }
}
