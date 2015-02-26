package clientHidden;
import java.util.ArrayList;

abstract class Board {

	protected Square[][] board;
	protected int size;
	protected ArrayList<Ship> ships; // Holds a reference of the ships so we can
										// access their coodrinates easier
	protected int width;
	protected int height;

	public Board() {
		super();
	}

	public Board(int size, Square[][] board) {
		this.size = size;
		this.board = board;
		this.width = size - 2;
		this.height = size;
	}

	public Square[][] getSquares() {
		return board;
	}

	public int Size() {
		return size;
	}
	
	public int width() {
		return this.width;
	}
	
	public int height() {
		return this.height;
	}

	public ArrayList<Ship> ships() {
		return this.ships;
	}

	public void setShips(ArrayList<Ship> ships) {
		this.ships = ships;
	}

}
