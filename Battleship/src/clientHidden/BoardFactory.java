package clientHidden;

class BoardFactory {

	/**
	 * pick one of the subclasses depending on the type(String)
	 * @param type
	 * @return
	 */
	public Board createBoard(String type) {

		Board board = null;

		if (type.equals("SmallBoard")) {
			board = new SmallBoard();
		} else if (type.equals("MediumBoard")) {
			board = new MediumBoard();
		} else if (type.equals("LargeBoard")) {
			board = new LargeBoard();
		}

		return board;
	}

}
