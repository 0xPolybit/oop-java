package lab.day6;

class University {
    String universityName;
    String location;

    University(String universityName, String location) {
        this.universityName = universityName;
        this.location = location;
    }

    class Department {
        String deptName;
        String hodName;

        Department(String deptName, String hodName) {
            this.deptName = deptName;
            this.hodName = hodName;
        }

        void display() {
            System.out.println("University: " + universityName);
            System.out.println("Location: " + location);
            System.out.println("Department: " + deptName);
            System.out.println("HOD: " + hodName);
        }
    }

    void createDepartment(String deptName, String hodName) {
        Department dept = new Department(deptName, hodName);
        dept.display();
    }

    public static void main(String[] args) {
        University uni = new University("KIIT University", "Bhubaneswar");
        uni.createDepartment("Computer Science", "Dr. A. Kumar");
    }
}
