package creational.prototype;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        Moving moving = new Moving();
        moving.move();
        moving.changeState();
        System.out.println(moving);
        Moving moving1 = (Moving)moving.clone();
        System.out.println(moving1);
        Running running = new Running();
        running.run();
        System.out.println(running);
        Running running1 = (Running) running.clone();
        System.out.println(running1);
    }
}
