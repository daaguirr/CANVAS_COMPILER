package gui;

import java.util.Observable;
import java.util.Observer;

import Model.ColorUpdate;
import Model.Position;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Canvas extends GridPane implements Observer{
  private final Cell cell[][];
  private final int rows;
  private final int columns;
  
  public Canvas(int width, int height) {
    rows = height;
    columns = width;
    cell = new Cell[rows][columns];
    
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < columns; ++col) {
        cell[row][col] = new Cell();
        super.add(cell[row][col], col, row);
      }
    }
  }

  @Override
  public void update(Observable o, Object arg) {
    ColorUpdate update = (ColorUpdate) arg;
    ColorPalette cp = new ColorPalette();
    setColor(update.getPto(), cp.convert(update.getColor()));    
  }
  
  public void setColor(Position pos, Color color){
    cell[pos.row][pos.col].setFill(color);
  }
}
