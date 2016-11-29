package ast;

public class PlumaDown implements Expression {
  @Override
  public boolean eval(Runtime runtime) {
    return runtime.pluma.isDown();
  }
}
