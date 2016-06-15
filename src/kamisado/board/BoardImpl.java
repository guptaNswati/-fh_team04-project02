package kamisado.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		
		if (checkWinCondition(p,s)){
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * 
	 * @param p  -- the piece to move
	 * @param s  -- the intended square to move to...
	 * @return   -- true if move is valid
	 */
	@Override
	public boolean isValidMove(Piece p, Square s) {
		System.out.println("teststartisvalid");

		List<Square> sqList = getAllowableMoves(p);
		boolean isValid = sqList.contains(s);
		
		
		
		/*Square checkSquare;
		for (int i = 0; i < sqList.size(); i++){
			checkSquare = sqList.get(i);
			if ((checkSquare.getX() == s.getX()) && (checkSquare.getY() == s.getY())){
				isValid = true;
				break;
			}
		}*/
		System.out.println("testendisvalid");
		return isValid;
	}

	/**
	 * returns a list of allowable moves for the specified Piece
	 * 
	 */
	@Override
	public List<Square> getAllowableMoves(Piece p) {

		//System.out.println("teststartgetallow");
		List<Square> sqList = new ArrayList<Square>();
		boolean isValid = true;
		Square pieceSquare = getSquarePieceIsOn(p);
		Square checkSquare = pieceSquare;
		if (p.getPlayer() == Player.WHITE){
			//System.out.println("test getallow white");
			while (isValid){
				//System.out.println("test getallow white left");
				if (((checkSquare.getX()-1) >= 0) && ((checkSquare.getY()+1) <= 7)){  
					if (boardPieces[checkSquare.getY()+1][checkSquare.getX()-1] == null){
						checkSquare = new Square((checkSquare.getX()-1), (checkSquare.getY()+1));
						sqList.add(checkSquare);
					}
					else{
						isValid = false;
					}
				}
				else{
					isValid = false;
				}
				//alternatively, use break
				
			}
			
			isValid = true;
			checkSquare = pieceSquare;
			
			while (isValid){
				//System.out.println("test getallow white right");
				if (((checkSquare.getX()+1) <= 7) && ((checkSquare.getY()+1) <= 7)){
					if (boardPieces[checkSquare.getY()+1][checkSquare.getX()+1] == null){
						checkSquare = new Square((checkSquare.getX()+1), (checkSquare.getY()+1));
						sqList.add(checkSquare);
					}
					else{
						isValid = false;
					}
				}
				else{
					isValid = false;
				}
				
			}
			
			isValid = true;
			checkSquare = pieceSquare;
			
			while (isValid){
				//System.out.println("test getallow white straight");
				if ((checkSquare.getY()+1) <= 7){
					
					//System.out.println("WOH");
					
					if (boardPieces[checkSquare.getY()+1][checkSquare.getX()] == null){
						
						//System.out.println("in allowableMOves white straight ...");
						
						checkSquare = new Square((checkSquare.getX()), (checkSquare.getY()+1));
						sqList.add(checkSquare);
					}
					else{
						isValid = false;
					}
				}
				else{
					isValid = false;
				}
				
			}
		}
		
		else{ // BLACK
			while (isValid){
				if (((checkSquare.getX()-1) >= 0) && ((checkSquare.getY()-1) >= 0)){
					if (boardPieces[checkSquare.getY()-1][checkSquare.getX()-1] == null){
						checkSquare = new Square((checkSquare.getX()-1), (checkSquare.getY()-1));
						sqList.add(checkSquare);
					}
					else{
						isValid = false;
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
				if (((checkSquare.getX()+1) <= 7) && ((checkSquare.getY()-1) >= 0)){
					if (boardPieces[checkSquare.getY()-1][checkSquare.getX()+1] == null){
						checkSquare = new Square((checkSquare.getX()+1), (checkSquare.getY()-1));
						sqList.add(checkSquare);
					}
					else{
						isValid = false;
					}
				}
				else{
					isValid = false;
				}
			}
			
			isValid = true;
			checkSquare = pieceSquare;
			
			while (isValid){
				if ((checkSquare.getY()-1) >= 0){
					if (boardPieces[checkSquare.getY()-1][checkSquare.getX()] == null){
						checkSquare = new Square((checkSquare.getX()), (checkSquare.getY()-1));
						sqList.add(checkSquare);
					}
					else{
						isValid = false;
					}
				}
				else{
					isValid = false;
				}
			}
		}
		//System.out.println("testendgetallow");
		
		//System.out.println( sqList );
		
		return sqList;
	}
	
	public boolean checkWinCondition(Piece p, Square s){
		System.out.println("WinCheckStart");
		if (p.getPlayer() == Player.BLACK && s.getY() == 0){
			System.out.println("Black wins!");
			return true;
		}
		else if (p.getPlayer() == Player.WHITE && s.getY() == 7){
			System.out.println("White wins!");
			return true;
		}
		
		else{
			System.out.println("Game's not over!");
			return false;
		}
	}
	
	public boolean computerMove(Piece p){
		Square moveTo = null;
		boolean won = false;
		Random randomGenerator = new Random();
		List <Square> safeMoves = new ArrayList<Square>();
		System.out.println("initiate!");
		for (int i = 0; i < getAllowableMoves(p).size(); i++){
			if ((getAllowableMoves(p).get(i).getY() == 0) || (getAllowableMoves(p).get(i).getY() == 7)){
				moveTo = getAllowableMoves(p).get(i);
			}
		}

		System.out.println("not a winner!");
		if (moveTo == null){
			System.out.println("moveTo null");
			for (int i = 0; i < getAllowableMoves(p).size(); i++){
				if (lookAhead(p, getAllowableMoves(p).get(i))){
					safeMoves.add(getAllowableMoves(p).get(i));
				}
			}
			
			int random = randomGenerator.nextInt(safeMoves.size());
			moveTo = safeMoves.get(random);
		}
		System.out.println("done!");
		won = move(p, moveTo);
		return won;
	}
	
	public boolean lookAhead(Piece p, Square s){
		boolean safe = true;
		Color color = getSquareColor(s);
		Square initSq = getSquarePieceIsOn(p);
		Piece nextP = null;
		
		setBoardPiece( initSq, null);
		setBoardPiece( s, p );
		setPieceLocation( p , s);
		
		System.out.println("Looking ahead!");
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				if ((getPieceOnSquare(i,j) != null)){
					if  ((color == (getPieceOnSquare(i,j).getColor()) &&
					p.getPlayer() != getPieceOnSquare(i,j).getPlayer())){
						System.out.println("good");
					nextP = getPieceOnSquare(i, j);
					}
				}
			}
		}
		System.out.println(nextP.getColor().toString());
		for (int i = 0; i < getAllowableMoves(nextP).size(); i++){
			if ((getAllowableMoves(nextP).get(i).getY() == 0) || (getAllowableMoves(nextP).get(i).getY() == 7)){
				safe = false;
			}
		}
		
		setBoardPiece( s, null);
		setBoardPiece( initSq, p );
		setPieceLocation( p , initSq);
		
		return safe;

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

					if (p.getPlayer() == Player.WHITE){
						System.out.print("("+pcolrname+")");
					}
					else {
						System.out.print("["+pcolrname+"]");
					}

				}
				else
					System.out.print(" "+colr+" ");
			}
			System.out.println();
		}
	}
}
