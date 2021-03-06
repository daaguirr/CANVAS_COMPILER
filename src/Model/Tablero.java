package Model;

import java.util.Arrays;
import java.util.Observable;

public class Tablero extends Observable implements ITablero {
  private Color[][] colorOf;
  private int rows;
  private int columns;
  
  public Tablero(int width, int height, Color defaultColor) {
    this.rows = height;
    this.columns = width;
    colorOf = new Color[rows][columns];
    for (Color[] row : colorOf)
      Arrays.fill(row, defaultColor);
  }
  
  @Override
  public boolean contains(Position point) {
    return 0 <= point.row && point.row < rows
        && 0 <= point.col && point.col < columns;
  }

  @Override
  public void setColor(Position point, Color color) throws BordeException {
    if (!contains(point))
      throw new BordeException(point);
    colorOf[point.row][point.col] = color;
    setChanged();
    notifyObservers(new ColorUpdate(point, color));
  }

  @Override
  public Color getColor(Position point) {
    return colorOf[point.row][point.col];
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < columns; ++col)
        sb.append(colorOf[row][col].toChar());
      sb.append(System.lineSeparator());
    }
    return sb.toString();
  }

  public void refresh() {
    for (int row = 0; row < rows; ++row) {
      for (int col = 0; col < columns; ++col) {
        Position pos = new Position(row, col);
        Color color = colorOf[row][col];
        setChanged();
        notifyObservers(new ColorUpdate(pos, color));
      }
    }
  }
}
