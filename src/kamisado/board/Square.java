import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * 
 * @author chris
 * Illustrating some methods for a board square
 * Questions:  How to represent x and y ( for instance
 * X 1..8 and Y a..h )
 */

public class Square {
	private java.awt.Color color;

    private Point coordinate;

    private Rectangle drawingRectangle;

    public Point getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    public Rectangle getDrawingRectangle() {
        return drawingRectangle;
    }

    public void setDrawingRectangle(Rectangle drawingRectangle) {
        this.drawingRectangle = drawingRectangle;
    }

    public java.awt.Color getColor() {
        return color;
    }

	public void setColor(Color green) {
		// TODO Auto-generated method stub
		this.color = green;
		
	}
}
