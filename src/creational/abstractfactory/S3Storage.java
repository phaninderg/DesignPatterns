package creational.abstractfactory;

import java.util.Random;

public class S3Storage implements Storage{
    public S3Storage(int capInMB) {
        System.out.println("Allocated " + capInMB + " on S3");
    }

    @Override
    public int getStorageId() {
        return new Random().nextInt(1001);
    }
}
