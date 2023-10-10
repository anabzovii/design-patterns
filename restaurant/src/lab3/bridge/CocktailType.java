package lab3.bridge;

public abstract class CocktailType {
    protected Cocktail cocktail;

    public CocktailType(Cocktail cocktail){
        this.cocktail = cocktail;
    }

    abstract public int additionPrice();
}
