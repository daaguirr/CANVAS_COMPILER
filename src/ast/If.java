package ast;

public class If implements Statement {
  private final Expression condition;
  private final Statement action;
  
  public If(Expression condition, Statement action) {
    this.condition = condition;
    this.action = action;
  }
  
  @Override
  public void exec(Runtime runtime) {
    if (condition.eval(runtime))
      action.exec(runtime);
  }
}
