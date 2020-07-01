package controller;

import Model.Coordinates;

public interface ShootController extends ColocateController {
    void shoot(Coordinates coordinates);
}