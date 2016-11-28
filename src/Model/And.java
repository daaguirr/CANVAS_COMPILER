package Model;

import java.util.Observable;
import java.util.Observer;

public class And extends Observable implements IExpression, Observer {
  private IExpression expr1, expr2;
  private boolean value;
  
  public And(IExpression expr1, IExpression expr2){
    this.expr1 = expr1;
    this.expr2 = expr2;
  }
  @Override
  public boolean eval() {
    return expr1.eval() & expr2.eval();
  }

  @Override
  public boolean getValue() {
    // TODO Auto-generated method stub
    return false;
  }
  @Override
  public void update(Observable o, Object arg) {
    // TODO Auto-generated method stub
    
  }

}
