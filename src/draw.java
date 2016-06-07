import javax.swing.*;
import java.awt.*;
public class draw extends JPanel
{
   private static int x,y;
    public void drawing(int xx, int yy)
    {
       x = xx;
       y = yy;
       repaint();
    }
   public void paintComponent(Graphics g)
    {
       super.paintComponent(g);
       g.setColor(Color.red);
       g.fillOval(x, y, 20, 20);
    }
}
