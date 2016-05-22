package kamisado.board;

import java.util.List;

public class SimpleBoardRender {

	public static void main(String[] args) {
		
		Board b = new BoardImpl();
		
		b.render();
		
		Square from= new Square(0,0);
		Piece p1 = b.getPieceOnSquare(from);
		Square to = new Square(0,3);
		b.move(p1, to );
		
		System.out.println();
		
		b.render();
		
		from = new Square(2,0);
		Piece p2 = b.getPieceOnSquare(from);
		to = new Square(3,1);
		b.move(p2, to);
		
		System.out.println();
	
		
		b.render();
		
		System.out.println("Allowable Moves fpr Piece "+p1);
		List<Square> allowableMoves = b.getAllowableMoves(p1);
		
		for ( Square s : allowableMoves ) {
			
			System.out.println( s );
			
		}
		
		System.out.println("Allowable Moves fpr Piece "+p2);
		allowableMoves = b.getAllowableMoves(p2);
		
		for ( Square s : allowableMoves ) {
			
			System.out.println( s );
			
		}
		
		Piece p3 = new Piece(Player.BLACK,Color.PINK);
		allowableMoves = b.getAllowableMoves(p3);
		
		System.out.println("Allowable Moves fpr Piece "+p3);
		allowableMoves = b.getAllowableMoves(p3);
		
		for ( Square s : allowableMoves ) {
			
			System.out.println( s );
			
		}
		
	}

}
