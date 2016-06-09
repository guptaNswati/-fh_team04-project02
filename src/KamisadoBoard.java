import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

public class KamisadoBoard //implements MouseInputListener
{	
	   private JFrame frame;
	   private JPanel panel;
	   private KBoard board;
	   
	   
	   public KamisadoBoard()
	   {
		  frame = new JFrame("Kamisado");
		  panel = new JPanel();
		  board = new KBoard();
	      
		  
	      panel.setLayout(new GridBagLayout());
	      GridBagConstraints gbc = new GridBagConstraints();
	      gbc.insets = new Insets(1,1,1,1);
	      	      
	      for (int x=0; x < 8; x++)
	      {	         
	    	  for (int y = 0; y < 8; y++)
	         {
	            gbc.gridx = y;
	            gbc.gridy = x;
	            panel.add(board.panelSquares[x][y].getPanel(), gbc);
	            
	           
	         }
	      }
	      
	      
//	      panel.addMouseListener(this);		   
	      frame.add(panel);
	      frame.setSize(1000, 1000);
	      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      frame.pack();
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
   
	   
//@Override
//public void mouseClicked(MouseEvent e) {
//	
//	if(e.getSource() == panel.getComponent(1)) //board.panelSquares[0][0].getPanel() || e.getSource() == board.panelSquares[0][0].getLabel())
//	{
//		System.out.println("hello");
//		
//	}
//	
//	ArrayList<PanelSquare> validPanels = movesForBlackOrange();
////	
//	System.out.println("source  " + e.getSource());
//	System.out.println("compo " + e.getComponent());
////	
////	
//	if(e.getSource() == board.panelSquares[0][0] )
//	{
//		System.out.println("hello");
////		
//	}
////	
//	if(e.getComponent() == board.panelSquares[0][0].getPanel() )
//	{
//		System.out.println("hello");
//	}
//}
//		
//	}
//	
//	for(int i = 0; i < validPanels.size(); i++)
//	{
//		if(e.getSource() == validPanels.get(i).getPanel())
//		{
//			System.out.println("hello");
//			
//			validPanels.get(i).setLabel(board.pieces.blackPieces[0]);
//
//		}
//	   }
	
//	if(e.equals(board.pieces.blackPieces[0]))
//	{
//		movesForBlackOrange();
		
//	}

//}
//
//
//
//@Override
//public void mousePressed(MouseEvent e) { }
//@Override
//public void mouseReleased(MouseEvent e) { }
//@Override
//public void mouseEntered(MouseEvent e) { }
//@Override
//public void mouseExited(MouseEvent e) { }
//@Override
//public void mouseDragged(MouseEvent e) { }
//@Override
//public void mouseMoved(MouseEvent e) { }

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


}