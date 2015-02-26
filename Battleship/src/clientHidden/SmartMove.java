package clientHidden;
import java.util.ArrayList;
import java.util.Random;

/* Makes a strategic move based on the hits it already has */
class SmartMove implements MoveType // randomly generate an index number
											// in range 0 - (board.size()-1)
{
	Random random;

	public SmartMove() {
		random = new Random();
	}

	public Square makeRandomMove(Board board) {
		int max = board.Size();
		int min = 0;
		int nextMoveR = random.nextInt(max - min) + min;
		int nextMoveC = random.nextInt((max - 3) - min + 1) + min;
		
		return board.getSquares()[nextMoveR][nextMoveC];
	}
	int i, j = 0;
	
	/**
	 * looks for a hit ship. Then checks if the ship has been destroyed. If not destroyed, it will try to make the best
	 * educated guess on where the next move is going to be
	 */
	public Square makeMove(Board board, Game g) {
		ArrayList<Ship> ships = g.getUser().ships();   //  ArrayList with the User' ships
		int width = board.width();
		int height = board.height();
		Square[][] square = board.getSquares();			//  The board
		
		for (i = 0; i < height; i++) {
			for (j = 0; j < width; j++) {
				if (square[i][j].isAHit()) {		//  check if the square in the position is a hit
					for (Ship ship : ships) {		
						if (ship.containsSquare(square[i][j])) {	//  Check if the ship contains the square
							if (!ship.isDestroyed()) {			//  ship destroyed?
								/* if ship is not destroyed then check all the spots around it */
								int x=i,y=j;
								try {
									Square max = square[i][j];
									for (Square sq : ship.positionList()) {		//  Check down from the up-most known position
										if (sq.coordinates().getX() < max.coordinates().getX() && sq.isAHit())
											max = sq;
									}
									x = max.coordinates().getX();
									y = max.coordinates().getY();
									while (x < height && square[x+1][y].isAHit()) {	//  Walk down and try one after the last hit
										x++;
										if (x < height && square[x+1][y].isClicked() == false) {
											return square[x+1][y];
										}
									}
								} catch (Exception e) {
									System.out.println("x: " +x + " y: " +y);
									x = i;
									y = j;
								}
								
								try {
									Square max = square[i][j];
									for (Square sq : ship.positionList()) {		//  Check up from the down most known position
										if (sq.coordinates().getX() > max.coordinates().getX() && sq.isAHit())
											max = sq;
									}
									x = max.coordinates().getX();
									y = max.coordinates().getY();
									while (x > 0 && square[x-1][y].isAHit()) {//  Walk up and try one after the last hit
										x--;
										if (x > 0 && square[x-1][y].isClicked() == false) {
											return square[x-1][y];
										}
									}
								} catch (Exception e) {
									System.out.println("x: " +x + " y: " +y);
									x = i;
									y = j;
								}

								try {
									Square max = square[i][j];
									for (Square sq : ship.positionList()) {		//  Check right from the left-most position
										if (sq.coordinates().getY() < max.coordinates().getY() && sq.isAHit())
											max = sq;
									}
									x = max.coordinates().getX();
									y = max.coordinates().getY();
									while (y < width && square[x][y+1].isAHit()) {	//  Walk right and try one after the last hit
										y++;
										if (y < width && square[x][y+1].isClicked() == false) {
											return square[x][y+1];
										}
									}
								} catch (Exception e) {
									System.out.println("x: " +x + " y: " +y);
									x = i;
									y = j;
								}

								try {
									Square max = square[i][j];
									for (Square sq : ship.positionList()) {		//  Check Left from the right-most position
										if (sq.coordinates().getY() > max.coordinates().getY() && sq.isAHit())
											max = sq;
									}
									x = max.coordinates().getX();
									y = max.coordinates().getY();
									while (y > 0 && square[x][y-1].isAHit()) {	//  Walk left and try one after the last hit
										y--;
										if (y > 0 && square[x][y-1].isClicked() == false) {
											return square[x][y-1];
										}
									}
								} catch (Exception e) {
									System.out.println("x: " +x + " y: " +y);
									x = i;
									y = j;
								}
								x=i;
								y =j;
								//  If none of the above enter the loop...
								if (((x+1) < height) && square[x+1][y].isClicked() == false) {  // guess down
									return square[x+1][y];
								}
								else if (((x-1) > 0) && square[x-1][y].isClicked() == false) {	// guess up
									return square[x-1][y];
								}
								else if (((y+1) < width) && square[x][y+1].isClicked() == false) {	// guess right
									return square[x][y+1];
								}
								else if (((y-1) > 0) && square[x][y-1].isClicked() == false) {	// guess left
									return square[x][y-1];
								}
								else {
									return makeRandomMove(board);		//  If all of these fail for some reason then make a random guess
								}
							}
						}
					}
				}
			}
		}
		
		return makeRandomMove(board);		// If no hit, non-destroyed ships, make a random guess
	}

}
