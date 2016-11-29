package gui;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {
  private static final int SIZE = 16;
  public static final int PIXELS = SIZE + 1;
  private Color fill = Color.LIGHTGRAY;
  
  public Cell() {
    super(SIZE, SIZE, Color.WHITE);
    super.setStroke(Color.GRAY);
    super.setFill(fill);
    super.setOnMouseEntered((MouseEvent event) -> super.setFill(fill.darker()));
    super.setOnMouseExited((MouseEvent event) -> super.setFill(fill));
    super.setOnMouseClicked((MouseEvent event) -> {
      ;
    });
  }
  
  public void setFill(Color fill) {
    this.fill = fill;
    super.setFill(fill);
  }
}
