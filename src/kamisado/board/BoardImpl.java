package kamisado.board;

import java.util.List;
import java.util.ArrayList;

public class BoardImpl implements Board {
	
	private Color[][] boardColors;
	private Piece[][] boardPieces;
	private Square[][] pieceLocations;
	
	public BoardImpl() {
		
		// Initilize board colors...
		boardColors = new Color[][] {
		
		    { Color.ORANGE, Color.BLUE, Color.PURPLE, Color.PINK,Color.YELLOW,Color.RED,Color.GREEN,Color.BROWN },
			{ Color.RED,Color.ORANGE,Color.PINK,Color.GREEN,Color.BLUE,Color.YELLOW,Color.BROWN,Color.PURPLE },
			{ Color.GREEN,Color.PINK,Color.ORANGE,Color.RED,Color.PURPLE,Color.BROWN,Color.YELLOW,Color.BLUE },
			{ Color.PINK,Color.PURPLE,Color.BLUE,Color.ORANGE,Color.BROWN,Color.GREEN,Color.RED,Color.YELLOW },
			{ Color.YELLOW,Color.RED,Color.GREEN,Color.BROWN,Color.ORANGE,Color.BLUE,Color.PURPLE,Color.PINK },
			{ Color.BLUE,Color.YELLOW,Color.BROWN,Color.PURPLE,Color.RED,Color.ORANGE,Color.PINK,Color.GREEN },
			{ Color.PURPLE,Color.BROWN,Color.YELLOW,Color.BLUE,Color.GREEN,Color.PINK,Color.ORANGE,Color.RED },
			{ Color.BROWN,Color.GREEN,Color.RED,Color.YELLOW,Color.PINK,Color.PURPLE,Color.BLUE,Color.ORANGE }
		};
		
		// Initialize Pieces on board.,.
		boardPieces = new Piece[8][8];
		pieceLocations = new Square[2][8];
		
		for ( int x=0; x<8; x++ ) {
			
			Color c = getSquareColor(x,0);
			Piece p = new Piece( Player.WHITE, c );
			Square s = new Square( x,0 );
			setBoardPiece(s,p);
			setPieceLocation(p,s);
			
			c = getSquareColor(x,7);
			p = new Piece( Player.BLACK, c);
			s = new Square( x,7 );
			setBoardPiece(s,p);
			setPieceLocation(p,s);
			
		}
		
	}
	
	/**
	 * get the color of the square referenced by x,y / Square
	 * @param x   x index on board
	 * @param y   y index on board
	 * @return    the color of the square at x,y
	 */
	@Override
	public Color getSquareColor(int x, int y) {
		return boardColors[y][x];
	}

	@Override
	public Color getSquareColor(Square s) {
		return boardColors[s.getY()][s.getX()];
	}
	
	/**
	 * get the Piece at a particular square / x,y
	 * @param x   x index on board
	 * @param y   y index on board
	 * @return    the Piece on the board square at x,y
	 *            will return null if square is not occupied
	 */
	@Override
	public Piece getPieceOnSquare(int x, int y) {
		return boardPieces[y][x];
	}

	@Override
	public Piece getPieceOnSquare(Square s) {
		return boardPieces[s.getY()][s.getX()];
	}
	
	/**
	 * return the Square the specified Piece is on
	 * @param p  -- specified Piece
	 * @return -- the Square the specified Piece is on.
	 */
	public Square getSquarePieceIsOn( Piece p ) {
		return pieceLocations[p.getPlayer().ordinal()][p.getColor().ordinal()];
	}
	
	/**
	 * set the board location ( square / x,y ) to a particular Piece
	 * @param s
	 * @param p
	 */
	private void setBoardPiece( Square s, Piece p) {
		boardPieces[s.getY()][s.getX()] = p;
	}
	
	private void setPieceLocation(Piece p, Square loc ) {
		pieceLocations[p.getPlayer().ordinal()][p.getColor().ordinal()] = loc;
	}
	
	/**
	 *  
	 * @param p  -- the piece to be moved
	 * @param s  -- the square to move the piece to
	 * @return   -- true if move is valid
	 */
	@Override
	public boolean move(Piece p, Square s) {
		Square start = pieceLocations[p.getPlayer().ordinal()][p.getColor().ordinal()];
		// set board piece square ( start ) to null;
		setBoardPiece( start, null);
		setBoardPiece( s, p );
		setPieceLocation( p , s);
		
		return false;
	}
	/**
	 * 
	 * @param p  -- the piece to move
	 * @param s  -- the intended square to move to...
	 * @return   -- true if move is valid
	 */
	@Override
	public boolean isValidMove(Piece p, Square s) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * returns a list of allowable moves for the specified Piece
	 * 
	 */
	@Override
	public List<Square> getAllowableMoves(Piece p) {
		return new ArrayList<Square>();
	}
	
	
	/**
	 * Simple text rendering of board
	 */
	public void render() {
		
		System.out.println();
		
		for ( int y=0; y<8; y++ ) {
			for ( int x=0; x<8; x++ ) {
				
				Square sq = new Square(x,y);
				
				Color c = getSquareColor(sq);
				Piece p = getPieceOnSquare(sq);
				
				String colr = c.name().substring(0, 2);
				
				if (p!=null) {
					Color pcolr = p.getColor();
					String pcolrname=pcolr.name().substring(0, 2);
					if ( p.getPlayer()==Player.BLACK) System.out.print("["+pcolrname+"]");
					else System.out.print("("+pcolrname+")");
				}
				else
					System.out.print(" "+colr+" ");
			}
			System.out.println();
		}
	}

}
