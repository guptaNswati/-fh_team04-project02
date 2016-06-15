import java.awt.Dimension;
import java.awt.Image;
import kamisado.board.*;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class KamisadoBoard implements MouseListener
{	
	   private JFrame frame;
	   private JPanel panel;
	   private KBoard board;
	   private BoardImpl model;
	   private Piece p;
	   private boolean gameStarted;	  
	   private static final JButton exitButton = new JButton("Exit");
	   private static final JButton RestartButton = new JButton("restart");
	   
	   public KamisadoBoard() 
	   {
		  frame = new JFrame("Kamisado");
		  panel = new JPanel();
		  board = new KBoard();
		  model = new BoardImpl();
		  //p = model.getPieceOnSquare(0,0);
		  gameStarted = false;
        exitButton.addActionListener(new ExitHandler());
        RestartButton.addActionListener((new restartHandler()));
        panel.add(exitButton);
        panel.add(RestartButton);
		  panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		  
		  for (int x=0; x < 8; x++)
		  {	 
			  JPanel rowPanel = new JPanel();
			  rowPanel.setLayout(new BoxLayout(rowPanel, BoxLayout.X_AXIS));
			  for (int y = 0; y < 8; y++)
			  {
				  PanelSquare ps = board.panelSquares[x][y];
				  ps.setPreferredSize(new Dimension(50, 50));
				  ps.setSize(new Dimension(50, 50));
				  //ps.addImageLabel(new JLabel(null, Symbols.symbols[x][y], JLabel.CENTER));
				  rowPanel.add(ps);
				  ps.addMouseListener(this);

			  }
			  panel.add(rowPanel);
		      
		  }  
		  
		 /*ImageIcon BlackOrange = new ImageIcon(new ImageIcon("Images/Symbol1.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	     JLabel label = new JLabel(null, BlackOrange, JLabel.CENTER);
	     JLabel label2 = new JLabel(null, BlackOrange, JLabel.CENTER);
	     
	      board.panelSquares[3][3].setLabel(label2);
		  board.panelSquares[6][0].setLabel(label);*/
		  
//		  board.panelSquares[2][0].add(BlackOrange);
	      frame.add(panel);
	      //frame.setSize(1000, 1000);
	      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      frame.pack();
//	      frame.setResizable(false);
	     
	      frame.setVisible(true);	     
   }
	 
	   
	   public boolean isEmpty(JPanel panel)
	   {
		   System.out.println(panel.getComponent(0));
		   if(panel.getComponent(0) == null)
		   {
			   return true;
		   }
		   return false;		   
	   }
	   
	   public void allowMove(JPanel panel, JLabel label)
	   {
		   panel.add(label);		   
	   }
	   
	   public ArrayList<PanelSquare> movesForBlackOrange()
	   {
		   ArrayList<PanelSquare> listOfPanels = new ArrayList<PanelSquare>();		   
		   
		   listOfPanels.add(board.panelSquares[1][0]);
		   listOfPanels.add(board.panelSquares[1][1]);
		   
		   listOfPanels.add(board.panelSquares[2][0]);
		   listOfPanels.add(board.panelSquares[2][2]);
		   
		   listOfPanels.add(board.panelSquares[3][0]);
		   listOfPanels.add(board.panelSquares[3][3]);
		   
		   listOfPanels.add(board.panelSquares[4][0]);
		   listOfPanels.add(board.panelSquares[4][4]);
		   
		   listOfPanels.add(board.panelSquares[5][0]);
		   listOfPanels.add(board.panelSquares[5][5]);
		   
		   listOfPanels.add(board.panelSquares[6][0]);
		   listOfPanels.add(board.panelSquares[6][6]);	
		   
		   return listOfPanels;
	   }
   
	  
public static void main(String[] args)
{
  SwingUtilities.invokeLater(new Runnable()
  {
     public void run()
     {
        new KamisadoBoard();
     }
  });
}

@Override
public void mouseReleased(MouseEvent e) {
	int x,y;
	PanelSquare clicked = (PanelSquare)e.getSource();
	
	x = clicked.getXX();
	y = clicked.getYY();
	Square s = new Square (y,x);
	
	System.out.println(s);
	
	if (!gameStarted){
		if (x == 0 || x == 7){
			p = model.getPieceOnSquare(s);
			System.out.println(p);
			List <Square> allowable = model.getAllowableMoves(p);
			PanelSquare allowablePanel;
			
			for ( Square as: allowable){
				allowablePanel = board.panelSquares[as.getY()][as.getX()];
		    	JLabel highlight = new JLabel(null,new ImageIcon(new ImageIcon("Pieces/Allowable.png").getImage().
		    			getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER);
				allowablePanel.setLabel(highlight);
				//allowablePanel.repaint();
			}
			//System.out.println(p);
		    gameStarted = true;
		}
		
		return;
	}
	
	
	if (!model.isValidMove(p, s)){
		return;
	}
		
	Square from = model.getSquarePieceIsOn(p);
	model.move(p, s);
	
	
	System.out.println( from );
	
	PanelSquare fromPS = board.panelSquares[from.getY()][from.getX()];
	
	JLabel l = fromPS.getLabel();
	
	fromPS.remove(0);
	fromPS.repaint();
	
	clicked.setLabel( l );
	clicked.repaint();
	
	Player nextPlayer = p.getPlayer() == Player.WHITE?Player.BLACK:Player.WHITE;
	Color c = model.getSquareColor(s);
	
	p = new Piece(nextPlayer,c);
	/*
	gameRules.getAllowableMoorves((Piece)e.getSource());
	PanelSquare ps = (PanelSquare) e.getSource();
	System.out.println(" ps " + ps.getXX() + ", " + ps.getYY());
	
	PanelSquare ps1 = board.panelSquares[1][0];
	ps1.setLabel(board.pieces.blackPieces[0]);
//	ps1.repaint();
	
	PanelSquare ps2 = board.panelSquares[0][0];
	ps2.setLabel(new JLabel());
//	ps2.repaint();
 * 
 */
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
}

/*
@Override
public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
*/
class ExitHandler implements ActionListener{
   public void actionPerformed(ActionEvent e){
       System.exit(0);
   }
}

class restartHandler implements ActionListener{
   public void actionPerformed(ActionEvent e){
       new KamisadoBoard();
   }
}

