package creational.abstractfactory;

public interface ResourceFactory {
    Instance createInstance(Capacity capacity);
    Storage createStorage(int sizeInMB);
    void attachStoragetoInstance(Instance instance,Storage storage);
}
