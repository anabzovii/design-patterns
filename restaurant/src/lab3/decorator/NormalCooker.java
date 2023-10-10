package lab3.decorator;

import lab3.composite.FoodType;

public class NormalCooker implements Cooker {
    private String name;
    private int salary;
    private FoodType foodType;

    public NormalCooker(String name, int salary, FoodType foodType) {
        this.name = name;
        this.salary = salary;
        this.foodType = foodType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int finalSalary() {
        return salary;
    }

    @Override
    public void cook() {
        System.out.println("Normal Cooker cooks");
    }
}
