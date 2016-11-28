package Model;
import java.util.*;

public class Expression extends Observable implements Observer, IExpression{
  private boolean value;
  private String expr;
  
  public Expression(String expr){
    this.expr = expr;
  }

  /*
   * Evalua una expresion regular 
   */
  public boolean eval(){
    return false;
  }

  public boolean getValue(){
    return this.value;
  }
  /*
   *  Cuando llega un update, seteo una operacion
   */
  @Override
  public void update(Observable o, Object arg) {
    // TODO Auto-generated method stub
    
  }
}
