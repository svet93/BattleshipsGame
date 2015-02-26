package clientHidden;

class ShipFactory// ship factory for creating ship
{
	public Ship makeShip(String type, int row) {
		Ship ship = null;

		if (type.equals("Battleship")) {
			ship = new Battleship(row);
		} else if (type.equals("Boat")) {
			ship = new Boat(row);
		} else if (type.equals("Submarine")) {
			ship = new Submarine(row);
		}
		return ship;
	}

}
