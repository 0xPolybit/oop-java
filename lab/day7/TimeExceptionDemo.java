package lab.day7;

import java.util.Scanner;

public class TimeExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        Time t = new Time();
        boolean caught = false;
        try {
            try {
                t.setHours(h);
            } catch (HrsException e) {
                if (!caught) { System.out.println("Caught the exception"); caught = true; }
                System.out.println("Exception occurred:  " + e.getClass().getSimpleName() + ":" + e.getMessage());
            }
            try {
                t.setMinutes(m);
            } catch (MinException e) {
                if (!caught) { System.out.println("Caught the exception"); caught = true; }
                System.out.println("Exception occurred:  " + e.getClass().getSimpleName() + ":" + e.getMessage());
            }
            try {
                t.setSeconds(s);
            } catch (SecException e) {
                if (!caught) { System.out.println("Caught the exception"); caught = true; }
                System.out.println("Exception occurred:  " + e.getClass().getSimpleName() + ":" + e.getMessage());
            }
            if (!caught) System.out.println("Correct Time-> " + t.hours + ":" + t.minutes + ":" + t.seconds);
        } finally {
            sc.close();
        }
    }
}

class Time {
    int hours;
    int minutes;
    int seconds;

    void setHours(int h) throws HrsException {
        if (h < 0 || h > 24) throw new HrsException("hour is not in range 0-24");
        hours = h;
    }

    void setMinutes(int m) throws MinException {
        if (m < 0 || m > 60) throw new MinException("minute is not in range 0-60");
        minutes = m;
    }

    void setSeconds(int s) throws SecException {
        if (s < 0 || s > 60) throw new SecException("second is not in range 0-60");
        seconds = s;
    }
}

class HrsException extends Exception {
    HrsException(String msg) { super(msg); }
}

class MinException extends Exception {
    MinException(String msg) { super(msg); }
}

class SecException extends Exception {
    SecException(String msg) { super(msg); }
}
