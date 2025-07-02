# Design Patterns Implementation

This project demonstrates various design patterns implemented in Java. Design patterns are typical solutions to common problems in software design. Each pattern is like a blueprint that you can customize to solve a particular design problem in your code.

## Project Overview

This project contains implementations of the following design patterns:

### Creational Patterns
- **Abstract Factory**: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
- **Builder**: Separates the construction of a complex object from its representation.
- **Factory Method**: Defines an interface for creating an object, but lets subclasses decide which class to instantiate.
- **Object Pool**: Reuses and shares objects that are expensive to create.
- **Prototype**: Creates new objects by copying an existing object.
- **Simple Factory**: Provides a simple interface to create objects without exposing the creation logic.
- **Singleton**: Ensures that a class has only one instance and provides a global point of access to it.

### Structural Patterns
- **Adapter**: Allows objects with incompatible interfaces to collaborate.
- **Bridge**: Separates an abstraction from its implementation so that the two can vary independently.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher

### Running the Examples
Each design pattern has its own `Main` class that demonstrates how the pattern works. To run an example, execute the corresponding `Main` class.

For example, to run the Abstract Factory pattern example:
```
java -cp . creational.abstractfactory.Main
```

## Design Pattern Details

Each pattern implementation includes:
- Concrete implementation of the pattern
- Example usage in a Main class
- Necessary interfaces and classes to demonstrate the pattern

## Project Structure

```
src/
├── creational/
│   ├── abstractfactory/
│   ├── builderPattern/
│   ├── factorymethod/
│   ├── objectPool/
│   ├── prototype/
│   ├── simplefactorypattern/
│   └── singleton/
└── structural/
    ├── adapter/
    └── bridge/
```

## Contributing

Feel free to submit pull requests to add more design patterns or improve the existing implementations.

## License

This project is open source and available under the MIT License.
