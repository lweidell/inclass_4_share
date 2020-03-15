package cs3500.tictactoe;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

public class TTTViewImpl extends JFrame implements TTTView {
  private TTTPanel panel;

  public TTTViewImpl(String windowTitle, ReadonlyTTTModel m){
    super(windowTitle);

    setSize(400, 300);
    setLocation(200,200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel = new TTTPanel(m);
    this.add(panel);
  }
  /**
   * Set up the controller to handle click events in this view.
   *
   * @param listener the controller
   */
  @Override
  public void addClickListener(TicTacToeController listener) {
    MouseListener ml = (MouseAdapter) mouseClicked(e) -> {
      int row = (e.getY() - TTTPanel.OFFSET) / TTTPanel.CELL_DIM;
      int col = (e.getX() - TTTPanel.OFFSET) / TTTPanel.CELL_DIM;
      ml.handleCellClick(row, col);
      };

    panel.addMouseListener(ml);

  }

  /**
   * Refresh the view to reflect any changes in the game state.
   */
  @Override
  public void refresh() {

  }

  /**
   * Make the view visible to start the game session.
   */
  @Override
  public void makeVisible() {

  }
}
