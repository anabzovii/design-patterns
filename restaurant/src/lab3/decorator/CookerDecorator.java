package lab3.decorator;

public class CookerDecorator implements Cooker {
    protected Cooker cooker;

    public CookerDecorator(Cooker c) {
        this.cooker = c;
    }

    @Override
    public void cook() {
        System.out.println("Good Cooker cooks");
    }

    @Override
    public int finalSalary() {
        return this.cooker.finalSalary();
    }

}
