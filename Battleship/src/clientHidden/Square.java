package clientHidden;

class Square {

	private boolean isClicked;           //    if a Square has been clicked this is set to true
	private boolean isAHit;				//    if a Square is a hit this is set to true
	private Coordinates coordinates;	//    Coordinates of where the Square

	public Square() {
		super();
		isClicked = false;
		isAHit = false;
	}

	public Square(Coordinates coordinates) {
		super();
		this.coordinates = coordinates;
		isClicked = false;
		isAHit = false;
	}

	public boolean isClicked() {
		return isClicked;
	}

	public Coordinates coordinates() {
		return this.coordinates;
	}

	public void setClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}

	public boolean isAHit() {
		return isAHit;
	}

	public void setHit() {
		this.isAHit = true;
	}

}
