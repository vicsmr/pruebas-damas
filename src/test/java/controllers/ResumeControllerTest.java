package controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import models.Game;
import models.State;
import models.StateValue;

public class ResumeControllerTest {

    public ResumeControllerTest() {
    }

    @Test
    public void givenResumeControllerWhenResumeGameMoveToInitialStateRequiereCorrectThenNotError() {
        State state = new State();
        Game game = new Game();
        ResumeController resumeController = new ResumeController(game, state);
        assertEquals(StateValue.INITIAL, state.getStateValue());
        resumeController.nextState();
        assertEquals(StateValue.OPENED_GAME, state.getStateValue());
        resumeController.nextState();
        assertEquals(StateValue.FINAL, state.getStateValue());
        resumeController.resume(true);
        assertEquals(StateValue.INITIAL, state.getStateValue());
    }
}