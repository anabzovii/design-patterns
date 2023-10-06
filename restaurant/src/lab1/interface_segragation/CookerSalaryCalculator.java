package lab1.interface_segragation;

import lab1.liskov_substitution.RestaurantEmployee;
import lab1.open_closed.SalaryCalculator;

public class CookerSalaryCalculator implements SalaryCalculator {
    @Override
    public int calculateSalary(RestaurantEmployee restaurantEmployee) {
        return restaurantEmployee.getSalary();
    }
}