package Model;

public class BordeException extends Exception {
  private static final long serialVersionUID = 1L;
  public Position point;
  
  public BordeException(Position point) {
    this.point = point;
  }
}
