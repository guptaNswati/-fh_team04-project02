import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSquare {
	private JPanel panel;
	private JLabel label;

	PanelSquare(java.awt.Color panelColor)
	{
	    setPanel(new JPanel());
		this.panel.setPreferredSize(new Dimension(50, 50));
		this.panel.setBackground(panelColor);	
		label = new JLabel();		
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
		this.panel.add(label);
	}
	
}
