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
    private static final Color PURPLE = new Color(127, 0, 255);
    private static final Color BROWN = new Color(102, 51, 0);
    private static final Color PINK = new Color(255, 153, 204);
    
    private static final Color[][] colors = {{ Color.ORANGE, Color.BLUE, PURPLE, PINK,Color.YELLOW,Color.RED,Color.GREEN,BROWN},
    		{ Color.RED,Color.ORANGE,PINK,Color.GREEN,Color.BLUE,Color.YELLOW,BROWN,PURPLE },
    		{ Color.GREEN,PINK,Color.ORANGE,Color.RED,PURPLE,BROWN,Color.YELLOW,Color.BLUE },
    		{ PINK,PURPLE,Color.BLUE,Color.ORANGE,BROWN,Color.GREEN,Color.RED,Color.YELLOW },
    		{ Color.YELLOW,Color.RED,Color.GREEN,BROWN,Color.ORANGE,Color.BLUE,PURPLE,PINK },
    		{ Color.BLUE,Color.YELLOW,BROWN,PURPLE,Color.RED,Color.ORANGE,PINK,Color.GREEN },
    		{ PURPLE,BROWN,Color.YELLOW,Color.BLUE,Color.GREEN,PINK,Color.ORANGE,Color.RED },
    		{ BROWN,Color.GREEN,Color.RED,Color.YELLOW,PINK,PURPLE,Color.BLUE,Color.ORANGE } };

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
        	// white pieces
        	Rectangle drawingRectangleForWhite = allPieces[0][i].getDrawingRectangle();
        	int white_x = drawingRectangleForWhite.x + drawingRectangleForWhite.width / 2;
            int white_y = drawingRectangleForWhite.y + drawingRectangleForWhite.height / 2;
            int radiusForWhite = this.getSquareWidth() * 2 / 4;
            int radiusInnerCircle = radiusForWhite - 12;          
            g.setColor(whitePieces.get(i).getColor());
            g.fillOval(white_x - radiusForWhite, white_y - radiusForWhite, radiusForWhite + radiusForWhite, radiusForWhite
                    + radiusForWhite);              
            g.setColor(colors[0][i]);           
            g.fillOval(white_x - radiusInnerCircle, white_y - radiusInnerCircle, radiusInnerCircle + radiusInnerCircle, radiusInnerCircle
                    + radiusInnerCircle);  
        	
            // black pieces
        	Rectangle drawingRectangleForBlack = allPieces[7][i].getDrawingRectangle();
            int black_x = drawingRectangleForBlack.x + drawingRectangleForBlack.width / 2;
             int black_y = drawingRectangleForBlack.y + drawingRectangleForBlack.height / 2;
             int radiusForBlack = this.getSquareWidth() * 2 / 4;
             int radiusInnerBlkCircle = radiusForBlack - 12;
             
             g.setColor(blackPieces.get(i).getColor());
             g.fillOval(black_x - radiusForBlack, black_y - radiusForBlack, radiusForBlack + radiusForBlack, radiusForBlack
                     + radiusForBlack);                
             g.setColor(colors[7][i]);
             g.fillOval(black_x - radiusInnerBlkCircle, black_y - radiusInnerBlkCircle, radiusInnerBlkCircle + radiusInnerBlkCircle, radiusInnerBlkCircle
                     + radiusInnerBlkCircle);              
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
    frame.setSize(600, 600);
    frame.setLocationRelativeTo(null);
	
	KamisadoBoard game = new KamisadoBoard();
	frame.add(game);

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setVisible(true);
     frame.setResizable(true);
    }
}



}