package lab4.iterator;


import lab4.strategy.Food;

public class FoodCollection implements Collection
{
    static final int MAX_ITEMS = 10;
    int numberOfItems = 0;
    Food[] foods;

    public FoodCollection()
    {
        foods = new Food[MAX_ITEMS];
    }

    public void addFood(String str, int price)
    {
        Food food = new Food(str, price);
        if (numberOfItems >= MAX_ITEMS)
            System.err.println("Full");
        else
        {
            foods[numberOfItems] = food;
            numberOfItems = numberOfItems + 1;
        }
    }

    public Iterator createIterator()
    {
        return new FoodIterator(foods);
    }
}