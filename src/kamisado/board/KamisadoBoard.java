import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class KamisadoBoard extends JPanel{
	private static final int BOARD_SIZE = 8;
    private static final int SQUARES = 64;

    private Square[][] board;
    private Pieces pieces;

    public KamisadoBoard() {
        this.board = initalizeBoard(BOARD_SIZE, SQUARES);
        pieces = new Pieces();        
    }

    private Square[][] initalizeBoard(int boardWidth, int squareWidth) {
        Square[][] board = new Square[boardWidth][boardWidth];

        int x = 0;
        int y = 0;
 
        for (int i = 0; i < boardWidth; i++) {
        	
            for (int j = 0; j < boardWidth; j++) {
                Square square = new Square();   
                square.setColor(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
                square.setCoordinate(new Point(i, j));
                square.setDrawingRectangle(new Rectangle(x, y, squareWidth,
                        squareWidth));

                board[i][j] = square;

                x += squareWidth;
            }
            x = 0;
            y += squareWidth;
        }

        return board;
    }

    

    public Dimension getPreferredSize() {
        int width = SQUARES * 8 + 1;
        return new Dimension(width, width);
    }

    public Square[][] getBoard() {
        return board;
    }

    public int getSquareWidth() {
        return SQUARES;
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Square[][] allPieces = this.getBoard();
        Random rand = new Random();

        for (int row = 0; row < allPieces.length; row++) {
            for (int column = 0; column < allPieces[row].length; column++) {
                Square square = allPieces[row][column];
                Rectangle drawingRectangle = square.getDrawingRectangle();
                g.setColor(square.getColor());
                g.fillRect(drawingRectangle.x, drawingRectangle.y,
                        drawingRectangle.width, drawingRectangle.height);
            }
        }

        List<Piece> drawPieces = pieces.getPieces();

        for (Piece box : drawPieces) {
            Point coordinate = box.getCoordinate();
            Rectangle drawingRectangle = allPieces[coordinate.x][coordinate.y]
                    .getDrawingRectangle();

            int x = drawingRectangle.x + drawingRectangle.width / 2;
            int y = drawingRectangle.y + drawingRectangle.height / 2;
            int radius = this.getSquareWidth() * 2 / 6;

            g.setColor(box.getColor());
            g.fillOval(x - radius, y - radius, radius + radius, radius
                    + radius);
        }
    }
    
public static void main(String[] args) {
		
		JFrame frame = new JFrame();
        
        frame = new JFrame("Kamisado");
        frame.setSize(500, 500);
		
		KamisadoBoard game = new KamisadoBoard();
		frame.add(game);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
	}



}
