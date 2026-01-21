public class Operation {
  Doctor doctor;
  Patient patient;
  Surgery surgery;
  double totalCharge;

  public Operation(Doctor doctor, Patient patient, Surgery surgery) {
    this.doctor = doctor;
    this.patient = patient;
    this.surgery = surgery;
    this.computeTotalCharge();
  }

  public double computeTotalCharge() {
    this.totalCharge = this.surgery.charge + this.doctor.charge;
    int age = this.patient.age;

    // Apply discount if patient is 10 years old or younger
    if (age <= 10) {
      this.totalCharge *= 0.5;
    }

    // Apply discount if patient is between 11-20 or 60-200 years old
    else if (age <= 20 || age >= 60) {
      this.totalCharge *= 0.75;
    }

    patient.charge(this.totalCharge);

    return this.totalCharge;
  }
}