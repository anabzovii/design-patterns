# Author: Bzovîi Ana

----

# Topic: *SOLID PRINCIPLES*
## Objectives:


&ensp; &ensp; __1. Study and understand the SOLID Principles.__

&ensp; &ensp; __2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.__

&ensp; &ensp;__3. Create a sample project that respects SOLID Principles.__

## Implementation

* Introduction

I have have created a simulation of an Restaurant with it's cookers, restaurantEmployee and the functionality to count their salary.

* Snippets from your files.


* S -> Single Responsibility:

I respected the single responsibility in the full project. Every class has it's own responsibility and it shouldn't 
execute unnecessary things.
```java
public class RestaurantEmployee {
    private String name;
    private int salary;

    public RestaurantEmployee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
```
* O -> Open Close:

I have added SalaryCalculator, CookerSalaryCalculator.
My code is open for extensions and closed for modification.
```java
//Open-Closed Principle (I added SalaryCalculator and CookerSalaryCalculator)
public interface SalaryCalculator {
    int calculateSalary(RestaurantEmployee restaurantEmployee);
}
```

* L -> Liskov Substitution:

I can substitute Cooker with RestaurantEmployee and the code will work.
```java
RestaurantEmployee cooker = new Cooker("Ion", 5000);
RestaurantEmployee cooker1 = new Cooker("Maria", 6000);
```
* I -> Interface Segregation:

Classes don't implement unnecessary interfaces and I can create an object using the as object reference the interface
that it implements.
```java
SalaryCalculator cookerSalaryCalculate = new CookerSalaryCalculator();
```

* D -> Dependency Inversion:

I set the SalaryCalculator as a field in Restaurant and inject it using the constructor.
```java
public class Restaurant implements CookerManagement {
    private List<RestaurantEmployee> restaurantEmployees;

    //Dependency Inversion
    private SalaryCalculator salaryCalculator;

    //dependency injection in the constructor
    public Restaurant(SalaryCalculator salaryCalculator) {
        restaurantEmployees = new ArrayList<>();

        this.salaryCalculator = salaryCalculator;
    }
}
```

## Conclusion
To sum up, I have created a restaurant that have cookers and the function to count their salary.
 I implemented somehow all SOLID principles and I learned all tactics used in the SOLID design principles.