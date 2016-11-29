package gui;

import javafx.scene.layout.GridPane;

public class Canvas extends GridPane {
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
}
