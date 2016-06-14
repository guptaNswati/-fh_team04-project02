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

	public String toString() {
		return "("+player.name()+","+color.name()+")";
	}

}