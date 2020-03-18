package cs3500.tictactoe;
import javax.swing.JFrame;

/**
 * A class for the TTTView implementation. Extends JFrame.
 * Has no fields, has methods to add mouse listener, refresh animation, and make it visible.
 */
public class TTTViewImpl extends JFrame implements TTTView {
  private TTTPanel panel;

  /**
   * A public constructor for the class. Receives a String for the title of the window, as well
   * as the ReadonlyTTTModel instance. Sets the size, location, and close operation for this
   * JFrame, as well as adds a JPanel to itself.
   * @param windowTitle a String, the name of the frame.
   * @param m           a ReadonlyTTTModel instance.
   */
  public TTTViewImpl(String windowTitle, ReadonlyTTTModel m) {
    super(windowTitle);

    setSize(500, 500);
    setLocation(200, 200);
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
    TTTHandleClick handleClick = new TTTHandleClick(listener);
    addMouseListener(handleClick);
  }

  /** Refresh the view to reflect any changes in the game state. */
  @Override
  public void refresh() {
    this.repaint();
  }

  /** Make the view visible to start the game session. */
  @Override
  public void makeVisible() {
    this.setVisible(true);
  }
  }
