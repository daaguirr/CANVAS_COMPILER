package Model;

public class Pluma {
  private Point position;
  private Color color;
  private boolean isUp;
  private Point direction;
  
  public Pluma() {
    position = new Point(1, 1);
    color = Color.WHITE;
    isUp = true;
    direction = Direction.EAST;
  }
  
  public void bajar() {
    isUp = false;
  }
  
  public void levantar() {
    isUp = true;
  }
  
  public void setColor(Color color) {
    this.color = color;
  }
  
  public void setDirection(Direction direction) {
    this.direction = direction;
  }
  
  public void avanzar(int num, ITablero tablero) throws BordeException {
    if (isDown())
      for (int i = 0; i < num; ++i)
        tablero.setColor(position.moved_by(direction.scaled_by(i)), color);
    
    position = position.moved_by(direction.scaled_by(num));
    if (!tablero.contains(position))
      throw new BordeException(position);
  }
  
  public boolean hasColor(char c) {
    return color.equals(new Color(c));
  }
  
  public boolean hasDirection(char d) {
    return direction.equals(new Direction(d));
  }
  
  public boolean isUp() {
    return isUp;
  }
  
  public boolean isDown() {
    return !isUp;
  }
}
