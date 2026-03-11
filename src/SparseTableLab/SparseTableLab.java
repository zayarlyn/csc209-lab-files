public class SparseTableLab {
    public static void main(String[] args) {
      SparseTableLinkedList spl = new SparseTableLinkedList(8000, 300);

      spl.addRegister(501, 10, 5);
      RegisterNode temp = spl.students[501];
      System.out.println(temp.courseId);
      spl.addRegister(501, 45, 0);
      System.out.println(temp.nextClass.courseId);

      spl.addRegister(600, 45, 1);
      spl.addRegister(100, 45, 2);
      temp = spl.classes[45];
      System.out.println(temp.studentId + " " + temp.nextStudent.studentId + " " + temp.nextStudent.nextStudent.studentId);

      spl.addRegister(300, 45, 3);
      spl.addRegister(2000, 45, 1);
      spl.printAllStudents(45);
      spl.addRegister(501, 35, 6);
      temp = spl.classes[45];
      System.out.println(temp.grade);
      spl.addRegister(501, 200, 0);
      spl.addRegister(501, 201, 1);
      spl.addRegister(501, 202, 0);
      spl.addRegister(501, 203, 0);
      spl.addRegister(501, 204, 0);
      System.out.println(spl.calculateGPA(501));
    }
}
