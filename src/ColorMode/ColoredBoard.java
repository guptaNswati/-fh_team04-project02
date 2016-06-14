import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class ColoredBoard {
	   
	public PanelSquare [][] panelSquares;	
    
    ColoredBoard()
    {    	
    	panelSquares = new PanelSquare[8][8];
    	   	
      for (int i = 0; i < 8; i++)
      {
    	  for (int j = 0; j < 8; j++)
    	  {
    		  panelSquares[i][j] = new PanelSquare(Colors.colors[i][j], i, j);    		  
    	  }
      }
      
      for(int k = 0; k < 8; k++)
		 {
    	     panelSquares[0][k].setLabel(BoardPieces.whitePieces[k]);			 
    	     panelSquares[7][k].setLabel(BoardPieces.blackPieces[k]);			
		 } 	
 
}
}