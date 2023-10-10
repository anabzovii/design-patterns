package lab3.bridge;

public class BerryCocktail extends CocktailType {
    private int price;
    public BerryCocktail(Cocktail c, int price) {
        super(c);
        this.price = price;
    }

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