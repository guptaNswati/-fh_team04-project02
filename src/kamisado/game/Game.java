package kamisado.game;

import kamisado.board.*;

public interface Game {
	
	/**
	 * Called to start the game
	 */
	public void start();
	
	/**
	 * move piece from present location to the square specified
	 */
	public boolean move(Piece p ,Square s);
	
	/**
	 * shorthand for above method
	 */
	public boolean move(Square s);
	
	/**
	 * present player ( BLACK / WHITE )
	 */
	public Player player();
	
	/**
	 * present piece ( player / color )
	 */
	public Piece piece();
	
	/**
	 * allowable moves for current player / piece
	 */
	public Square[] allowableMoves();
	
	

}
