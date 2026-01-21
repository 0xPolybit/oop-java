package lab.day6;

interface Greeting {
    void sayHello();
}

public class GreetingDemo {
    public static void main(String[] args) {
        Greeting g = new Greeting() {
            public void sayHello() {
                System.out.println("Hello, this is a custom greeting from an anonymous inner class!");
            }
        };
        g.sayHello();
    }
}
