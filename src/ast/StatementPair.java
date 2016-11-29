package ast;

public class StatementPair implements Statement {
  Statement stat1;
  Statement stat2;
  
  public StatementPair(Statement stat1, Statement stat2) {
    this.stat1 = stat1;
    this.stat2 = stat2;
  }
  
  @Override
  public void exec(Runtime runtime) {
    stat1.exec(runtime);
    stat2.exec(runtime);
  }
}
