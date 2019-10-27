package controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import models.Game;
import models.State;
import models.StateValue;

public class CancelControllerTest {

    public CancelControllerTest() {
    }

    @Test
    public void givenCancelControllerWhenCancelGameMoveToFinalStateRequiereCorrectThenNotError() {
        State state = new State();
        Game game = new Game();
        CancelController cancelController = new CancelController(game, state);
        assertEquals(StateValue.INITIAL, state.getStateValue());
        cancelController.nextState();
        assertEquals(StateValue.OPENED_GAME, state.getStateValue());
        cancelController.cancelGame();
        assertEquals(StateValue.FINAL, state.getStateValue());
    }
}