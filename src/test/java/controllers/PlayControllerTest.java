package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import models.Coordinate;
import models.Game;
import models.State;
import models.StateValue;

public class PlayControllerTest {

    PlayController playController;
    Game game;
    State state;

    public PlayControllerTest() {
    }

    @Before
    public void before() {
        game = new Game();
        state = new State();
        playController = new PlayController(game,state);
    }

    @Test
    public void givenPlayControllerWhenMoveTheStateNotChangeRequiereCorrectThenNotError() {
        Coordinate origin = new Coordinate(9, 0);
        Coordinate target = new Coordinate(10, 1);
        this.playController.nextState();
        assertNotNull(this.playController.move(origin, target));
        assertEquals(StateValue.OPENED_GAME, this.state);
    }

}