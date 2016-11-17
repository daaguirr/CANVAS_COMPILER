package Model;

public class BordeException extends Exception {
  private static final long serialVersionUID = 1L;
  public Point point;
  
  public BordeException(Point point) {
    this.point = point;
  }
}
