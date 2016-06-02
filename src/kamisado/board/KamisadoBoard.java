import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class KamisadoBoard extends JPanel{
	private static final int BOARD_SIZE = 8;
    private static final int SQUARES = 64;

    private Square[][] board;
    private Pieces pieces;
    private static final Color[][] colors = {{ Color.ORANGE, Color.BLUE, Color.MAGENTA, Color.PINK,Color.YELLOW,Color.RED,Color.GREEN,Color.CYAN},
    		{ Color.RED,Color.ORANGE,Color.PINK,Color.GREEN,Color.BLUE,Color.YELLOW,Color.CYAN,Color.MAGENTA },
    		{ Color.GREEN,Color.PINK,Color.ORANGE,Color.RED,Color.MAGENTA,Color.CYAN,Color.YELLOW,Color.BLUE },
    		{ Color.PINK,Color.MAGENTA,Color.BLUE,Color.ORANGE,Color.CYAN,Color.GREEN,Color.RED,Color.YELLOW },
    		{ Color.YELLOW,Color.RED,Color.GREEN,Color.CYAN,Color.ORANGE,Color.BLUE,Color.MAGENTA,Color.PINK },
    		{ Color.BLUE,Color.YELLOW,Color.CYAN,Color.MAGENTA,Color.RED,Color.ORANGE,Color.PINK,Color.GREEN },
    		{ Color.MAGENTA,Color.CYAN,Color.YELLOW,Color.BLUE,Color.GREEN,Color.PINK,Color.ORANGE,Color.RED },
    		{ Color.CYAN,Color.GREEN,Color.RED,Color.YELLOW,Color.PINK,Color.MAGENTA,Color.BLUE,Color.ORANGE }
            };

    public KamisadoBoard() {
        this.board = initalizeBoard(BOARD_SIZE, SQUARES);
        pieces = new Pieces();        
    }

    private Square[][] initalizeBoard(int boardWidth, int squareWidth) {
        Square[][] board = new Square[boardWidth][boardWidth];

        int x = 0;
        int y = 0;
        Random rand = new Random();
 
        for (int i = 0; i < boardWidth; i++) {
        	
            for (int j = 0; j < boardWidth; j++) {
                Square square = new Square();  
                square.setColor(colors[i][j]);
//                square.setColor(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
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
        
        List<Piece> blackPieces = pieces.getBlackPieces();
        List<Piece> whitePieces  = pieces.getWhitePieces(); 

        for (int row = 0; row < allPieces.length; row++) {
            for (int column = 0; column < allPieces[row].length; column++) {
                Square square = allPieces[row][column];
                Rectangle drawingRectangle = square.getDrawingRectangle();
                g.setColor(square.getColor());
                g.fillRect(drawingRectangle.x, drawingRectangle.y,
                        drawingRectangle.width, drawingRectangle.height);
            }
        }
        
        for(int i = 0; i < 8; i++ )
        {
        	Rectangle drawingRectangleForWhite = allPieces[0][i].getDrawingRectangle();
        	int white_x = drawingRectangleForWhite.x + drawingRectangleForWhite.width / 2;
            int white_y = drawingRectangleForWhite.y + drawingRectangleForWhite.height / 2;
            int radiusForWhite = this.getSquareWidth() * 2 / 6;
            
            g.setColor(whitePieces.get(i).getColor());
            g.fillOval(white_x - radiusForWhite, white_y - radiusForWhite, radiusForWhite + radiusForWhite, radiusForWhite
                    + radiusForWhite);        	
        	
        	Rectangle drawingRectangleForBlack = allPieces[7][i].getDrawingRectangle();
            int black_x = drawingRectangleForBlack.x + drawingRectangleForBlack.width / 2;
             int black_y = drawingRectangleForBlack.y + drawingRectangleForBlack.height / 2;
             int radiusForBlack = this.getSquareWidth() * 2 / 6;
             
             g.setColor(blackPieces.get(i).getColor());
             g.fillOval(black_x - radiusForBlack, black_y - radiusForBlack, radiusForBlack + radiusForBlack, radiusForBlack
                     + radiusForBlack);               
        }
        
        // highlighting valid moves
       List<Square> allowableMoves = new ArrayList<Square>();
        
        // vertical moves
        allowableMoves.add(allPieces[1][0]);
        allowableMoves.add(allPieces[2][0]);
        allowableMoves.add(allPieces[3][0]);
        allowableMoves.add(allPieces[4][0]);
        allowableMoves.add(allPieces[5][0]);
        allowableMoves.add(allPieces[6][0]);
        
        // diagonal moves
        allowableMoves.add(allPieces[1][1]);
        allowableMoves.add(allPieces[2][2]);
        allowableMoves.add(allPieces[3][3]);
        allowableMoves.add(allPieces[4][4]);
        allowableMoves.add(allPieces[5][5]);
        allowableMoves.add(allPieces[6][6]); 
        
        for(int j = 0; j < allowableMoves.size(); j++)
        {
        	Rectangle drawingRectangle = allowableMoves.get(j).getDrawingRectangle();
            g.setColor(Color.WHITE);
            g.drawRect(drawingRectangle.x + 2, drawingRectangle.y + 2 ,
                    drawingRectangle.width - 5, drawingRectangle.height - 5);        	
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
