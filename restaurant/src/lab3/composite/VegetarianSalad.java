package lab3.composite;

public class VegetarianSalad implements Salad {
    @Override
    public void create(int quantity) {
            System.out.println("Vegetarian salad of quantity " + quantity);
    }

}
