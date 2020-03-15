package cs3500.tictactoe;

import javax.swing.JPanel;
import java.awt.*;

public class TTTPanel extends JPanel {
  private ReadonlyTTTModel model;

  public static final int CELL_DIM = 80;
  public static final int OFFSET = 80;
  public static final int FONT_SIZE = 40;
  public static final String FONT_FACE = "Helvetica";

  public TTTPanel(ReadonlyTTTModel m) { model = m; }



  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    for(int i = 1; i < 3; i++){
      g2.drawLine(i* CELL_DIM + OFFSET, OFFSET, i + CELL_DIM + OFFSET, 3 * CELL_DIM + OFFSET);
      g2.drawLine(OFFSET, i* CELL_DIM + OFFSET, 3 * CELL_DIM + OFFSET, i * CELL_DIM + OFFSET);
      }
    g2.setFont(new Font(FONT_FACE, Font.PLAIN, FONT_SIZE));
    Player[][] board = model.getBoard();
    for(int r = 0; r < 3; r++){
      for(int c = 0; c < 3; c++){
        if (board[r][c] != null) {
          g2.drawString(board[r][c].toString(),
                  Math.round((c + 0.3) * CELL_DIM + OFFSET),
                  Math.round((r + 0.75) + CELL_DIM + OFFSET));
          }
        }
      }
    if (model.isGameOver()) {
      g2.drawString( "Game Over: "
      + (model.getWinner() == null ? "tie game." : model.getWinner().toString() + "wins."),
              OFFSET, OFFSET - 4);
      } else {
      g2.drawString("Turn: " + model.getTurn().toString(), OFFSET, OFFSET - 4);
    }
  }
}
