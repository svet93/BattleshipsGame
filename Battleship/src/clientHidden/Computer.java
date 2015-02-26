package clientHidden;

class Computer extends Player {
	public MoveType movetype;

	public Computer() {
		super();
	}

	/**
	 * Check if a ship at Coordinates c has been destroyed
	 * @param game  -  Game class in order to get reference to the User
	 * @param c - Coordinates class - contains x and y position
	 * @return
	 */
	public boolean checkForDestroyed (Game game, Coordinates c) {
		Ship hasIt;
		for (Ship s : game.getUser().ships()) {			//  Loop through the ships position lists
			for (Square sq : s.positionList()) {
				if (sq.coordinates().getX() == c.getX() && sq.coordinates().getY() == c.getY()) {  // If you find a match...
					hasIt = s;						//	set hasIt to the ship that has a match
					hasIt.setDestroyed();			//	check if ship is destroyed and if it is set isDestroyed to true
					if (hasIt.getIsDestroyed() == true) {
						return true;
					}
					return false;
				}
			}
		}
		
		return false;
	}

}
