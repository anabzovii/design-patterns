package lab3.adapter;

import lab3.flyweight.Cocktail;

public class Barmen implements BarmenObligations {
    private Cocktail cocktail;
    private int salary;

    public Barmen(Cocktail cocktail, int salary) {
        this.cocktail = cocktail;
        this.salary = salary;
    }


    public void prepareCocktail() {
        System.out.println("Barmen prepare a cocktail");
    }

    @Override
    public int showCocktailPrice() {
        return salary;
    }
}
