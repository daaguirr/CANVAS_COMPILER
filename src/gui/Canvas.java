package gui;

import java.util.Observable;
import java.util.Observer;

import Model.ColorUpdate;
import Model.Point;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Canvas extends GridPane implements Observer{
  private final Cell cell[][];
  
  public Canvas(int width, int height) {
    cell = new Cell[height][width];
    
    for (int row = 0; row < height; ++row) {
      for (int col = 0; col < width; ++col) {
        cell[row][col] = new Cell();
        super.add(cell[row][col], row, col);
      }
    }
  }

  @Override
  public void update(Observable o, Object arg) {
    ColorUpdate update = (ColorUpdate) arg;
    ColorPalette cp = new ColorPalette();
    setColor(update.getPto(), cp.convert(update.getColor()));
    
    
  }
  
  public void setColor(Point point , Color color){
    cell[point.x][point.y].setFill(color);
  }
}
