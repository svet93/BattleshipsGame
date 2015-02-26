package clientHidden;

class StupidMove implements MoveType // return squares in index 0 ,1,
											// 2... until board.size
{
	int nextMove;
	int nextLine;

	public StupidMove() {
		nextMove = 0;
		nextLine = 0;
	}
	
	/**
	 * make a very stupid move
	 */
	public Square makeMove(Board board, Game g) {
		if (nextMove > board.Size() - 3) {
			nextLine++;
			nextMove = 0;
		}
		return board.getSquares()[nextLine][nextMove++];
	}

}
