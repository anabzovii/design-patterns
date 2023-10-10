package lab4.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingMenu {
    List<Food> foods;
    public ShoppingMenu() {
        this.foods = new ArrayList<>();
    }
    public void addFood(Food food) {
        this.foods.add(food);
    }
    public void removeFood(Food food) {
        this.foods.remove(food);
    }
    public int calculateTotal() {
        int sum = 0;
        for (Food food : foods) {
            sum += food.getPrice();
        }
        return sum;
    }
    public void pay(PaymentStrategy paymentMethod) {
        int amount = calculateTotal();
        paymentMethod.pay(amount);
    }
}
