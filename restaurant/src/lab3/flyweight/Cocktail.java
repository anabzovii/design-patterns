package lab3.flyweight;

public class Cocktail implements Preparation {
    private String name;
    private int price;

    public Cocktail(String name){
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void prepare() {
        System.out.println("Cocktail: Preparation() [Name : " + name + ", price :" + price);
    }
}
