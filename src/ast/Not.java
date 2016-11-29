package ast;

public class Not implements Expression {
  private Expression expr1;
  
  public Not(Expression expr1){
    this.expr1 = expr1;
  }
  
  @Override
  public boolean eval(Runtime runtime) {
    return !expr1.eval(runtime);
  }
}
