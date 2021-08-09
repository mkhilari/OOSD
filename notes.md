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

## Overriding 
Overriding is having a subclass method with the same name and arguments (same method signature) as a superclass method, but a different method body. 

Subclasses can **override** superclass methods. 

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
**Static** attributes and methods belong to the class, and are shared by all instances of the class. 

**Instance** attributes and methods are unique to each instance of a class. 

```java 
class Circle {
    private static int numCircles = 0;

    private Point center;
    private double radius;
}
```

## Static Methods 
All methods independent of instance variables should be static. 

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

## Copy Constructors 
A copy constructor takes an object as an argumet, and creates an independent copy of the object. 

If instance attributes **reference** other objects, independent copies of the referenced objects must also be created. 

```java 
class Circle {
    private static int numCircles = 0; 

    Point center;
    double radius;

    public Circle(Circle aCircle) {
        numCircles += 1; 

        // Independent copy of referenced object 
        this.center = new Point(aCircle.center);

        this.radius = aCircle.radius;
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

# Standard Methods 
All classes inherit the **Object** class, with methods 
* equals 
* toString 

```java 
class Object {
    public boolean equals(T other) {
        return <isEqual>; 
    }

    public String toString() {
        return <aString>; 
    }
}
``` 

# Privacy 
## Information Hiding 
Information hiding is making attributes and methods visible in their class, and invisible to external classes. 

All **non final** attributes should be private. 

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

# Inheritance 
A subclass can **extend** a superclass. 

The subclass inherits the attributes and methods of the superclass. 

## Super 
`super()` calls the constructor of the superclass. 

`super.` allows for superclass member access. 

```java 
class Shape {
    private Point center;

    public Shape(Point center) {
        this.center = center;
    }

    public double getArea() {
        return 0;
    }
}

class Circle extends Shape {
    private double radius; 

    public Circle(Point center, double radius) {
        super(center); 

        this.radius = radius; 
    }

    public double getArea() {
        return Math.PI * radius * radius; 
    }
}
``` 

## Upcasting 
Upcasting is assigning a subclass object to a superclass variable. 

```java 
Shape aCircle = new Circle();
``` 

## Downcasting 
Downcasting is explicitly **casting** a superclass variable, and assigning it to a subclass variable. 

The superclass variable must reference an object of the subclass. 

```java 
Shape aCircle = new Circle();
Circle sameCircle = (Circle) aCircle;
``` 

## Abstract Methods 
Abstract methods are methods with no implementation (body). 

Abstract methods must be overriden by a subclass to be used. 

## Abstract Classes 
Abstract classes have zero or more abstract methods. 

Abstract classes have no instances. 

# Interfaces 
Interfaces are abstract classes with only 
* static final attributes 
* abstract methods 

A subclass can **implement** an interface, and must override all abstract methods from the interface. 

```java 
interface Consumable {
    
    public void consume();
}

class WaterBottle implements Consumable {
    private double volume; 

    public WaterBottle(double volume) {
        this.volume = volume;
    }

    // Override 
    public void consume() {
        this.volume = volume / 2;
    }
}
``` 

A sub interface can **extend** a super interface. 

```java 
interface Drinkable extends Consumable {

    public void evaporate(); 
}
``` 

## Comparable Interface 
The comparable interface is a generic class with method 
* compareTo 

```java 
interface Comparable<T> {
    
    public int compareTo(T other);
}
``` 

# Generics 
A generic is a class or method that takes a type parameter `T`. 

```java 
class Book<T> {
    int numPages;
    ArrayList<T> pages = new ArrayList<>();
}
``` 

## Arrays 
* Fixed size 
* Manual resizing 

```java 
int A[nA];
``` 

## ArrayLists 
**Advantages** 
* Automatic size increasing 
* Insert, remove, update at any index 

**Disadvantages** 
* Manual size decreasing with `trimToSize()` 

```java 
ArrayList<T> scores = new ArrayList<>();

// ArrayList for each 
for (T score : scores) {
    // Use score 
}
``` 