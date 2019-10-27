package controllers;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.Coordinate;
import models.Game;
import models.State;

public class PlayControllerTest {

    public PlayControllerTest() {
    }

    @Test
    public void givenBoardWhenAPlayerCanNotMoveCorrectThenNotError() {
        Game game = new Game();
        State state = new State();
        PlayController playController = new PlayController(game, state);

        Coordinate oneRowSixColumnPosition = new Coordinate(1, 6);
        Coordinate twoRowFiveColumnPosition = new Coordinate(2, 5);
        Coordinate threeRowSixColumnPosition = new Coordinate(3, 6);
        Coordinate fourRowFiveColumnPosition = new Coordinate(4, 5);
        Coordinate fiveRowSixColumnPosition = new Coordinate(5, 6);
        Coordinate sixRowFiveColumnPosition = new Coordinate(6, 5);
        Coordinate sevenRowSixColumnPosition = new Coordinate(7, 6);
        Coordinate eightRowFiveColumnPosition = new Coordinate(8, 5);
        Coordinate twoRowSevenColumnPosition = new Coordinate(2, 7);
        Coordinate fourRowSevenColumnPosition = new Coordinate(4, 7);
        Coordinate sixRowSevenColumnPosition = new Coordinate(6, 7);
        Coordinate eightRowSevenColumnPosition = new Coordinate(8, 7);
        Coordinate oneRowEightColumnPosition = new Coordinate(1, 8);
        Coordinate threeRowEightColumnPosition = new Coordinate(3, 8);
        Coordinate fiveRowEightColumnPosition = new Coordinate(5, 8);
        Coordinate sevenRowEightColumnPosition = new Coordinate(7, 8);

        Coordinate oneRowFourColumnPosition = new Coordinate(1, 4);
        Coordinate threeRowFourColumnPosition = new Coordinate(3, 4);
        Coordinate fiveRowFourColumnPosition = new Coordinate(5, 4);
        Coordinate sevenRowFourColumnPosition = new Coordinate(7, 4);
        Coordinate twoRowThreeColumnPosition = new Coordinate(2, 3);
        Coordinate fourRowThreeColumnPosition = new Coordinate(4, 3);
        Coordinate sixRowThreeColumnPosition = new Coordinate(6, 3);
        Coordinate eightRowThreeColumnPosition = new Coordinate(8, 3);
        Coordinate oneRowTwoColumnPosition = new Coordinate(1, 2);
        Coordinate threeRowTwoColumnPosition = new Coordinate(3, 2);
        Coordinate fiveRowTwoColumnPosition = new Coordinate(5, 2);
        Coordinate sevenRowTwoColumnPosition = new Coordinate(7, 2);
        Coordinate twoRowOneColumnPosition = new Coordinate(2, 1);
        Coordinate fourRowOneColumnPosition = new Coordinate(4, 1);
        Coordinate sixRowOneColumnPosition = new Coordinate(6, 1);
        Coordinate eightRowOneColumnPosition = new Coordinate(8, 1);

        assertNull(playController.move(oneRowSixColumnPosition, twoRowFiveColumnPosition));
        assertFalse(playController.isEndGame());
        assertNull(playController.move(threeRowSixColumnPosition, fourRowFiveColumnPosition));
        assertFalse(playController.isEndGame());
        assertNull(playController.move(fiveRowSixColumnPosition, sixRowFiveColumnPosition));
        assertFalse(playController.isEndGame());
        assertNull(playController.move(sevenRowSixColumnPosition, eightRowFiveColumnPosition));
        assertFalse(playController.isEndGame());

        assertNull(playController.move(twoRowSevenColumnPosition, oneRowSixColumnPosition));
        assertFalse(playController.isEndGame());
        assertNull(playController.move(fourRowSevenColumnPosition, threeRowSixColumnPosition));
        assertFalse(playController.isEndGame());
        assertNull(playController.move(sixRowSevenColumnPosition, fiveRowSixColumnPosition));
        assertFalse(playController.isEndGame());
        assertNull(playController.move(eightRowSevenColumnPosition, sevenRowSixColumnPosition));
        assertFalse(playController.isEndGame());

        assertNull(playController.move(oneRowEightColumnPosition, twoRowSevenColumnPosition));
        assertFalse(playController.isEndGame());
        assertNull(playController.move(threeRowEightColumnPosition, fourRowSevenColumnPosition));
        assertFalse(playController.isEndGame());
        assertNull(playController.move(fiveRowEightColumnPosition, sixRowSevenColumnPosition));
        assertFalse(playController.isEndGame());
        assertNull(playController.move(sevenRowEightColumnPosition, eightRowSevenColumnPosition));
        assertFalse(playController.isEndGame());

        assertNull(playController.move(twoRowThreeColumnPosition, oneRowFourColumnPosition));
        assertFalse(playController.isEndGame());
        assertNull(playController.move(fourRowThreeColumnPosition, threeRowFourColumnPosition));
        assertFalse(playController.isEndGame());
        assertNull(playController.move(sixRowThreeColumnPosition, fiveRowFourColumnPosition));
        assertFalse(playController.isEndGame());
        assertNull(playController.move(eightRowThreeColumnPosition, sevenRowFourColumnPosition));
        assertFalse(playController.isEndGame());

        assertNull(playController.move(oneRowTwoColumnPosition, twoRowThreeColumnPosition));
        assertFalse(playController.isEndGame());
        assertNull(playController.move(threeRowTwoColumnPosition, fourRowThreeColumnPosition));
        assertFalse(playController.isEndGame());
        assertNull(playController.move(fiveRowTwoColumnPosition, sixRowThreeColumnPosition));
        assertFalse(playController.isEndGame());
        assertNull(playController.move(sevenRowTwoColumnPosition, eightRowThreeColumnPosition));
        assertFalse(playController.isEndGame());

        assertNull(playController.move(twoRowOneColumnPosition, oneRowTwoColumnPosition));
        assertFalse(playController.isEndGame());
        assertNull(playController.move(fourRowOneColumnPosition, threeRowTwoColumnPosition));
        assertFalse(playController.isEndGame());
        assertNull(playController.move(sixRowOneColumnPosition, fiveRowTwoColumnPosition));
        assertFalse(playController.isEndGame());
        assertNull(playController.move(eightRowOneColumnPosition, sevenRowTwoColumnPosition));
        assertTrue(playController.isEndGame());
    }
}