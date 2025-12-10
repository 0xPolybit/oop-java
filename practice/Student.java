package practice;

public class Student {
    
    String name;
    int roll;

    Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    void printStudentDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + roll);
    }

}
