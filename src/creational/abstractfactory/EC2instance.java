package creational.abstractfactory;

import java.util.Random;

public class EC2instance implements Instance{
    public EC2instance(Capacity capacity) {
        System.out.println("Created " + capacity + " EC2 instance on Aws");
    }

    @Override
    public void start() {
        System.out.println("Starting EC2 instance");
    }

    @Override
    public void stop() {
        System.out.println("Stopping EC2 instance");
    }

    @Override
    public int getInstanceId() {
        return new Random().nextInt(101);
    }
}
