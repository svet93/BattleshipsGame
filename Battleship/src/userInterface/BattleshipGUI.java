package userInterface;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

import clientHidden.Coordinates;
import clientHidden.GameFacade;
import clientHidden.shipPlacerButtonListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.Font;


public class BattleshipGUI {

	private JFrame frame;
	private int boardSize = 8;
	private int numOfShips = 5;
	private String boardType = "SmallBoard";
	private int shipsPlayerDestroyed = 0;
	private int shipsComputerDestroyed = 0;
	private String moveType = "EasyMove";
	private String userWon = "YOU WIN!";
	private String computerWon = "YOU LOSE!";
		
	private GameFacade clientSide = new GameFacade();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleshipGUI window = new BattleshipGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BattleshipGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 585, 326);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel pnlGame = new JPanel(); // This will be the Panel for the gameplay
		frame.getContentPane().add(pnlGame, "name_5913269722303");
		pnlGame.setLayout(new GridLayout(1, 0, 0, 0));
		pnlGame.setVisible(false);

		JPanel pnlMenu = new JPanel(); // Panel which will give game options
		frame.getContentPane().add(pnlMenu, "name_5916310685744");
		pnlMenu.setLayout(null);

		
		// Create a set up for the ships coordinate screen
		JPanel pnlSetShips = new JPanel();
		frame.getContentPane().add(pnlSetShips, "name_5610085190979");
		pnlSetShips.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel pnlSetShipsLeft = new JPanel();
		pnlSetShips.add(pnlSetShipsLeft);
		
		JPanel pnlSetShipsRight = new JPanel();
		pnlSetShips.add(pnlSetShipsRight);
		pnlSetShipsRight.setLayout(null);
		
		JLabel lblPlaceShipOf = new JLabel("Place ship of length:");
		lblPlaceShipOf.setBounds(143, 46, 128, 16);
		pnlSetShipsRight.add(lblPlaceShipOf);
		
		JLabel lblShipLength = new JLabel("4");
		lblShipLength.setBounds(167, 74, 61, 19);
		pnlSetShipsRight.add(lblShipLength);
		lblShipLength.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		
		JRadioButton rdbtnHorizontal = new JRadioButton("Horizontal");
		rdbtnHorizontal.setSelected(true);
		rdbtnHorizontal.setBounds(6, 105, 141, 23);
		pnlSetShipsRight.add(rdbtnHorizontal);
		
		JRadioButton rdbtnVertical = new JRadioButton("Vertical");
		rdbtnVertical.setBounds(6, 140, 141, 23);
		pnlSetShipsRight.add(rdbtnVertical);
		
		ButtonGroup horizontalVert = new ButtonGroup();
		horizontalVert.add(rdbtnVertical);
		horizontalVert.add(rdbtnHorizontal);
		
		
		
		
		
		// Create a set up for the game screen

		JPanel tpLeft = new JPanel();
		JPanel tpRight = new JPanel();
		pnlGame.add(tpLeft);

		JPanel pnlScores = new JPanel();
		pnlGame.add(pnlScores);
		pnlScores.setLayout(null);

		JLabel lblPlayerHits = new JLabel("Player:");
		lblPlayerHits.setBounds(59, 65, 84, 16);
		pnlScores.add(lblPlayerHits);

		JLabel lblUserSunk = new JLabel("");
		lblUserSunk.setBounds(70, 80, 84, 16);
		pnlScores.add(lblUserSunk);

		JLabel lblOpponent = new JLabel("Opponent:");
		lblOpponent.setBounds(59, 143, 84, 16);
		pnlScores.add(lblOpponent);
		
		JLabel lblComputerSunk = new JLabel("");
		lblComputerSunk.setBounds(69, 158, 85, 16);
		pnlScores.add(lblComputerSunk);
		pnlGame.add(tpRight);

		// Buttons to choose the number of ships ---------------
		JLabel lblSquares = new JLabel("# Squares: 48");
		lblSquares.setBounds(17, 215, 100, 16);

		JRadioButton rbtn5 = new JRadioButton("5");
		rbtn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numOfShips = 5;
			}
		});
		rbtn5.setSelected(true);
		rbtn5.setBounds(173, 91, 141, 23);
		pnlMenu.add(rbtn5);

		JRadioButton rbtn7 = new JRadioButton("7");
		rbtn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numOfShips = 7;
			}
		});
		rbtn7.setEnabled(false);
		rbtn7.setBounds(173, 126, 141, 23);
		pnlMenu.add(rbtn7);

		JRadioButton rbtn9 = new JRadioButton("9");
		rbtn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numOfShips = 9;
			}
		});
		rbtn9.setEnabled(false);
		rbtn9.setBounds(173, 161, 141, 23);
		pnlMenu.add(rbtn9);

		JRadioButton rbtn11 = new JRadioButton("11");
		rbtn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numOfShips = 11;
			}
		});
		rbtn11.setEnabled(false);
		rbtn11.setBounds(173, 196, 141, 23);
		pnlMenu.add(rbtn11);

		ButtonGroup numberOfShips = new ButtonGroup();
		numberOfShips.add(rbtn5);
		numberOfShips.add(rbtn7);
		numberOfShips.add(rbtn9);
		numberOfShips.add(rbtn11);
		//------------------------------------------------------------------------------------

		
		// Create the group of buttons for the board size -
		// ------------------------------
		ButtonGroup grpBoardSize = new ButtonGroup();
		JRadioButton rbtnSmall = new JRadioButton("Small");
		rbtnSmall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbtn11.setEnabled(false);
				rbtn9.setEnabled(false);
				rbtn7.setEnabled(false);
				lblSquares.setText("# Squares: 48");
				boardType = "SmallBoard";
				boardSize = 8;
			}
		});
		rbtnSmall.setBounds(17, 91, 66, 23);
		pnlMenu.add(rbtnSmall);
		rbtnSmall.setSelected(true);
		grpBoardSize.add(rbtnSmall);

		JRadioButton rbtnMedium = new JRadioButton("Medium");
		rbtnMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbtn11.setEnabled(false);
				rbtn9.setEnabled(true);
				rbtn7.setEnabled(true);
				lblSquares.setText("# Squares: 80");
				boardType = "MediumBoard";
				boardSize = 10;
			}
		});
		rbtnMedium.setBounds(17, 126, 82, 23);
		pnlMenu.add(rbtnMedium);
		grpBoardSize.add(rbtnMedium);

		JRadioButton rbtnLarge = new JRadioButton("Large");
		rbtnLarge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbtn11.setEnabled(true);
				rbtn9.setEnabled(true);
				rbtn7.setEnabled(true);
				lblSquares.setText("# Squares: 120");
				boardType = "LargeBoard";
				boardSize = 12;
			}
		});
		rbtnLarge.setBounds(17, 161, 66, 23);
		pnlMenu.add(rbtnLarge);
		grpBoardSize.add(rbtnLarge);

		JLabel lblBoardSize = new JLabel("Board Size:");
		lblBoardSize.setBounds(17, 66, 77, 16);
		pnlMenu.add(lblBoardSize);
		// //////////////////////////----------------------////////////////////////////

		JLabel lblShips = new JLabel("Ships:");
		lblShips.setBounds(173, 66, 61, 16);
		pnlMenu.add(lblShips);


		pnlMenu.add(lblSquares);
		
		JPanel pnlFinished = new JPanel();
		frame.getContentPane().add(pnlFinished, "name_50385187431809");
		pnlFinished.setLayout(null);
		pnlFinished.setVisible(false);
		
		JLabel lblMessage = new JLabel("New label");
		lblMessage.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblMessage.setBounds(184, 121, 247, 62);
		pnlFinished.add(lblMessage);
		
		//  The button that brings out the game panel
		JButton btnSet = new JButton("Start");
		btnSet.setBounds(167, 234, 75, 29);
		pnlSetShipsRight.add(btnSet);
		btnSet.setEnabled(false);
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlSetShips.setVisible(false);
				pnlGame.setVisible(true);
				createBoards(boardSize, tpLeft, tpRight, lblUserSunk, lblComputerSunk, lblMessage, pnlFinished, pnlGame);
				for (int i = 0; i < numOfShips; i++) {
					while( !clientSide.setUpComputerShips(i));
				}
			}
		});

		//  Set up the radio buttons for setting the difficulty
		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setBounds(300, 66, 77, 16);
		pnlMenu.add(lblDifficulty);

		JRadioButton rdbtnEasy = new JRadioButton("Easy");
		rdbtnEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveType = "StupidMove";
			}
		});
		rdbtnEasy.setSelected(true);
		rdbtnEasy.setBounds(310, 91, 141, 23);
		pnlMenu.add(rdbtnEasy);

		JRadioButton rdbtnHarder = new JRadioButton("Harder");
		rdbtnHarder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveType = "SmartMove";
			}
		});
		rdbtnHarder.setBounds(310, 126, 141, 23);
		pnlMenu.add(rdbtnHarder);
		pnlMenu.setVisible(true);

		ButtonGroup btnGroupDiff = new ButtonGroup();
		btnGroupDiff.add(rdbtnEasy);
		btnGroupDiff.add(rdbtnHarder);
		//-------------------------------------------------------
		
		//----   Start button on the first panel (pnlMenu) that will hide this panel and show the next (setShips) panel
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlMenu.setVisible(false);
				placeShipBoard(pnlSetShipsLeft, btnSet, lblShipLength, rdbtnVertical);
				pnlSetShips.setVisible(true);
				clientSide.createNewGame(boardType, numOfShips, moveType);
			}
		});
		btnStart.setBounds(288, 232, 117, 29);
		pnlMenu.add(btnStart);
		

		
		
		//--------------------------------------------------------------------
	} //  End of CreateContent method



	

	
	/*
	 * Generates the board for placing of ships
	 * JPanel pnlSetShipsLeft is the panel that holds that board
	 */
	public void placeShipBoard(JPanel pnlSetShipsLeft, JButton btnStart, JLabel lblShip, JRadioButton rbtnVertical) {
		JButton[][] boardButtons = new JButton[boardSize][boardSize - 2];
		ButtonGroup boardGroup = new ButtonGroup();
		pnlSetShipsLeft.setLayout(new GridLayout(boardSize, boardSize-2));
		
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize - 2; j++) {
				boardButtons[i][j] = new JButton();
				boardButtons[i][j].putClientProperty("row", i); // / a way to associate the button with the squares
				boardButtons[i][j].putClientProperty("column", j); // / a way to associate the button with the squares
				boardGroup.add(boardButtons[i][j]);
				pnlSetShipsLeft.add(boardButtons[i][j]);
				boardButtons[i][j].addActionListener(new shipPlacerButtonListener(boardButtons, clientSide, btnStart, lblShip, rbtnVertical));
			}
		}
		pnlSetShipsLeft.setVisible(true);
	}  // end of placeShipBoard method
	
	
	/* 
	 * JButton action listener for the boardButtons
	 */
	class GameBoardButtonListener implements ActionListener {
		JButton[][] buttons;
		JLabel lblUserSunk;
		JLabel lblComputerSunk;
		JLabel lblMessage;
		JPanel pnlWinner;
		JPanel pnlGame;
		
		public GameBoardButtonListener(JButton[][] buttons, JLabel lblUserSunk,
				JLabel lblComputerSunk, JLabel lblMessage, JPanel pnlWinner, JPanel pnlGame) {
			this.buttons = buttons;
			this.lblUserSunk = lblUserSunk;
			this.lblComputerSunk = lblComputerSunk;
			this.lblMessage = lblMessage;
			this.pnlWinner = pnlWinner;
			this.pnlGame = pnlGame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Coordinates playerHit;
			JButton btn = (JButton) e.getSource();
			btn.setEnabled(false);
			int x = (int) btn.getClientProperty("row");
			int y = (int) btn.getClientProperty("column");
			playerHit = clientSide.makePlayerMove(x, y);
			
			if (playerHit != null) {
				btn.setText("H");
				btn.setBackground(new Color(0xFF0000));
				if(clientSide.checkForDestroyed(playerHit)) {
					shipsPlayerDestroyed++;
					lblUserSunk.setText(shipsPlayerDestroyed + "/" + clientSide.getNumberShips() + " Sunk");
					if (shipsPlayerDestroyed == clientSide.getNumberShips()){
						//System.out.println("Player WON!");
						lblMessage.setText(userWon);
						lblMessage.setForeground(new Color(0x00FF00));
						pnlGame.setVisible(false);
						pnlWinner.setVisible(true);
					}
				}
			}
			else {
				btn.setText("M");
				btn.setBackground(new Color(0x0000FF));
			}
			
			Coordinates computerHit;
			computerHit = clientSide.makeComputerMove();
			if (computerHit != null) {
				if(clientSide.checkForComputerDestroyed(computerHit)) {
					shipsComputerDestroyed++;
					lblComputerSunk.setText(shipsComputerDestroyed + "/" + clientSide.getNumberShips() + " Sunk");
					if (shipsComputerDestroyed == clientSide.getNumberShips()){
						//System.out.println("Computer WON!");
						lblMessage.setText(computerWon);
						lblMessage.setForeground(new Color(0xFF0000));
						pnlGame.setVisible(false);
						pnlWinner.setVisible(true);
						
					}
				}
				buttons[computerHit.getX()][computerHit.getY()].setText("H");
				buttons[computerHit.getX()][computerHit.getY()].setBackground(new Color(0xFF0000));
			}
			else
			{
				ArrayList<Coordinates> toBeMarked = clientSide.clickedByComputer();
				
				for (Coordinates c : toBeMarked) {
					buttons[c.getX()][c.getY()].setText("M");
					buttons[c.getX()][c.getY()].setBackground(new Color(0x0000FF));
				}
			}

		}
	}  //  End of GameBoardButtonListener Class

	/*
	 * Creates two 2D arrays of buttons depending on the size of the board, one for the user, and one for computer
	 */
	public void createBoards(int boardSize, JPanel tpLeft, JPanel tpRight, JLabel lblUserSunk, JLabel lblComputerSunk,
			JLabel lblMessage, JPanel pnlFinished, JPanel pnlGame) {
		// 
		ButtonGroup boardGroup = new ButtonGroup();
		JButton[][] boardButtons = new JButton[boardSize][boardSize - 2];

		JButton[][] opponentBoard = new JButton[boardSize][boardSize - 2];

		// Generates the board that you click and try to hit your opponent's
		// ships
		tpLeft.setLayout(new GridLayout(boardSize, boardSize - 2));
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize - 2; j++) {
				boardButtons[i][j] = new JButton();
				boardButtons[i][j].putClientProperty("row", i); // / a way to associate the button with the squares
				boardButtons[i][j].putClientProperty("column", j); // / a way to associate the button with the squares
				boardButtons[i][j].setOpaque(true);
				boardGroup.add(boardButtons[i][j]);
				tpLeft.add(boardButtons[i][j]);
				boardButtons[i][j].addActionListener(new GameBoardButtonListener(
						opponentBoard, lblUserSunk, lblComputerSunk, lblMessage, pnlFinished, pnlGame));
			}
		}

		// Generates your board /// what the opponent is seeing
		ArrayList<Coordinates> ships = clientSide.getPlayerFilledSquares();

		ButtonGroup opponentGroup = new ButtonGroup();
		tpRight.setLayout(new GridLayout(boardSize, boardSize - 2));
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize - 2; j++) {
				opponentBoard[i][j] = new JButton();
				opponentBoard[i][j].setEnabled(false);
				opponentBoard[i][j].setOpaque(true);
				opponentGroup.add(opponentBoard[i][j]);
				tpRight.add(opponentBoard[i][j]);

			}
		}
		for (Coordinates c : ships) {
			opponentBoard[c.getX()][c.getY()].setText("S");
		}

	}  //  End of createBoard method
}  //  End of the BattleshipGUI class