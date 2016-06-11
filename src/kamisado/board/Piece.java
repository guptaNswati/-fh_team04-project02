
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

package kamisado.board;

public class Piece {
	
	private Color color;
	private Player player;
	
	public Piece( Player p, Color c ) {
		
		setColor(c);
		setPlayer(p);
		
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public boolean equals( Object o ) {
		
		if ( !( o instanceof Piece ) ) return false;
		
		Piece p = (Piece)o;
		return ( (p.getPlayer()==getPlayer()) && ( p.getColor()==getColor()) );		
		
	}
	public String toString() {
		return "("+player.name()+","+color.name()+")";
	}

}

