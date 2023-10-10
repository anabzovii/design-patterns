package lab3.composite;

public class MeatSalad implements Salad {

    @Override
    public void create(int quantity) {
        System.out.println("Meat Salad with quantity " + quantity);
    }

}
