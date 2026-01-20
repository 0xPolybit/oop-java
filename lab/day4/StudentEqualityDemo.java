package lab.day4;

class Student {
    int rollNo;
    String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return rollNo == student.rollNo && name.equals(student.name);
    }
}

public class StudentEqualityDemo {
    public static void main(String[] args) {
        Student s1 = new Student(101, "John");
        Student s2 = new Student(101, "John");
        Student s3 = new Student(102, "Jane");

        System.out.println("s1 equals s2: " + s1.equals(s2));
        System.out.println("s1 equals s3: " + s1.equals(s3));
    }
}
