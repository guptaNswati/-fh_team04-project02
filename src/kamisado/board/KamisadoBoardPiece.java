package kamisado.board;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class KamisadoBoardPiece extends JPanel
{
   public JPanel squares[][] = new JPanel[8][8];
   
   private static final Color orange = new Color(255,204,153);
   private static final Color blue = new Color(51,153,255);
   private static final Color cyan = new Color(153,255,255);
   private static final Color pink = new Color(255,102,178);
   private static final Color yellow = new Color(236,236,122);
   private static final Color red = new Color(246,74,85);
   private static final Color green = new Color(122, 230, 122);
   private static final Color brown = new Color(204, 102, 0);
   
   public KamisadoBoardPiece()
   {
      initializeBoard();
   }
   
   private void initializeBoard()
   {      
      
      for (int x = 0; x < 8; x++)
         for (int y = 0; y < 8; y++)
         {
            squares[x][y] = new JPanel();
         }    
      squares[0][0].setBackground(Color.orange);
      squares[1][1].setBackground(Color.orange);
      squares[2][2].setBackground(Color.orange);
      squares[3][3].setBackground(Color.orange);
      squares[4][4].setBackground(Color.orange);
      squares[5][5].setBackground(Color.orange);
      squares[6][6].setBackground(Color.orange);
      squares[7][7].setBackground(Color.orange);
      
      squares[0][1].setBackground(Color.blue);
      squares[1][4].setBackground(Color.blue);
      squares[2][7].setBackground(Color.blue);
      squares[3][2].setBackground(Color.blue);
      squares[4][5].setBackground(Color.blue);
      squares[5][0].setBackground(Color.blue);
      squares[6][3].setBackground(Color.blue);
      squares[7][6].setBackground(Color.blue);
      
      squares[0][2].setBackground(Color.cyan);
      squares[1][7].setBackground(Color.cyan);
      squares[2][4].setBackground(Color.cyan);
      squares[3][1].setBackground(Color.cyan);
      squares[4][6].setBackground(Color.cyan);
      squares[5][3].setBackground(Color.cyan);
      squares[6][0].setBackground(Color.cyan);
      squares[7][5].setBackground(Color.cyan);
      
      squares[0][3].setBackground(Color.pink);
      squares[1][2].setBackground(Color.pink);
      squares[2][1].setBackground(Color.pink);
      squares[3][0].setBackground(Color.pink);
      squares[4][7].setBackground(Color.pink);
      squares[5][6].setBackground(Color.pink);
      squares[6][5].setBackground(Color.pink);
      squares[7][4].setBackground(Color.pink);
      
      squares[0][4].setBackground(Color.yellow);
      squares[1][5].setBackground(Color.yellow);
      squares[2][6].setBackground(Color.yellow);
      squares[3][7].setBackground(Color.yellow);
      squares[4][0].setBackground(Color.yellow);
      squares[5][1].setBackground(Color.yellow);
      squares[6][2].setBackground(Color.yellow);
      squares[7][3].setBackground(Color.yellow);
      
      squares[0][5].setBackground(Color.red);
      squares[1][0].setBackground(Color.red);
      squares[2][3].setBackground(Color.red);
      squares[3][6].setBackground(Color.red);
      squares[4][1].setBackground(Color.red);
      squares[5][4].setBackground(Color.red);
      squares[6][7].setBackground(Color.red);
      squares[7][2].setBackground(Color.red);
      
      squares[0][6].setBackground(Color.green);
      squares[1][3].setBackground(Color.green);
      squares[2][0].setBackground(Color.green);
      squares[3][5].setBackground(Color.green);
      squares[4][2].setBackground(Color.green);
      squares[5][7].setBackground(Color.green);
      squares[6][4].setBackground(Color.green);
      squares[7][1].setBackground(Color.green);
      
      squares[0][7].setBackground(Color.black);
      squares[1][6].setBackground(Color.black);
      squares[2][5].setBackground(Color.black);
      squares[3][4].setBackground(Color.black);
      squares[4][3].setBackground(Color.black);
      squares[5][2].setBackground(Color.black);
      squares[6][1].setBackground(Color.black); 
      squares[7][0].setBackground(Color.black);
      
   }
}
