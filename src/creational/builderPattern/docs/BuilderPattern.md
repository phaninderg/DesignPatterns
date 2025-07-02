# Builder Pattern

## Sequence Diagram

```
┌─────────┐      ┌────────────┐      ┌────────────────┐      ┌────────┐
│  Main   │      │DosaBuilder │      │Dosa.DosaBuilder│      │  Dosa  │
└────┬────┘      └─────┬──────┘      └────────┬───────┘      └───┬────┘
     │                 │                      │                  │
     │ directBuild     │                      │                  │
     │─────────────────┼──────────────────────┼──────────────────┼───────►
     │                 │                      │                  │
     │                 │ withBatter(Batter.URADDAL)              │
     │                 │──────────────────────►                  │
     │                 │                      │                  │
     │                 │ Size(Size.MEDIUM)    │                  │
     │                 │──────────────────────►                  │
     │                 │                      │                  │
     │                 │ withCheese(true)     │                  │
     │                 │──────────────────────►                  │
     │                 │                      │                  │
     │                 │ withPaneer(true)     │                  │
     │                 │──────────────────────►                  │
     │                 │                      │                  │
     │                 │ build()              │                  │
     │                 │──────────────────────►                  │
     │                 │                      │                  │
     │                 │                      │ new Dosa()       │
     │                 │                      │──────────────────►
     │                 │                      │                  │
     │                 │                      │ setBatter()      │
     │                 │                      │──────────────────►
     │                 │                      │                  │
     │                 │                      │ setSize()        │
     │                 │                      │──────────────────►
     │                 │                      │                  │
     │                 │                      │ setUsePaneer()   │
     │                 │                      │──────────────────►
     │                 │                      │                  │
     │                 │                      │ setUseCheese()   │
     │                 │                      │──────────────────►
     │                 │                      │                  │
     │                 │                      │ return dosa      │
     │                 │                      │◄─────────────────┤
     │                 │                      │                  │
     │ return dosa     │                      │                  │
     │◄────────────────┼──────────────────────┼──────────────────┤
     │                 │                      │                  │
┌────┴────┐      ┌─────┴──────┐      ┌────────┴───────┐      ┌───┴────┐
│  Main   │      │DosaBuilder │      │Dosa.DosaBuilder│      │  Dosa  │
└─────────┘      └────────────┘      └────────────────┘      └────────┘
```

## Pattern Overview

### Problem Statement
How to construct a complex object step by step and allow different representations of the same construction process? In traditional object creation, constructors with many parameters can be confusing and error-prone, especially when some parameters are optional.

### Pattern Description
The Builder pattern separates the construction of a complex object from its representation, allowing the same construction process to create different representations. It involves:

- **Director**: Optional class that defines the order in which to execute the building steps (`Main` class with `directBuild` method)
- **Builder**: Abstract interface that defines steps to build parts of a product (`DosaBuilder` interface)
- **Concrete Builder**: Provides implementation for Builder (`Dosa.DosaBuilder` inner class)
- **Product**: The complex object being built (`Dosa` class)

The pattern allows for fluent interfaces through method chaining, making the client code more readable and maintainable.

### Benefits
1. **Construct objects step-by-step**: Provides control over the construction process.
2. **Reuse the same construction code**: The same construction process can create different representations.
3. **Single Responsibility Principle**: Isolates complex construction code from business logic.
4. **Fluent interface**: Method chaining makes the code more readable.
5. **Clear separation of optional parameters**: Avoids the "telescoping constructor" anti-pattern.

### Consequences of Not Following
1. **Telescoping constructors**: Multiple constructors with different parameter combinations.
2. **Complex object creation logic**: Construction logic mixed with business logic.
3. **Reduced readability**: Hard to understand what parameters mean in a large constructor call.
4. **Immutability challenges**: Difficult to create immutable objects with many optional parameters.
5. **Parameter validation complexity**: Difficult to validate parameters during construction.

## Use Case Analysis

### Context
The project implements a food ordering system that needs to create customizable food items (Dosa) with various optional toppings and characteristics. The system should allow:
- Different types of batter (RAGI, RAVVA, URADDAL)
- Different sizes (SMALL, MEDIUM, LARGE)
- Optional toppings (paneer, cheese, masala, karam, butter)
- Optional sides (chutney, sambhar)

### Pattern Application
The Builder pattern is applied as follows:
1. `Dosa` class contains a static inner class `DosaBuilder` that implements the builder pattern.
2. The `DosaBuilder` provides methods for setting each attribute of the Dosa (e.g., `withBatter()`, `Size()`, `withCheese()`).
3. Each builder method returns the builder instance, allowing for method chaining.
4. The `build()` method creates a new `Dosa` instance and sets all the attributes based on the builder's state.
5. The `Main` class uses a `directBuild()` method to demonstrate how to use the builder to create a Dosa with specific attributes.

### Benefits Realization
1. **Readability**: The client code clearly shows what attributes are being set (`withBatter(Batter.URADDAL).Size(Size.MEDIUM).withCheese(true).withPaneer(true)`).
2. **Flexibility**: Clients can create different Dosa configurations using the same builder.
3. **Default values**: The builder provides default values for optional attributes (e.g., `needChutney = true`).
4. **Encapsulation**: The Dosa class's setter methods are private, ensuring that objects can only be created through the builder.

In this implementation, the Builder pattern successfully simplifies the creation of complex Dosa objects with many optional attributes, making the code more readable and maintainable.
