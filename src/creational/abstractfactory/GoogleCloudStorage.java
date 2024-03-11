package creational.abstractfactory;

import java.util.Random;

public class GoogleCloudStorage implements Storage{
    public GoogleCloudStorage(int capInMB) {
        System.out.println("Created " + capInMB + " storage on GCP");
    }

    @Override
    public int getStorageId() {
        return new Random().nextInt(1001);
    }
}
