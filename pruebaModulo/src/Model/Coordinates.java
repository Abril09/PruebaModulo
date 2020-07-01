package Model;
import java.util.Random;

import utils.Configuracion;

public class Coordinates {
    private  int file;
    private int column;
    

    public Coordinates(int file, int column) {
        this.file = file;
        this.column = column;
    }

    public Coordinates(){
        int[] random = new Random().ints(2, 0, Configuracion.TAMAÑO_MATRIZ).toArray();
        this.file =random[0];
        this.column = random[1];
    }
    

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    
}