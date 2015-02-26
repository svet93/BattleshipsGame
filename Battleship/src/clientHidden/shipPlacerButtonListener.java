package clientHidden;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


public class shipPlacerButtonListener implements ActionListener {
	boolean isVertical;
	static int shipsPlaced = 0;
	ArrayList<Coordinates> toBeDisabled;
	GameFacade clientSide;
	
	
	JButton[][] buttons;
	JButton btnStart;
	JLabel lblShip;
	JRadioButton rbVertical;
	
	public shipPlacerButtonListener(JButton[][] buttons, GameFacade clientSide, JButton start, JLabel lblShip, JRadioButton rbVertical) {
		this.buttons = buttons;
		this.clientSide = clientSide;
		this.btnStart = start;
		this.lblShip = lblShip;
		this.rbVertical = rbVertical;
		this.isVertical = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (shipsPlaced < clientSide.getNumberShips()) {
			JButton btn = (JButton) e.getSource();
			int i = (int) btn.getClientProperty("row");
			int j = (int) btn.getClientProperty("column");
			
			if (rbVertical.isSelected() == true)
				isVertical = true;
			else
				isVertical = false;
			
			if (clientSide.setShip(i, j, isVertical, shipsPlaced) == true) {
				toBeDisabled = clientSide.getPlayerFilledSquares();
				for (Coordinates c : toBeDisabled) {
					int x = c.getX();
					int y = c.getY();
					buttons[x][y].setEnabled(false);
					buttons[x][y].setText("S");
				}
				shipsPlaced++;
				if (shipsPlaced < clientSide.getNumberShips())
					lblShip.setText(clientSide.getShipSizeByIndex(shipsPlaced) + " ");
				else {
					lblShip.setText("Play!");
					for (JButton[] btnRow : buttons) {
						for (JButton bton : btnRow) {
							bton.setEnabled(false);
						}
					}
					btnStart.setEnabled(true);
				}
			}
		}

	}
}
