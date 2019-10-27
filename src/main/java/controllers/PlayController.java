package controllers;

import models.Game;
import models.Coordinate;
import models.Piece;
import models.State;
import models.Error;

class PlayController extends AcceptController{

    public PlayController(Game game, State state) {
		super(game, state);
	}

	public Error move(Coordinate origin, Coordinate target){
        return null;
    }

	public Piece getPiece(Coordinate origin) {
		return null;
	}

	public void cancelGame() {
	}
	
	public boolean isEndGame() {
		return false;
	}
}