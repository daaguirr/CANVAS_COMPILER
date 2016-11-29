package Model;

public class Color {
  private char id;
  
  public static final Color BLACK = new Color('N');
  public static final Color BLUE = new Color('A');
  public static final Color GREEN = new Color('G');
  public static final Color RED = new Color('R');
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

  public char toChar() {
    return id;
  }
}
