package lab2;

import lab2.builder.Cooker;
import lab2.factory.FoodType;
import lab2.factory.FoodTypeFactory;
import lab2.prototype.Client;
import lab2.singletone.Restaurant;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Singleton
        Restaurant restaurant = Restaurant.getInstance();
        restaurant.setName("COTLETCA");
        Restaurant restaurant1 = Restaurant.getInstance();
        System.out.println("Restaurant name is " + restaurant.getName());

        //Builder
        Cooker cooker = new Cooker.CookerBuilder()
                .setTypesOfFood(new ArrayList<>())
                .setSalary(200)
                .setRestaurant(restaurant)
                .setFirstname("Vasile")
                .build();

        //Factory
        FoodTypeFactory foodTypeFactory = new FoodTypeFactory();
        FoodType hotFood = foodTypeFactory.chooseFoodType("H");
        FoodType coldFood = foodTypeFactory.chooseFoodType("C");
        FoodType dessert = foodTypeFactory.chooseFoodType("D");
        cooker.foodType(hotFood);
        cooker.foodType(coldFood);
        System.out.println(cooker.getTypesOfFood());

        //Prototype
        Client client = new Client("Ion", 120);
        Client client1 = (Client) client.clone(); //generics
        System.out.println(client1.getName());


    }
}
