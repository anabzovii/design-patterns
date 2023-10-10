package lab4.iterator;

import lab4.strategy.Food;

public class FoodBar {
    FoodCollection foodCollection;
    public FoodBar(FoodCollection foodCollection) {
        this.foodCollection = foodCollection;
    }

    public void printFoodPrices() {
        Iterator iterator = foodCollection.createIterator();
        while (iterator.hasNext()) {
            Food n = (Food) iterator.next();
            System.out.println(n.getPrice());
        }
    }
}
