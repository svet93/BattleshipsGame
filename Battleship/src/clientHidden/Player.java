package clientHidden;
import java.util.ArrayList;

abstract class Player {

	protected ArrayList<Ship> ships;
	protected Board board;
	private BoardFactory boardFactory;
	private ShipFactory shipFactory;

	protected int numOfHits;
	protected int numOfMoves;
	private boolean dead;

	public Player() {
		dead = false;
		boardFactory = new BoardFactory();
		shipFactory = new ShipFactory();
	}

	public void createBoard(String boardtype) {
		board = boardFactory.createBoard(boardtype); // create a board using
														// factory
	}

	/**
	 * Creates the arraylist of ships that will be assigned to the board int
	 * numOfShips: how many ships to create Board board: used to bass the
	 * squares to the ship factory
	 */
	public void makeShips(int numOfShips) {
		// ShipFactory shipFactory = new ShipFactory();
		ArrayList<Ship> ships = new ArrayList<Ship>();

		if (numOfShips == 5) {
			ships.add(shipFactory.makeShip("Battleship", 0));
			ships.add(shipFactory.makeShip("Battleship", 1));
			ships.add(shipFactory.makeShip("Submarine", 2));
			ships.add(shipFactory.makeShip("Submarine", 3));
			ships.add(shipFactory.makeShip("Boat", 4));
		} else if (numOfShips == 7) {
			for (int i = 0; i < 3; i++)
				ships.add(shipFactory.makeShip("Battleship", i));
			for (int i = 3; i < 6; i++)
				ships.add(shipFactory.makeShip("Submarine", i));
			ships.add(shipFactory.makeShip("Boat", 6));
		} else if (numOfShips == 9) {
			for (int i = 0; i < 4; i++)
				ships.add(shipFactory.makeShip("Battleship", i));
			for (int i = 4; i < 7; i++)
				ships.add(shipFactory.makeShip("Submarine", i));
			ships.add(shipFactory.makeShip("Boat", 7));
			ships.add(shipFactory.makeShip("Boat", 8));
		} else if (numOfShips == 11) {
			for (int i = 0; i < 5; i++)
				ships.add(shipFactory.makeShip("Battleship", i));
			for (int i = 5; i < 9; i++)
				ships.add(shipFactory.makeShip("Submarine", i));
			ships.add(shipFactory.makeShip("Boat", 9));
			ships.add(shipFactory.makeShip("Boat", 10));
		} else {
			System.out.print("ERROR!");
			System.exit(0);
		}

		this.ships = ships;
	}

	public int numOfHits() {	// get numOfHits
		return numOfHits;
	}

	public Board board() {
		return this.board;
	}

	public ArrayList<Ship> ships() {	// get ships
		return ships;
	}

	
	public void incrementHits() {
		numOfHits++;
	}


	public boolean Dead() {
		return dead;
	}

	/**
	 * if all ships are destroyed set dead to true
	 */
	public void updateDead() {	
		for (int i = 0; i < ships.size(); ++i) {
			if (!ships.get(i).isDestroyed()) {
				dead = false;
				break;
			}
		}
		dead = true;

	}
	

	


}
