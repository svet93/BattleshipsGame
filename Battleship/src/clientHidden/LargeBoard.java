package clientHidden;

/** Generate a small board 12x10 */
class LargeBoard extends Board {
	public LargeBoard() {
		super();
		size = 12;
		width = size-2;
		height = size;
		board = new Square[size][size - 2];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - 2; j++) {
				board[i][j] = new Square(new Coordinates(i, j));
			}
		}
	}

}
