package Model;

public class ColorUpdate {
  private Position pto;
  private Color color;
  
  public ColorUpdate(Position pto, Color color){
    this.setPto(pto);
    this.setColor(color);
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Position getPto() {
    return pto;
  }

  public void setPto(Position pto) {
    this.pto = pto;
  }
}
