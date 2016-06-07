import javax.swing.*;
import java.awt.event.*;

public class mouse
{
private static int x,y;
private static draw object = new draw();

public static void main(String[] args)
{
   JFrame frame = new JFrame("Mouse");
   frame.setVisible(true);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setSize(400,400);
   frame.add(object);
   object.addMouseListener(new AL());
   }


static class AL extends MouseAdapter
{
   public void mouseClicked (MouseEvent e)
   {
      x = e.getX();
      y = e.getY();
      object.drawing(x,y);
   }
}
}