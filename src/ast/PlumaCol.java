package ast;

import Model.Color;

public class PlumaCol implements Expression {
  private final Color desiredColor;
  
  public PlumaCol(Color desiredColor) {
    this.desiredColor = desiredColor;
  }
  
  @Override
  public boolean eval(Runtime runtime) {
    return runtime.pluma.hasColor(desiredColor);
  }
}
