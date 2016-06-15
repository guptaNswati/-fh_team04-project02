import java.awt.Dimension;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class PanelSquare extends JPanel{

	//private JLabel label;
	private int xx,yy;

	PanelSquare(java.awt.Color panelColor, int x, int y)
	{
		this.setPreferredSize(new Dimension(50, 50));
		this.setSize(new Dimension(50, 50));
		this.setBackground(panelColor);	
//		label = new JLabel();
//		label.setPreferredSize(new Dimension(50, 50));
//		label.setSize(new Dimension(50, 50));
//		this.add(label);
		this.setXX(x);
		this.setYY(y);
		
	}
	
	public JLabel getLabel() {
		return (JLabel) this.getComponent(0);
	}
	public void setLabel(JLabel label) {
		if ( this.getComponentCount()!=0) 
			{ this.remove(0);}
		this.add(label);
		this.revalidate();
		this.repaint();
	}
	public int getXX() {
		return xx;
	}
	public void setXX(int xx) {
		this.xx = xx;
	}
	public int getYY() {
		return yy;
	}
	public void setYY(int yy) {
		this.yy = yy;
	}
	
}
