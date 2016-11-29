package ast;

import Model.Color;

public class CambiarColor implements Statement {
  private Color color;
  public CambiarColor(Color color){
    this.color = color;
  }
  @Override
  public void exec(Runtime runtime) {
    runtime.pluma.setColor(color);

  }

}
