package lab1.open_closed;

import lab1.liskov_substitution.RestaurantEmployee;

//Open-Closed Principle (I added SalaryCalculator and CookerSalaryCalculator)
public interface SalaryCalculator {
    int calculateSalary(RestaurantEmployee restaurantEmployee);
}
