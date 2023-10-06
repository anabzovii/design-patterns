package lab1.dependency_inversion;

import lab1.interface_segragation.CookerManagement;
import lab1.liskov_substitution.RestaurantEmployee;
import lab1.open_closed.SalaryCalculator;

import java.util.ArrayList;
import java.util.List;

public class Restaurant implements CookerManagement {
    private List<RestaurantEmployee> restaurantEmployees;

    //Dependency Inversion
    private SalaryCalculator salaryCalculator;

    //dependency injection in the constructor
    public Restaurant(SalaryCalculator salaryCalculator) {
        restaurantEmployees = new ArrayList<>();
        this.salaryCalculator = salaryCalculator;
    }

    @Override
    public void hire(RestaurantEmployee restaurantEmployee) {
        restaurantEmployees.add(restaurantEmployee);
    }

    @Override
    public void paySalaries() {
        for (RestaurantEmployee restaurantEmployee : restaurantEmployees) {
            int salary = salaryCalculator.calculateSalary(restaurantEmployee);
            System.out.println("Restaurant pays " + salary + " to " + restaurantEmployee.getName());
        }
    }
}