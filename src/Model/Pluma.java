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
  
  public void set_color(char c) {
    color = new Color(c);
  }
  
  public void set_direction(char d) {
    direction = new Direction(d);
  }
  
  public void avanzar(int num, ITablero tablero) throws BordeException {
    if (is_down())
      for (int i = 0; i < num; ++i)
        tablero.set_color(position.moved_by(direction.scaled_by(i)), color);
    
    position = position.moved_by(direction.scaled_by(num));
    if (!tablero.contains(position))
      throw new BordeException(position);
  }
  
  public boolean has_color(char c) {
    return color.equals(new Color(c));
  }
  
  public boolean has_direction(char d) {
    return direction.equals(new Direction(d));
  }
  
  public boolean is_up() {
    return isUp;
  }
  
  public boolean is_down() {
    return !isUp;
  }
}
