package kamisado.board;

import java.util.ArrayList;
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
	
	public Square getSquarePieceIsOn( Piece p ) {
		return pieceLocations[p.getPlayer().ordinal()][p.getColor().ordinal()];
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
	public boolean isValidMove(Piece p, Square s) {
		List<Square> sqList = getAllowableMoves(p);
		boolean isValid = false;
		Square checkSquare;
		for (int i = 0; i < sqList.size(); i++){
			checkSquare = sqList.get(i);
			if ((checkSquare.getX() == s.getX()) && (checkSquare.getY() == s.getY())){
				isValid = true;
				break;
			}
		}
		return isValid;
	}

	@Override
	public List<Square> getAllowableMoves(Piece p) {
		List<Square> sqList = new ArrayList<Square>();
		boolean isValid = true;
		Square pieceSquare = getSquarePieceIsOn(p);
		Square checkSquare = pieceSquare;
		if (p.getPlayer() == Player.BLACK){
			while (isValid){
				if (((checkSquare.getX()-1) >= 0) && ((checkSquare.getY()-1) >= 0)){
					if (boardPieces[checkSquare.getX()-1][checkSquare.getY()+1] == null){
						checkSquare = new Square((checkSquare.getX()-1), (checkSquare.getY()-1));
						sqList.add(checkSquare);
					}
				}
				//alternatively, use break
				else{
					isValid = false;
				}
			}
			
			isValid = true;
			checkSquare = pieceSquare;
			
			while (isValid){
				if (((checkSquare.getX()+1) <= 7) && ((checkSquare.getY()+1) <= 7)){
					if (boardPieces[checkSquare.getX()+1][checkSquare.getY()+1] == null){
						checkSquare = new Square((checkSquare.getX()+1), (checkSquare.getY()+1));
						sqList.add(checkSquare);
					}
				}
				else{
					isValid = false;
				}
			}
			
			isValid = true;
			checkSquare = pieceSquare;
			
			while (isValid){
				if ((checkSquare.getY()+1) <= 7){
					if (boardPieces[checkSquare.getX()][checkSquare.getY()+1] == null){
						checkSquare = new Square((checkSquare.getX()), (checkSquare.getY()+1));
						sqList.add(checkSquare);
					}
				}
				else{
					isValid = false;
				}
			}
		}
		return sqList;
	}
	
	public boolean checkWinCondition(Piece p, Square s){
		if (p.getPlayer() == Player.BLACK && s.getY() == 0)
			return true;
		else if (p.getPlayer() == Player.WHITE && s.getY() == 7)
			return true;
		else return false;
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
