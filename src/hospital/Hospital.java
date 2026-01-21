public class Hospital {
  public static void main(String[] args) {
    Doctor d1 = new Doctor(1, "Dr. Smith", 45, "Male");
    d1.addSpecialty("Cardiology");
    d1.addSpecialty("Neurology");

    System.out.println(d1);
  
    Surgery s1 = new Surgery("Appendectomy", 300.0, 200.0);
    s1.addTool("Scalpel");
    s1.addTool("Forceps");

    Patient p1 = new Patient(101, "John Doe", 20, "Male", "O+");
    Patient p2 = new Patient(102, "Jane Smith", 22, "Female", "A-");

    d1.charge = 10000;
    Operation op1 = new Operation(d1, p1, s1);
    System.out.println(p1.getUnpaid());
    Operation op2 = new Operation(d1, p2, s1);
    System.out.println(p2.getUnpaid());
    p1.pay(10000);
    Operation op3 = new Operation(d1, p1, s1);
    System.out.println(p1.getUnpaid());
  }
}
