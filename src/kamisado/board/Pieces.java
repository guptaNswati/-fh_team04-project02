import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

class Pieces {

    private List<Piece> pieces;

    public Pieces() {
        this.pieces = addPieces();
    }

    private List<Piece> addPieces() {
        List<Piece> pieces = new ArrayList<Piece>();

        Piece piece = new Piece();
        piece.setColor(Color.RED);
        piece.setCoordinate(new Point(2, 1));
        pieces.add(piece);

        piece = new Piece();
        piece.setColor(Color.BLACK);
        piece.setCoordinate(new Point(5, 0));
        pieces.add(piece);

        // Add the rest of the red and black pieces here

        return pieces;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void addPiece(Piece piece) {
        this.pieces.add(piece);
    }
}
