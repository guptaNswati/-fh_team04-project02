import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BoardPieces {
	public JLabel[] blackPieces;
    public JLabel[] whitePieces;
    
    BoardPieces()
    {
    	blackPieces = new JLabel [8];
    	whitePieces = new JLabel [8];
    	
    	ImageIcon BlackOrange = new ImageIcon(new ImageIcon("Pieces/BlackOrange.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
    	blackPieces[0] = new JLabel(null, BlackOrange, JLabel.CENTER);

    	ImageIcon BlackRed = new ImageIcon(new ImageIcon("Pieces/BlackRed.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
    	blackPieces[1] = new JLabel(null, BlackRed, JLabel.CENTER);

    	ImageIcon BlackGreen = new ImageIcon(new ImageIcon("Pieces/BlackGreen.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
    	blackPieces[2] = new JLabel(null, BlackGreen, JLabel.CENTER);

    	ImageIcon BlackPink = new ImageIcon(new ImageIcon("Pieces/BlackPink.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
    	blackPieces[3] = new JLabel(null, BlackPink, JLabel.CENTER);

    	ImageIcon BlackYellow = new ImageIcon(new ImageIcon("Pieces/BlackYellow.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
    	blackPieces[4] = new JLabel(null, BlackYellow, JLabel.CENTER);

    	ImageIcon BlackBlue = new ImageIcon(new ImageIcon("Pieces/BlackBlue.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
    	blackPieces[5] = new JLabel(null, BlackBlue, JLabel.CENTER);

    	ImageIcon BlackLightBlue = new ImageIcon(new ImageIcon("Pieces/BlackLightBlue.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
    	blackPieces[6] = new JLabel(null, BlackLightBlue, JLabel.CENTER);

    	ImageIcon BlackBrown = new ImageIcon(new ImageIcon("Pieces/BlackBrown.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
    	blackPieces[7]  = new JLabel(null, BlackBrown , JLabel.CENTER);
    	
    	ImageIcon WhiteBrown = new ImageIcon(new ImageIcon("Pieces/WhiteBrown.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
    	whitePieces[0] = new JLabel(null,WhiteBrown, JLabel.CENTER);

    	ImageIcon WhiteLightBlue = new ImageIcon(new ImageIcon("Pieces/WhiteLightBlue.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
    	whitePieces[1]  = new JLabel(null,WhiteLightBlue, JLabel.CENTER);

    	ImageIcon WhiteBlue = new ImageIcon(new ImageIcon("Pieces/WhiteBlue.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
    	whitePieces[2]  = new JLabel(null,WhiteBlue , JLabel.CENTER);   		  

    	ImageIcon WhiteYellow = new ImageIcon(new ImageIcon("Pieces/WhiteYellow.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
    	whitePieces[3]  = new JLabel(null,WhiteYellow, JLabel.CENTER);

    	ImageIcon WhitePink = new ImageIcon(new ImageIcon("Pieces/WhitePink.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
    	whitePieces[4]  = new JLabel(null,WhitePink, JLabel.CENTER);

    	ImageIcon WhiteGreen = new ImageIcon(new ImageIcon("Pieces/WhiteGreen.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
    	whitePieces[5] = new JLabel(null,WhiteGreen, JLabel.CENTER);    		    

    	ImageIcon WhiteRed = new ImageIcon(new ImageIcon("Pieces/WhiteRed.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
    	whitePieces[6] = new JLabel(null,WhiteRed, JLabel.CENTER);

    	ImageIcon WhiteOrange = new ImageIcon(new ImageIcon("Pieces/WhiteOrange.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT));
    	whitePieces[7]  = new JLabel(null, WhiteOrange , JLabel.CENTER);
    }

}
