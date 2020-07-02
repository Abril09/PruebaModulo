package controller;

import Model.Coordinates;

public interface ShootController extends GameController {
    void shoot(Coordinates coordinates)throws Exception;
    String getState();
    void changeEndGame(Boolean end);
}