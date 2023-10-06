package lab2.factory;


public class ColdFood implements FoodType {

    @Override
    public String foodType() {
        return "Can prepare cold food";
    }
}