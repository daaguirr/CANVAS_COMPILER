package Model;

public class Direction extends Point {  
  private static final long serialVersionUID = 1L;

  public static final Direction EAST = new Direction('E');
  
  public Direction(char d) {
    super(get_x(d), get_y(d));
  }
  
  private static int get_x(char d) {
    switch (d) {
      case 'S': return 0;
      case 'N': return 0;
      case 'E': return 1;
      case 'O': return -1;
      default:
        throw new IllegalArgumentException();
    }
  }
  
  private static int get_y(char d) {
    switch (d) {
      case 'S': return 1;
      case 'N': return -1;
      case 'E': return 0;
      case 'O': return 0;
      default:
        throw new IllegalArgumentException();
    }
  }
}
