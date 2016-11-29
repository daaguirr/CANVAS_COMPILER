package ast;

public class BajarPluma implements Statement {  
  @Override
  public void exec(Runtime runtime) {
    runtime.pluma.bajar();
  }
}
