package ast;

import Model.BordeException;

public class If implements Statement {
  private final Expression condition;
  private final Statement action;
  
  public If(Expression condition, Statement action) {
    this.condition = condition;
    this.action = action;
  }
  
  @Override
  public void exec(Runtime runtime) throws BordeException {
    if (condition.eval(runtime))
      action.exec(runtime);
  }
}
