package cs3500.tictactoe;

public class TicTacToeControllerImpl implements TicTacToeController {
  private TTTViewImpl view;
  private TicTacToe model;

  public TicTacToeControllerImpl(TTTViewImpl view){
    this.view = view;
  }
  /**
   * Execute a single game of tic tac toe given a tic tac toe Model. When the game is over,
   * the playGame method ends.
   *
   * @param m a non-null tic tac toe Model
   */
  @Override
  public void playGame(TicTacToe m) {
    this.model = m;
    view.addClickListener(this);
    view.makeVisible();

  }

  /**
   * Handle an action in a single cell of the board, such as to make a move.
   *
   * @param row the row of the clicked cell
   * @param col the column of the clicked cell
   */
  @Override
  public void handleCellClick(int row, int col) {
    model.move(row, col);
    view.refresh();
    view.makeVisible();
  }
}
