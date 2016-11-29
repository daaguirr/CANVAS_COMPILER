package gui;

import javafx.scene.paint.Color;

public class ColorPalette {
  public Color convert(Model.Color modelColor) {
    if (modelColor.equals(Model.Color.BLACK))
      return Color.BLACK;
    if (modelColor.equals(Model.Color.BLUE))
      return Color.BLUE;
    if (modelColor.equals(Model.Color.GREEN))
      return Color.GREEN;
    if (modelColor.equals(Model.Color.RED))
      return Color.RED;
    if (modelColor.equals(Model.Color.WHITE))
      return Color.WHITE;
    return Color.MAGENTA;
  }
}
