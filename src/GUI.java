import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class GUI extends JPanel
{
 
      

   public static void main(String[] args) {
          JFrame frame = new JFrame();;
          JPanel squares[][] = new JPanel[8][8];
         
         
          frame = new JFrame("Kamisado");
          frame.setSize(500, 500);
          frame.setLayout(new GridLayout(8,8));
          

          squares[0][0] = new JPanel();
          squares[0][0].setBackground(Color.orange);
          frame.add(squares[0][0]);
          
          squares[0][1] = new JPanel();
          squares[0][1].setBackground(Color.blue);
          frame.add(squares[0][1]);
          
          squares[0][2] = new JPanel();
          squares[0][2].setBackground(Color.cyan);
          frame.add(squares[0][2]);
          
          squares[0][3] = new JPanel();
          squares[0][3].setBackground(Color.pink);
          frame.add(squares[0][3]);
          
          squares[0][4] = new JPanel();
          squares[0][4].setBackground(Color.yellow);
          frame.add(squares[0][4]);
          
          squares[0][5] = new JPanel();
          squares[0][5].setBackground(Color.red);
          frame.add(squares[0][5]);
          
          squares[0][6] = new JPanel();
          squares[0][6].setBackground(Color.green);
          frame.add(squares[0][6]);
          
          squares[0][7] = new JPanel();
          squares[0][7].setBackground(Color.black);
          frame.add(squares[0][7]);
          
          squares[1][0] = new JPanel();
          squares[1][0].setBackground(Color.red);
          frame.add(squares[1][0]);
          
          
          squares[1][1] = new JPanel();
          squares[1][1].setBackground(Color.orange);
          frame.add(squares[1][1]);
          
          
          squares[1][2] = new JPanel();
          squares[1][2].setBackground(Color.pink);
          frame.add(squares[1][2]);
          
          
          squares[1][3] = new JPanel();
          squares[1][3].setBackground(Color.green);
          frame.add(squares[1][3]);
          
          
          squares[1][4] = new JPanel();
          squares[1][4].setBackground(Color.blue);
          frame.add(squares[1][4]);
          
          
          squares[1][5] = new JPanel();
          squares[1][5].setBackground(Color.yellow);
          frame.add(squares[1][5]);
          
          
          squares[1][6] = new JPanel();
          squares[1][6].setBackground(Color.black);
          frame.add(squares[1][6]);
          
          
          squares[1][7] = new JPanel();
          squares[1][7].setBackground(Color.cyan);
          frame.add(squares[1][7]);
          
          
          squares[2][0] = new JPanel();
          squares[2][0].setBackground(Color.green);
          frame.add(squares[2][0]);
          
          squares[2][1] = new JPanel();
          squares[2][1].setBackground(Color.pink);
          frame.add(squares[2][1]);
          
          squares[2][2] = new JPanel();
          squares[2][2].setBackground(Color.orange);
          frame.add(squares[2][2]);
          
          squares[2][3] = new JPanel();
          squares[2][3].setBackground(Color.red);
          frame.add(squares[2][3]);
          
          squares[2][4] = new JPanel();
          squares[2][4].setBackground(Color.cyan);
          frame.add(squares[2][4]);
          
          squares[2][5] = new JPanel();
          squares[2][5].setBackground(Color.black);
          frame.add(squares[2][5]);
          
          squares[2][6] = new JPanel();
          squares[2][6].setBackground(Color.yellow);
          frame.add(squares[2][6]);
          
          squares[2][7] = new JPanel();
          squares[2][7].setBackground(Color.blue);
          frame.add(squares[2][7]);
          
          squares[3][0] = new JPanel();
          squares[3][0].setBackground(Color.pink);
          frame.add(squares[3][0]);
          
          squares[3][1] = new JPanel();
          squares[3][1].setBackground(Color.cyan);
          frame.add(squares[3][1]);
          
          squares[3][2] = new JPanel();
          squares[3][2].setBackground(Color.blue);
          frame.add(squares[3][2]);
          
          squares[3][3] = new JPanel();
          squares[3][3].setBackground(Color.orange);
          frame.add(squares[3][3]);
          
          squares[3][4] = new JPanel();
          squares[3][4].setBackground(Color.black);
          frame.add(squares[3][4]);
          
          squares[3][5] = new JPanel();
          squares[3][5].setBackground(Color.green);
          frame.add(squares[3][5]);
          
          squares[3][6] = new JPanel();
          squares[3][6].setBackground(Color.red);
          frame.add(squares[3][6]);
          
          squares[3][7] = new JPanel();
          squares[3][7].setBackground(Color.yellow);
          frame.add(squares[3][7]);
          
          squares[4][0] = new JPanel();
          squares[4][0].setBackground(Color.yellow);
          frame.add(squares[4][0]);
          
          squares[4][1] = new JPanel();
          squares[4][1].setBackground(Color.red);
          frame.add(squares[4][1]);
          
          squares[4][2] = new JPanel();
          squares[4][2].setBackground(Color.green);
          frame.add(squares[4][2]);
          
          squares[4][3] = new JPanel();
          squares[4][3].setBackground(Color.black);
          frame.add(squares[4][3]);
          
          squares[4][4] = new JPanel();
          squares[4][4].setBackground(Color.orange);
          frame.add(squares[4][4]);
          
          squares[4][5] = new JPanel();
          squares[4][5].setBackground(Color.blue);
          frame.add(squares[4][5]);
          
          squares[4][6] = new JPanel();
          squares[4][6].setBackground(Color.cyan);
          frame.add(squares[4][6]);
          
          squares[4][7] = new JPanel();
          squares[4][7].setBackground(Color.pink);
          frame.add(squares[4][7]);
          
          squares[5][0] = new JPanel();
          squares[5][0].setBackground(Color.blue);
          frame.add(squares[5][0]);
          
          squares[5][1] = new JPanel();
          squares[5][1].setBackground(Color.yellow);
          frame.add(squares[5][1]);
          
          squares[5][2] = new JPanel();
          squares[5][2].setBackground(Color.black);
          frame.add(squares[5][2]);
          
          squares[5][3] = new JPanel();
          squares[5][3].setBackground(Color.cyan);
          frame.add(squares[5][3]);
          
          squares[5][4] = new JPanel();
          squares[5][4].setBackground(Color.red);
          frame.add(squares[5][4]);
          
          squares[5][5] = new JPanel();
          squares[5][5].setBackground(Color.orange);
          frame.add(squares[5][5]);
          
          squares[5][6] = new JPanel();
          squares[5][6].setBackground(Color.pink);
          frame.add(squares[5][6]);
          
          squares[5][7] = new JPanel();
          squares[5][7].setBackground(Color.green);
          frame.add(squares[5][7]);
          
          squares[6][0] = new JPanel();
          squares[6][0].setBackground(Color.cyan);
          frame.add(squares[6][0]);
          
          squares[6][1] = new JPanel();
          squares[6][1].setBackground(Color.black);
          frame.add(squares[6][1]);
          
          squares[6][2] = new JPanel();
          squares[6][2].setBackground(Color.yellow);
          frame.add(squares[6][2]);
          
          squares[6][3] = new JPanel();
          squares[6][3].setBackground(Color.blue);
          frame.add(squares[6][3]);
          
          squares[6][4] = new JPanel();
          squares[6][4].setBackground(Color.green);
          frame.add(squares[6][4]);
          
          squares[6][5] = new JPanel();
          squares[6][5].setBackground(Color.pink);
          frame.add(squares[6][5]);
          
          squares[6][6] = new JPanel();
          squares[6][6].setBackground(Color.orange);
          frame.add(squares[6][6]);
          
          squares[6][7] = new JPanel();
          squares[6][7].setBackground(Color.red);
          frame.add(squares[6][7]);
          
          squares[7][0] = new JPanel();
          squares[7][0].setBackground(Color.black);
          frame.add(squares[7][0]);
          
          squares[7][1] = new JPanel();
          squares[7][1].setBackground(Color.green);
          frame.add(squares[7][1]);
          
          squares[7][2] = new JPanel();
          squares[7][2].setBackground(Color.red);
          frame.add(squares[7][2]);
          
          squares[7][3] = new JPanel();
          squares[7][3].setBackground(Color.yellow);
          frame.add(squares[7][3]);
          
          squares[7][4] = new JPanel();
          squares[7][4].setBackground(Color.pink);
          frame.add(squares[7][4]);
          
          squares[7][5] = new JPanel();
          squares[7][5].setBackground(Color.cyan);
          frame.add(squares[7][5]);
          
          squares[7][6] = new JPanel();
          squares[7][6].setBackground(Color.blue);
          frame.add(squares[7][6]);
          
          squares[7][7] = new JPanel();
          squares[7][7].setBackground(Color.orange);
          frame.add(squares[7][7]);
          
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setVisible(true);
      }  
   
  
   
}