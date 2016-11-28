package ast;

public class While implements Statement {
  private Expression condition;
  private Statement action;
  
  public While(Expression condition, Statement action) {
    this.condition = condition;
    this.action = action;
  }
  
  @Override
  public void exec() {
    while (condition.eval())
      action.exec();
  }
};