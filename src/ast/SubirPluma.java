package ast;

public class SubirPluma implements Statement {
  @Override
  public void exec(Runtime runtime) {
    runtime.pluma.levantar();
  }
}
