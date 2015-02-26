package clientHidden;

class Game {

	private Player user;
	private Player computer;

	private String boardSize;
	private int numOfShips;
	
	private MoveType moveType;
	

	public Game(String boardSize, int numOfShips, String moveType) {
		user = new User();
		computer = new Computer();
		this.boardSize = boardSize;
		this.numOfShips = numOfShips;
		createBoards();
		createShips();
		if (moveType.equals("SmartMove"))
			this.moveType = new SmartMove();
		else
			this.moveType = new StupidMove();
	}
	

	private void createBoards() {
		user.createBoard(boardSize);
		computer.createBoard(boardSize);
	}


	private void createShips() {
		user.makeShips(numOfShips);
		computer.makeShips(numOfShips);
	}

	public Player getUser() {
		return this.user;
	}

	public Player getComputer() {
		return this.computer;
	}
	
	public int getBoardSize () {
		if (boardSize.equals("SmallBoard"))
			return 8;
		else if (boardSize.equals("MediumBoard"))
			return 10;
		else 
			return 12;
	}
	
	public int getNumberOfShips () {
		return this.numOfShips;
	}
	
	public Square getMove() {
		return this.moveType.makeMove(this.getUser().board(), this);
	}
	
}
