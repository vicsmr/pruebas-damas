package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    private Board board;

    public BoardTest() {
    }

    @Before
    public void before() {
        board = new Board();
    }

    @Test
    public void givenBoardWhenCoordinateHaveAPieceRequireCorrectThenNotError() {
        Coordinate coordinate = new Coordinate(1, 6);
        assertNotNull(this.board.getPiece(coordinate));
    }

    @Test
    public void givenBoardWhenCoordinateNotHaveAPieceRequireInCorrectThenError() {
        Coordinate coordinate = new Coordinate(1, 5);
        assertNull(this.board.getPiece(coordinate));
    }

    @Test
    public void givenBoardWhenCoordinateIsOutOfTheBoardRequireInCorrectThenError() {
        Coordinate coordinate = new Coordinate(1, 9);
        assertNull(this.board.getPiece(coordinate));
    }

    @Test
    public void givenBoardWhenInitializeCheckPositionOfTwoContraryPiecesRequireCorrectThenNotError() {
        Coordinate coordinateWhite = new Coordinate(1, 6);
        assertEquals(Color.WHITE, board.getPiece(coordinateWhite));
        Coordinate coordinateBlack = new Coordinate(2, 3);
        assertEquals(Color.BLACK, board.getPiece(coordinateBlack));
    }

    @Test
    public void givenBoardWhenMovementFromANonExistPositionToANonExistPositionRequiereIncorrectThenError() {
        Coordinate origin = new Coordinate(9, 0);
        Coordinate target = new Coordinate(10, 1);
        assertNotNull(this.board.move(origin, target));
    }

    @Test
    public void givenBoardWhenMovementFromANonExistPositionRequiereIncorrectThenError() {
        Coordinate origin = new Coordinate(9, 0);
        Coordinate target = new Coordinate(4, 3);
        assertNotNull(this.board.move(origin, target));
    }

    @Test
    public void givenBoardWhenMovementToANonExistPositionRequiereIncorrectThenError() {
        Coordinate origin = new Coordinate(1, 6);
        Coordinate target = new Coordinate(10, 1);
        assertNotNull(this.board.move(origin, target));
        assertNotNull(this.board.getPiece(origin));
    }

    @Test
    public void givenBoardWhenMovementRequiereCorrectThenNotError() {
        Coordinate origin = new Coordinate(1, 6);
        Coordinate target = new Coordinate(2, 5);
        assertNull(this.board.move(origin, target));
        assertNull(this.board.getPiece(origin));
        Piece targetPiece = this.board.getPiece(target);
        assertNotNull(targetPiece);
        assertEquals(Color.WHITE, targetPiece.getColor());
    }

    
    @Test
    public void givenBoardWhenMovementToAnOccupiedPositionRequiereIncorrectThenError() {
        Coordinate origin = new Coordinate(1, 6);
        Coordinate target = new Coordinate(2, 5);
        Coordinate contraryOrigin = new Coordinate(4, 3);
        Coordinate contraryFirstMove = new Coordinate(3, 4);
        Piece originPiece = board.getPiece(origin);
        Piece targetpiece = board.getPiece(target);
        assertNull(this.board.move(contraryOrigin, contraryFirstMove));
        assertNull(this.board.move(contraryFirstMove, target));
        assertNotNull(this.board.move(origin, target));
        assertNotNull(originPiece);
        assertNotNull(targetpiece);
        assertEquals(Color.WHITE, originPiece.getColor());
        assertEquals(Color.WHITE, targetpiece.getColor());
    }

    @Test
    public void givenBoardWhenMovementMenToAPreviousPositionRequiereIncorrectThenError() {
        Coordinate firstMove = new Coordinate(2, 5);
        Coordinate origin = new Coordinate(1, 6);
        assertNull(this.board.move(origin, firstMove));
        assertNotNull(this.board.move(firstMove, origin));
        Piece menOrigin = this.board.getPiece(firstMove);
        assertNotNull(menOrigin);
        assertEquals(Color.WHITE, menOrigin.getColor());
        assertNull(this.board.getPiece(origin));
    }

    private Board createKing(Board board, Coordinate origin, Coordinate fifthMove) {
        Coordinate firstMove = new Coordinate(2, 5);
        Coordinate secondMove = new Coordinate(3, 4);
        Coordinate thirdMove = new Coordinate(4, 3);
        Coordinate fourthMove = new Coordinate(5, 2);
        Coordinate firstContraryMove = new Coordinate(1, 4);
        Coordinate secondContraryPosition = new Coordinate(6, 3);
        Coordinate secondContraryMove = new Coordinate(5, 4);
        Coordinate thirdContraryPosition = new Coordinate(8, 3);
        Coordinate thirdContraryMove = new Coordinate(7, 4);
        Coordinate fourthContraryPosition = new Coordinate(7, 2);
        Coordinate fifthContraryPosition = new Coordinate(6, 1);
        Coordinate firstOwnPosition = new Coordinate(7, 6);
        Coordinate firstOwnMove = new Coordinate(8, 5);
        Coordinate secondOwnPosition = new Coordinate(5, 6);
        Coordinate secondOwnmove = new Coordinate(4, 5);
        assertNull(board.move(origin, firstMove));
        assertNull(board.move(thirdMove, firstContraryMove));
        assertNull(board.move(firstMove, secondMove));
        assertNull(board.move(secondContraryPosition, secondContraryMove));
        assertNull(board.move(secondMove, thirdMove));
        assertNull(board.move(fourthMove, secondContraryPosition));
        assertNull(board.move(thirdMove, fourthMove));
        assertNull(board.move(thirdContraryPosition, thirdContraryMove));
        assertNull(board.move(firstOwnPosition, firstOwnMove));
        assertNull(board.move(fourthContraryPosition, thirdContraryPosition));
        assertNull(board.move(secondOwnPosition, secondOwnmove));
        assertNull(board.move(fifthContraryPosition, fourthContraryPosition));
        assertNull(board.move(fourthMove, fifthMove));
        return board;
    }

    private void checkFinalPositionKing(Board board, Coordinate origin, Coordinate target) {
        Piece kingOrigin = board.getPiece(origin);
        assertNull(kingOrigin);
        Piece targetKing = board.getPiece(target);
        assertNotNull(targetKing);
        assertEquals(Color.WHITE, targetKing.getColor());
    }

    @Test
    public void givenBoardWhenMovementKingTwoPositionRequiereCorrectThenNotError() {
        Coordinate origin = new Coordinate(1, 6);
        Coordinate target = new Coordinate(4, 3);
        Coordinate fifthMove = new Coordinate(6, 1);
        Coordinate contraryPosition = new Coordinate(2, 3);
        Coordinate contraryMove = new Coordinate(1, 4);
        this.board = this.createKing(this.board, origin, fifthMove);
        assertNull(this.board.move(contraryPosition, contraryMove));
        assertNull(this.board.move(fifthMove, target));
        this.checkFinalPositionKing(this.board, origin, target);
    }

    @Test
    public void givenBoardWhenMovementKingThreePositionRequiereCorrectThenNotError() {
        Coordinate origin = new Coordinate(1, 6);
        Coordinate target = new Coordinate(3, 4);
        Coordinate fifthMove = new Coordinate(6, 1);
        Coordinate contraryPosition = new Coordinate(2, 3);
        Coordinate contraryMove = new Coordinate(1, 4);
        this.board = this.createKing(this.board, origin, fifthMove);
        assertNull(this.board.move(contraryPosition, contraryMove));
        assertNull(this.board.move(fifthMove, target));
        this.checkFinalPositionKing(this.board, origin, target);
    }

    @Test
    public void givenBoardWhenJumpKingTwoPiecesRequiereCorrectThenNotError() {
        Coordinate origin = new Coordinate(1, 6);
        Coordinate target = new Coordinate(3, 4);
        Coordinate fifthMove = new Coordinate(6, 1);
        Coordinate firstContraryPosition = new Coordinate(4, 1);
        Coordinate firstContraryMove = new Coordinate(5, 2);
        Coordinate secondContraryPosition = new Coordinate(3, 2);
        Coordinate secondContraryMove = new Coordinate(4, 3);
        Coordinate firstOwnPosition = new Coordinate(3, 6);
        Coordinate firstOwnMove = new Coordinate(2, 5);
        this.board = this.createKing(this.board, origin, fifthMove);
        assertNull(this.board.move(firstContraryPosition, firstContraryMove));
        assertNull(this.board.move(firstOwnPosition, firstOwnMove));
        assertNull(this.board.move(secondContraryPosition, secondContraryMove));
        assertNull(this.board.move(fifthMove, target));
        assertNull(this.board.getPiece(firstContraryMove));
        assertNull(this.board.getPiece(secondContraryMove));
        this.checkFinalPositionKing(board, origin, target);
    }

    @Test
    public void givenBoardWhenMovementPieceToAStraightPositionRequiereIncorrectThenError() {
        Coordinate origin = new Coordinate(1, 6);
        Coordinate target = new Coordinate(1, 5);
        Piece menOrigin = (Piece) board.getPiece(origin);
        assertNotNull(this.board.move(origin, target));
        assertNotNull(menOrigin);
        assertEquals(Color.WHITE, menOrigin.getColor());
        assertNull(this.board.getPiece(target));
        this.checkFinalPositionKing(this.board, origin, target);
    }

    @Test
    public void givenBoardWhenJumpAnotherPieceRequiereCorrectThenNotError() {
        Coordinate originPositionOwnPiece = new Coordinate(1, 6);
        Coordinate targetPositionOwnPiece = new Coordinate(3, 4);
        Coordinate positionContraryPiece = new Coordinate(2, 5);
        Piece originPiece = board.getPiece(originPositionOwnPiece);
        Piece contraryPiece = board.getPiece(positionContraryPiece);
        assertEquals(Color.WHITE, originPiece.getColor());
        assertEquals(Color.BLACK, contraryPiece.getColor());
        assertNull(this.board.move(originPositionOwnPiece, targetPositionOwnPiece));
        assertNull(this.board.getPiece(originPositionOwnPiece));
        assertNull(this.board.getPiece(positionContraryPiece));
        Piece pieceTarget = this.board.getPiece(targetPositionOwnPiece);
        assertNotNull(pieceTarget);
        assertEquals(Color.WHITE, pieceTarget.getColor());
    }

    @Test
    public void givenBoardWhenAMenJumpAnotherPieceWithoutPieceBetweenRequiereInCorrectThenError() {
        Coordinate originPositionOwnPiece = new Coordinate(1, 6);
        Coordinate targetPositionOwnPiece = new Coordinate(3, 4);
        Piece originPiece = board.getPiece(originPositionOwnPiece);
        assertEquals(Color.WHITE, originPiece.getColor());
        assertNotNull(this.board.move(originPositionOwnPiece, targetPositionOwnPiece));
        assertNotNull(this.board.getPiece(originPositionOwnPiece));
        Piece pieceTarget = this.board.getPiece(targetPositionOwnPiece);
        assertNull(pieceTarget);
    }

    @Test
    public void givenBoardWhenJumpAnotherPieceWithPieceOfTheSameColorBetweenRequiereInCorrectThenError() {
        Coordinate originPositionOwnPiece = new Coordinate(1, 6);
        Coordinate targetPositionOwnPiece = new Coordinate(3, 4);
        Coordinate positionContraryPiece = new Coordinate(2, 5);
        Piece originPieceBeforeMove = board.getPiece(originPositionOwnPiece);
        Piece contraryPieceBeforeMove = board.getPiece(positionContraryPiece);
        assertEquals(Color.WHITE, originPieceBeforeMove.getColor());
        assertEquals(Color.WHITE, contraryPieceBeforeMove.getColor());
        assertNotNull(this.board.move(originPositionOwnPiece, targetPositionOwnPiece));
        assertNotNull(this.board.getPiece(positionContraryPiece));
        Piece originPieceAfterMove = this.board.getPiece(originPositionOwnPiece);
        assertNotNull(originPieceAfterMove);
        assertEquals(Color.WHITE, originPieceAfterMove.getColor());
        Piece contraryPieceAfterMove = this.board.getPiece(positionContraryPiece);
        assertNotNull(contraryPieceAfterMove);
        assertEquals(Color.WHITE, contraryPieceAfterMove.getColor());
        assertNull(this.board.getPiece(targetPositionOwnPiece));
    }

    @Test
    public void givenBoardWhenATurnWantToMoveMoreThanOneTimeInCorrectThenError() {
        Coordinate originPositionOwnPiece = new Coordinate(1, 6);
        Coordinate targetPositionOwnPiece = new Coordinate(2, 5);
        Coordinate originPositionSecondOwnPiece = new Coordinate(3, 6);
        Coordinate targetPositionSecondOwnPiece = new Coordinate(4, 5);
        Piece originPiece = board.getPiece(originPositionOwnPiece);
        assertEquals(Color.WHITE, originPiece.getColor());
        assertNull(board.move(originPositionOwnPiece, targetPositionOwnPiece));
        Piece targetPiece = this.board.getPiece(targetPositionOwnPiece);
        assertNotNull(targetPiece);
        assertEquals(Color.WHITE, targetPiece.getColor());
        Piece originSecondPiece = this.board.getPiece(originPositionSecondOwnPiece);
        assertEquals(Color.WHITE, originSecondPiece.getColor());
        assertNotNull(this.board.move(originPositionSecondOwnPiece, targetPositionSecondOwnPiece));
        assertNull(this.board.getPiece(targetPositionSecondOwnPiece));
    }

}