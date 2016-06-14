import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BoardPieces {
	public static final JLabel[] whitePieces = new JLabel[] {
			new JLabel(null,new ImageIcon(new ImageIcon("Pieces/WhiteBrown.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
			new JLabel(null,new ImageIcon(new ImageIcon("Pieces/WhiteLightBlue.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
			new JLabel(null,new ImageIcon(new ImageIcon("Pieces/WhiteBlue.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
			new JLabel(null,new ImageIcon(new ImageIcon("Pieces/WhiteYellow.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),			
			new JLabel(null,new ImageIcon(new ImageIcon("Pieces/WhitePink.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
			new JLabel(null,new ImageIcon(new ImageIcon("Pieces/WhiteGreen.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
			new JLabel(null,new ImageIcon(new ImageIcon("Pieces/WhiteRed.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
			new JLabel(null,new ImageIcon(new ImageIcon("Pieces/WhiteOrange.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
	} ;
	
	public static final JLabel[] blackPieces = new JLabel[] {
			new JLabel(null,new ImageIcon(new ImageIcon("Pieces/BlackOrange.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
			new JLabel(null,new ImageIcon(new ImageIcon("Pieces/BlackRed.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
			new JLabel(null,new ImageIcon(new ImageIcon("Pieces/BlackGreen.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
			new JLabel(null,new ImageIcon(new ImageIcon("Pieces/BlackPink.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),			
			new JLabel(null,new ImageIcon(new ImageIcon("Pieces/BlackYellow.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
			new JLabel(null,new ImageIcon(new ImageIcon("Pieces/BlackBlue.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
			new JLabel(null,new ImageIcon(new ImageIcon("Pieces/BlackLightBlue.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
			new JLabel(null,new ImageIcon(new ImageIcon("Pieces/BlackBrown.png").getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER),
	} ;
	
}
