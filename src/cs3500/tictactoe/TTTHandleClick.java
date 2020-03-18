package cs3500.tictactoe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TTTHandleClick extends MouseAdapter {

  @Override
  public void mouseClicked(MouseEvent e) {
    int x = e.getX();
    int y = e.getY();
    System.out.println(x + ", " + y);
  }
}
