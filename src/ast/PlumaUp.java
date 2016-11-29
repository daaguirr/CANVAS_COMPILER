package ast;

public class PlumaUp implements Expression {
  @Override
  public boolean eval(Runtime runtime) {
    return runtime.pluma.isUp();
  } 
}
