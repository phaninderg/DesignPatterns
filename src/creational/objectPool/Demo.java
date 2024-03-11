package creational.objectPool;

import java.awt.*;

public class Demo implements Poolable{

    Point point;

    Demo() {
        point = new Point();
    }

    void setLocation(Point point) {
        this.point = point;
    }

    void move(int dist) {
        int x = (int) (point.getX() + dist);
        int y = (int) (point.getY() + dist);
        point.move(x,y);
    }

    void draw(Point point) {
        System.out.println("Line is drawn between " + point.getX() + " and " + point.getY());
    }
    @Override
    public void reset() {
        this.point = new Point(0,0);
        System.out.println("Reset the point values");
    }
}
