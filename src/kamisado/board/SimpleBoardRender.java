package kamisado.board;
import java.util.Scanner;
public class SimpleBoardRender {

	public static void main(String[] args) {
		
		Board b = new BoardImpl();
		Scanner sc = new Scanner(System.in);
		int x=0;
		int y=0;
		Color color;
		Square square;
		boolean gameOver = false;
		boolean valid = false;
		boolean win = false;
		Piece p = b.getPieceOnSquare(0,0);
		Piece nextP = null;
		b.render();
		
		while (gameOver == false){
			System.out.println("The active piece is: " + p.toString());
			
			if (p.getPlayer() == Player.WHITE){
			
			if (b.getAllowableMoves(p).isEmpty() == false){
			
				System.out.println("ok");
				
				while (valid == false){
					System.out.println("Enter x:");
					x = sc.nextInt();
					System.out.println(x);
					System.out.println("Enter y:");
					y = sc.nextInt();
					System.out.println(y);
				
					if (b.isValidMove(p, new Square(x,y))){
						valid = true;
					}
					
					else{
						System.out.println("Not valid!");
					}
				}
			}
			
			else{
				x = b.getSquarePieceIsOn(p).getX();
				y = b.getSquarePieceIsOn(p).getY();
			}
			
			
			System.out.println(x + " " + y);
			square = new Square(x,y);
			win = b.move(p, square);
			//square = b.getSquarePieceIsOn(p);
			color = b.getSquareColor(square);
			
			
			for (int i = 0; i < 8; i++){
				for (int j = 0; j < 8; j++){
					if ((b.getPieceOnSquare(i,j) != null)){
						if  ((color == (b.getPieceOnSquare(i,j).getColor()) &&
						p.getPlayer() != b.getPieceOnSquare(i,j).getPlayer())){
						nextP = b.getPieceOnSquare(i, j);
						}
					}
				}
			}
			
			if (win == true){
				System.out.println("winCheckTrue");
				gameOver = true;
			}
			
			else {
				System.out.println("winCheckFalse");
				p = nextP;
				valid = false;
				b.render();
			}
			}
			
			//piece is black
			else {
				if (b.getAllowableMoves(p).isEmpty() == false){
					win = b.computerMove(p);
					square = b.getSquarePieceIsOn(p);
					color = b.getSquareColor(square);
					
					
					for (int i = 0; i < 8; i++){
						for (int j = 0; j < 8; j++){
							if ((b.getPieceOnSquare(i,j) != null)){
								if  ((color == (b.getPieceOnSquare(i,j).getColor()) &&
								p.getPlayer() != b.getPieceOnSquare(i,j).getPlayer())){
								nextP = b.getPieceOnSquare(i, j);
								}
							}
						}
					}
					
					if (win == true){
						System.out.println("winCheckTrue");
						gameOver = true;
						b.render();
					}
					
					else {
						System.out.println("winCheckFalse");
						p = nextP;
						valid = false;
						b.render();
					}
				}
			}
		}
		
		System.out.println(p.getPlayer().name() + " wins!");
		
		/*b.render();

		
		Square from= new Square(0,0);
		p = b.getPieceOnSquare(from);
		Square to = new Square(0,3);
		b.move(p, to );
		
		System.out.println();
		
		b.render();
		
		from = new Square(2,0);
		p = b.getPieceOnSquare(from);
		to = new Square(3,1);
		b.move(p, to);
		
		System.out.println();
		
		b.render();*/
		
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
