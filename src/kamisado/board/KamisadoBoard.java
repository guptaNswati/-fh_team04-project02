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
      JLabel LableBlackOrange = new JLabel(null, BlackOrange, JLabel.CENTER);
      boardPiece.squares[0][1].add(LableBlackOrange);
      
      ImageIcon BlackBlue = new ImageIcon(new ImageIcon("BlackBlue.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      JLabel LableBlackBlue = new JLabel(null, BlackBlue, JLabel.CENTER);
      boardPiece.squares[0][2].add(LableBlackBlue);
      
      ImageIcon BlackLightBlue = new ImageIcon(new ImageIcon("BlackLightBlue.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      JLabel LableBlackLightBlue = new JLabel(null, BlackLightBlue, JLabel.CENTER);
      boardPiece.squares[0][3].add(LableBlackLightBlue);
      
      
      ImageIcon BlackPink = new ImageIcon(new ImageIcon("BlackPink.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      JLabel LableBlackPink = new JLabel(null, BlackPink, JLabel.CENTER);
      boardPiece.squares[0][4].add(LableBlackPink);
      
      ImageIcon BlackYellow = new ImageIcon(new ImageIcon("BlackYellow.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      JLabel LableBlackYellow = new JLabel(null, BlackYellow, JLabel.CENTER);
      boardPiece.squares[0][5].add(LableBlackYellow);
      
      ImageIcon BlackRed = new ImageIcon(new ImageIcon("BlackRed.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      JLabel LableBlackRed = new JLabel(null, BlackRed, JLabel.CENTER);
      boardPiece.squares[0][6].add(LableBlackRed);
      
      ImageIcon BlackGreen = new ImageIcon(new ImageIcon("BlackGreen.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      JLabel LableBlackGreen = new JLabel(null, BlackGreen, JLabel.CENTER);
      boardPiece.squares[0][7].add(LableBlackGreen);
      
      ImageIcon BlackBrown = new ImageIcon(new ImageIcon("BlackBrown.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      JLabel LableBlackBrown  = new JLabel(null, BlackBrown , JLabel.CENTER);
      boardPiece.squares[7][0].add(LableBlackBrown);
      
      ImageIcon WhiteOrange = new ImageIcon(new ImageIcon("WhiteOrange.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      JLabel LableWhiteOrange  = new JLabel(null, WhiteOrange , JLabel.CENTER);
      boardPiece.squares[7][7].add(LableWhiteOrange);
      
      ImageIcon WhiteBlue = new ImageIcon(new ImageIcon("WhiteBlue.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      JLabel LableWhiteBlue  = new JLabel(null,WhiteBlue , JLabel.CENTER);
      boardPiece.squares[7][6].add(LableWhiteBlue);
      
      ImageIcon WhiteLightBlue = new ImageIcon(new ImageIcon("WhiteLightBlue.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      JLabel LableWhiteLightBlue  = new JLabel(null,WhiteLightBlue, JLabel.CENTER);
      boardPiece.squares[7][5].add(LableWhiteLightBlue);
      
      ImageIcon WhitePink = new ImageIcon(new ImageIcon("WhitePink.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      JLabel LableWhitePink  = new JLabel(null,WhitePink, JLabel.CENTER);
      boardPiece.squares[7][4].add(LableWhitePink);
            
      ImageIcon WhiteYellow = new ImageIcon(new ImageIcon("WhiteYellow.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      JLabel LableWhiteYellow  = new JLabel(null,WhiteYellow, JLabel.CENTER);
      boardPiece.squares[7][3].add(LableWhiteYellow);
      
      ImageIcon WhiteRed = new ImageIcon(new ImageIcon("WhiteRed.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      JLabel LableWhiteRed = new JLabel(null,WhiteRed, JLabel.CENTER);
      boardPiece.squares[7][2].add(LableWhiteRed);
      
      ImageIcon WhiteGreen = new ImageIcon(new ImageIcon("WhiteGreen.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      JLabel LableWhiteGreen = new JLabel(null,WhiteGreen, JLabel.CENTER);
      boardPiece.squares[7][1].add(LableWhiteGreen);
      
      ImageIcon WhiteBrown = new ImageIcon(new ImageIcon("WhiteBrown.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
      JLabel LableWhiteBrown = new JLabel(null,WhiteBrown, JLabel.CENTER);
      boardPiece.squares[0][0].add(LableWhiteBrown);
   
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
