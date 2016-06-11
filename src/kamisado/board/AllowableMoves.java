package kamisado.board;

import java.util.ArrayList;
import java.util.List;

public class AllowableMoves {
	
public List<Square> getAllowableMoves(Piece p) {
		
		Board b = new BoardImpl();
			
		List<Square> list = new ArrayList<Square>();
		
		int direction = p.getPlayer()==Player.WHITE?1:-1;
		
		Square start = b.getSquarePieceIsOn( p );
		
		int x,y;
		
		y=start.getY()+direction;
		while (y<8 && y>=0) {
			
			Square s1 = new Square( start.getX(), y );
			if (( b.getPieceOnSquare(s1)!=null)) break;
			list.add(s1);
			
			y+=direction;
		}
	
		if ( start.getX()>0 ) {
			
			x = start.getX()-1;
			y = start.getY()+direction;
			
			while ( x>=0 && y<8 && y>=0 ) {
		    	Square s2 = new Square(x,y);
		    	if (( b.getPieceOnSquare(s2)!=null)) break;
				list.add(s2);
				x--;
				y+=direction;
				
		    }
		}
		
		if (start.getX()<7) {
			
			y = start.getY()+direction;
			x = start.getX()+1;
			
			while ( x<8 && y<8 && y>=0 ) {
			
				Square s3=new Square(x,y);
				if (( b.getPieceOnSquare(s3)!=null)) break;
				list.add(s3);
				
				x++;
				y+=direction;
				
			}
		}
		
		return list;
	
	}

}
