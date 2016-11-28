package Model;

public class Not implements IExpression {
  private IExpression expr1;
  
  public Not(IExpression expr1){
    this.expr1 = expr1;
  }
  
  @Override
  public boolean eval() {
    return !expr1.eval();
  }
}
