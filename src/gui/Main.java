package gui;

import javafx.application.Application;
import javafx.stage.Stage;

/** Main JavaFX app. */
public class Main extends Application {  
  @Override
  public void start(Stage stage) throws Exception {    
    stage.setTitle("Canvas Compiler");
    stage.setScene(new DummyScene(stage));
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

