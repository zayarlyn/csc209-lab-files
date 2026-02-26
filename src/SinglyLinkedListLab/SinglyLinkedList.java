
class SinglyLinkedList {
  Node head, tail;

  public SinglyLinkedList() {
    head = tail = null;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public void addToTail(int id, String name, String gender, double gpa, String major) {
    Student st = new Student(id, name, gender, gpa, major);
    if (this.isEmpty()) {
      head = tail = new Node(st, null);
    } else {
      tail.next = new Node(st, null);
      tail = tail.next;
    }
  }

  public void addToHead(int id, String name, String gender, double gpa, String major) {
    Student st = new Student(id, name, gender, gpa, major);
    head = new Node(st, head);
    if (tail == null) {
      tail = head;
    }
  }

  public Student deleteFromHead() {
    Student st = null;
    if (this.isEmpty()) {
      return st;
    }
    else if (head == tail) {
      st = head.info;
      head = tail = null;
    }
    else {
      st = head.info;
      head = head.next;
    }

    return st;
  }

  public Student deleteFromTail() {
    Student st = null;
    if (this.isEmpty()) {
      return st;
    }
    else if (head == tail) {
      st = head.info;
      head = tail = null;
    }
    else {
      st = tail.info;
      Node temp;
      for (temp = head; temp.next != tail; temp = temp.next);
      temp.next = null;
    }
    return st;
  }

  public Student searchByName(String name) {
    Node temp = head;
    while (temp != null) {
      if (temp.info.name.equals(name)) {
        return temp.info;
      }
      temp = temp.next;
    }
    if (this.isEmpty()) {
      System.out.println("List is empty");
    }
    else {
      System.out.println("Not found");
    }
    return null;
  }

  public int countNumberOfStudentsByMajor(String major) {
    int count = 0;
    Node temp = head;
    while (temp != null) {
      if (temp.info.major.equals(major)) {
        count++;
      }
      temp = temp.next;
    }
    return count;
  }
}