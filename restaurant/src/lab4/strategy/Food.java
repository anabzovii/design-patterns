package lab4.strategy;

public class Food {

    private String name;
    private int price;

    public Food(String upc, int cost){
        this.name =upc;
        this.price=cost;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
