package Model;

public class Or implements IExpression {
  private IExpression expr1, expr2;
  
  public Or(IExpression expr1, IExpression expr2){
    this.expr1 = expr1;
    this.expr2 = expr2;
  }
  
  @Override
  public boolean eval() {
    return expr1.eval() || expr2.eval();
  }
}