# Simple Factory Pattern

## Sequence Diagram

```
┌─────────┐      ┌──────────────┐      ┌────────┐
│  Main   │      │SimpleFactory │      │ Circle │
└────┬────┘      └──────┬───────┘      └───┬────┘
     │                  │                  │
     │ getShapeInstance("circle")          │
     │──────────────────►                  │
     │                  │                  │
     │                  │ new Circle()     │
     │                  │──────────────────►
     │                  │                  │
     │                  │ return circle    │
     │                  │◄─────────────────┤
     │                  │                  │
     │ return shape     │                  │
     │◄─────────────────┤                  │
     │                  │                  │
┌────┴────┐      ┌──────┴───────┐      ┌───┴────┐
│  Main   │      │SimpleFactory │      │ Circle │
└─────────┘      └──────────────┘      └────────┘
```

## Pattern Overview

### Problem Statement
How to create objects without exposing the instantiation logic to the client? When a client needs to create objects of different types without knowing the specific classes, a simple factory can provide a centralized point for object creation.

### Pattern Description
The Simple Factory pattern provides a static method that encapsulates the object creation logic and returns instances of different classes based on input parameters. It involves:

- **Factory**: Contains a static method that creates and returns objects (`SimpleFactory`)
- **Product**: Defines the interface for objects the factory creates (`Shape`)
- **Concrete Products**: Different implementations of the product interface (`Circle`, `Square`, `Rectangle`)
- **Client**: Uses the factory to create objects (`Main`)

Unlike the Factory Method pattern, the Simple Factory doesn't use inheritance to create objects; instead, it relies on a single method with conditional logic.

### Benefits
1. **Encapsulation**: Hides the instantiation logic from the client.
2. **Centralization**: Centralizes object creation code in one place.
3. **Naming clarity**: Provides meaningful names for object creation methods.
4. **Simplicity**: Simpler than other creational patterns for basic use cases.
5. **Reduced duplication**: Avoids duplicating object creation code across the codebase.

### Consequences of Not Following
1. **Code duplication**: Object creation logic might be duplicated across the codebase.
2. **Tight coupling**: Client code would be directly coupled to concrete classes.
3. **Reduced flexibility**: Adding new product types would require modifying client code.
4. **Testing complexity**: Harder to test client code in isolation from concrete product classes.
5. **Violation of Single Responsibility Principle**: Client classes would handle both creation and business logic.

## Use Case Analysis

### Context
The project implements a shape creation system that needs to create different types of shapes (Circle, Square, Rectangle) based on a string identifier. The system should:
- Create shapes without exposing the instantiation logic to the client
- Provide a centralized point for shape creation
- Allow for easy addition of new shape types

### Pattern Application
The Simple Factory pattern is applied as follows:
1. `Shape` is the product interface that defines the common behavior for all shapes.
2. `Circle`, `Square`, and `Rectangle` are concrete products that implement the `Shape` interface.
3. `SimpleFactory` is the factory class with a static `getShapeInstance()` method that creates and returns shapes based on a string parameter.
4. The `Main` class demonstrates how to use the factory to create a circle.

### Benefits Realization
1. **Encapsulation**: The `Main` class doesn't need to know how to create shapes; it only needs to know the string identifier.
2. **Centralization**: All shape creation logic is centralized in the `SimpleFactory` class.
3. **Flexibility**: New shape types can be added by updating the factory method without changing client code.
4. **Simplicity**: The pattern is simple to implement and understand, making it suitable for this use case.
5. **Error handling**: The factory method can handle invalid shape types by throwing an exception.

In this implementation, the Simple Factory pattern successfully decouples the client code from the shape creation logic, making the system more maintainable and flexible.
