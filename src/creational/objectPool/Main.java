package creational.objectPool;

import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ObjectPool<Demo> demoObjectPool = new ObjectPool<>(Demo::new,3);
        Demo d1 = demoObjectPool.get();
        Point p1 = new Point(4,5);
        d1.setLocation(p1);
        d1.draw(p1);
        d1.move(5);
        d1.draw(p1);
        Demo d2 = demoObjectPool.get();
        d2.draw(new Point(3,2));
        System.out.println("Remaining Demo objects " + demoObjectPool.remainingCapacity());
        demoObjectPool.release(d1);
        demoObjectPool.release(d2);
        System.out.println("Remaining Demo objects " + demoObjectPool.remainingCapacity());
    }
}
