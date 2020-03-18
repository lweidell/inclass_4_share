package cs3500.tictactoe;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;

/** This the class representation of the Pannel which extends the JPanel.
 * @field dimension Is the integer set for the 
 * @field spacing Is the integer of the space between lines for the board.
 * @field FontSize is the integer size of the font.
 * @field FontType is the string font type to be set.
 * @field model is a readonly version of the gameModel to keep immutable in this class.
 */ 
public class TTTPanel extends JPanel {
  //Dimensions used from inclass
  public static final int dimension = 80;
  public static final int spacing = 80;
  public static final int FontSize = 40;
  public static final String FontType = "Helvetica";
  private ReadonlyTTTModel model;

  /** This is the constructor for the Panel given the read only. The rest of the values are set.
   * @param m The readonly state of the model.
   */
  public TTTPanel(ReadonlyTTTModel m) {
    model = m;
  }

  /** This functions handles drawing the board, players, and text into the viewer.
   *  The steps is takes are commented below.
   *  @param game Takes in a graphics Class that it draws on for the Panel.
   */
  public void paintComponent(Graphics game) {
    //Steps needed to complete:
    //10 Draw the boundary lines
    //2) Draw the players
    //3) Draw state of turn
    super.paintComponent(game);
    Graphics2D gameDrawn = (Graphics2D) game;

    //This is a compound for loop to draw board regardless of panel size.
    for (int i = 1; i < 3; i++) {
      gameDrawn.drawLine(
          i * dimension + spacing, spacing, i * dimension + spacing, 3 * dimension + spacing);
      gameDrawn.drawLine(
          spacing, i * dimension + spacing, 3 * dimension + spacing, i * dimension + spacing);
    }
    gameDrawn.setFont(new Font(FontType, Font.PLAIN, FontSize));
    Player[][] board = model.getBoard();

    //Compound for loop to turn drawn board to appropiate string.
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        if (board[row][col] != null) {
          gameDrawn.drawString(
              board[row][col].toString(),
              Math.round((col + 0.4) * dimension + spacing),
              Math.round((row + .75) * dimension + spacing));
        }
      }
    }

    //Conditional to draw who is moving above the board.
    if (model.isGameOver()) {
      if (model.getWinner() == null) {
        gameDrawn.drawString("Game Over: " + "Its a tie game.", spacing, spacing - 4);
      } else {
        gameDrawn.drawString(
            "Game Over! The winner is " + model.getWinner().toString(), spacing, spacing-4);
      }
    }
    else {
      gameDrawn.drawString("Current Player to Move: " + model.getTurn().toString(), spacing, spacing-4);
    }
  }
}
