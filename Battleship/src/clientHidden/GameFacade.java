package clientHidden;
import java.util.ArrayList;
import java.util.Random;

/*
 * This Class acts as a business tier that will hide implementations from the client
 */
public class GameFacade {
	Game game;     //  Holds a reference to just about anything you might need
	
	/*
	 * Generate an empty Facade that has to be initialized later on
	 */
	public GameFacade() {
		game = null;
	}
	
	/*
	 * This version of constructor overload will generate a game with given:
	 * String boardSize: String that is either "SmallBoard", "MediumBoard" or "LargeBoard" that will be passed to BoardFactory
	 * int numOfShips: the number of ships that will be passed to the ShipFactory
	 */
	public GameFacade(String boardSize, int numOfShips, String moveType) {
		game = new Game(boardSize, numOfShips, moveType);
	}

	/*
	 * Creates a new game instance int boardSize: the board that will be created
	 * int numOfShips: the number of ships to be created per user * This will
	 * instantiate everything that needs for the game to be played
	 */
	public void createNewGame(String boardSize, int numOfShips, String moveType) {
		game = new Game(boardSize, numOfShips, moveType);
	}

	/* + getShipSizeByIndex(int index): int
	 * int index: pass the index of the ship you would like to get
	 * Returns the size of the ship at index
	 */
	public int getShipSizeByIndex(int index) {
		return game.getUser().ships().get(index).size();
	}

	/* + getNumberShips(): int
	 * Returns the number of ships
	 */
	public int getNumberShips() {
		return game.getUser().ships().size();
	}

	/* setShip(int x, int y, boolean isVertical, int index): boolean
	 * int x: x coordinate of the ship
	 * int y: y coordinate of the ship
	 * boolean isVertical: false-> horizontal --- true-> vertical
	 * int index: ship at that index
	 * Tries to position ship at index at the coordinates (x,y) with orientation isVertical
	 * Returns true if the ship was successfully set or false if there is a conflict
	 */
	public boolean setShip(int x, int y, boolean isVertical, int index) {
		ArrayList<Square> tempPosition = new ArrayList<Square>();
		int size = getShipSizeByIndex(index);
		
		
		try {
			if (!isVertical) {
				for (int i = 0; i < size; i++) 
					tempPosition.add(game.getUser().board().getSquares()[x][y+i]);
			}
			else {
				for (int i = 0; i < size; i++) 
					tempPosition.add(game.getUser().board().getSquares()[x+i][y]);
			}
		} catch (Exception e1) {
			return false;
		}
		
		
		try {
			for (Ship s : game.getUser().ships()) {
				for (Square square : s.positionList()) {
					for (int i = 0; i < size; i++) {
						if (square.coordinates() == tempPosition.get(i).coordinates()) 
							return false;
					}
				}
			}
		} catch (NullPointerException e) {
			game.getUser().ships().get(index).setPosition(tempPosition);
			return true;
		}

		
		game.getUser().ships().get(index).setPosition(tempPosition);
		return true;
	}   //  End of setShip

	/*
	 * return an ArrayList<Coordinates> with all the coordinates of ships that have been placed
	 */
	public ArrayList<Coordinates> getPlayerFilledSquares() {
		ArrayList<Coordinates> filledSquares = new ArrayList<Coordinates>();
		
		try {
			for (Ship s : game.getUser().ships()) {
				for (Square square : s.positionList()) {
					filledSquares.add(square.coordinates());
				}
			}
		} catch (NullPointerException e) {
			return filledSquares;
		}
		
		return filledSquares;
	}

	
	/*
	 * Read the player's move and decide whether it is a hit or miss
	 * int x, y: coordinates of the square that was clicked by the user
	 */
	public Coordinates makePlayerMove(int x, int y) {
		ArrayList<Coordinates> ships = getComputerFilledSquares();
		Coordinates cords = new Coordinates(x, y);
		
		for (Coordinates s : ships) {
			if (s.getX() == cords.getX() && s.getY() == cords.getY()) 
				for (Ship ship : game.getComputer().ships()) {
					for (Square square : ship.positionList()) {
						if (cords.getX() == square.coordinates().getX() && cords.getY() == square.coordinates().getY()) {
							square.setHit();
							return s;
						}
					}
				}
				//return s;
		}
		return null;
	}

