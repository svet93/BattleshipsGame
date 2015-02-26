package clientHidden;



class User extends Player {
	public User() {
		super();
	}

	
	
	/**
	 * checks if a hit ship has been destroyed
	 */
	public boolean checkForDestroyed (Game game, Coordinates c) {
		Ship hasIt;
		for (Ship s : game.getComputer().ships()) {
			for (Square sq : s.positionList()) {
				if (sq.coordinates().getX() == c.getX() && sq.coordinates().getY() == c.getY()) {
					hasIt = s;
					hasIt.setDestroyed();
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
