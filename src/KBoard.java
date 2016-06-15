import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class KBoard {
	   
	public PanelSquare [][] panelSquares;	
    public BoardPieces pieces;
    
    
    KBoard()
    {    	
    	pieces = new BoardPieces();
    	panelSquares = new PanelSquare[8][8];
    	
    	
      for (int i = 0; i < 8; i++)
      {
    	  for (int j = 0; j < 8; j++)
    	  {
    		  panelSquares[i][j] = new PanelSquare(Colors.colors[i][j], i, j);
    		  
    	  }
      }
    panelSquares[0][7].setLabel(pieces.whitePieces[0]); 
    panelSquares[0][6].setLabel(pieces.whitePieces[1]);
    panelSquares[0][5].setLabel(pieces.whitePieces[2]);
    panelSquares[0][4].setLabel(pieces.whitePieces[3]);
    panelSquares[0][3].setLabel(pieces.whitePieces[4]);
    panelSquares[0][2].setLabel(pieces.whitePieces[5]);
    panelSquares[0][1].setLabel(pieces.whitePieces[6]);
    panelSquares[0][0].setLabel(pieces.whitePieces[7]);     	
    panelSquares[7][7].setLabel(pieces.blackPieces[0]); 
    panelSquares[7][6].setLabel(pieces.blackPieces[1]);
    panelSquares[7][5].setLabel(pieces.blackPieces[2]);
    panelSquares[7][4].setLabel(pieces.blackPieces[3]);
    panelSquares[7][3].setLabel(pieces.blackPieces[4]);
    panelSquares[7][2].setLabel(pieces.blackPieces[5]);
    panelSquares[7][1].setLabel(pieces.blackPieces[6]);
    panelSquares[7][0].setLabel(pieces.blackPieces[7]);  		    
    
}
}