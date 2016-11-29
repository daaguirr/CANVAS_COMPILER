package Model;

public class Position {
  public int row;
  public int col;
  
  public Position(int x, int y) {
    this.row = x;
    this.col = y;
  }
  
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || !(o instanceof Position))
      return false;
    Position other = (Position) o;
    return this.row == other.row && this.col == other.col;
  }
  
  public Position moved_by(Position other) {
    return new Position(this.row + other.row, this.col + other.col);
  }
  
  public Position scaled_by(int scale) {
    return new Position(row*scale, col*scale);
  }
}
