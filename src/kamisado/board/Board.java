package kamisado.board;
/*
 * This is a preliminary interface or the Board class
 * 
 * 
 */

import java.util.List;

public interface Board {
	/**
	 * 
	 * @param x   x index on board
	 * @param y   y index on board
	 * @return    the color of the square at x,y
	 */
	public Color getSquareColor(int x, int y );
	public Color getSquareColor( Square s );
	
	/**
	 * 
	 * @param x   x index on board
	 * @param y   y index on board
	 * @return    the Piece on the board square at x,y
	 *            will return null if square is not occupied
	 */
	public Piece getPieceOnSquare(int x, int y );
	public Piece getPieceOnSquare( Square s );

	/**
	 * 
	 * @param p  -- the piece to be moved
	 * @param s  -- the square to move the piece to
	 * @return   -- true if move is valid
	 */
	public boolean move( Piece p, Square s );
	
	/**
	 * 
	 * @param p  -- the piece to move
	 * @param s  -- the intended square to move to...
	 * @return   -- true if move is valid
	 */
	public boolean isValidMove( Piece p,  Square s);
	
	/**
	 * returns a list of Allowable moves for the specified Piece
	 * 
	 */
	public List<Square> getAllowableMoves( Piece p );
	
	/**
	 * prints simple text version to System.out
	 */
	public void render();
	
	public Square getSquarePieceIsOn(Piece p);
	
	public boolean checkWinCondition(Piece p, Square s);
	
	public boolean computerMove(Piece p);
	
	public boolean lookAhead(Piece p, Square s);
}
