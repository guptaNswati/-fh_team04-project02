import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Symbols {
	
	private static final ImageIcon symbolForOrange = new ImageIcon(new ImageIcon("Images/Symbol1.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	private static final ImageIcon symbolForRed = new ImageIcon(new ImageIcon("Images/Symbol2.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	private static final ImageIcon symbolForGreen= new ImageIcon(new ImageIcon("Images/Symbol3.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	private static final ImageIcon symbolForPink= new ImageIcon(new ImageIcon("Images/Symbol4.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	private static final ImageIcon symbolForYellow = new ImageIcon(new ImageIcon("Images/Symbol5.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	private static final ImageIcon symbolForBlue = new ImageIcon(new ImageIcon("Images/Symbol6.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	private static final ImageIcon symbolForLightBlue = new ImageIcon(new ImageIcon("Images/Symbol7.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	private static final ImageIcon symbolForBrwon = new ImageIcon(new ImageIcon("Images/Symbol8.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

	public static final ImageIcon[][] symbols = new ImageIcon[][] {		   
		   { symbolForOrange, symbolForBlue, symbolForLightBlue, symbolForPink, symbolForYellow, symbolForRed, symbolForGreen, symbolForBrwon}, 
		   { symbolForRed, symbolForOrange, symbolForPink, symbolForGreen, symbolForBlue, symbolForYellow, symbolForBrwon, symbolForLightBlue}, 
		   { symbolForGreen, symbolForPink, symbolForOrange, symbolForRed, symbolForLightBlue, symbolForBrwon, symbolForYellow, symbolForBlue}, 
		   { symbolForPink, symbolForLightBlue, symbolForBlue, symbolForOrange, symbolForBrwon, symbolForGreen, symbolForRed, symbolForYellow }, 
		   { symbolForYellow, symbolForRed, symbolForGreen, symbolForBrwon, symbolForOrange, symbolForBlue, symbolForLightBlue, symbolForPink }, 
		   {symbolForBlue, symbolForYellow, symbolForBrwon, symbolForLightBlue, symbolForRed, symbolForOrange, symbolForPink, symbolForGreen }, 
		   { symbolForLightBlue, symbolForBrwon, symbolForYellow, symbolForBlue, symbolForGreen, symbolForPink, symbolForOrange, symbolForRed },
		   { symbolForBrwon, symbolForGreen, symbolForRed, symbolForYellow, symbolForPink, symbolForLightBlue, symbolForBlue, symbolForOrange }
		   };
}
