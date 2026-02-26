class Student {
  int id;
  String name;
  String gender;
  double gpa;
  String major;

  public Student(int id, String name, String gender, double gpa, String major) {
    this.id = id;
    this.name = name;
    this.gender = gender;
    this.gpa = gpa;
    this.major = major;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public double getGpa() {
    return gpa;
  }

  public void setGpa(double gpa) {
    if ( gpa >= 0 && gpa <= 4) {
      this.gpa = gpa;
    }
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }
}