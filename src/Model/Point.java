package Model;

public class Point {
  public int x;
  public int y;
  
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || !(o instanceof Point))
      return false;
    Point other = (Point) o;
    return this.x == other.x && this.y == other.y;
  }
  
  public Point moved_by(Point other) {
    return new Point(this.x + other.x, this.y + other.y);
  }
  
  public Point scaled_by(int scale) {
    return new Point(x*scale, y*scale);
  }
}
