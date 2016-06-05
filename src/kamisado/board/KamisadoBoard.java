package kamisado.board;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class KamisadoBoard extends JPanel
{
   JPanel panel;
   KamisadoBoardPiece boardPiece = new KamisadoBoardPiece();
   
   public KamisadoBoard()
   {
      this.setBounds(400, 400, 600, 300);
      this.setVisible(true);
      panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
      panel.add(boardPiece.squares[0][1]);
      panel.add(boardPiece.squares[0][2]);
   }
 
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      
      frame = new JFrame("Kamisado");
      frame.setSize(600, 600);
      frame.setLocationRelativeTo(null);
     
     KamisadoBoard game = new KamisadoBoard();
     frame.add(game);

     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
       frame.setResizable(true);
   }
}
