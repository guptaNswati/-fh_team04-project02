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
	/**
	 * Get the Sqaure of the specified Piece
	 * @param    p  -- the Piece to get the location ( Square ) of
	 * @return      -- the Square ( location ) of the specified Piece ( p )
	 */
	public Square getSquarePieceIsOn(Piece p);
	
	/**
	 * Check if a particular Piece (p) on Square (s) makes a "win" condition
	 * @param p --  the Piece to check for winning condition
	 * @parma s --  the square to check for winning condition
	 * @return  --  true if the Piece p on Square s is a winning condition
	 */
	public boolean checkWinCondition(Piece p, Square s);
	
	/**
	 * BOT move
	 * @param  p  -- the Piece the BOT is to move
	 * @return    -- boolean ( winnig condition ? )
	 */
	 public boolean computerMove(Piece p);
	
	/**
	 * BOT lookahead
	 * @param p  --  Piece for lookahead
	 * @param s  --  Square for lookahead
	 * @return   --  true if ... ( winning condition )
	 */
	public boolean lookAhead(Piece p, Square s);
}
