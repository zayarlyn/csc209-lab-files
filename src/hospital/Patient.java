public class Patient extends Person {
  String bloodType;
  double unpaid;

  public Patient(int id, String name, int age, String gender, String bloodType) {
    super(id, name, age, gender);
    this.bloodType = bloodType;
    this.unpaid = 0.0;
  }

  public String getBloodType() {
    return this.bloodType;
  }

  public void setBloodType(String bloodType) {
    this.bloodType = bloodType;
  }

  public double getUnpaid() {
    return this.unpaid;
  }

  public void pay(double amount) {
    this.unpaid -= amount;
  }

  public void charge(double amount) {
    this.unpaid += amount;
  }

  public String toString() {
    String s = super.toString() + ". ";
    return s + bloodType + ", " + unpaid;
  }
}