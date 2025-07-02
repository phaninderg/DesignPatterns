# Prototype Pattern

## Sequence Diagram

```
┌─────────┐      ┌─────────┐      ┌─────────┐      ┌─────────┐
│  Main   │      │ Moving  │      │ Action  │      │ Running │
└────┬────┘      └────┬────┘      └────┬────┘      └────┬────┘
     │                │                │                │
     │ new Moving()   │                │                │
     │────────────────►                │                │
     │                │                │                │
     │                │ initialize()   │                │
     │                │────────────────►                │
     │                │                │                │
     │ move()         │                │                │
     │────────────────►                │                │
     │                │                │                │
     │ changeState()  │                │                │
     │────────────────►                │                │
     │                │                │                │
     │ clone()        │                │                │
     │────────────────►                │                │
     │                │                │                │
     │                │ initialize()   │                │
     │                │────────────────►                │
     │                │                │                │
     │                │ reset()        │                │
     │                │────────────────►                │
     │                │                │                │
     │                │ super.clone()  │                │
     │                │────────────────►                │
     │                │                │                │
     │ return moving1 │                │                │
     │◄───────────────┤                │                │
     │                │                │                │
     │ new Running()  │                │                │
     │────────────────────────────────────────────────────►
     │                │                │                │
     │                │                │ initialize()   │
     │                │                │────────────────►
     │                │                │                │
     │ run()          │                │                │
     │────────────────────────────────────────────────────►
     │                │                │                │
     │ clone()        │                │                │
     │────────────────────────────────────────────────────►
     │                │                │                │
     │                │                │ throw exception│
     │                │                │◄───────────────┤
     │                │                │                │
┌────┴────┐      ┌────┴────┐      ┌────┴────┐      ┌────┴────┐
│  Main   │      │ Moving  │      │ Action  │      │ Running │
└─────────┘      └─────────┘      └─────────┘      └─────────┘
```

## Pattern Overview

### Problem Statement
How to create new objects by copying existing ones without making the code dependent on their concrete classes? This is particularly important when the cost of creating a new object is greater than the cost of copying an existing one, or when objects have complex configurations that would be tedious to recreate.

### Pattern Description
The Prototype pattern creates new objects by copying existing ones, known as prototypes, which can be either standard or user-defined prototypes. It involves:

- **Prototype**: Declares an interface for cloning itself (`Action` with `clone()` method)
- **Concrete Prototype**: Implements the cloning operation (`Moving` and `Running`)
- **Client**: Creates new objects by asking a prototype to clone itself (`Main`)

The pattern allows for adding and removing products at runtime by registering prototypes with a prototype manager (not implemented in this example).

### Benefits
1. **Reduced subclassing**: You can clone objects without depending on their concrete classes.
2. **Dynamic object creation**: You can add and remove objects at runtime.
3. **Configuration flexibility**: You can configure objects with values that vary from the defaults.
4. **Reduced initialization cost**: Cloning can be more efficient than creating objects from scratch, especially for complex objects.
5. **Alternative to factory**: Can serve as an alternative to factory classes when the number of classes is large.

### Consequences of Not Following
1. **Tight coupling**: Code becomes dependent on concrete classes.
2. **Complex object creation**: Creating complex objects from scratch can be error-prone and tedious.
3. **Inflexible configuration**: Hard to create objects with varying configurations.
4. **Performance issues**: Creating objects from scratch can be more expensive than cloning.
5. **Code duplication**: Similar initialization code might be duplicated across the codebase.

## Use Case Analysis

### Context
The project implements a system that needs to create objects with different states (Moving and Running) that share common functionality. The system should:
- Create objects with different initial states
- Allow for cloning objects to create new instances with the same state
- Reset objects to their initial state during cloning
- Handle cases where cloning is not supported

### Pattern Application
The Prototype pattern is applied as follows:
1. `Action` is the abstract prototype class that implements `Cloneable` and defines the `clone()` method.
2. `Moving` and `Running` are concrete prototypes that extend `Action` and implement their own versions of `clone()`.
3. `Action.clone()` resets the object to its initial state before cloning.
4. `Moving` supports cloning, while `Running` demonstrates a case where cloning is not supported (throws an exception).
5. The `Main` class demonstrates how to create and clone objects.

### Benefits Realization
1. **Code reuse**: Common functionality is implemented in the `Action` class and reused by concrete prototypes.
2. **State preservation**: The `Moving` class can be cloned to create a new instance with the same state.
3. **Initialization control**: The `initialize()` method ensures that cloned objects start with a consistent state.
4. **Flexibility**: Different concrete prototypes can implement different cloning behaviors.
5. **Error handling**: The `Running` class demonstrates how to handle cases where cloning is not supported.

In this implementation, the Prototype pattern successfully allows for creating new objects by copying existing ones, with control over the cloning process and proper initialization of the cloned objects.
