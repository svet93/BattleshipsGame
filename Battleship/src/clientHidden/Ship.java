package clientHidden;
import java.util.ArrayList;

/** The structure of the ship */
abstract class Ship {

	private int size;
	private boolean isVertical;
	private boolean isDestroyed;
	private ArrayList<Square> positionList;

	public Ship() {
		isVertical = false;
		isDestroyed = false;
		positionList = null;
	}

	/**
	 * set the orientation of the ship to vertical
	 * @param isvertical - boolean value (true) for vertical (false) for horizontal
	 */
	public void setOrientation(boolean isvertical) {	
		this.isVertical = isvertical;
	}

	/**
	 * sets the position list for a ship
	 * @param arrayList
	 */
	public void setPosition(ArrayList<Square> arrayList) {		
		this.positionList = arrayList;
	}

	/**
	 * Returns true if ship is vertical, false if horizontal
	 * @return
	 */
	public boolean isVertical() { 	
		return this.isVertical;
	}

	/**
	 * returns list of the square positions the ship occupies
	 * @return
	 */
	public ArrayList<Square> positionList() {	
		return this.positionList;
	}

	/** 
	 * Check if Square s is in the ship's position list
	 * @param s - Square class
	 * @return
	 */
	public boolean containsSquare(Square s) {	
		for (int i = 0; i < positionList.size(); ++i) {
			if (positionList.get(i).equals(s))
				return true;
		}
		return false;
	}
	
	/**
	 * call the isDestroyed method and if it returns true, this sets isDestroyed(bool) to true
	 */
	public void setDestroyed () {
		if (isDestroyed() == true)
			this.isDestroyed = true;
	}
	
	/**
	 * returns the destroy state of the ship
	 * @return
	 */
	public boolean getIsDestroyed() {
		return this.isDestroyed;
	}

	/**
	 * loops through the squares that the ship occupies and if all are hit returns true, else false
	 * @return
	 */
	public boolean isDestroyed() {
		for (Square s : positionList) {
			if (s.isAHit() == false)
				return false;
		}

		return true;
	}

	/**
	 * return the size of the ship
	 * @return
	 */
	public int size() {		
		return size;
	}
	/** set size
	 * @param size - integer value the size gets set to
	 */
	public void size(int size) {
		this.size = size;
	}

}
