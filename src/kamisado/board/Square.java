package kamisado.board;

/**
 * 
 * @author chris
 * Illustrating some methods for a board square
 * Questions:  How to represent x and y ( for instance
 * X 1..8 and Y a..h )
 */

public class Square {
	
	private int x,y;
	
	public Square(int x, int y ) {
		
		setX(x);
		setY(y);
		
	}

	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean equals( Object o ) {
		
		if ( !(o instanceof Square)) return false;
		Square sq = (Square)o;
		
		return ( (sq.getX()==getX()) && (sq.getY()==getY()) );
		
	}

	public String toString() {
		return "("+x+","+y+")";
	}
	

	
}



