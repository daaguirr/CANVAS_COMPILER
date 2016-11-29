package Model;

public class ColorUpdate {
  private Point pto;
  private Color color;
  
  public ColorUpdate(Point pto, Color color){
    this.setPto(pto);
    this.setColor(color);
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Point getPto() {
    return pto;
  }

  public void setPto(Point pto) {
    this.pto = pto;
  }
}
