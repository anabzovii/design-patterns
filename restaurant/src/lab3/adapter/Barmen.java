package lab3.adapter;

import lab3.bridge.CocktailType;

public class Barmen implements BarmenObligations {
    private CocktailType cocktailType;
    private int salary;

    public Barmen(CocktailType cocktailType, int salary) {
        this.cocktailType = cocktailType;
        this.salary = salary;
    }


    public void prepareCocktail() {
        System.out.println("Barmen prepare a cocktail");
    }

    @Override
    public int showFinalSalary() {
        return salary + cocktailType.additionPrice();
    }
}
