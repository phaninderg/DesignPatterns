# Object Pool Pattern

## Sequence Diagram

```
┌─────────┐      ┌────────────┐      ┌──────────────────┐      ┌─────┐
│  Main   │      │ObjectPool  │      │BlockingQueue     │      │Demo │
└────┬────┘      └─────┬──────┘      └────────┬─────────┘      └──┬──┘
     │                 │                      │                   │
     │ new ObjectPool(Demo::new, 3)           │                   │
     │─────────────────►                      │                   │
     │                 │                      │                   │
     │                 │ new LinkedBlockingQueue(3)               │
     │                 │──────────────────────►                   │
     │                 │                      │                   │
     │                 │ IntStream.range(0,3).forEach(...)        │
     │                 │──────────────────────►                   │
     │                 │                      │                   │
     │                 │                      │ new Demo() x3     │
     │                 │                      │───────────────────►
     │                 │                      │                   │
     │ get()           │                      │                   │
     │─────────────────►                      │                   │
     │                 │                      │                   │
     │                 │ availablePool.take() │                   │
     │                 │──────────────────────►                   │
     │                 │                      │                   │
     │ return d1       │                      │                   │
     │◄─────────────────┤                     │                   │
     │                 │                      │                   │
     │ d1.setLocation(p1)                     │                   │
     │───────────────────────────────────────────────────────────►│
     │                 │                      │                   │
     │ d1.draw(p1)     │                      │                   │
     │───────────────────────────────────────────────────────────►│
     │                 │                      │                   │
     │ d1.move(5)      │                      │                   │
     │───────────────────────────────────────────────────────────►│
     │                 │                      │                   │
     │ d1.draw(p1)     │                      │                   │
     │───────────────────────────────────────────────────────────►│
     │                 │                      │                   │
     │ get()           │                      │                   │
     │─────────────────►                      │                   │
     │                 │                      │                   │
     │                 │ availablePool.take() │                   │
     │                 │──────────────────────►                   │
     │                 │                      │                   │
     │ return d2       │                      │                   │
     │◄─────────────────┤                     │                   │
     │                 │                      │                   │
     │ release(d1)     │                      │                   │
     │─────────────────►                      │                   │
     │                 │                      │                   │
     │                 │ d1.reset()           │                   │
     │                 │───────────────────────────────────────────►
     │                 │                      │                   │
     │                 │ availablePool.put(d1)│                   │
     │                 │──────────────────────►                   │
     │                 │                      │                   │
┌────┴────┐      ┌─────┴──────┐      ┌────────┴─────────┐      ┌──┴──┐
│  Main   │      │ObjectPool  │      │BlockingQueue     │      │Demo │
└─────────┘      └────────────┘      └──────────────────┘      └─────┘
```

## Pattern Overview

### Problem Statement
How to efficiently manage and reuse objects that are expensive to create, especially in scenarios where creating and destroying objects frequently can impact performance? This is particularly important in applications with high concurrency or when dealing with resource-intensive objects.

### Pattern Description
The Object Pool pattern maintains a pool of reusable objects that are ready for use. Instead of creating and destroying objects as needed, clients request objects from the pool and return them when finished. It involves:

- **Pool**: Manages a collection of reusable objects (`ObjectPool<T>`)
- **Reusable Object**: Objects that can be reused (`Demo` implementing `Poolable`)
- **Client**: Uses objects from the pool (`Main`)

The pattern helps improve performance by recycling objects instead of creating new ones, especially when object creation is resource-intensive.

### Benefits
1. **Improved performance**: Reduces the overhead of object creation and garbage collection.
2. **Resource management**: Controls the number of objects created, preventing resource exhaustion.
3. **Predictable behavior**: Provides more predictable response times by avoiding the cost of object initialization.
4. **Reduced memory fragmentation**: Reusing objects can reduce memory fragmentation.
5. **Throttling**: Naturally throttles the system when all objects are in use.

### Consequences of Not Following
1. **Performance degradation**: Frequent creation and destruction of expensive objects can lead to performance issues.
2. **Resource exhaustion**: Uncontrolled object creation can exhaust system resources.
3. **Unpredictable response times**: Object creation times can vary, leading to unpredictable system behavior.
4. **Increased garbage collection**: More objects created means more work for the garbage collector.
5. **Memory fragmentation**: Frequent allocation and deallocation can lead to memory fragmentation.

## Use Case Analysis

### Context
The project implements a system that needs to manage and reuse expensive objects (represented by the `Demo` class) efficiently. The system should:
- Limit the number of objects created
- Allow clients to get objects when needed
- Reset objects to their initial state when returned to the pool
- Track the number of available objects

### Pattern Application
The Object Pool pattern is applied as follows:
1. `Poolable` interface defines the contract for objects that can be pooled, requiring a `reset()` method.
2. `Demo` class implements `Poolable` and represents an expensive object with operations like `setLocation()`, `move()`, and `draw()`.
3. `ObjectPool<T>` is a generic pool that manages objects of type `T` (which must implement `Poolable`).
4. The pool uses a `BlockingQueue` to store available objects and provides methods to `get()` and `release()` objects.
5. The `Main` class demonstrates how to use the object pool to get objects, use them, and return them to the pool.

### Benefits Realization
1. **Resource control**: The pool is initialized with a fixed number of objects (3 in this case), preventing resource exhaustion.
2. **Performance improvement**: Objects are reused rather than created and destroyed repeatedly.
3. **Proper cleanup**: Objects are reset to their initial state when returned to the pool, ensuring they're ready for reuse.
4. **Concurrency support**: The use of `BlockingQueue` makes the pool thread-safe, allowing multiple threads to get and release objects safely.
5. **Resource monitoring**: The `remainingCapacity()` method allows clients to check how many objects are available in the pool.

In this implementation, the Object Pool pattern successfully manages the lifecycle of expensive objects, improving performance and resource utilization.
