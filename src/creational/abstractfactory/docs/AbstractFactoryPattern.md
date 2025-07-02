# Abstract Factory Pattern

## Sequence Diagram

```
┌─────────┐      ┌───────────────┐      ┌───────────────────┐      ┌─────────────┐      ┌─────────┐
│  Main   │      │ResourceFactory│      │AwsResourceFactory │      │EC2instance  │      │S3Storage│
└────┬────┘      └───────┬───────┘      └────────┬──────────┘      └──────┬──────┘      └────┬────┘
     │                   │                       │                        │                  │
     │ createStartStopServer                     │                        │                  │
     │───────────────────┼───────────────────────┼────────────────────────┼──────────────────┼────►
     │                   │                       │                        │                  │
     │                   │ createInstance        │                        │                  │
     │                   │───────────────────────►                        │                  │
     │                   │                       │                        │                  │
     │                   │                       │ new EC2instance        │                  │
     │                   │                       │────────────────────────►                  │
     │                   │                       │                        │                  │
     │                   │ createStorage         │                        │                  │
     │                   │───────────────────────►                        │                  │
     │                   │                       │                        │                  │
     │                   │                       │ new S3Storage          │                  │
     │                   │                       │──────────────────────────────────────────►│
     │                   │                       │                        │                  │
     │                   │ attachStoragetoInstance                        │                  │
     │                   │───────────────────────►                        │                  │
     │                   │                       │                        │                  │
     │                   │ instance.start()      │                        │                  │
     │                   │────────────────────────────────────────────────►                  │
     │                   │                       │                        │                  │
     │                   │ instance.stop()       │                        │                  │
     │                   │────────────────────────────────────────────────►                  │
     │                   │                       │                        │                  │
┌────┴────┐      ┌───────┴───────┐      ┌────────┴──────────┐      ┌──────┴──────┐      ┌────┴────┐
│  Main   │      │ResourceFactory│      │AwsResourceFactory │      │EC2instance  │      │S3Storage│
└─────────┘      └───────────────┘      └───────────────────┘      └─────────────┘      └─────────┘
```

## Pattern Overview

### Problem Statement
When a system needs to work with multiple families of related objects (products), but doesn't want to depend on the concrete classes of those objects. For example, when creating cloud resources, the system should be able to create resources for different cloud providers (AWS, GCP) without tightly coupling to the specific implementations.

### Pattern Description
The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes. It involves:

- **Abstract Factory**: Declares an interface for operations that create abstract product objects (`ResourceFactory`)
- **Concrete Factory**: Implements the operations to create concrete product objects (`AwsResourceFactory`, `GcpResourceFactory`)
- **Abstract Product**: Declares an interface for a type of product object (`Instance`, `Storage`)
- **Concrete Product**: Defines a product object to be created by the corresponding concrete factory (`EC2instance`, `S3Storage`, `GCPinstance`, `GoogleCloudStorage`)
- **Client**: Uses only interfaces declared by Abstract Factory and Abstract Product classes (`Main`)

### Benefits
1. **Isolation of concrete classes**: The client code works with factories and products through abstract interfaces, isolating it from implementation details.
2. **Consistency among products**: The pattern ensures that products created by a factory are compatible with each other.
3. **Easy exchange of product families**: Since the client code works with abstract interfaces, changing the concrete factory is straightforward.
4. **Promotes open/closed principle**: New variants of products can be introduced without breaking existing client code.

### Consequences of Not Following
1. **Tight coupling**: The client code would be directly coupled to concrete product classes, making it harder to change implementations.
2. **Inconsistent products**: Without the pattern, there's a risk of creating incompatible products from different families.
3. **Code duplication**: Similar creation logic might be duplicated across the codebase.
4. **Difficult maintenance**: Changes to product classes would require changes in multiple places throughout the code.

## Use Case Analysis

### Context
The project implements a cloud resource management system that needs to create and manage cloud resources (instances and storage) across different cloud providers (AWS and GCP). The system should be able to:
- Create instances with different capacities
- Create storage with different sizes
- Attach storage to instances
- Start and stop instances

### Pattern Application
The Abstract Factory pattern is applied as follows:
1. `ResourceFactory` is the abstract factory interface that declares methods for creating instances and storage.
2. `AwsResourceFactory` and `GcpResourceFactory` are concrete factories that implement the `ResourceFactory` interface to create AWS and GCP specific resources.
3. `Instance` and `Storage` are abstract product interfaces.
4. `EC2instance`, `GCPinstance`, `S3Storage`, and `GoogleCloudStorage` are concrete products.
5. The `Main` class uses the abstract factory to create and manage cloud resources without knowing their concrete implementations.

### Benefits Realization
1. **Flexibility**: The system can easily switch between AWS and GCP resources by changing the concrete factory.
2. **Consistency**: Resources created by a specific factory are guaranteed to be compatible with each other.
3. **Isolation**: The client code (`Main`) is isolated from the concrete implementations of cloud resources.
4. **Extensibility**: New cloud providers can be added by creating new concrete factories and products without modifying existing code.

In this implementation, the Abstract Factory pattern successfully decouples the client code from the specific cloud provider implementations, making the system more flexible and maintainable.
