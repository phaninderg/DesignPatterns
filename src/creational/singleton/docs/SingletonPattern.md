# Singleton Pattern

## Sequence Diagram

```
┌─────────┐      ┌───────────────┐      ┌────────────────────────────┐      ┌───────────────────┐
│  Main   │      │EagerSingleton │      │LazySingleton               │      │LazySingletonPlaceHolderIdiom│
└────┬────┘      └───────┬───────┘      └────────────┬───────────────┘      └───────────┬───────┘
     │                   │                           │                                  │
     │ getInstance()     │                           │                                  │
     │───────────────────►                           │                                  │
     │                   │                           │                                  │
     │ return INSTANCE   │                           │                                  │
     │◄───────────────────┤                          │                                  │
     │                   │                           │                                  │
     │ getInstance()     │                           │                                  │
     │───────────────────►                           │                                  │
     │                   │                           │                                  │
     │ return INSTANCE   │                           │                                  │
     │◄───────────────────┤                          │                                  │
     │                   │                           │                                  │
     │                   │                           │                                  │
     │ getInstance()     │                           │                                  │
     │─────────────────────────────────────────────────►                                │
     │                   │                           │                                  │
     │                   │                           │ if(INSTANCE == null)             │
     │                   │                           │ synchronized(LazySingleton.class)│
     │                   │                           │ if(INSTANCE == null)             │
     │                   │                           │ INSTANCE = new LazySingleton()   │
     │                   │                           │                                  │
     │ return INSTANCE   │                           │                                  │
     │◄─────────────────────────────────────────────────┤                               │
     │                   │                           │                                  │
     │ getInstance()     │                           │                                  │
     │─────────────────────────────────────────────────────────────────────────────────►│
     │                   │                           │                                  │
     │                   │                           │                                  │ return PlaceHolderIdiom.INSTANCE
     │                   │                           │                                  │ (static inner class initialization)
     │                   │                           │                                  │
     │ return INSTANCE   │                           │                                  │
     │◄─────────────────────────────────────────────────────────────────────────────────┤
     │                   │                           │                                  │
┌────┴────┐      ┌───────┴───────┐      ┌────────────┴───────────────┐      ┌───────────┴───────┐
│  Main   │      │EagerSingleton │      │LazySingleton               │      │LazySingletonPlaceHolderIdiom│
└─────────┘      └───────────────┘      └────────────────────────────┘      └───────────────────┘
```

## Pattern Overview

### Problem Statement
How to ensure that a class has only one instance and provide a global point of access to it? This is particularly important for classes that manage shared resources, such as configuration managers, connection pools, or caches.

### Pattern Description
The Singleton pattern restricts the instantiation of a class to a single instance and provides a global point of access to that instance. It involves:

- **Singleton**: A class that has a private constructor and a static method that returns the single instance (`EagerSingleton`, `LazySingleton`, `LazySingletonPlaceHolderIdiom`)

The pattern can be implemented in different ways, including eager initialization (instance created when class is loaded), lazy initialization (instance created when first needed), and thread-safe variations.

### Benefits
1. **Controlled access**: Provides a single point of access to the instance.
2. **Reduced memory footprint**: Only one instance is created, saving memory.
3. **Avoids global variables**: Provides a global access point without polluting the global namespace.
4. **Flexibility**: The singleton class can be extended, and the instance can be configured.
5. **Thread safety**: Can be implemented in a thread-safe manner to ensure only one instance exists in a multi-threaded environment.

### Consequences of Not Following
1. **Multiple instances**: Without the pattern, multiple instances might be created, leading to inconsistent state or resource conflicts.
2. **Resource waste**: Creating multiple instances of resource-intensive objects can waste system resources.
3. **Concurrency issues**: In multi-threaded environments, race conditions might lead to the creation of multiple instances.
4. **Global state**: Improper use of global access can lead to tight coupling and make testing difficult.
5. **Initialization complexity**: Managing the lifecycle of shared instances becomes more complex without a standardized approach.

## Use Case Analysis

### Context
The project implements a system that needs to ensure that certain classes have only one instance throughout the application. The system demonstrates three different Singleton implementations:
- Eager initialization (instance created when class is loaded)
- Lazy initialization with double-checked locking (instance created when first needed, thread-safe)
- Lazy initialization using the initialization-on-demand holder idiom (thread-safe, lazy loading)

### Pattern Application
The Singleton pattern is applied in three different ways:
1. `EagerSingleton`: Uses eager initialization with a private constructor and a static final instance created when the class is loaded.
2. `LazySingleton`: Uses lazy initialization with double-checked locking to ensure thread safety.
3. `LazySingletonPlaceHolderIdiom`: Uses the initialization-on-demand holder idiom with a private static inner class to hold the instance.

All three implementations share common characteristics:
- Private constructors to prevent instantiation from outside
- Static methods (`getInstance()`) to provide access to the single instance
- Static fields to hold the single instance

### Benefits Realization
1. **Controlled instantiation**: All three implementations ensure that only one instance of each class is created.
2. **Thread safety**: Both `LazySingleton` (with double-checked locking) and `LazySingletonPlaceHolderIdiom` (with the holder idiom) are thread-safe.
3. **Lazy loading**: Both lazy initialization approaches create the instance only when first needed, saving resources.
4. **Performance**: The holder idiom approach provides better performance than double-checked locking by leveraging JVM's class initialization guarantees.
5. **Simplicity**: Each implementation demonstrates a different trade-off between simplicity, thread safety, and lazy loading.

In this implementation, the Singleton pattern successfully ensures that each class has only one instance and provides a global point of access to that instance, with different variations demonstrating different implementation strategies.