	/*
	 * return an ArrayList<Coordinates> with all the coordinates of ships that have been placed
	 */
	public ArrayList<Coordinates> getComputerFilledSquares() {
		ArrayList<Coordinates> filledSquares = new ArrayList<Coordinates>();
		
		try {
			for (Ship s : game.getComputer().ships()) {
				for (Square square : s.positionList()) {
					filledSquares.add(square.coordinates());
				}
			}
		} catch (NullPointerException e) {
			return filledSquares;
		}
		
		return filledSquares;
	}
	
	/*
	 * Pick positions at random for the computer ships
	 * TODO: Right now this puts all the ships in the same manner. Write code that will generate positions randomly. For
	 reference check the code above of how to place player ships.
	 */
	public boolean setUpComputerShips(int index) {
		Random rn = new Random();
		
		int x = rn.nextInt(game.getBoardSize());
		int y = rn.nextInt(game.getBoardSize() - 2);
		boolean isVertical;
		
		if ((rn.nextInt(2)) == 1)
			isVertical = true;
		else
			isVertical = false;
		
		ArrayList<Square> tempPosition = new ArrayList<Square>();
		int size = getShipSizeByIndex(index);
		
		
		try {
			if (!isVertical) {
				for (int i = 0; i < size; i++) 
					tempPosition.add(game.getComputer().board().getSquares()[x][y+i]);
			}
			else {
				for (int i = 0; i < size; i++) 
					tempPosition.add(game.getComputer().board().getSquares()[x+i][y]);
			}
		} catch (Exception e1) {
			return false;
		}
		
		
		try {
			for (Ship s : game.getComputer().ships()) {
				for (Square square : s.positionList()) {
					for (int i = 0; i < size; i++) {
						if (square.coordinates() == tempPosition.get(i).coordinates()) 
							return false;
					}
				}
			}
		} catch (NullPointerException e) {
			game.getComputer().ships().get(index).setPosition(tempPosition);
			return true;
		}
		
		game.getComputer().ships().get(index).setPosition(tempPosition);
		return true;
	}
	
	public boolean checkForDestroyed(Coordinates c) {
		User user = (User)game.getUser();
		return user.checkForDestroyed(game, c);
	}
	
	public boolean checkForComputerDestroyed (Coordinates c) {
		Computer comp = (Computer)game.getComputer();
		return comp.checkForDestroyed(game, c);
	}
	
	
	public Coordinates makeComputerMove() {
		
		boolean valid = false;
		
		Square move = game.getMove();
		
		while (!valid) {
			if (move.isClicked())
				try {
					move = game.getMove();
				} catch (Exception e) {
					move = game.getMove();
				}
			else
				valid = true;
		}
		
		game.getUser().board().getSquares()[move.coordinates().getX()][move.coordinates().getY()].setClicked(true);
		
		ArrayList<Coordinates> ships = getPlayerFilledSquares();
		Coordinates cords = move.coordinates();
		
		for (Coordinates s : ships) {
			if (s.getX() == cords.getX() && s.getY() == cords.getY()) 
				for (Ship ship : game.getUser().ships()) {
					for (Square square : ship.positionList()) {
						if (cords.getX() == square.coordinates().getX() && cords.getY() == square.coordinates().getY()) {
							square.setHit();
							return s;
						}
					}
				}
		}
		return null;
	}
	
	public ArrayList<Coordinates> clickedByComputer() {
		ArrayList<Coordinates> toBeDisabled = new ArrayList<Coordinates>();
	
			for (Square[] s : game.getUser().board().getSquares()) {
				for (Square sq : s) {
					if (sq.isClicked() && sq.isAHit() == false) {
						toBeDisabled.add(sq.coordinates());
					}
				}
			}
		return toBeDisabled;
	}
}
