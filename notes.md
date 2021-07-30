# Introduction 
## OOSD 
An object is an instance of a class. 

Object Oriented Software Development (OOSD) is the use of object methods to turn inputs into outputs. 

## Java 
Java is 
* object oriented 
* platform independent 
* compiled and interpreted 

# Types  
## Identifiers 
An identifier is a name that uniquely identifies a 
* class 
* object 
* variable 
* method 

Identifiers 
* must not start with a digit 
* can have letters, digits, and underscores 
* are case sensitive 

```java
int SPEED_LIMIT = 100;
int SPEED = 70;
int speed = 60;
```

## Variables 
A variable is a pointer to an object with 
* memory address 
* type 

Variables must be initialised before use. 
```java
int age = 20;
``` 

## Constants 
Constants can only be set once. 

```java 
final int MAX_SCORE = 100;
```

## Primitive Types 
Primitive types have no methods. 

![Java Primitive Types](images/JavaPrimitiveTypes.png) 

Each primitive type has a wrapper classes with methods. 

![Java Wrapper Types](images/JavaWrapperTypes.png) 

```java 
int heightA = 180; 
Integer heightB = 190;

String heightC = heightB.toString();
int heightDigits = heightB.length();
``` 

## Boxing and Unboxing 
Boxing is converting a primitive value to a wrapper object. 

Unboxing is converting a wrapper object to a primitive value. 

## Type Casting 
```
byte < short < int < long < float < double 

char < int 

boolean 
```

Values can be assigned to a wider type. 

```java 
float a = 2;
double b = 3.14f;
``` 

Values must be explicitly **cast** to a narrower type. 

```java 
int a = (int) 2.5;
float b = (float) 2.5;
``` 

## Division 
Division with two integers returns integer floor division. 

```java 
double a = 5 / 3 // = 1 
``` 

Division with at least one real value (float or double) returns a real value. 

```java 
double a = 5 / (double) 3 // = 1.66... 
``` 

# Methods 
A method is a function in a class. 

All non `void` methods must `return` a value. 

## Method Signature 
The signature of a method includes the number and type of its arguments. 

```java 
public static double product(double a, double b) {
    return a * b;
}
``` 

## Overloading 
Overloading is having many methods with the same name but different number or type of arguments (different signatures). 

```java 
public static double product(double a, double b) {
    return a * b;
}

public static double product(int a, int b, int c) {
    return a * b * c;
}
```

# Classes 
A class is a type with attributes and methods. 

An object is an instance of a class.  

```java 
class Circle {
    // Attributes 
    // Methods 
}
```

## Static vs Instance 
**Static** attributes and methods belong to a class, and are shared by all instances of the class. 

**Instance** attributes and methods are unique to each instance of a class. 

```java 
class Circle {
    private static int numCircles = 0;

    private Point center;
    private double radius;
}
```

## Constructors 
A constructor is an instance method that initialises an object. 

The `this` keyword is the current object. 

Constructors can be **overloaded**. 

```java 
class Circle {
    private static int numCircles = 0;

    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }
}
``` 

## Null 
Variables have value **null** (no object here) until set. 

```java 
Circle circleA;
``` 

## Object Instantiation 
The `new` keyword allocates memory for an object. 

```java 
Circle circleA = new Circle(new Point(2, 3), 5);
``` 

## Getters and Setters 
**Getters** return private attributes. 

**Setters** set private attribues. 

```java 
class Circle {
    private static int numCircles = 0;

    private Point center;
    private double radius;

    public static int getNumCircles() {
        return this.numCircles;
    }

    public Circle(Point center, double radius) {
        numCircles += 1;

        this.center = center;
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
``` 

# Privacy 
## Privacy Levels 
**Private** attributes and methods can only be used in the same class. 

**Protected** attributes and methods can be used in the same package and in subclasses. 

**Public** attributes and methods can be used anywhere (global scope). 

## Privacy Leaks 
A privacy leak is when a reference to a private attribute is made avaiable (leaked) to an external object. 

## Mutable Objects 
An object is **mutable** if its attributes can be changed (mutated) after initialisation. 

## Immutable Objects 
An object is **immutable** if it has 
* only private attribues 
* no setters 