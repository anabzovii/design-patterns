package lab2.singletone;

public class Restaurant {
    private static Restaurant restaurant;
    private String name;

    private Restaurant() {
    }
//crearea obiectului unic
    public static Restaurant getInstance() {
        if (restaurant == null) {
            restaurant = new Restaurant();
        }
        return restaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
