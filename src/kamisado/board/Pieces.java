import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

class Pieces {

    private List<Piece> whitePieces;
    private List<Piece> blackPieces;

    public Pieces() {
    	whitePieces = new ArrayList<Piece>();
    	blackPieces = new ArrayList<Piece>();
    	
    	Piece whitePiece;
    	Piece blackPiece;
    	    	
    	for(int i = 0; i < 8; i++)
        {        
        	whitePiece = new Piece();        
        	whitePiece.setColor(Color.WHITE);
        	whitePieces.add(whitePiece);
        	
        	blackPiece =  new Piece();
        	blackPiece.setColor(Color.BLACK);        	
        	blackPieces.add(blackPiece);
        }
    }

    public List<Piece> getWhitePieces() {
        return this.whitePieces;
    }
    
    public List<Piece> getBlackPieces() {
        return this.blackPieces;
    }
}
