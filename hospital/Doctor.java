import java.util.Vector;

public class Doctor extends Person {
  Vector<String> specialty;
  double charge;

  Doctor(int id, String name, int age, String gender) {
    super(id, name, age, gender);
    this.specialty = new Vector<>(10);
  }

  int addSpecialty(String specialty) {
    this.specialty.add(specialty);
    return this.specialty.size();
  }

  public String toString() {
    String s = "";
    for (String str : specialty) {
      s += str + ", ";
    }

    return s;
    // System.out.println("Doctor specialties: " + s);
  }
}