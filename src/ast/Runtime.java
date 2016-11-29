package ast;

import Model.Color;
import Model.Pluma;
import Model.Tablero;

public class Runtime {
  public Tablero tablero;
  public Pluma pluma;
  
  public Runtime() {
    tablero = new Tablero(50, 50, Color.WHITE);
    pluma = new Pluma();
  }
}
