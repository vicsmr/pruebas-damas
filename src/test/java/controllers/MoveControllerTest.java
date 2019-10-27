package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import models.Coordinate;
import models.Game;
import models.State;
import models.StateValue;

public class MoveControllerTest {

    MoveController moveController;
    Game game;
    State state;

    public MoveControllerTest() {
    }

    @Before
    public void before() {
        game = new Game();
        state = new State();
        moveController = new MoveController(game,state);
    }

    @Test
    public void givenMoveControllerWhenMoveTheStateNotChangeRequiereCorrectThenNotError() {
        Coordinate origin = new Coordinate(9, 0);
        Coordinate target = new Coordinate(10, 1);
        this.moveController.nextState();
        assertNotNull(this.moveController.move(origin, target));
        assertEquals(StateValue.OPENED_GAME, this.state);
    }

}