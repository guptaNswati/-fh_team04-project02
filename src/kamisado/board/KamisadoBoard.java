package kamisado.board;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class KamisadoBoard 
{
   JPanel panel = new JPanel();
   JFrame frame = new JFrame("Kamisado");
   KamisadoBoardPiece boardPiece = new KamisadoBoardPiece();
   public KamisadoBoard()
   {
    
      panel.setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.insets = new Insets(1,1,1,1);
      for (int x=0; x<8;x++)
         for (int y = 0; y<8; y++)
         {
            gbc.gridx = x;
            gbc.gridy = y;
            panel.add(boardPiece.squares[x][y], gbc);
         }
      frame.add(panel);
      frame.setSize(1000, 1000);
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
           new KamisadoBoard();
        }
     });
   }
}
