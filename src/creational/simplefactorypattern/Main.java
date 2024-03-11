package creational.simplefactorypattern;

public class Main {
    public static void main(String[] args) {
        Shape shape = SimpleFactory.getShapeInstance("circle");
        System.out.println(shape);
    }
}
