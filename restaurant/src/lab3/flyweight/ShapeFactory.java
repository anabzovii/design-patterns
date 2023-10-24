package lab3.flyweight;

import java.util.HashMap;

public class ShapeFactory {
    private static final HashMap cocktailMap = new HashMap();

    public static Preparation getCocktail(String alcoholicDrink) {
        Cocktail cocktail = (Cocktail) cocktailMap.get(alcoholicDrink);
        if(cocktail == null) {
            cocktail = new Cocktail(alcoholicDrink);
            cocktailMap.put(alcoholicDrink, cocktail);
            System.out.println("Creating cocktail with : " + alcoholicDrink);
        }
        return cocktail;
    }
}