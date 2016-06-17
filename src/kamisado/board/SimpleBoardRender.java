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
		sc.close();
	}

}
