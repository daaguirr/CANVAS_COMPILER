package Model;

public class Color {
  private char id;
  
  public static final Color WHITE = new Color('B');
  
  public Color(char c) {
    id = c;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || !(o instanceof Color))
      return false;
    Color other = (Color) o;
    return this.id == other.id;
  }
}
