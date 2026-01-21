public class Person {
  int id;
  String name;
  int age;
  String gender;

  Person() {
    this.id = 1;
  }

  Person(int id, String name, int age, String gender) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  String getName() {
    return this.name;
  }

  void setName(String name) {
    this.name = name;
  }

  int getAge() {
    return this.age;
  }

  void setAge(int age) {
    this.age = age;
  }

  String getGender() {
    return this.gender;
  }

  void setGender(String gender) {
    this.gender = gender;
  }

  // public String toString() {

  // }
}
