# Author: Bzovîi Ana

----

# Topic: *Behavioral Design Patterns*
## Objectives:
&ensp; &ensp; __1. Study and understand the Behavioral Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about what communication between software entities might be involed in your system.__

&ensp; &ensp; __3. Create a new Project or add some additional functionalities using behavioral design patterns.__

## Theoretical background:
&ensp; &ensp; Behavioral design patterns are a category of design patterns that focus on the interaction and communication between objects and classes. They provide a way to organize the behavior of objects in a way that is both flexible and reusable, while separating the responsibilities of objects from the specific implementation details. Behavioral design patterns address common problems encountered in object behavior, such as how to define interactions between objects, how to control the flow of messages between objects, or how to define algorithms and policies that can be reused across different objects and classes.

&ensp; &ensp; Some examples from this category of design patterns are :

* Chain of Responsibility
* Command
* Interpreter
* Iterator
* Mediator
* Observer
* Strategy

## Implementation

* Introduction

I decided to implement Strategy, Iterator, Observer and Command design patterns.
I created an online restaurant page, were people can buy different foods and pay by card and paypal. Also, there is an 
observer that notice that functions are used on cards.

* Snippets from your files.

* Iterator:

Iterator is used to iterate the elements of a collection and make some changes on them in iterating process
```java
public class FoodIterator implements Iterator {
    Food[] foods;
    int pos = 0;

    public FoodIterator(Food[] foods) {
        this.foods = foods;
    }

    public Object next() {
        Food food = foods[pos];
        pos += 1;
        return food;
    }

    public boolean hasNext() {
        if (pos >= foods.length ||
                foods[pos] == null)
            return false;
        else
            return true;
    }
}
```

* Observer:

Observer is used to detect any changes in an object and execute some functions that are triggered by those changes.
```java
public class CardUsageSubscriber implements Observer {

    private String name;
    private Usage usage;

    public CardUsageSubscriber(String nm) {
        this.name = nm;
    }

    @Override
    public void update() {
        String msg = (String) usage.getUpdate(this);
        if (msg == null) {
            System.out.println(name + ":: No new message");
        } else
            System.out.println(name + ":: Consuming message::" + msg);
    }

    @Override
    public void setSubject(Usage sub) {
        this.usage = sub;
    }

}
```

* Command:

In my cases stores functionality of objects. That functionality events can be called later, after object initialization.
```java
public class CardTypeDeterminerUtil {

    public static CardFunctionality getCardType(CardFunctionality cardFunctionality) {
        if (cardFunctionality.getClass().equals(CreditCardStrategy.class)) {
            return new CreditCardStrategy();
        } else {
            return new PaypalStrategy();
        }
    }

}
```

* Strategy:

Strategy is used when we have multiple implementation of an object and client have to decide which implementation 
have to be used
```java
public interface CardFunctionality {

    String cardTransfer();
    String cardDeposit();
    String cardPayments();
}
```

## Conclusion
To sum up, I have created a simple code that implement the 4 behavioral design patterns that I have chosen.
I studied about all of them and managed to create an online restaurant. So, behavioral design patterns are used to show 
how classes have to act in dependence of the user wish.