package ast;

import Model.BordeException;

public class IfElse implements Statement {
  private Expression condition;
  private Statement ifTrue;
  private Statement ifFalse;
  
  public IfElse(Expression condition, Statement ifTrue, Statement ifFalse) {
    this.condition = condition;
    this.ifTrue = ifTrue;
    this.ifFalse = ifFalse;
  }
  
  @Override
  public void exec(Runtime runtime) throws BordeException {
    if (condition.eval(runtime))
      ifTrue.exec(runtime);
    else
      ifFalse.exec(runtime);
  }
}
