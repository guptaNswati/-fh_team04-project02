package kamisado.board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class KamisadoBoardPiece extends JPanel
{
   public JPanel squares[][] = new JPanel[8][8];
   
   private static final Color orange = new Color(255,204,153);
   private static final Color red = new Color(51,153,255);
   private static final Color green = new Color(153,255,255);
   private static final Color pink = new Color(255,102,178);
   private static final Color yellow = new Color(236,236,122);
   private static final Color blue = new Color(246,74,85);
   private static final Color lightblue = new Color(122, 230, 122);
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
            squares[x][y].setPreferredSize(new Dimension(50, 50));
         }    
      squares[0][0].setBackground(orange);
      squares[1][1].setBackground(orange);
      squares[2][2].setBackground(orange);
      squares[3][3].setBackground(orange);
      squares[4][4].setBackground(orange);
      squares[5][5].setBackground(orange);
      squares[6][6].setBackground(orange);
      squares[7][7].setBackground(orange);
      
      squares[0][1].setBackground(blue);
      squares[1][4].setBackground(blue);
      squares[2][7].setBackground(blue);
      squares[3][2].setBackground(blue);
      squares[4][5].setBackground(blue);
      squares[5][0].setBackground(blue);
      squares[6][3].setBackground(blue);
      squares[7][6].setBackground(blue);
      
      squares[0][2].setBackground(lightblue);
      squares[1][7].setBackground(lightblue);
      squares[2][4].setBackground(lightblue);
      squares[3][1].setBackground(lightblue);
      squares[4][6].setBackground(lightblue);
      squares[5][3].setBackground(lightblue);
      squares[6][0].setBackground(lightblue);
      squares[7][5].setBackground(lightblue);
      
      squares[0][3].setBackground(pink);
      squares[1][2].setBackground(pink);
      squares[2][1].setBackground(pink);
      squares[3][0].setBackground(pink);
      squares[4][7].setBackground(pink);
      squares[5][6].setBackground(pink);
      squares[6][5].setBackground(pink);
      squares[7][4].setBackground(pink);
      
      squares[0][4].setBackground(yellow);
      squares[1][5].setBackground(yellow);
      squares[2][6].setBackground(yellow);
      squares[3][7].setBackground(yellow);
      squares[4][0].setBackground(yellow);
      squares[5][1].setBackground(yellow);
      squares[6][2].setBackground(yellow);
      squares[7][3].setBackground(yellow);
      
      squares[0][5].setBackground(red);
      squares[1][0].setBackground(red);
      squares[2][3].setBackground(red);
      squares[3][6].setBackground(red);
      squares[4][1].setBackground(red);
      squares[5][4].setBackground(red);
      squares[6][7].setBackground(red);
      squares[7][2].setBackground(red);
      
      squares[0][6].setBackground(green);
      squares[1][3].setBackground(green);
      squares[2][0].setBackground(green);
      squares[3][5].setBackground(green);
      squares[4][2].setBackground(green);
      squares[5][7].setBackground(green);
      squares[6][4].setBackground(green);
      squares[7][1].setBackground(green);
      
      squares[0][7].setBackground(brown);
      squares[1][6].setBackground(brown);
      squares[2][5].setBackground(brown);
      squares[3][4].setBackground(brown);
      squares[4][3].setBackground(brown);
      squares[5][2].setBackground(brown);
      squares[6][1].setBackground(brown); 
      squares[7][0].setBackground(brown);
      
   }
}
