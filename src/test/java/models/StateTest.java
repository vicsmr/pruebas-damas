package models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StateTest {

    private State state;

    public StateTest() {
    }

    @Before
    public void before() {
        this.state = new State();
    }

    @Test
    public void givenStateWhenChangeRequireCorrectThenNotError() {
        assertEquals(StateValue.INITIAL, this.state.getStateValue());
        this.state.nextState();
        assertEquals(StateValue.OPENED_GAME, this.state.getStateValue());
        this.state.nextState();
        assertEquals(StateValue.FINAL, this.state.getStateValue());
    }
}