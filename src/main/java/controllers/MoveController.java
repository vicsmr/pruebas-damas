package controllers;

import models.Coordinate;
import models.Error;
import models.Game;
import models.State;

public class MoveController extends Controller {

    public MoveController(Game game, State state) {
        super(game, state);
    }

    public Error move(Coordinate origin, Coordinate target) {
        return null;
    }
}