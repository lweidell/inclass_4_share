package cs3500.tictactoe;

import javax.swing.JPanel;
import java.awt.*;

public class TTTPanel extends JPanel {
  public static final int Dimension = 80;
  public static final int spacing = 80;
  public static final int FontSize = 40;
  public static final String FontType = "Helvetica";
  private ReadonlyTTTModel model;

  public TTTPanel(ReadonlyTTTModel m) {
    model = m;
  }

  public void paintComponent(Graphics game) {
    super.paintComponent(game);
    Graphics2D gameDrawn = (Graphics2D) game;

    //This is a compound for loop to draw board regardless of panel size.
    for (int i = 1; i < 3; i++) {
      gameDrawn.drawLine(
          i * Dimension + spacing, spacing, i * Dimension + spacing, 3 * Dimension + spacing);
      gameDrawn.drawLine(
          spacing, i * Dimension + spacing, 3 * Dimension + spacing, i * Dimension + spacing);
    }
    gameDrawn.setFont(new Font(FontType, Font.PLAIN, FontSize));
    Player[][] board = model.getBoard();

    //Compound for loop to turn drawn board to appropiate string.
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        if (board[r][c] != null) {
          gameDrawn.drawString(
              board[r][c].toString(),
              Math.round((c + 0.5) * Dimension + spacing),
              Math.round((r + 1) + Dimension + spacing));
        }
      }
    }

    //Conditional to draw who is moving above the board.
    if (model.isGameOver()) {
      if (model.getWinner() == null) {
        gameDrawn.drawString("Game Over: " + "Its a tie game.", spacing, spacing);
      } else {
        gameDrawn.drawString(
            "Game Over! The winner is " + model.getWinner().toString(), spacing, spacing);
      }
    }
    gameDrawn.drawString("Current Player to Move: " + model.getTurn().toString(), spacing, spacing);
  }
}
