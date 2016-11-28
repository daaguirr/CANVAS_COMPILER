package Model;

import java.util.Observable;
import java.util.Observer;

public class Not extends Observable implements IExpression, Observer {
  private IExpression expr1;
  private boolean value;
  
  public Not(IExpression expr1){
    this.expr1 = expr1;
  }
  @Override
  public boolean eval() {
    return !expr1.eval();
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
