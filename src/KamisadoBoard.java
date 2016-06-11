import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

public class KamisadoBoard implements MouseInputListener
{	
	   private JFrame frame;
	   private JPanel panel;
	   private KBoard board;
	   
	   
	   public KamisadoBoard()
	   {
		  frame = new JFrame("Kamisado");
		  panel = new JPanel();
		  board = new KBoard();
	      
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
				  rowPanel.add(ps);
				  board.panelSquares[x][y].addMouseListener(this);

			  }
			  panel.add(rowPanel);
		      
		  }   
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
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub

	
	PanelSquare ps = (PanelSquare) e.getSource();
	System.out.println(" ps " + ps.getXX() + ", " + ps.getYY());
	
	PanelSquare ps1 = board.panelSquares[1][0];
	ps1.setLabel(board.pieces.blackPieces[0]);
	ps1.repaint();
	
	PanelSquare ps2 = board.panelSquares[0][0];
	ps2.setLabel(new JLabel());
	ps2.repaint();
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
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

@Override
public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


}