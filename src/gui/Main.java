package gui;

import cup.example.Parser;
import javafx.application.Application;
import javafx.stage.Stage;

/** Main JavaFX app. */
public class Main extends Application {
  public static ast.Runtime runtime;
  
  @Override
  public void start(Stage stage) throws Exception {
    CanvasScene scene = new CanvasScene(stage);
    
    stage.setTitle("Canvas Compiler");
    stage.setScene(scene);
    stage.show();
    
    /*ast.Runtime*/ runtime = new ast.Runtime();
    runtime.tablero.addObserver(scene.canvas);
    runtime.tablero.refresh();
    
    Parser parser = new Parser();
    parser.parse();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

