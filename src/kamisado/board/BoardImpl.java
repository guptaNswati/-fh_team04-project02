package kamisado.board;

import java.util.List;

public class BoardImpl implements Board {
	
	private Color[][] boardColors;
	private Piece[][] boardPieces;
	private Square[][] pieceLocations;
	
	public BoardImpl() {
		
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

	@Override
	public Color getSquareColor(int x, int y) {
		return boardColors[y][x];
	}

	@Override
	public Color getSquareColor(Square s) {
		return boardColors[s.getY()][s.getX()];
	}
	
	@Override
	public Piece getPieceOnSquare(int x, int y) {
		return boardPieces[y][x];
	}

	@Override
	public Piece getPieceOnSquare(Square s) {
		return boardPieces[s.getY()][s.getX()];
	}
	
	private void setBoardPiece( Square s, Piece p) {
		boardPieces[s.getY()][s.getX()] = p;
	}
	
	private void setPieceLocation(Piece p, Square loc ) {
		pieceLocations[p.getPlayer().ordinal()][p.getColor().ordinal()] = loc;
	}
	
	@Override
	public boolean move(Piece p, Square s) {
		Square start = pieceLocations[p.getPlayer().ordinal()][p.getColor().ordinal()];
		// set board piece square ( start ) to null;
		setBoardPiece( start, null);
		setBoardPiece( s, p );
		setPieceLocation( p , s);
		
		return false;
	}

	@Override
	public boolean isValudMove(Piece p, Square s) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<Square> getAllowableMoves(Piece p) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Simple text rendering of board
	 */
	public void render() {
		
		for ( int y=0; y<8; y++ ) {
			for ( int x=0; x<8; x++ ) {
				
				Square sq = new Square(x,y);
				
				Color c = getSquareColor(sq);
				Piece p = getPieceOnSquare(sq);
				
				String colr = c.name().substring(0, 2);
				
				if (p!=null) {
					Color pcolr = p.getColor();
					String pcolrname=pcolr.name().substring(0, 2);
					System.out.print("("+pcolrname+")");
				}
				else
					System.out.print(" "+colr+" ");
			}
			System.out.println();
		}
	}

}
