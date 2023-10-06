package lab2.factory;

public class FoodTypeFactory {
    public FoodType chooseFoodType(String foodType)
    {
        if (foodType == null || foodType.isEmpty())
            return null;
        return switch (foodType) {
            case "D" -> new Dessert();
            case "C" -> new ColdFood();
            case "H" -> new HotFood();
            default -> throw new IllegalArgumentException("Unknown food " + foodType);
        };
    }
}
