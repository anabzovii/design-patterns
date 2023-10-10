package lab3;

import lab3.adapter.Barmen;
import lab3.adapter.BarmenObligations;
import lab3.adapter.CookerAdapter;
import lab3.bridge.*;
import lab3.composite.FoodType;
import lab3.composite.MeatSalad;
import lab3.composite.Salad;
import lab3.composite.VegetarianSalad;
import lab3.decorator.Cooker;
import lab3.decorator.ExperiencedCooker;
import lab3.decorator.NormalCooker;
import lab3.decorator.ProfessionalCooker;

public class Main {
    public static void main(String[] args) {
        //Bridge
        CocktailType cocktailType = new PineappleCocktail(new AlcoolicCocktail(), 100);
        cocktailType.additionPrice();

        CocktailType cocktailType1 = new BerryCocktail(new NonAlcoolicCocktail(), 200);
        cocktailType1.additionPrice();

        //Composite
        Salad meatSalad = new MeatSalad();
        Salad vegetarianSalad = new VegetarianSalad();
        FoodType foodType = new FoodType(100);
        foodType.add(vegetarianSalad);
        foodType.showSalad(100);
        foodType.clear();
        foodType.add(meatSalad);
        foodType.add(vegetarianSalad);
        foodType.showSalad(200);

//        Decorator
        Cooker meatCooker = new ExperiencedCooker(new NormalCooker("Sandu", 1000, foodType), 2000);
        System.out.println(meatCooker.finalSalary());

        Cooker meatCooker1 = new ExperiencedCooker(new ProfessionalCooker(new NormalCooker("Catalin", 1200, foodType), 30), 200);
        System.out.println(meatCooker1.finalSalary());

//        Adapter
        BarmenObligations barmenObligations = new Barmen(cocktailType1, 100);
        BarmenObligations cookerAdapter = new CookerAdapter(meatCooker);
        System.out.println(barmenObligations.showFinalSalary());
        cookerAdapter.prepareCocktail();
    }
}
