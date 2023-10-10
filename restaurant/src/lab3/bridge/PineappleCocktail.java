package lab3.bridge;

public class PineappleCocktail extends CocktailType {
    public PineappleCocktail(Cocktail c, int price) {
        super(c);
        this.price = price;
    }

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int additionPrice() {
        return cocktail.additionPrice() + price;
    }

}