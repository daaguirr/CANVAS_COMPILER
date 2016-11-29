package gui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CanvasScene extends Scene {
  private static Canvas tmp;
  public Canvas canvas;
  
  public CanvasScene(Stage stage) {
    super(root(stage), Cell.PIXELS*50, Cell.PIXELS*50 + 100);
    canvas = tmp;
  }
  
  private static Parent root(Stage stage) {
    tmp = new Canvas(50, 50);
    
    VBox root = new VBox();
    root.getChildren().addAll(
        new Text("The Canvas"),
        tmp
    );
    return root;
  }
}