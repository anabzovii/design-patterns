package lab1;

import lab1.dependency_inversion.Restaurant;
import lab1.interface_segragation.CookerManagement;
import lab1.interface_segragation.CookerSalaryCalculator;
import lab1.liskov_substitution.Cooker;
import lab1.liskov_substitution.RestaurantEmployee;
import lab1.open_closed.SalaryCalculator;

public class Main {
    public static void main(String[] args) {
        //interface segregation (interfata inlocuieste tipul de referinta a clasei)
        SalaryCalculator cookerSalaryCalculate = new CookerSalaryCalculator();
        CookerManagement restaurant = new Restaurant(cookerSalaryCalculate);

        //Liskov Substitution (clasa fiica poate sa aiba tipul de referinta a mamei)
        RestaurantEmployee cooker = new Cooker("Ion", 5000);
        RestaurantEmployee cooker1 = new Cooker("Maria", 6000);

        restaurant.hire(cooker);
        restaurant.hire(cooker1);

        restaurant.paySalaries();
    }
}
