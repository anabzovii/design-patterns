package lab3.composite;

import java.util.ArrayList;
import java.util.List;

public class FoodType {
    private int price;

    public FoodType(int price) {
        this.price = price;
    }

    private List<Salad> salads = new ArrayList<>();

    public void showSalad(int quantity) {
        for(Salad sh : salads) {
            sh.create(quantity);
        }
    }

    public void add(Salad s){
        this.salads.add(s);
    }

    public int getPrice() {
        return price * salads.size();
    }

    public void clear(){
        System.out.println("Clear salads");
        this.salads.clear();
    }
}
