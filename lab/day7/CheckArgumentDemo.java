package lab.day7;

public class CheckArgumentDemo {
    public static void main(String[] args) {
        try {
            if (args.length < 4) throw new CheckArgument();
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = Integer.parseInt(args[2]);
            int d = Integer.parseInt(args[3]);
            int sum = a*a + b*b + c*c + d*d;
            System.out.println(sum);
        } catch (CheckArgument e) {
            System.out.println("Exception occurred - " + e.getClass().getSimpleName());
        }
    }
}

class CheckArgument extends Exception {
    CheckArgument() { super("CheckArgument"); }
}
