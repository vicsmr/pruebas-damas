package models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TurnTest {

    private Turn turn;

    public TurnTest() {
    }

    @Before
    public void before() {
        turn = new Turn();
    }

    @Test
    public void givenTurnWhenInitializeIsWhiteRequireCorrectThenNotError() {
        assertEquals(Color.WHITE, turn.getColorTurn());
    }

    @Test
    public void givenTurnWhenChangeTurnObtainContraryColorRequireCorrectThenNotError() {
        turn.changeTurn();
        assertEquals(Color.BLACK, turn.getColorTurn());
    }

}