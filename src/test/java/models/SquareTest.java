package models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SquareTest {

    public SquareTest() {
    }

    @Test
    public void givenSquareWhenIsEmptyRequireCorrectThenNotError() {
        Square square = new Square(Color.BLACK);
        assertTrue(square.isEmpty());
    }

    @Test
    public void givenSquareWhenNotIsEmptyRequireCorrectThenNotError() {
        Square square = new Square(Color.BLACK);
        square.setPiece(new Piece(Color.WHITE));
        assertFalse(square.isEmpty());
    }

    @Test
    public void givenSquareWhenNotIsAccesibleRequireCorrectThenNotError() {
        Square square = new Square(Color.WHITE);
        assertFalse(square.isAccesible());
    }

    @Test
    public void givenSquareWhenIsAccesibleRequireCorrectThenNotError() {
        Square square = new Square(Color.BLACK);
        assertTrue(square.isAccesible());
    }
}