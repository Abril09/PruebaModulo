package Model;

import java.util.ArrayList;
import java.util.List;

import utils.Colors;

public class Carro {

    protected int life;
    protected List<Coordinates> coordinates;
    protected Colors color;

    protected Carro(int life,Colors color) {
        this.life = life;
        this.color = color;
        this.coordinates = new ArrayList<>();
    }

    public Boolean addCoordinates(Coordinates coordinates) {
        if (this.coordinates.size() < life) {
            this.coordinates.add(coordinates);
            return true;
        }
        return false;
    }

    public Boolean isDead() {
        return this.coordinates.isEmpty();
    }

    public int getLife(){
        return this.life;
    }
  
    public Boolean removeCoordinates(Coordinates coordinates) {
       return this.coordinates
                .removeIf(x -> x.getFile() == coordinates.getFile() && x.getColumn() == coordinates.getColumn());
    }

    public List<Coordinates> getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(List<Coordinates> coordinates) {
       this.coordinates = coordinates;
    }

    public Colors getColor() {
        return color;
    }

    public String getColorToString(){
        return this.color.getSimbol();
    }




}
