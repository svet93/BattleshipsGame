package clientHidden;

/** Generate a small board 8x10 */
class MediumBoard extends Board {
	public MediumBoard() {
		super();
		size = 10;
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