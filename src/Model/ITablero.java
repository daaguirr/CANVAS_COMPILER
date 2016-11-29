package Model;

public interface ITablero {
  boolean contains(Position point);
  
  void setColor(Position point, Color color) throws BordeException;
  
  Color getColor(Position point);
}
