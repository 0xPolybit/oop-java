package lab.day5;

interface Motor {

    final int capacity = 5;

    void run();
    void consume();

}

public class WashingMachine implements Motor {

    public void run() {
        System.out.println("Running the Washing Machine...");
    }

    public void consume() {
        System.out.println("Consuming electricity...");
    }

    public static void main(String[] args) {
        WashingMachine wm = new WashingMachine();
        System.out.println("Capacity of the motor is " + wm.capacity);
    }

}
