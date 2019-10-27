package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import models.Coordinate;
import models.Game;
import models.Piece;
import models.State;
import models.StateValue;

public class StartControllerTest {

    private StartController startController;
    private Game game;
    private State state;

    public StartControllerTest() {
    }

    @Before
    public void before() {
        game = new Game();
        state = new State();
        startController = new StartController(game, state);
        startController.newGame();
    }

    @Test
    public void givenStartControllerWhenCreateNewGameCheckOnePieceRequiereCorrectThenNotError() {
        Coordinate coordinate = new Coordinate(1, 6);
        Piece piece = game.getPiece(coordinate);
        assertNotNull(piece);
        assertEquals(Color.WHITE, piece.getColor());
    }

    @Test
    public void givenStartControllerWhenCreateNewGameCheckOneSquareIsEmptyRequiereCorrectThenNotError() {
        Coordinate coordinate = new Coordinate(1, 5);
        assertNull(game.getPiece(coordinate));
    }

    @Test
    public void givenStartControllerWhenCreateNewGameCheckStateChangeRequiereCorrectThenNotError() {
        assertEquals(StateValue.OPENED_GAME, this.state.getStateValue());
    }
}