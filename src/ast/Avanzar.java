package ast;

import Model.BordeException;

public class Avanzar implements Statement {
  private Integer intt;
  public Avanzar(Integer intt){
    this.intt = intt;
  }
  @Override
  public void exec(Runtime runtime) throws BordeException {
    runtime.pluma.avanzar(intt, runtime.tablero);
  }

}
