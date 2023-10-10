# Author: Bzovîi Ana

----

# Topic: *Structural Design Patterns*
## Objectives:
&ensp; &ensp; __1. Study and understand the Structural Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.__

&ensp; &ensp; __3. Implement some additional functionalities, or create a new project using lab3 design patterns.__

## Theoretical background:
&ensp; &ensp; Structural design patterns are a category of design patterns that focus on the composition of classes and objects to form larger structures and systems. They provide a way to organize objects and classes in a way that is both flexible and efficient, while allowing for the reuse and modification of existing code. Structural design patterns address common problems encountered in the composition of classes and objects, such as how to create new objects that inherit functionality from existing objects, how to create objects that share functionality without duplicating code, or how to define relationships between objects in a flexible and extensible way.

&ensp; &ensp; Some examples of from this category of design patterns are:

* Adapter
* Bridge
* Composite
* Decorator
* Facade
* Flyweight
* Proxy

## Implementation

* Introduction

I implemented Adapter, Bridge, Composite and Decorator design patterns.
In the program we have a cooker and barmen. Both of them have their out possibilities to create meat or vegetarian salads.
Or, neither alcoholic or nonalcoholic cocktails.

* Snippets from your files.

* Adapter:

Adapter allows an object execute the other object functionality.
```java
public class CookerAdapter implements BarmenObligations {
    Cooker cooker;
    public CookerAdapter(Cooker cooker) {
        this.cooker = cooker;
    }

    @Override
    public void prepareCocktail()
    {
        cooker.cook();
    }

    @Override
    public int showFinalSalary() {
        return cooker.finalSalary();
    }
}
```

* Bridge:

Bridge allows to create objects of different types that have at the same time different characteristics. It gives us a 
bigger object variety.
```java
public abstract class CocktailType {
    protected Cocktail cocktail;

    public CocktailType(Cocktail cocktail){
        this.cocktail = cocktail;
    }

    abstract public int additionPrice();
}
```

* Composite:

Composite gives the possibility to treat many objects as an object.

```java
public class FoodType {
    private int price;

    public FoodType(int price) {
        this.price = price;
    }

    private List<Salad> salads = new ArrayList<>();

    public void showSalad(int quantity) {
        for(Salad sh : salads) {
            sh.create(quantity);
        }
    }

    public void add(Salad s){
        this.salads.add(s);
    }

    public int getPrice() {
        return price * salads.size();
    }

    public void clear(){
        System.out.println("Clear salads");
        this.salads.clear();
    }
}
```

* Decorator:

Decorator makes the process of changing the object type in runtime and allow new features in the runtime.
```java
public class CookerDecorator implements Cooker {
    protected Cooker cooker;

    public CookerDecorator(Cooker c) {
        this.cooker = c;
    }

    @Override
    public void cook() {
        System.out.println("Good Cooker cooks");
    }

    @Override
    public int finalSalary() {
        return this.cooker.finalSalary();
    }

}
```

## Conclusion
At this laboratory I implemented 4 lab3 design patterns. They are integrated in each other. I learned information about 
each of them. Structural design patterns is about defining the structure of classes in such a wat that they can execute
the necessary problem.