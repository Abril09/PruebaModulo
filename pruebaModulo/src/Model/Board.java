package Model;
import utils.Colors;
import utils.Configuracion;

public class Board {
    private  final Integer DIMENSION = Configuracion.TAMAÑO_MATRIZ;
    private String [][] matrix;

    public Board (){
        matrix = new String[DIMENSION][DIMENSION];
        this.write();
    }

    private void write(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                  matrix[i][j] = Colors.EMPY.getSimbol();  
            }
        }
    }
    
    public Boolean isValid(int file, int column){
     if(DIMENSION > file && column < DIMENSION && column >= 0 && 0 <= file){
        return (this.matrix[file][column] == Colors.EMPY.getSimbol());  
     }  
      return false;   
    }
   
    public void put(int file, int column,String simbols){
        if(DIMENSION > file && column < DIMENSION ){
            matrix[file][column] = simbols;
        }
    }

    public void delete(int file, int column){
        matrix[file][column] = Colors.EMPY.getSimbol() ;
    }


    public void print(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                   System.out.print(matrix[i][j] + " ");                   
            }
            System.out.println();
        }
        System.out.println();
    }
    
}