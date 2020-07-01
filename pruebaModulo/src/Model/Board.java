
package Model;

import utils.Colors;

public class Board {
    private  final Integer DIMENSION = 15;
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
     return matrix[file][column] == Colors.EMPY.getSimbol() 
            && file < DIMENSION & column < DIMENSION ;
    }



    
    public void put(int file, int column,String simbols){
        matrix[file][column] = simbols; 
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