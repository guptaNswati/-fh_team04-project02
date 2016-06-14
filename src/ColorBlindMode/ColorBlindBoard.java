import javax.swing.JLabel;

public class ColorBlindBoard {
	 private KamisadoBoard board; 
	 
	 ColorBlindBoard()
	 {
		 initialiseColorBlind();		 
	 }
	 
	 public void initialiseColorBlind()
	 {
		 board = new KamisadoBoard();
		 
		 ColoredBoard coloredBoard = board.getBoard();
		 
		 PanelSquare[][] boardSquares = coloredBoard.panelSquares;
		 		 
		 for(int i = 0; i < 8; i++)
		 {
			 boardSquares[0][i].setLabel(Symbols.whitePiecesSymbols[i]);			 
			 boardSquares[7][i].setLabel(Symbols.blackPieceSymbols[i]);			
		 }
		 
		 for(int k = 1; k < 7; k++)
		 {
			 for(int j = 0; j < 8; j++)
			 {
				 boardSquares[k][j].addImageLabel(new JLabel(null,Symbols.squareSymbols[k][j], JLabel.CENTER));			 
			 }
		 }
	 }

}
