import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

public class GameWindow implements MouseInputListener
{	
	   private JFrame frame;
	   private JPanel panel;
	   private ColoredBoard board;
	   
	   public ColoredBoard getBoard() {
		return board;
	}

	public void setBoard(ColoredBoard board) {
		this.board = board;
	}

	public GameWindow()
	   {
		  frame = new JFrame("Kamisado");
		  panel = new JPanel();
		  board = new ColoredBoard();
	      
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
				  ps.addMouseListener(this);

			  }
			  panel.add(rowPanel);
		      
		  }  
	      frame.add(panel);
	      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      frame.pack();
	      frame.setVisible(true);	     
   }
	  
public static void main(String[] args)
{
  SwingUtilities.invokeLater(new Runnable()
  {
     public void run()
     {
        new GameWindow();
     }
  });
}

@Override
public void mouseClicked(MouseEvent e) {

	PanelSquare ps = (PanelSquare) e.getSource();
	java.awt.Color panelColor = ps.getBackground();
	
	PanelSquare ps1 = (PanelSquare) e.getSource();
}
public void mousePressed(MouseEvent e) {}
public void mouseReleased(MouseEvent e) {}
public void mouseEntered(MouseEvent e) {}
public void mouseExited(MouseEvent e) {}
public void mouseDragged(MouseEvent e) {}
public void mouseMoved(MouseEvent e) {}

}