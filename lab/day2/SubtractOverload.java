package lab.day2;

public class SubtractOverload {
    static class Subtractor {
        public int subtract(int a, int b) {
            int r = a - b;
            System.out.println("subtract(int,int): " + r);
            return r;
        }

        public double subtract(double a, double b) {
            double r = a - b;
            System.out.println("subtract(double,double): " + r);
            return r;
        }

        public int subtract(int a, int b, int c) {
            int r = a - b - c;
            System.out.println("subtract(int,int,int): " + r);
            return r;
        }

        public double subtract(double a, double b, double c) {
            double r = a - b - c;
            System.out.println("subtract(double,double,double): " + r);
            return r;
        }

        public int subtract(int[] values) {
            if (values == null || values.length == 0) {
                System.out.println("subtract(int[]): 0");
                return 0;
            }
            int res = values[0];
            for (int i = 1; i < values.length; i++) {
                res -= values[i];
            }
            System.out.println("subtract(int[]): " + res);
            return res;
        }
    }

    public static void main(String[] args) {
        Subtractor s = new Subtractor();

        // Demonstrate different overloaded subtract methods
        s.subtract(10, 3);                    // int, int
        s.subtract(10.5, 3.2);                // double, double
        s.subtract(20, 5, 3);                 // int, int, int
        s.subtract(12.5, 2.5, 1.0);           // double, double, double
        s.subtract(new int[]{50, 10, 5});    // int[]
    }
}
