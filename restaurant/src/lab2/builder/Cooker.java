package lab2.builder;

import lab2.factory.FoodType;
import lab2.singletone.Restaurant;

import java.util.List;

public class Cooker {
    private final List<String> typesOfFood;
    private final String firstname;
    private final int salary;
    private final Restaurant restaurant;

    public Cooker(CookerBuilder builder) {
        this.typesOfFood = builder.typesOfFood;
        this.firstname = builder.firstname;
        this.salary = builder.salary;
        this.restaurant = builder.restaurant;
    }

    public void foodType(FoodType foodType) {
        typesOfFood.add(foodType.foodType());
    }

    public void deleteFoodType(FoodType foodType) {
        typesOfFood.remove(foodType.foodType());
    }

    public List<String> getTypesOfFood() {
        return typesOfFood;
    }

    public String getFirstname() {
        return firstname;
    }

    public Restaurant getSchool() {
        return restaurant;
    }

    public int getSalary() {
        return salary;
    }

    public static class CookerBuilder {
        private List<String> typesOfFood;
        private String firstname;
        private int salary;
        private Restaurant restaurant;

        public CookerBuilder setFirstname(String firstname) {
            this.firstname = firstname;
            //dupa setare ne returneaza inapoi in constructor
            return this;
        }

        public CookerBuilder setSalary(int salary) {
            this.salary = salary;
            return this;
        }

        public CookerBuilder setTypesOfFood(List<String> typesOfFood) {
            this.typesOfFood = typesOfFood;
            return this;
        }

        public CookerBuilder setRestaurant(Restaurant restaurant) {
            this.restaurant = restaurant;
            return this;
        }
//returneaza obiectul cu totul setat
        public Cooker build() {
            return new Cooker(this);
        }
    }
}
