package Model;

import java.util.ArrayList;
import java.util.List;

public class Carro {
    protected int life;
    protected List<Coordinates> coordinates;

    protected Carro(int life) {
        this.life = life;
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

    public Boolean containsCoordinates(Coordinates coordinates) {
        return this.coordinates.stream()
                .anyMatch(x -> x.getFile() == coordinates.getFile() && x.getColumn() == coordinates.getColumn());
    }

    public void removeCoordinates(Coordinates coordinates) {
        this.coordinates
                .removeIf(x -> x.getFile() == coordinates.getFile() && x.getColumn() == coordinates.getColumn());
    }

    public List<Coordinates> getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(List<Coordinates> coordinates) {
       this.coordinates = coordinates;
    }

}