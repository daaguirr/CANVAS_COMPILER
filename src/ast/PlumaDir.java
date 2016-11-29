package ast;

import Model.Direction;

public class PlumaDir implements Expression {
  private final Direction desiredDirection;
  
  public PlumaDir(Direction desiredDirection) {
    this.desiredDirection = desiredDirection;
  }
  
  @Override
  public boolean eval(Runtime runtime) {
    return runtime.pluma.hasDirection(desiredDirection);
  }
}
