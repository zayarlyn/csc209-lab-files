public class SinglyLinkedListLab {
  public static void main(String[] args) {
    SinglyLinkedList sll = new SinglyLinkedList();
    sll.addToTail(1, "John", "male", 3.4, "CS");
    sll.addToTail(1, "Ann", "female", 3.96, "CS");
    sll.addToTail(1, "Saw", "male", 4, "CS");

    System.out.println(sll.head.info.name);
    System.out.println(sll.head.info.name + " " + sll.head.next.info.gpa);

    System.out.println(sll.head.next.next.info
            .name);
    System.out.println(sll.tail.info.name);

    sll.addToHead(4, "Pita", "male", 3.3, "CS");
    sll.addToHead(5, "WhoWhoWho", "male", 2.4, "Robotics");

    System.out.println(sll.head.info.name);
    System.out.println(sll.head.next.next.next.info.name);

    Student deletedNode = sll.deleteFromHead();
    // Pita -> John -> Ann -> Saw
    System.out.println(deletedNode.name);
    System.out.println(sll.head.info.name);

//    SinglyLinkedList sll2 = new SinglyLinkedList();
//    sll2.addToHead(11, "Anutin", "male", 2.0, "Engineer");
//    Student x = sll2.deleteFromHead();
//    System.out.println(x.name);
//    x = sll2.deleteFromHead();
//    x = sll2.deleteFromTail();
//
//    System.out.println(x.name);
//    System.out.println(sll.tail.info.name);

    Student x = sll.searchByName("John");
    System.out.println(x.id);
    System.out.println(sll.countNumberOfStudentsByMajor("CS"));
  }
}