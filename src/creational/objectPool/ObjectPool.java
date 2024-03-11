package creational.objectPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ObjectPool <T extends Poolable> {

    private BlockingQueue<T> availablePool;

    public ObjectPool(Supplier<T> creator, int preCache) {
        availablePool = new LinkedBlockingQueue<>(preCache);
        IntStream.range(0,preCache).forEach(i->availablePool.offer(creator.get()));
    }

    public T get() {
        try {
            return availablePool.take();
        } catch (InterruptedException e) {
            System.out.println("take interrupted, waiting on pooled queue");
        }
        return null;
    }

    public void release(T obj) {
        obj.reset();
        try {
            availablePool.put(obj);
        }catch (InterruptedException e) {
            System.out.println("put interrupted, waiting to put object");
        }
    }

    public int remainingCapacity() {
        return availablePool.size();
    }
}
