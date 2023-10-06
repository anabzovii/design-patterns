package lab1.interface_segragation;

import lab1.liskov_substitution.RestaurantEmployee;

public interface CookerManagement {
    void hire(RestaurantEmployee restaurantEmployee);
    void paySalaries();
}
