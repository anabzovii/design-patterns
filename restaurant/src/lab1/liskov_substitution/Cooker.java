package lab1.liskov_substitution;

//Liskov Substitution Principle (We can substitute Cooker with RestaurantEmployee)
public class Cooker extends RestaurantEmployee {
    public Cooker(String name, int salary) {
        super(name, salary);
    }
}
