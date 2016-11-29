package Model;

import java.util.Arrays;

public class Tablero implements ITablero {
  private Color[][] colorOf;
  private int width;
  private int height;
  
  public Tablero(int width, int height, Color defaultColor) {
    this.width = width;
    this.height = height;
    colorOf = new Color[width][height];
    for (Color[] row : colorOf)
      Arrays.fill(row, defaultColor);
  }
  
  @Override
  public boolean contains(Point point) {
    return 0 <= point.x && point.x < width
        && 0 <= point.y && point.y < height;
  }

  @Override
  public void setColor(Point point, Color color) throws BordeException {
    if(!contains(point)) throw new BordeException(point);
    colorOf[point.x][point.y] = color;
  }

  @Override
  public Color getColor(Point point) {
    return colorOf[point.x][point.y];
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int row = 0; row < height; ++row) {
      for (int col = 0; col < width; ++col)
        sb.append(colorOf[col][row].toChar());
      sb.append(System.lineSeparator());
    }
    return sb.toString();
  }
}
