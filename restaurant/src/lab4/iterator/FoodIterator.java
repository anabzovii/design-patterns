package lab4.iterator;

import lab4.strategy.Food;

public class FoodIterator implements Iterator {
    Food[] foods;
    int pos = 0;

    public FoodIterator(Food[] foods) {
        this.foods = foods;
    }

    public Object next() {
        Food food = foods[pos];
        pos += 1;
        return food;
    }

    public boolean hasNext() {
        if (pos >= foods.length ||
                foods[pos] == null)
            return false;
        else
            return true;
    }
}
