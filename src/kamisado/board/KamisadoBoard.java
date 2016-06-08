package kamisado.board;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;




public class KamisadoBoard extends JPanel
{
   JPanel panel = new JPanel();
   JFrame frame = new JFrame("Kamisado");
   KamisadoBoardPiece boardPiece = new KamisadoBoardPiece();
   public KamisadoBoard()
   {
    
      panel.setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.insets = new Insets(1,1,1,1);
      for (int x=0; x < 8; x++)
         for (int y = 0; y < 8; y++)
         {
            gbc.gridx = y;
            gbc.gridy = x;
            panel.add(boardPiece.squares[x][y], gbc);
         }
      ImageIcon BlackOrange = new ImageIcon(new ImageIcon("BlackOrange.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      boardPiece.squares[0][0].add(new JLabel(BlackOrange));
      
      ImageIcon BlackBlue = new ImageIcon(new ImageIcon("BlackBlue.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      boardPiece.squares[0][1].add(new JLabel(BlackBlue));
      
      ImageIcon BlackLightBlue = new ImageIcon(new ImageIcon("BlackLightBlue.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      boardPiece.squares[0][2].add(new JLabel(BlackLightBlue));
      
      ImageIcon BlackPink = new ImageIcon(new ImageIcon("BlackPink.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      boardPiece.squares[0][3].add(new JLabel(BlackPink));
      
      ImageIcon BlackYellow = new ImageIcon(new ImageIcon("BlackYellow.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      boardPiece.squares[0][4].add(new JLabel(BlackYellow));
      
      ImageIcon BlackRed = new ImageIcon(new ImageIcon("BlackRed.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      boardPiece.squares[0][5].add(new JLabel(BlackRed));
      
      ImageIcon BlackGreen = new ImageIcon(new ImageIcon("BlackGreen.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      boardPiece.squares[0][6].add(new JLabel(BlackGreen));
      
      ImageIcon BlackBrown = new ImageIcon(new ImageIcon("BlackBrown.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      boardPiece.squares[0][7].add(new JLabel(BlackBrown));
      
      ImageIcon WhiteOrange = new ImageIcon(new ImageIcon("WhiteOrange.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      boardPiece.squares[7][0].add(new JLabel(WhiteOrange));
      
      ImageIcon WhiteBlue = new ImageIcon(new ImageIcon("WhiteBlue.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      boardPiece.squares[7][6].add(new JLabel(WhiteBlue));
      
      ImageIcon WhiteLightBlue = new ImageIcon(new ImageIcon("WhiteLightBlue.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      boardPiece.squares[7][5].add(new JLabel(WhiteLightBlue));
      
      ImageIcon WhitePink = new ImageIcon(new ImageIcon("WhitePink.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      boardPiece.squares[7][4].add(new JLabel(WhitePink));
      
      ImageIcon WhiteYellow = new ImageIcon(new ImageIcon("WhiteYellow.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      boardPiece.squares[7][3].add(new JLabel(WhiteYellow));
      
      ImageIcon WhiteRed = new ImageIcon(new ImageIcon("WhiteRed.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      boardPiece.squares[7][2].add(new JLabel(WhiteRed));
      
      ImageIcon WhiteGreen = new ImageIcon(new ImageIcon("WhiteGreen.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      boardPiece.squares[7][1].add(new JLabel(WhiteGreen));
      
      ImageIcon WhiteBrown = new ImageIcon(new ImageIcon("WhiteBrown.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      boardPiece.squares[7][7].add(new JLabel(WhiteBrown));
   
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
