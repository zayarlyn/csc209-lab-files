public class RegisterNode {
  int studentId, courseId, grade;
  RegisterNode nextStudent, nextClass;

  public RegisterNode(int studentId, int courseId, int grade, RegisterNode nextStudent, RegisterNode nextClass) {
    this.studentId = studentId;
    this.courseId = courseId;
    this.grade = grade;
    this.nextStudent = nextStudent;
    this.nextClass = nextClass;
  }

  public RegisterNode(int studentId, int courseId, int grade) {
    this(studentId, courseId, grade, null, null);
  }

  public RegisterNode(int studentId, int courseId) {
    this(studentId, courseId, 10, null, null);
  }

  public int getGrade() {
    return grade;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }
}
