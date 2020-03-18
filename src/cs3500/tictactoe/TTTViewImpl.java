package cs3500.tictactoe;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TTTViewImpl extends JFrame implements TTTView {
  private TTTPanel panel;

  public TTTViewImpl(String windowTitle, ReadonlyTTTModel m){
    super(windowTitle);

    setSize(1000 , 1000);
    setLocation(500,500);
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
    TTTHandleClick handleClick = new TTTHandleClick();
    addMouseListener(handleClick);
    if(handleEvent(evt)){
      int row = (evt.getY - TTTPanel.spacing) / TTTPanel.;
      int col = (evt.getX - TTTPanel.spacing) / TTTPanel.Dimension;
      listener.handleCellClick(row, col);
    }
    /*
    MouseListener ml = (MouseAdapter) mouseClicked(e) -> {
      int row = (e.getY() - TTTPanel.spacing) / TTTPanel.Dimension;
      int col = (e.getX() - TTTPanel.spacing) / TTTPanel.Dimension;
      listener.handleCellClick(row, col);
      };
    panel.addMouseListener(ml);
    }
    */
  }


  /**
   * Refresh the view to reflect any changes in the game state.
   */
  @Override
  public void refresh() {
    this.repaint();
  }

  /**
   * Make the view visible to start the game session.
   */
  @Override
  public void makeVisible() {
    this.setVisible(true);
  }
}
