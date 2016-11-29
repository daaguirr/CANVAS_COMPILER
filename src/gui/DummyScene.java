package gui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DummyScene extends Scene {
  public DummyScene(Stage stage) {    
    super(root(stage), 300, 250);
  }
  
  private static Parent root(Stage stage) {
    Rectangle rect = new Rectangle(42, 33, Color.RED);
    rect.setStroke(Color.BLACK);
    
    VBox root = new VBox();
    root.getChildren().addAll(
        new Text("This is a dummy scene."),
        rect,
        new Text("This is a single cell."),
        new Cell(),
        new Text("Now a 2x3 canvas:"),
        new Canvas(2, 3)
    );
    return root;
  }
}