package Model;

public class Pluma {
  private Position position;
  private Color color;
  private boolean isUp;
  private Position direction;
  
  public Pluma() {
    position = new Position(49, 0);
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
  
  public Position getPosition() {
    return position;
  }
  
  public void avanzar(int num, ITablero tablero) throws BordeException {
    if (isDown())
      for (int i = 0; i < num; ++i)
        tablero.setColor(position.moved_by(direction.scaled_by(i)), color);
    
    position = position.moved_by(direction.scaled_by(num));
    if (!tablero.contains(position))
      throw new BordeException(position);
  }
  
  public boolean hasColor(Color desiredColor) {
    return color.equals(desiredColor);
  }
  
  public boolean hasDirection(Direction desiredDirection) {
    return direction.equals(desiredDirection);
  }
  
  public boolean isUp() {
    return isUp;
  }
  
  public boolean isDown() {
    return !isUp;
  }
}
