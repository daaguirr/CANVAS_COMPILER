package Model;

public interface ITablero {
  boolean contains(Point point);
  
  void setColor(Point point, Color color);
  
  Color getColor(Point point);
}
