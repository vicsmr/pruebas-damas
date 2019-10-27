package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class PieceTest {

    public PieceTest() {
    }

    @Test
    public void givenPieceWhenHaveColorRequireCorrectThenNotError() {
        Piece piece = new Piece(Color.WHITE);
        assertNotNull(piece.getColor());
    }

    @Test
    public void givenPieceWhenColorIsWhiteOrBlackRequireCorrectThenNotError() {
        Piece pieceWhite = new Piece(Color.WHITE);
        assertEquals(Color.WHITE, pieceWhite.getColor());
        Piece pieceBlack = new Piece(Color.BLACK);
        assertEquals(Color.BLACK, pieceBlack.getColor());
    }

}