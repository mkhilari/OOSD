1. 
Information hiding is making the internal members of a class invisible to external classes through use of privacy. 

```java 
class City {
    private String name; 
    private int population = 0; 

    String getName() {
        return this.name;
    }

    int getPopulation() {
        return this.population;
    }

    void setPopulation(int population) {
        this.population = population;
    }
}
``` 

2. 
Best is having private attributes with getters and setters. 

3. 
A class is immutable if it has 
* only private attributes 
* no setters 