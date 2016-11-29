package ast;

import Model.Color;
import Model.Point;

public class TableroCol implements Expression {
  private Color desiredColor;
  
  public TableroCol(Color desiredColor) {
    this.desiredColor = desiredColor;
  }
  
  @Override
  public boolean eval(Runtime runtime) {
    Point position = runtime.pluma.getPosition();
    return runtime.tablero.getColor(position).equals(desiredColor);
  }
}
