package ast;

import Model.Direction;

public class CambiarDireccion implements Statement {

  private Direction dir;
  public CambiarDireccion(Direction dir){
    this.dir = dir;
  }
  @Override
  public void exec(Runtime runtime) {
    runtime.pluma.setDirection(dir);
  }

}
