package lab3.decorator;

public class ExperiencedCooker extends CookerDecorator {
    private int addSalary;

    public ExperiencedCooker(Cooker c, int addSalary) {
        super(c);
        this.addSalary = addSalary;
    }

    public int getAddSalary() {
        return addSalary;
    }

    public void setAddSalary(int addSalary) {
        this.addSalary = addSalary;
    }

    @Override
    public int finalSalary() {
        return super.finalSalary() + getAddSalary();
    }
}
