package controllers;

import models.Game;
import models.State;

public class StartController extends AcceptController {

    public StartController(Game game, State state) {
        super(game, state);
    }

    public Game newGame() {
        return null;
    }
}