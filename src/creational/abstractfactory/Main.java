package creational.abstractfactory;

public class Main {
    private final ResourceFactory resourceFactory;

    Main(ResourceFactory resourceFactory) {
        this.resourceFactory = resourceFactory;
    }
    private void createStartStopServer(Capacity capacity, int sizeInMB) {
        Instance instance = resourceFactory.createInstance(capacity);
        Storage storage = resourceFactory.createStorage(sizeInMB);
        resourceFactory.attachStoragetoInstance(instance,storage);
        instance.start();
        instance.stop();
    }

    public static void main(String[] args) {
        Main aws = new Main(new AwsResourceFactory());
        aws.createStartStopServer(Capacity.MICRO,40960);
        System.out.println();
        System.out.println("***************************");
        System.out.println();
        Main gcp = new Main(new GcpResourceFactory());
        gcp.createStartStopServer(Capacity.LARGE,20480);
    }
}
