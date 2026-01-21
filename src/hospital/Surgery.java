import java.util.Vector;

public class Surgery {
  String bodyPart;
  double bloodNeeded;
  Vector<String> tools;
  double charge;

  Surgery(String bodyPart, double bloodNeeded, double charge) {
    this.bodyPart = bodyPart;
    this.bloodNeeded = bloodNeeded;
    this.charge = charge;
    this.tools = new Vector<>(10);
  }

  public int addTool(String tool) {
    this.tools.add(tool);
    return this.tools.size();
  }
}