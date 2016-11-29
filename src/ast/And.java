package ast;

public class And implements Expression {
  private Expression expr1, expr2;
  
  public And(Expression expr1, Expression expr2){
    this.expr1 = expr1;
    this.expr2 = expr2;
  }
  
  @Override
  public boolean eval(Runtime runtime) {
    return expr1.eval(runtime) && expr2.eval(runtime);
  }
}
