package creational.simplefactorypattern;

public class SimpleFactory {
    public static Shape getShapeInstance(String type) {
        switch(type) {
            case "circle":
                return new Circle();
            case "square":
                return new Square();
            case "rectangle":
                return new Rectangle();
            default:
                throw new IllegalArgumentException("unknown shape type");
        }
    }
}
