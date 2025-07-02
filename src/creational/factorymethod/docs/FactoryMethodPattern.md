# Factory Method Pattern

## Sequence Diagram

```
┌─────────┐      ┌────────────────────┐      ┌────────────────────┐      ┌────────────┐      ┌────────────┐
│  Main   │      │MessageBrokerCreator│      │KafkaBrokerCreator  │      │KafkaBroker │      │MessageBroker│
└────┬────┘      └──────────┬─────────┘      └──────────┬─────────┘      └─────┬──────┘      └─────┬──────┘
     │                      │                           │                      │                   │
     │ publishMessage       │                           │                      │                   │
     │──────────────────────┼───────────────────────────┼──────────────────────┼───────────────────┼─────►
     │                      │                           │                      │                   │
     │                      │ publishMessage()          │                      │                   │
     │                      │───────────────────────────►                      │                   │
     │                      │                           │                      │                   │
     │                      │                           │ createMessageBroker()│                   │
     │                      │                           │──────────────────────►                   │
     │                      │                           │                      │                   │
     │                      │                           │ new KafkaBroker()    │                   │
     │                      │                           │──────────────────────►                   │
     │                      │                           │                      │                   │
     │                      │                           │ return messageBroker │                   │
     │                      │                           │◄─────────────────────┤                   │
     │                      │                           │                      │                   │
     │                      │                           │ messageBroker.encrypt()                  │
     │                      │                           │──────────────────────────────────────────►
     │                      │                           │                      │                   │
     │                      │                           │ messageBroker.publishMessage()           │
     │                      │                           │──────────────────────────────────────────►
     │                      │                           │                      │                   │
     │                      │ return messageBroker      │                      │                   │
     │                      │◄──────────────────────────┤                      │                   │
     │                      │                           │                      │                   │
     │                      │ messageBroker.receiveMessage()                   │                   │
     │                      │──────────────────────────────────────────────────┼───────────────────┼─────►
     │                      │                           │                      │                   │
     │ return               │                           │                      │                   │
     │◄─────────────────────┼───────────────────────────┼──────────────────────┼───────────────────┤
     │                      │                           │                      │                   │
┌────┴────┐      ┌──────────┴─────────┐      ┌──────────┴─────────┐      ┌─────┴──────┐      ┌─────┴──────┐
│  Main   │      │MessageBrokerCreator│      │KafkaBrokerCreator  │      │KafkaBroker │      │MessageBroker│
└─────────┘      └────────────────────┘      └────────────────────┘      └────────────┘      └────────────┘
```

## Pattern Overview

### Problem Statement
How to create objects without specifying the exact class of object that will be created, while still allowing subclasses to alter the type of objects that will be created? This is particularly important when a class can't anticipate the class of objects it must create, and you want to delegate the responsibility to subclasses.

### Pattern Description
The Factory Method pattern defines an interface for creating an object, but lets subclasses decide which class to instantiate. It involves:

- **Product**: Defines the interface of objects the factory method creates (`MessageBroker`)
- **Concrete Product**: Implements the Product interface (`KafkaBroker`, `RabbitBroker`)
- **Creator**: Declares the factory method that returns a Product object (`MessageBrokerCreator`)
- **Concrete Creator**: Overrides the factory method to return an instance of a Concrete Product (`KafkaBrokerCreator`, `RabbitBrokerCreator`)

The pattern allows a class to defer instantiation to subclasses, promoting loose coupling and adherence to the Open/Closed Principle.

### Benefits
1. **Eliminates the need to bind application-specific classes into your code**: The code deals only with the Product interface.
2. **Provides hooks for subclasses**: Gives subclasses the ability to change the type of objects that will be created.
3. **Connects parallel class hierarchies**: Can help connect two different class hierarchies.
4. **Single Responsibility Principle**: Moves the product creation code into one place, making the code easier to maintain.
5. **Open/Closed Principle**: You can introduce new types of products without breaking existing client code.

### Consequences of Not Following
1. **Tight coupling**: Client code would be tightly coupled to specific product classes.
2. **Code duplication**: Similar object creation code might be duplicated across the codebase.
3. **Difficult extension**: Adding new product types would require modifying existing code.
4. **Testing complexity**: Harder to test client code in isolation from concrete product classes.
5. **Violation of Single Responsibility Principle**: Classes would handle both creation and business logic.

## Use Case Analysis

### Context
The project implements a message broker system that needs to support different types of message brokers (Kafka, RabbitMQ) while providing a common interface for publishing and receiving messages. The system should:
- Support different message broker implementations
- Provide common functionality like encryption and decryption
- Allow for easy addition of new message broker types

### Pattern Application
The Factory Method pattern is applied as follows:
1. `MessageBroker` is the abstract product class that defines the interface for all message brokers.
2. `KafkaBroker` and `RabbitBroker` are concrete products that implement the `MessageBroker` interface.
3. `MessageBrokerCreator` is the abstract creator class that declares the factory method `createMessageBroker()` and provides template methods `publishMessage()` and `receiveMessage()`.
4. `KafkaBrokerCreator` and `RabbitBrokerCreator` are concrete creators that override the factory method to create specific message broker instances.
5. The `Main` class demonstrates how to use different message broker creators to publish messages.

### Benefits Realization
1. **Flexibility**: The system can easily support different message broker implementations by creating new concrete creator and product classes.
2. **Code reuse**: Common functionality like encryption and decryption is implemented once in the abstract `MessageBroker` class.
3. **Encapsulation**: The creation logic is encapsulated in the concrete creator classes, separating it from the client code.
4. **Extensibility**: New message broker types can be added without modifying existing code, adhering to the Open/Closed Principle.

In this implementation, the Factory Method pattern successfully decouples the client code from the specific message broker implementations, making the system more flexible and maintainable.
