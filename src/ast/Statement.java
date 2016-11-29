package ast;

import Model.BordeException;

public interface Statement {
  void exec(Runtime runtime) throws BordeException;
}
