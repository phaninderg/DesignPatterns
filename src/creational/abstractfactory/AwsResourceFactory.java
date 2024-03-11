package creational.abstractfactory;

public class AwsResourceFactory implements ResourceFactory{
    @Override
    public Instance createInstance(Capacity capacity) {
        return new EC2instance(capacity);
    }

    @Override
    public void attachStoragetoInstance(Instance instance, Storage storage) {
        System.out.println("Attaching GoogleCloudStorage " + storage.getStorageId() +
                "to Compute Instance " +instance.getInstanceId());
    }

    @Override
    public Storage createStorage(int sizeInMB) {
        return new S3Storage(sizeInMB);
    }
}
