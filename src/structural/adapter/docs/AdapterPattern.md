# Adapter Pattern

## Sequence Diagram

```
┌─────────┐      ┌────────────────────┐      ┌───────────────────┐      ┌─────────────────────┐
│  Main   │      │EmployeeClassAdapter│      │BusinessCardDesigner│      │EmployeeObjectAdapter│
└────┬────┘      └──────────┬─────────┘      └─────────┬─────────┘      └──────────┬──────────┘
     │                      │                          │                           │
     │ new EmployeeClassAdapter()                      │                           │
     │──────────────────────►                          │                           │
     │                      │                          │                           │
     │ populateEmployeeInfo(adapter)                   │                           │
     │──────────────────────►                          │                           │
     │                      │                          │                           │
     │ new BusinessCardDesigner()                      │                           │
     │────────────────────────────────────────────────►│                           │
     │                      │                          │                           │
     │ printCard(adapter)   │                          │                           │
     │────────────────────────────────────────────────►│                           │
     │                      │                          │                           │
     │                      │                          │ getCustomerName()         │
     │                      │◄─────────────────────────┤                           │
     │                      │                          │                           │
     │                      │ return firstName + lastName                          │
     │                      │─────────────────────────►│                           │
     │                      │                          │                           │
     │                      │                          │ getCustomerDesignation()  │
     │                      │◄─────────────────────────┤                           │
     │                      │                          │                           │
     │                      │ return jobTitle          │                           │
     │                      │─────────────────────────►│                           │
     │                      │                          │                           │
     │                      │                          │ getCustomerAddress()      │
     │                      │◄─────────────────────────┤                           │
     │                      │                          │                           │
     │                      │ return address           │                           │
     │                      │─────────────────────────►│                           │
     │                      │                          │                           │
     │ new Employee()       │                          │                           │
     │──────────────────────►                          │                           │
     │                      │                          │                           │
     │ populateEmployeeInfo(employee)                  │                           │
     │──────────────────────►                          │                           │
     │                      │                          │                           │
     │ new EmployeeObjectAdapter(employee)             │                           │
     │───────────────────────────────────────────────────────────────────────────────►
     │                      │                          │                           │
     │ printCard(objectAdapter)                        │                           │
     │────────────────────────────────────────────────►│                           │
     │                      │                          │                           │
     │                      │                          │ getCustomerName()         │
     │                      │                          │───────────────────────────►
     │                      │                          │                           │
     │                      │                          │ return firstName + lastName
     │                      │                          │◄──────────────────────────┤
     │                      │                          │                           │
┌────┴────┐      ┌──────────┴─────────┐      ┌─────────┴─────────┐      ┌──────────┴──────────┐
│  Main   │      │EmployeeClassAdapter│      │BusinessCardDesigner│      │EmployeeObjectAdapter│
└─────────┘      └────────────────────┘      └───────────────────┘      └─────────────────────┘
```

## Pattern Overview

### Problem Statement
How to make classes with incompatible interfaces work together? This is particularly important when integrating existing systems or third-party libraries that have interfaces different from what your application expects.

### Pattern Description
The Adapter pattern allows objects with incompatible interfaces to collaborate by wrapping an object with a new interface. It involves:

- **Target**: Defines the domain-specific interface that the client uses (`Customer`)
- **Adaptee**: Defines an existing interface that needs adapting (`Employee`)
- **Adapter**: Adapts the interface of the Adaptee to the Target interface (`EmployeeClassAdapter`, `EmployeeObjectAdapter`)
- **Client**: Collaborates with objects conforming to the Target interface (`BusinessCardDesigner`)

The pattern can be implemented in two ways:
1. **Class Adapter**: Uses inheritance to adapt one interface to another (extends Adaptee, implements Target)
2. **Object Adapter**: Uses composition to contain the Adaptee instance (implements Target, has a reference to Adaptee)

### Benefits
1. **Integration**: Allows integration of classes that couldn't work together due to incompatible interfaces.
2. **Reusability**: Enables reuse of existing classes without modifying their code.
3. **Flexibility**: Provides multiple adapters for the same adaptee, each with different adaptations.
4. **Separation of concerns**: Separates interface conversion from business logic.
5. **Open/Closed Principle**: New adapters can be introduced without breaking existing client code.

### Consequences of Not Following
1. **Code duplication**: Similar conversion code might be duplicated across the codebase.
2. **Tight coupling**: Client code would be directly coupled to specific interfaces.
3. **Reduced reusability**: Existing classes with incompatible interfaces couldn't be reused.
4. **Complex integration**: Integrating systems with different interfaces would be more complex.
5. **Violation of Single Responsibility Principle**: Classes would handle both interface conversion and business logic.

## Use Case Analysis

### Context
The project implements a business card printing system that needs to work with employee data, but the business card designer expects customer data. The system demonstrates two approaches to adapting employee data to the customer interface:
- Class adapter approach (inheritance-based)
- Object adapter approach (composition-based)

### Pattern Application
The Adapter pattern is applied in two ways:
1. **Class Adapter (`EmployeeClassAdapter`)**: Extends `Employee` and implements `Customer`, directly adapting the methods.
2. **Object Adapter (`EmployeeObjectAdapter`)**: Implements `Customer` and has a reference to an `Employee` object, delegating calls to it.

Both adapters convert between the following interfaces:
- `Employee` methods (`getFirstName()`, `getLastName()`, `getJobTitle()`, `getAddress()`)
- `Customer` methods (`getCustomerName()`, `getCustomerDesignation()`, `getCustomerAddress()`)

### Benefits Realization
1. **Reuse**: The `BusinessCardDesigner` can work with `Employee` data without modification.
2. **Flexibility**: The system demonstrates two different adapter approaches, each with its own advantages.
3. **Separation of concerns**: The adaptation logic is isolated in the adapter classes, keeping the client and adaptee classes focused on their core responsibilities.
4. **Maintainability**: Changes to either the `Employee` or `Customer` interfaces would only require changes to the adapter classes.
5. **Extensibility**: New adapters could be added to support different data sources without modifying existing code.

In this implementation, the Adapter pattern successfully bridges the gap between the incompatible `Employee` and `Customer` interfaces, allowing the `BusinessCardDesigner` to work with employee data without modification.
