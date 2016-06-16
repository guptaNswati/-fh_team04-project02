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
	   private boolean gameStarted, gameOver, singlePlayer, blockedByComputer;
	   private static final JButton singlePlayerButton = new JButton("singlePlayer");
	   public KamisadoBoard()
	   {
		  frame = new JFrame("Kamisado");
		  panel = new JPanel();
		  board = new KBoard();
		  model = new BoardImpl();
		  //p = model.getPieceOnSquare(0,0);
		  gameStarted = false;
		  gameOver = false;
	      singlePlayer = false;
	      blockedByComputer = false;
	      singlePlayerButton.addActionListener(new SinglePlayer());
	      panel.add(singlePlayerButton);
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
	List <Square> allowable;
	x = clicked.getXX();
	y = clicked.getYY();
	Square s = new Square (y,x);
	Player nextPlayer;
	Color c;
	PanelSquare allowablePanel;
	Square from;
	PanelSquare fromPS;
	System.out.println(s);
	JLabel movedPiece;
	
	if (!gameStarted){
		if (x == 0 || x == 7){
			p = model.getPieceOnSquare(s);
			System.out.println(p);
			allowable = model.getAllowableMoves(p);
			
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
	
	if (!blockedByComputer){
	//checking that the move is valid and that the game is not over
	if (!model.isValidMove(p, s) || gameOver){
		return;
	}
	
	//clearing old possible moves display
	allowable = model.getAllowableMoves(p);
			
	for ( Square as: allowable){
		allowablePanel = board.panelSquares[as.getY()][as.getX()];
		    	
		allowablePanel.remove(0);
		allowablePanel.repaint();
	}
	
	from = model.getSquarePieceIsOn(p);
	gameOver = model.move(p, s);
		
	System.out.println( from );
	
	fromPS = board.panelSquares[from.getY()][from.getX()];
	
	movedPiece = fromPS.getLabel();
	
	fromPS.remove(0);
	fromPS.repaint();
	
	clicked.setLabel(movedPiece);
	clicked.repaint();
	
	if (gameOver){
		return;
	}
	
	//switching p to the next player's piece
	nextPlayer = p.getPlayer() == Player.WHITE?Player.BLACK:Player.WHITE;
	c = model.getSquareColor(s);
	p = new Piece(nextPlayer,c);
	}
	
	
	if (!singlePlayer){	
		allowable = model.getAllowableMoves(p);
		//in case of blocked piece, switch p again to the other player
		if (allowable.size() == 0){
			nextPlayer = p.getPlayer() == Player.WHITE?Player.BLACK:Player.WHITE;
			c = model.getSquareColor(model.getSquarePieceIsOn(p));
			p = new Piece(nextPlayer,c);
			allowable = model.getAllowableMoves(p);
		}
		
			for ( Square as: allowable){
				allowablePanel = board.panelSquares[as.getY()][as.getX()];
				JLabel highlight = new JLabel(null,new ImageIcon(new ImageIcon("Pieces/Allowable.png").getImage().
						getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER);
				allowablePanel.setLabel(highlight);
			}
		}
	
	else{
		allowable = model.getAllowableMoves(p);
		//in case of blocked piece, switch p again to the other player
		if (allowable.size() == 0){
			nextPlayer = p.getPlayer() == Player.WHITE?Player.BLACK:Player.WHITE;
			c = model.getSquareColor(model.getSquarePieceIsOn(p));
			p = new Piece(nextPlayer,c);
			allowable = model.getAllowableMoves(p);

			for ( Square as: allowable){
				allowablePanel = board.panelSquares[as.getY()][as.getX()];
				JLabel highlight = new JLabel(null,new ImageIcon(new ImageIcon("Pieces/Allowable.png").getImage().
						getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER);
				allowablePanel.setLabel(highlight);
			}

			return;
		}
		
		from = model.getSquarePieceIsOn(p);

		gameOver = model.computerMove(p);
		
		Square next = model.getSquarePieceIsOn(p);
		fromPS = board.panelSquares[from.getY()][from.getX()];
		movedPiece = fromPS.getLabel();
		fromPS.remove(0);
		fromPS.repaint();
		clicked = board.panelSquares[next.getY()][next.getX()];
		clicked.setLabel(movedPiece);
		clicked.repaint();
		

		if (!gameOver){
			
			nextPlayer = p.getPlayer() == Player.WHITE?Player.BLACK:Player.WHITE;
			c = model.getSquareColor(next);
			p = new Piece(nextPlayer,c);
			allowable = model.getAllowableMoves(p);
			
			if (allowable.size() != 0){
				blockedByComputer = false;
				for ( Square as: allowable){
					allowablePanel = board.panelSquares[as.getY()][as.getX()];
					JLabel highlight = new JLabel(null,new ImageIcon(new ImageIcon("Pieces/Allowable.png").getImage().
							getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER);
					allowablePanel.setLabel(highlight);
				}
			}
			
			else {
				blockedByComputer = true;
				nextPlayer = p.getPlayer() == Player.WHITE?Player.BLACK:Player.WHITE;
				c = model.getSquareColor(model.getSquarePieceIsOn(p));
				p = new Piece(nextPlayer,c);
				allowable = model.getAllowableMoves(p);
				
				for ( Square as: allowable){
					allowablePanel = board.panelSquares[as.getY()][as.getX()];
					JLabel highlight = new JLabel(null,new ImageIcon(new ImageIcon("Pieces/Allowable.png").getImage().
							getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER);
					allowablePanel.setLabel(highlight);
				}

			}
		}
	}
}

private void recursiveFunction() {
	// TODO Auto-generated method stub
	
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

class SinglePlayer implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!singlePlayer){
			singlePlayer = true;
		}
		else {
			singlePlayer = false;
		}
	}

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
