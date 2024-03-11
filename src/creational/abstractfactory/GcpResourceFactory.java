package creational.abstractfactory;

public class GcpResourceFactory implements ResourceFactory{
    @Override
    public Instance createInstance(Capacity capacity) {
        return new GCPinstance(capacity);
    }

    @Override
    public void attachStoragetoInstance(Instance instance, Storage storage) {

        System.out.println("Attaching GoogleCloudStorage " + storage.getStorageId() +
                "to Compute Instance " +instance.getInstanceId());
    }

    @Override
    public Storage createStorage(int sizeInMB) {
        return new GoogleCloudStorage(sizeInMB);
    }
}
