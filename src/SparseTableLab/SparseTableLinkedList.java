public class SparseTableLinkedList {
  RegisterNode[] students;
  RegisterNode[] classes;

  SparseTableLinkedList(int amountOfStudents, int amountOfClasses) {
    this.students = new RegisterNode[amountOfStudents];
    this.classes = new RegisterNode[amountOfClasses];
  }

  public RegisterNode addRegister(int studentId, int classId) {
    if (!this.isRegistered(studentId, classId)) {
      RegisterNode node = new RegisterNode(studentId, classId);
      RegisterNode temp;

      if (students[studentId] == null) {
        students[studentId] = node;
      }
      else if (classId < students[studentId].courseId) {
        node.nextClass = students[studentId];
        students[studentId] = node;
      }
      else {
        for (temp = students[studentId]; temp.nextClass != null && temp.nextClass.courseId < classId; temp = temp.nextClass);
        node.nextClass = temp.nextClass;
        temp.nextClass = node;
      }

      if (classes[classId] == null) {
        classes[classId] = node;
      }
      else if (studentId < classes[classId].studentId) {
        node.nextStudent = classes[classId];
        classes[classId] = node;
      }
      else {
        for (temp = classes[classId]; temp.nextStudent != null && temp.nextStudent.studentId < studentId; temp = temp.nextStudent);
        node.nextStudent = temp.nextStudent;
        temp.nextStudent = node;
      }

      return node;
    }

    return null;
  }

  public RegisterNode addRegister(int studentId, int classId, int grade) {
      RegisterNode node = this.addRegister(studentId, classId);
      node.setGrade(grade);
      return node;
  }

    public boolean isRegistered(int studentId, int classId) {
    if (this.students[studentId] == null) {
      return false;
    }

//    RegisterNode temp = students[studentId];
//    while (temp != null && temp.courseId <= classId) {
//      if (temp.courseId == classId) return true;
//    }
//
//    return false;

    RegisterNode temp;
    for (temp = students[studentId]; temp != null && temp.courseId < classId; temp = temp.nextClass);

    if (temp == null || temp.courseId > classId) return false;
    return true;
  }

  public void printAllStudents(int classId) {
    for (RegisterNode node = classes[classId]; node != null; node = node.nextStudent) {
      System.out.print(node.studentId + " ");
    }
    System.out.println();
  }

  public double calculateGPA(int studentId) {
    double[] gradePoints = {4, 3.6, 3.3, 3, 2.6, 2.3, 2, 1.6, 1.3, 1, 0};

    int count = 0;
    double total = 0;
    for (RegisterNode node = students[studentId]; node != null; node = node.nextClass) {
        total += gradePoints[node.getGrade()];
        count++;
    }

    return total / count;
  }
}

//c 2
//c+ 2.3
//b- 2.6
//b 3
//b+ 3.3
//a- 3.6
//a 4.0