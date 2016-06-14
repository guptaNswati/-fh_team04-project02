 import java.awt.Dimension;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class PanelSquare extends JPanel{

	private int xx,yy;

	PanelSquare(java.awt.Color panelColor, int x, int y)
	{
		this.setPreferredSize(new Dimension(50, 50));
		this.setSize(new Dimension(50, 50));
		this.setBackground(panelColor);	
		this.setXX(x);
		this.setYY(y);
		
	}
	
	public void addImageLabel(JLabel imageLabel)
	{
		if(this.getComponentCount() == 0)
		{
			this.add(imageLabel);
			this.revalidate();
			this.repaint();			
		}
		
		else if ( this.getComponentCount() != 0) 
		{ this.setLabel(imageLabel); }		
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
