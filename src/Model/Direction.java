package Model;

public class Direction extends Position {
  public static final Direction EAST = new Direction('E');
  public static final Direction NORTH = new Direction('N');
  public static final Direction SOUTH = new Direction('S');
  public static final Direction WEST = new Direction('O');
  
  public Direction(char d) {
    super(get_row(d), get_col(d));
  }
  
  private static int get_col(char d) {
    switch (d) {
      case 'S': return 0;
      case 'N': return 0;
      case 'E': return 1;
      case 'O': return -1;
      default:
        throw new IllegalArgumentException();
    }
  }
  
  private static int get_row(char d) {
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
