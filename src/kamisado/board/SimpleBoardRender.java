package kamisado.board;

public class SimpleBoardRender {

	public static void main(String[] args) {
		
		Board b = new BoardImpl();
		
		b.render();
		
		Square from= new Square(0,0);
		Piece p = b.getPieceOnSquare(from);
		Square to = new Square(0,3);
		b.move(p, to );
		
		System.out.println();
		
		b.render();
		
		from = new Square(2,0);
		p = b.getPieceOnSquare(from);
		to = new Square(3,1);
		b.move(p, to);
		
		System.out.println();
		
		b.render();
		
//		for ( int y=0; y<8; y++ ) {
//			for ( int x=0; x<8; x++ ) {
//				
//				Square sq = new Square(x,y);
//				
//				Color c = b.getSquareColor(sq);
//				Piece p = b.getPieceOnSquare(sq);
//				
//				String colr = c.name().substring(0, 2);
//				
//				if (p!=null) {
//					Color pcolr = p.getColor();
//					String pcolrname=pcolr.name().substring(0, 2);
//					System.out.print("("+pcolrname+")");
//				}
//				else
//					System.out.print(" "+colr+" ");
//			}
//			System.out.println();
//		}
	}

}
