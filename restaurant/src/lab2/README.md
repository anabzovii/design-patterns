# Author: Bzovîi Ana    

----

# Topic: *Creational Design Patterns*
## Objectives:
&ensp; &ensp; __1. Study and understand the Creational Design Patterns.__

&ensp; &ensp; __2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.__

&ensp; &ensp; __3. Use some lab2 design patterns for object instantiation in a sample project.__

## Some Theory:
&ensp; &ensp; Creational design patterns are a category of design patterns that focus on the process of object creation. They provide a way to create objects in a flexible and controlled manner, while decoupling the client code from the specifics of object creation. Creational design patterns address common problems encountered in object creation, such as how to create objects with different initialization parameters, how to create objects based on certain conditions, or how to ensure that only a single instance of an object is created. There are several lab2 design patterns that have their own strengths and weaknesses. Each of it is best suited for solving specific problems related to object creation. By using lab2 design patterns, developers can improve the flexibility, maintainability, and scalability of their code.

&ensp; &ensp; Some examples of this kind of design patterns are:

* Singleton
* Builder
* Prototype
* Object Pooling
* Factory Method
* Abstract Factory

## Implementation

* Introduction

I decided to implement Singleton, Builder, Prototype and Factory design principles.
I created a java program where there is a Restaurant and it is shown its Cookers and Clients. Also, cooker has their own list of types of food that cooker can cook.

* Snippets from your files.

* Singleton Principle:

Singleton is a design pattern that allow creation of only one instance of a class and don't allow to create another
instances of this class. But, we can set the parameters of it's object after it's creation.
```java
public class Restaurant {
    private static Restaurant restaurant;
    private String name;

    private Restaurant() {
    }

    public static Restaurant getInstance() {
        if (restaurant == null) {
            restaurant = new Restaurant();
        }
        return restaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

* Prototype Principle:

Using this pattern we can make many clones of one object.
```java
public class Client implements Cloneable {
    private String name;
    private int paidPrice;

    public Client(String name, int paidPrice) {
        this.name = name;
        this.paidPrice = paidPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(int paidPrice) {
        this.paidPrice = paidPrice;
    }

    @Override
    public Object clone() {
        return new Client(getName(), getPaidPrice());
    }
}
```

* Builder Principle:

Builder is another form of creation on objects, it is easier that using standard constructor.
```java
public static class TeacherBuilder {
    private List<String> schoolTeaches;
    private String fullName;
    private int salary;
    private School restaurant;

    public TeacherBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public TeacherBuilder setSalary(int salary) {
        this.salary = salary;
        return this;
    }

    public TeacherBuilder setSchoolTeaches(List<String> schoolTeaches) {
        this.schoolTeaches = schoolTeaches;
        return this;
    }

    public TeacherBuilder setSchool(School restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public Teacher build() {
        return new Teacher(this);
    }
}
```

* Factory Pattern:

Factory pattern allows to determine object type in the runtime and create an object th that type.
```java
public class SchoolTypeFactory {
    public SchoolType chooseSchoolType(String foodType)
    {
        if (foodType == null || foodType.isEmpty())
            return null;
        return switch (foodType) {
            case "P" -> new PrimarySchool();
            case "L" -> new Lyceum();
            case "G" -> new Gymnasium();
            default -> throw new IllegalArgumentException("Unknown foodType " + foodType);
        };
    }
}
```

Main Class:

```java
public class Main {
    public static void main(String[] args) {
        //Singleton
        Restaurant restaurant = Restaurant.getInstance();
        restaurant.setName("COTLETCA");
        Restaurant restaurant1 = Restaurant.getInstance();
        System.out.println("Restaurant name is " + restaurant.getName());

        //Builder
        Cooker cooker = new Cooker.CookerBuilder()
                .setTypesOfFood(new ArrayList<>())
                .setSalary(200)
                .setRestaurant(restaurant)
                .setFirstname("Vasile")
                .build();

        //Factory
        FoodTypeFactory foodTypeFactory = new FoodTypeFactory();
        FoodType hotFood = foodTypeFactory.chooseFoodType("H");
        FoodType coldFood = foodTypeFactory.chooseFoodType("C");
        FoodType dessert = foodTypeFactory.chooseFoodType("D");
        cooker.foodType(hotFood);
        cooker.foodType(coldFood);
        System.out.println(cooker.getTypesOfFood());

        //Prototype
        Client client = new Client("Ion", 120);
        Client client1 = (Client) client.clone();
        System.out.println(client1.getName());


    }
}
```
## Conclusion
To sum up, I have created a simple code that implement the 4 design patterns that I have chosen.
All patterns are divided in different classes and all of them are interconnected. I learned the information about each
creational design patterns. Creational design pattern allow to create objects with different behavior.