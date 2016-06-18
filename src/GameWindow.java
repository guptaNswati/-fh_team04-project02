import kamisado.board.*;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class GameWindow implements MouseListener
{	
	private JFrame frame;
	private JPanel panel;
	private KBoard board;
	private BoardImpl model;
	private Piece p;
	private boolean gameStarted, gameOver, singlePlayer, blockedByComputer, colorBlind;
	public boolean isSinglePlayer() {
		return singlePlayer;
	}

	public void setSinglePlayer(boolean singlePlayer) {
		this.singlePlayer = singlePlayer;
	}

	private static final JButton singlePlayerButton = new JButton("singlePlayer");


	public GameWindow()
	{
		frame = new JFrame("Kamisado");
		panel = new JPanel();
		board = new KBoard();
		model = new BoardImpl();
		gameStarted = false;
		gameOver = false;
		singlePlayer = false;
		blockedByComputer = false;
		colorBlind = false;
		//singlePlayerButton.addActionListener(new SinglePlayer());
		//panel.add(singlePlayerButton);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		for (int x=0; x < 8; x++)
		{	 
			JPanel rowPanel = new JPanel();
			rowPanel.setLayout(new BoxLayout(rowPanel, BoxLayout.X_AXIS));
			for (int y = 0; y < 8; y++)
			{
				PanelSquare ps = board.panelSquares[x][y];
				ps.setPreferredSize(new Dimension(50, 50));
				ps.setSize(new Dimension(50, 50));
				rowPanel.add(ps);
				ps.addMouseListener(this);
			}
			panel.add(rowPanel);		      
		}  		  
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);	     
	}

	public void activateColorBlind()
	{
		setActivateColorBlind(true);

		for(int i = 0; i < 8; i++)
		{
			board.panelSquares[0][i].setLabel(Symbols.whitePiecesSymbols[i]);			 
			board.panelSquares[7][i].setLabel(Symbols.blackPieceSymbols[i]);			
		}
		for(int k = 1; k < 7; k++)
		{
			for(int j = 0; j < 8; j++)
			{
				board.panelSquares[k][j].setLabel(new JLabel(null,Symbols.squareSymbols[k][j], JLabel.CENTER));			 
			}
		}
	}

	private void setActivateColorBlind(boolean b) {
		// TODO Auto-generated method stub
		colorBlind = b;
	}

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new GameWindow();
			}
		});
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int x,y;
		PanelSquare clicked = (PanelSquare)e.getSource();
		List <Square> allowable;
		x = clicked.getXX();
		y = clicked.getYY();
		Square s = new Square (y,x);
		Player nextPlayer;
		Color c;
		PanelSquare allowablePanel;
		Square from;
		PanelSquare fromPS;
		System.out.println(s);
		JLabel movedPiece;

		if (!gameStarted){
			if (x == 0 || x == 7){
				p = model.getPieceOnSquare(s);
				System.out.println(p);
				allowable = model.getAllowableMoves(p);

				
				if (!colorBlind){
					for ( Square as: allowable){
						allowablePanel = board.panelSquares[as.getY()][as.getX()];
						JLabel highlight = new JLabel(null,new ImageIcon(new ImageIcon("Pieces/Allowable.png").getImage().
								getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER);
						allowablePanel.setLabel(highlight);
						//allowablePanel.repaint();
					}
				}
				//System.out.println(p);
				gameStarted = true;
			}

			return;
		}

		if (!blockedByComputer){
			
			// debug code
			System.out.println("not blocked by computer");
			//checking that the move is valid and that the game is not over
			if (!model.isValidMove(p, s) || gameOver){	
				System.out.println(model.isValidMove(p, s));
				return;
			}
			System.out.println("game not over ");

			//clearing old possible moves display
			allowable = model.getAllowableMoves(p);

			if (!colorBlind){
				for ( Square as: allowable){
					System.out.println("inside for loop ");
					allowablePanel = board.panelSquares[as.getY()][as.getX()];
					

					allowablePanel.remove(0);
					allowablePanel.repaint();
				}
			}

			from = model.getSquarePieceIsOn(p);
			gameOver = model.move(p, s);

			System.out.println( from );

			fromPS = board.panelSquares[from.getY()][from.getX()];

			movedPiece = fromPS.getLabel();

			fromPS.remove(0);
			fromPS.repaint();

			if(colorBlind)
			{
				fromPS.setLabel(new JLabel(null,Symbols.squareSymbols[fromPS.getXX()][fromPS.getYY()], JLabel.CENTER));			
			}
			clicked.setLabel(movedPiece);

			if (gameOver){
				return;
			}

			//switching p to the next player's piece
			nextPlayer = p.getPlayer() == Player.WHITE?Player.BLACK:Player.WHITE;
			c = model.getSquareColor(s);
			p = new Piece(nextPlayer,c);
		}


		if (!singlePlayer){	
			allowable = model.getAllowableMoves(p);
			//in case of blocked piece, switch p again to the other player
			if (allowable.size() == 0){
				nextPlayer = p.getPlayer() == Player.WHITE?Player.BLACK:Player.WHITE;
				c = model.getSquareColor(model.getSquarePieceIsOn(p));
				p = new Piece(nextPlayer,c);
				allowable = model.getAllowableMoves(p);
			}

			if (!colorBlind){
				for ( Square as: allowable){
					allowablePanel = board.panelSquares[as.getY()][as.getX()];
					JLabel highlight = new JLabel(null,new ImageIcon(new ImageIcon("Pieces/Allowable.png").getImage().
							getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER);
					allowablePanel.setLabel(highlight);
				}
			}
		}

		else{
			allowable = model.getAllowableMoves(p);
			//in case of blocked piece, switch p again to the other player
			if (allowable.size() == 0){
				nextPlayer = p.getPlayer() == Player.WHITE?Player.BLACK:Player.WHITE;
				c = model.getSquareColor(model.getSquarePieceIsOn(p));
				p = new Piece(nextPlayer,c);
				allowable = model.getAllowableMoves(p);

				for ( Square as: allowable){
					allowablePanel = board.panelSquares[as.getY()][as.getX()];
					JLabel highlight = new JLabel(null,new ImageIcon(new ImageIcon("Pieces/Allowable.png").getImage().
							getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER);
					allowablePanel.setLabel(highlight);
				}

				return;
			}

			from = model.getSquarePieceIsOn(p);

			gameOver = model.computerMove(p);

			Square next = model.getSquarePieceIsOn(p);
			fromPS = board.panelSquares[from.getY()][from.getX()];
			movedPiece = fromPS.getLabel();
			fromPS.remove(0);
			fromPS.repaint();
			clicked = board.panelSquares[next.getY()][next.getX()];
			clicked.setLabel(movedPiece);
			clicked.repaint();


			if (!gameOver){

				nextPlayer = p.getPlayer() == Player.WHITE?Player.BLACK:Player.WHITE;
				c = model.getSquareColor(next);
				p = new Piece(nextPlayer,c);
				allowable = model.getAllowableMoves(p);

				if (allowable.size() != 0){
					blockedByComputer = false;
					for ( Square as: allowable){
						allowablePanel = board.panelSquares[as.getY()][as.getX()];
						JLabel highlight = new JLabel(null,new ImageIcon(new ImageIcon("Pieces/Allowable.png").getImage().
								getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER);
						allowablePanel.setLabel(highlight);
					}
				}

				else {
					blockedByComputer = true;
					nextPlayer = p.getPlayer() == Player.WHITE?Player.BLACK:Player.WHITE;
					c = model.getSquareColor(model.getSquarePieceIsOn(p));
					p = new Piece(nextPlayer,c);
					allowable = model.getAllowableMoves(p);

					for ( Square as: allowable){
						allowablePanel = board.panelSquares[as.getY()][as.getX()];
						JLabel highlight = new JLabel(null,new ImageIcon(new ImageIcon("Pieces/Allowable.png").getImage().
								getScaledInstance(45, 45, Image.SCALE_DEFAULT)), JLabel.CENTER);
						allowablePanel.setLabel(highlight);
					}

				}
			}
		}
	}

	private void recursiveFunction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	class SinglePlayer implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!singlePlayer){
				singlePlayer = true;
			}
			else {
				singlePlayer = false;		
			}

		}
	}

}

