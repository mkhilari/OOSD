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
<type> <name> = <optional initial value>;
```

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