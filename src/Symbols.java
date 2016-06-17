import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Symbols {

	private static final ImageIcon symbolForOrange = new ImageIcon(new ImageIcon("Symbols/Symbol1.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	private static final ImageIcon symbolForRed = new ImageIcon(new ImageIcon("Symbols/Symbol2.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	private static final ImageIcon symbolForGreen = new ImageIcon(new ImageIcon("Symbols/Symbol3.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	private static final ImageIcon symbolForPink = new ImageIcon(new ImageIcon("Symbols/Symbol4.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	private static final ImageIcon symbolForYellow = new ImageIcon(new ImageIcon("Symbols/Symbol5.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	private static final ImageIcon symbolForBlue = new ImageIcon(new ImageIcon("Symbols/Symbol6.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	private static final ImageIcon symbolForLightBlue = new ImageIcon(new ImageIcon("Symbols/Symbol7.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	private static final ImageIcon symbolForBrwon = new ImageIcon(new ImageIcon("Symbols/Symbol8.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

	public static final ImageIcon[][] squareSymbols = new ImageIcon [][] {		   
		   { symbolForOrange, symbolForBlue, symbolForLightBlue, symbolForPink, symbolForYellow, symbolForRed, symbolForGreen, symbolForBrwon}, 
		   { symbolForRed, symbolForOrange, symbolForPink, symbolForGreen, symbolForBlue, symbolForYellow, symbolForBrwon, symbolForLightBlue}, 
		   { symbolForGreen, symbolForPink, symbolForOrange, symbolForRed, symbolForLightBlue, symbolForBrwon, symbolForYellow, symbolForBlue}, 
		   { symbolForPink, symbolForLightBlue, symbolForBlue, symbolForOrange, symbolForBrwon, symbolForGreen, symbolForRed, symbolForYellow }, 
		   { symbolForYellow, symbolForRed, symbolForGreen, symbolForBrwon, symbolForOrange, symbolForBlue, symbolForLightBlue, symbolForPink }, 
		   {symbolForBlue, symbolForYellow, symbolForBrwon, symbolForLightBlue, symbolForRed, symbolForOrange, symbolForPink, symbolForGreen }, 
		   { symbolForLightBlue, symbolForBrwon, symbolForYellow, symbolForBlue, symbolForGreen, symbolForPink, symbolForOrange, symbolForRed },
		   { symbolForBrwon, symbolForGreen, symbolForRed, symbolForYellow, symbolForPink, symbolForLightBlue, symbolForBlue, symbolForOrange }
		   };
		   
		   public static final JLabel[] whitePiecesSymbols = new JLabel[] { 
				   new JLabel(null,new ImageIcon(new ImageIcon("Images/Symbol Pieces/Symbol1white.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
			       new JLabel(null,new ImageIcon(new ImageIcon("Images/Symbol Pieces/Symbol6white.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
				   new JLabel(null,new ImageIcon(new ImageIcon("Images/Symbol Pieces/Symbol7white.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
				   new JLabel(null,new ImageIcon(new ImageIcon("Images/Symbol Pieces/Symbol4white.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
				   new JLabel(null,new ImageIcon(new ImageIcon("Images/Symbol Pieces/Symbol5white.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
				   new JLabel(null,new ImageIcon(new ImageIcon("Images/Symbol Pieces/Symbol2white.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
				   new JLabel(null,new ImageIcon(new ImageIcon("Images/Symbol Pieces/Symbol3white.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
				   new JLabel(null,new ImageIcon(new ImageIcon("Images/Symbol Pieces/Symbol8white.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER)
				   };
		   
		   public static final JLabel[] blackPieceSymbols = new JLabel[] {
				   new JLabel(null,new ImageIcon(new ImageIcon("Images/Symbol Pieces/Symbol8black.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
					new JLabel(null,new ImageIcon(new ImageIcon("Images/Symbol Pieces/Symbol3black.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
					new JLabel(null,new ImageIcon(new ImageIcon("Images/Symbol Pieces/Symbol2black.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
					new JLabel(null,new ImageIcon(new ImageIcon("Images/Symbol Pieces/Symbol5black.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
					new JLabel(null,new ImageIcon(new ImageIcon("Images/Symbol Pieces/Symbol4black.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
					new JLabel(null,new ImageIcon(new ImageIcon("Images/Symbol Pieces/Symbol7black.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
					new JLabel(null,new ImageIcon(new ImageIcon("Images/Symbol Pieces/Symbol6black.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
					new JLabel(null,new ImageIcon(new ImageIcon("Images/Symbol Pieces/Symbol1black.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER)
					};	   
		    
		  	  	
}

