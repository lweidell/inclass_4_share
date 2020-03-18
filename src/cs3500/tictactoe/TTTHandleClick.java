package cs3500.tictactoe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A class that implements MouseListener. Overrides mouseClicked method to handle user's mouse
 * action and register the inputs to further pass them to the controller.
 * Has 1 field which is the controller.
 */
public class TTTHandleClick extends MouseAdapter {
  private TicTacToeController controller;

  /**
   * A public constructor for the TTTHandleClick class that takes in an instance of the controller.
   * @param controller
   */
  public TTTHandleClick(TicTacToeController controller) {
    this.controller = controller;
  }

  /**
   * An overridden mouseClicked method from MouseAdapter.
   * Gets a mouse event, extract Y and X, passes it to the controller.
   * @param e a Mouse Event.
   */
  @Override
  public void mouseClicked(MouseEvent e) {
    int row = (e.getY() - TTTPanel.spacing - 25) / TTTPanel.dimension;
    int col = (e.getX() - TTTPanel.spacing - 6) / TTTPanel.dimension;
    controller.handleCellClick(row, col);
  }
}
