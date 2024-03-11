package creational.abstractfactory;

import java.util.Random;

public class GCPinstance implements Instance{
    public GCPinstance(Capacity capacity) {
        System.out.println("Created " + capacity + " compute Instance on GCP");
    }

    @Override
    public void start() {
        System.out.println("Starting GCP instance...");
    }

    @Override
    public void stop() {
        System.out.println("Stopping GCP instance...");
    }

    @Override
    public int getInstanceId() {
        return new Random().nextInt(101);
    }

}
