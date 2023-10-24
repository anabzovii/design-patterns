package lab3;

import lab3.adapter.Barmen;
import lab3.adapter.BarmenObligations;
import lab3.adapter.CookerAdapter;
import lab3.flyweight.Cocktail;
import lab3.flyweight.ShapeFactory;
import lab3.composite.FoodType;
import lab3.composite.MeatSalad;
import lab3.composite.Salad;
import lab3.composite.VegetarianSalad;
import lab3.decorator.Cooker;
import lab3.decorator.ExperiencedCooker;
import lab3.decorator.NormalCooker;
import lab3.decorator.ProfessionalCooker;

public class Main {
    private static final String[] alcohol = {"Vodka", "Gin", "BlueCuracao", "Whisky", "Rum"};

    public static void main(String[] args) {
        //FlyWeight
        for (int i = 0; i < 10; ++i) {
            Cocktail cocktail = (Cocktail) ShapeFactory.getCocktail(getRandomAlcohol());
            cocktail.setPrice(100);
            cocktail.prepare();
        }


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
        BarmenObligations barmenObligations = new Barmen( new Cocktail("Blood Mary"), 100);
        BarmenObligations cookerAdapter = new CookerAdapter(meatCooker);
        System.out.println(barmenObligations.showCocktailPrice());
        cookerAdapter.prepareCocktail();
    }

    private static String getRandomAlcohol() {
        return alcohol[(int) (Math.random() * alcohol.length)];
    }
}
